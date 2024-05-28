package com.veterinario.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.veterinario.config.DBConfig;
import com.veterinario.model.entity.Animal;
import com.veterinario.model.entity.Cliente;

public class AnimalDAO implements IDAO<Animal> {

    @Override
    public void cadastrar(Animal entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "INSERT INTO animal(id_animal, nome, raca, idade, sexo, id_cliente) values" +
                                "(?, ?, ?, ?, ?, ?)")) {
            ps.setInt(1, entidade.getId());
            ps.setString(2, entidade.getNome());
            ps.setString(3, entidade.getRaca());
            ps.setInt(4, entidade.getIdade());
            ps.setString(5, entidade.getSexo());
            ps.setInt(6, entidade.getDono().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar animal: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Animal entidade) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "UPDATE animal SET nome = ?, raca = ?, idade = ?, = sexo = ?, id_cliente = ? WHERE id_animal = ?")) {
            // "UPDATE animal SET nome = ?, raca = ?, idade = ?, sexo = ?, id_cliente = ?
            // WHERE id_animal = ?"
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getRaca());
            ps.setInt(3, entidade.getIdade());
            ps.setString(4, entidade.getSexo());
            ps.setInt(5, entidade.getId());
            ps.setInt(6, entidade.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar animal: " + e.getMessage());
        }
    }

    @Override
    public void excluir(int id) {
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("DELETE FROM animal WHERE id_animal = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir animal: " + e.getMessage());
        }
    }

    @Override
    public Animal buscar(int id) {
        Animal animal = null;
        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement("SELECT * FROM animal WHERE id_animal = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Cliente dono = new Cliente();

                animal = new Animal(
                        rs.getInt("id_animal"),
                        rs.getString("nome"),
                        rs.getString("raca"),
                        rs.getInt("idade"),
                        rs.getString("sexo"),
                        null);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar animal: " + e.getMessage());
        }
        return animal;
    }

    @Override
    public List<Animal> listar() {
        Map<Integer, Cliente>mapCliente = new HashMap<>();
        List<Animal> listaAnimal = new ArrayList<>();

        try (Connection conexao = DBConfig.getConnection();
                PreparedStatement ps = conexao.prepareStatement(
                        "SELECT a.id_animal, a.nome AS nome_animal, a.raca, a.idade, a.sexo, a.id_cliente, " +
                        "c.id_cliente AS id_cliente, c.nome AS nome_cliente, c.endereco, c.telefone, c.email, c.cpf " +
                        "FROM animal AS a " +
                        "INNER JOIN cliente AS c ON a.id_cliente = c.id_cliente");        
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                Cliente dono = mapCliente.get(idCliente);
                if(dono == null){
                dono = new Cliente(
                        idCliente,
                        rs.getString("nome_cliente"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf"));
                        mapCliente.put(idCliente, dono);
                }
                
                Animal animal = new Animal(
                        rs.getInt("id_animal"),
                        rs.getString("nome_animal"),
                        rs.getString("raca"),
                        rs.getInt("idade"),
                        rs.getString("sexo"),
                        dono);
                
                dono.getAnimais().add(animal);
                listaAnimal.add(animal);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar animais: " + e.getMessage());
        }
        return listaAnimal;
    }

    
}
