package com.veterinario.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veterinario.config.DBConfig;
import com.veterinario.model.entity.Cliente;

public class ClienteDAO implements IDAO<Cliente> {

    @Override
    public void cadastrar(Cliente entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "INSERT INTO cliente(id_cliente, nome, endereco, telefone, email, cpf) values" +
                                "(?, ?, ?, ?, ?, ?)")) {
            ps.setInt(1, entidade.getId());
            ps.setString(2, entidade.getNome());
            ps.setString(3, entidade.getEndereco());
            ps.setString(4, entidade.getTelefone());
            ps.setString(5, entidade.getEmail());
            ps.setString(6, entidade.getCpf());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Cliente entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "UPDATE cliente SET nome = ?,  endereco = ?,  telefone = ?,  email = ?,  cpf = ? WHERE id_cliente = ?")) {
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getEndereco());
            ps.setString(3, entidade.getTelefone());
            ps.setString(4, entidade.getEmail());
            ps.setString(5, entidade.getCpf());
            ps.setInt(6, entidade.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente; " + e.getMessage());
        }
    }

    @Override
    public void excluir(int id) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente buscar(int id) {
        Cliente cliente = null;
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("SELECT *FROM cliente WHERE id_cliente = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente: " + e.getMessage());
        }
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> listaCliente = new ArrayList<>();
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cliente");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf"));
                listaCliente.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar Cliente: " + e.getMessage());
        }
        return listaCliente;
    }

}
