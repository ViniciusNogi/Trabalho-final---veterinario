package com.veterinario.config;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static final String url = "jdbc:postgresql://localhost:5432/veterinario";
    private static final String user = "postgres";
    private static final String password = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void TBCliente() {
        try (Connection conexao = getConnection();
                Statement st = conexao.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS cliente" +
                    "(id_cliente INT PRIMARY KEY," +
                    "nome VARCHAR (100) NOT NULL," +
                    "endereco VARCHAR (100) NOT NULL," +
                    "telefone VARCHAR(20) NOT NULL," +
                    "email VARCHAR (50) NOT NULL," +
                    "cpf VARCHAR(11) NOT NULL)";
            st.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela Cliente " + e.getMessage());
        }
    }

    public static void TBAnimal() {
        try (Connection conexao = getConnection();
                Statement st = conexao.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS animal" +
                    "(id_animal INT PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL," +
                    "raca VARCHAR(100) NOT NULL," +
                    "idade INT NOT NULL," +
                    "sexo VARCHAR(10) NOT NULL," +
                    "id_cliente INT," +
                    "CONSTRAINT fk_animalCliente FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente))";
            st.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela Animal: " + e.getMessage());
        }
    }

    public static void TBVeterinario() {
        try (Connection conexao = getConnection();
                Statement st = conexao.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS veterinario" +
                    "(id_veterinario INT PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL," +
                    "especializacao VARCHAR(100) NOT NULL)";
            st.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela veterinario: " + e.getMessage());
        }
    }

    public static void TBConsulta() {
        try (Connection conexao = getConnection();
                Statement st = conexao.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS consulta " +
                    "(id_consulta INT PRIMARY KEY, " +
                    "id_veterinario INT NOT NULL, " +
                    "id_cliente INT NOT NULL, " +
                    "id_animal INT NOT NULL, " +
                    "data DATE  NOT NULL, " +
                    "hora VARCHAR(100) NOT NULL, " +
                    "motivo_consulta VARCHAR(100) NOT NULL, " +
                    "diagnostico VARCHAR(100) NOT NULL, " +
                    "CONSTRAINT fk_consultaVeterinario FOREIGN KEY(id_veterinario) REFERENCES veterinario(id_veterinario),"+
                    "CONSTRAINT fk_consultaCliente FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente)," +
                    "CONSTRAINT fk_consultaAnimal FOREIGN KEY(id_animal) REFERENCES animal(id_animal))";
            st.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela consulta: " + e.getMessage());
        }
    }

    public static void TBMedicamento() {
        try (Connection conexao = getConnection();
                Statement st = conexao.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS medicamento" +
                    "(id_medicamento INT PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL," +
                    "descricao VARCHAR(100) NOT NULL) ";
            st.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela medicamento: " + e.getMessage());
        }
    }

    public static void TBReceita() {
        try (Connection conexao = getConnection();
                Statement st = conexao.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS receita" +
                    "(id_receita INT PRIMARY KEY," +
                    "id_consulta INT NOT NULL," +
                    "id_medicamento INT NOT NULL," +
                    "CONSTRAINT fk_receitaConsulta FOREIGN KEY(id_consulta) REFERENCES consulta(id_consulta)," +
                    "CONSTRAINT fk_receitaMedicamento FOREIGN KEY(id_medicamento) REFERENCES medicamento(id_medicamento))";
            st.executeUpdate(sql);
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela receita: " + e.getMessage());
        }
    }
}
