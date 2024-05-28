package com.veterinario.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veterinario.config.DBConfig;
import com.veterinario.model.entity.Veterinario;

public class VeterinarioDAO implements IDAO<Veterinario> {

    @Override
    public void cadastrar(Veterinario entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "INSERT INTO veterinario(id_veterinario, nome, especializacao) values" +
                                "(?, ?, ?)")) {
            ps.setInt(1, entidade.getId());
            ps.setString(2, entidade.getNome());
            ps.setString(3, entidade.getEspecializacao());
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar veterinário: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Veterinario entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "UPDATE veterinario SET nome = ?,  especializacao = ? WHERE id_veterinario = ?")) {
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getEspecializacao());
            ps.setInt(6, entidade.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar veterinario: " + e.getMessage());
        }
    }

    @Override
    public void excluir(int id) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("DELETE FROM veterinario WHERE id_veterinario = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir veterinario: " + e.getMessage());
        }
    }

    @Override
    public Veterinario buscar(int id) {
        Veterinario veterinario = null;
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("SELECT *FROM veterinario WHERE id_veterinario = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                veterinario = new Veterinario(
                        rs.getInt("id_veterinario"),
                        rs.getString("nome"),
                        rs.getString("especializacao"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar veterinario: " + e.getMessage());
        }
        return veterinario;
    }

    @Override
    public List<Veterinario> listar() {
        List<Veterinario> listaVeterinario = new ArrayList<>();
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("SELECT * FROM Veterinario");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Veterinario veterinario = new Veterinario(
                        rs.getInt("id_veterinario"),
                        rs.getString("nome"),
                        rs.getString("especializacao"));

                listaVeterinario.add(veterinario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar veterinário: " + e.getMessage());
        }
        return listaVeterinario;
    }

}
