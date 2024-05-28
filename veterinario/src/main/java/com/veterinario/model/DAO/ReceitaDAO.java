package com.veterinario.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veterinario.config.DBConfig;
import com.veterinario.model.entity.Receita;

public class ReceitaDAO implements IDAO<Receita>{
    
    @Override
    public void cadastrar(Receita entidade) {
        String sql = "INSERT INTO receita (id_receita, id_consulta, id_medicamento) VALUES (?, ?, ?)";

        try (Connection conexao = DBConfig.getConnection();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, entidade.getId());
            ps.setInt(2, entidade.getIdConsulta());
            ps.setInt(3, entidade.getIdMedicamento());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar receita: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Receita entidade) {
        String sql = "UPDATE receita SET id_consulta = ?, id_medicamento = ? WHERE id_receita = ?";

        try (Connection conexao = DBConfig.getConnection();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, entidade.getIdConsulta());
            ps.setInt(2, entidade.getIdMedicamento());
            ps.setInt(3, entidade.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar receita: " + e.getMessage());
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM receita WHERE id_receita = ?";

        try (Connection conexao = DBConfig.getConnection();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao excluir receita: " + e.getMessage());
        }
    }

    @Override
    public Receita buscar(int id) {
        String sql = "SELECT id_receita, id_consulta, id_medicamento FROM receita WHERE id_receita = ?";
        Receita receita = null;

        try (Connection conexao = DBConfig.getConnection();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                receita = new Receita(
                        rs.getInt("id_receita"),
                        rs.getInt("id_consulta"),
                        rs.getInt("id_medicamento")
                );
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar receita: " + e.getMessage());
        }
        return receita;
    }

    @Override
    public List<Receita> listar() {
        String sql = "SELECT id_receita, id_consulta, id_medicamento FROM receita";
        List<Receita> listaReceita = new ArrayList<>();

        try (Connection conexao = DBConfig.getConnection();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Receita receita = new Receita(
                        rs.getInt("id_receita"),
                        rs.getInt("id_consulta"),
                        rs.getInt("id_medicamento")
                );
                listaReceita.add(receita);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar receitas: " + e.getMessage());
        }
        return listaReceita;
    }
}