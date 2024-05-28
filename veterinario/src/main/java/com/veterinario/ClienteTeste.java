package com.veterinario;

import java.util.List;
import java.util.Scanner;

import com.veterinario.controller.ClienteController;
import com.veterinario.model.DAO.ClienteDAO;
import com.veterinario.model.entity.Cliente;

public class ClienteTeste {
    private static ClienteController clienteController;

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteController = new ClienteController(clienteDAO);

        //Execute os testes
        testarCadastro(); //ok
        testarListagem(); // ok
        testarBusca(); // ok
        testarAtualizacao(); // ok
        testarExclusao(); // ok
    }

    public static void testarCadastro() {
        Cliente cliente = new Cliente(6 ,"Olivia", "Rua Ali, 123", "43214321", "olivia@example.com", "11122233344");
        System.out.println(clienteController.cadastrar(cliente));
    }

    public static void testarListagem() {
        List<Cliente> clientes = clienteController.listar();
        for (Cliente cliente : clientes) {
            System.out.println("Id_cliente: " + cliente.getId());
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("E-mail: " + cliente.getEmail());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println(" ");
        }
    }

    public static void testarBusca() {
        Cliente clienteBuscado = clienteController.buscar(6);
        System.out.println("Cliente buscado: " + clienteBuscado.getNome());
    }

    // public static void testarAtualizacao() {
    //     Cliente cliente = new Cliente(6, "Olivia atualizado", "Rua A, 123", "999111222", "olivia@example.com", "11122233344");
    //     clienteController.atualizar(cliente);
    // }

    public static void testarAtualizacao() {
        // Solicitar ID do cliente a ser atualizado
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do cliente que deseja atualizar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Cliente cliente = clienteController.buscar(idCliente);
        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("CPF: " + cliente.getCpf());

            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo endereço: ");
            String novoEndereco = scanner.nextLine();
            System.out.print("Digite o novo telefone: ");
            String novoTelefone = scanner.nextLine();
            System.out.print("Digite o novo email: ");
            String novoEmail = scanner.nextLine();
            System.out.print("Digite o novo CPF: ");
            String novoCpf = scanner.nextLine();

            cliente.setNome(novoNome);
            cliente.setEndereco(novoEndereco);
            cliente.setTelefone(novoTelefone);
            cliente.setEmail(novoEmail);
            cliente.setCpf(novoCpf);

            System.out.println(clienteController.atualizar(cliente));
        } else {
            System.out.println("Cliente não encontrado.");
        }
        scanner.close();
    }

    public static void testarExclusao() {
        clienteController.excluir(0);
        System.out.println(clienteController.excluir(0));
    }

    // private static void limparBancoDeDados() {
    // List<Cliente> clientes = clienteController.listar();
    // for (Cliente cliente : clientes) {
    // clienteController.excluir(cliente.getId());
    // }
    // }
}
