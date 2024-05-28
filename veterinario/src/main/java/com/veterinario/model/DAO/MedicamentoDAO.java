package com.veterinario.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veterinario.config.DBConfig;
import com.veterinario.model.entity.Medicamento;

public class MedicamentoDAO implements IDAO<Medicamento> {

    @Override
    public void cadastrar(Medicamento entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "INSERT INTO Medicamento(id_Medicamento, nome, descricao) values" +
                        "(?, ?, ?)")) {
            ps.setInt(1, entidade.getId());
            ps.setString(2, entidade.getNome());
            ps.setString(3, entidade.getDescricao());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar Medicamento: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Medicamento entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "UPDATE medicamento SET nome = ?, descricao = ? WHERE id_medicamento = ?")) {
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getDescricao());
            ps.setInt(6, entidade.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar medicamento; " + e.getMessage());
        }
    }

    @Override
    public void excluir(int id) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("DELETE FROM medicamento WHERE id_medicamento = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir medicamento: " + e.getMessage());
        }
    }

    @Override
    public Medicamento buscar(int id) {
        Medicamento medicamento = null;
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("SELECT *FROM medicamento WHERE id_medicamento = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                medicamento = new Medicamento(
                        rs.getInt("id_medicamento"),
                        rs.getString("nome"),
                        rs.getString("descricao"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar medicamento: " + e.getMessage());
        }
        return medicamento;
    }

    @Override
    public List<Medicamento> listar() {
        List<Medicamento> listaMedicamento = new ArrayList<>();
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("SELECT * FROM medicamento");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medicamento medicamento = new Medicamento(
                        rs.getInt("id_animal"),
                        rs.getString("nome"),
                        rs.getString("descricao"));
                listaMedicamento.add(medicamento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar Medicamento: " + e.getMessage());
        }
        return listaMedicamento;
    }

}
