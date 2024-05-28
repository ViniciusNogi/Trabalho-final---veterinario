package com.veterinario.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veterinario.config.DBConfig;
import com.veterinario.model.entity.Consulta;

public class ConsultaDAO implements IDAO<Consulta> {

    @Override
    public void cadastrar(Consulta entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "INSERT INTO consulta(id_Consulta, id_veterinario, id_cliente, id_animal, data, hora, motivoConsulta, diagnostico) values"
                                +
                                "(?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setInt(1, entidade.getId());
            ps.setInt(2, entidade.getIdVeterinario());
            ps.setInt(3, entidade.getIdCliente());
            ps.setInt(4, entidade.getIdAnimal());
            ps.setDate(5, entidade.getData());
            ps.setString(6, entidade.getHora());
            ps.setString(7, entidade.getMotivoConsulta());
            ps.setString(8, entidade.getDiagnostico());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar consulta: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Consulta entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "UPDATE consulta SET id_veterinario = ?, id_cliente = ?, id_animal = ?, data = ?, hora = ?, motivo_consulta = ?, diagnostico = ? WHERE id_consulta = ?")) {
            ps.setInt(2, entidade.getIdVeterinario());
            ps.setInt(3, entidade.getIdCliente());
            ps.setInt(4, entidade.getIdAnimal());
            ps.setDate(5, entidade.getData());
            ps.setString(6, entidade.getHora());
            ps.setString(7, entidade.getMotivoConsulta());
            ps.setString(8, entidade.getDiagnostico());
            ps.setInt(1, entidade.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar consulta; " + e.getMessage());
        }
    }

    @Override
    public void excluir(int id) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("DELETE FROM consulta WHERE id_cliente = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir consulta: " + e.getMessage());
        }
    }

    @Override
    public Consulta buscar(int id) {
        Consulta consulta = null;
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("SELECT *FROM consulta WHERE id_consulta = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                consulta = new Consulta(
                        rs.getInt("id_consulta"),
                        rs.getInt("id_veterinario"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_animal"),
                        rs.getDate("data"),
                        rs.getString("hora"),
                        rs.getString("motivo_consulta"),
                        rs.getString("diagnostico"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar consulta: " + e.getMessage());
        }
        return consulta;
    }

    @Override
    public List<Consulta> listar() {
        List<Consulta> listaConsulta = new ArrayList<>();
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("SELECT * FROM Consulta");
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Consulta consulta = new Consulta(
                    rs.getInt("id_consulta"),
                    rs.getInt("id_veterinario"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_animal"),
                    rs.getDate("data"),
                    rs.getString("hora"),
                    rs.getString("motivo_consulta"),
                    rs.getString("diagnostico"));
                listaConsulta.add(consulta);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar consulta: " + e.getMessage());
        }
        return listaConsulta;
    }

}
