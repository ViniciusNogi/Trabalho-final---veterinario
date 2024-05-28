package com.veterinario.view;

import java.util.List;
import java.util.Scanner;
import com.veterinario.controller.ClienteController;
import com.veterinario.model.DAO.ClienteDAO;
import com.veterinario.model.entity.Cliente;

public class ClienteView {
  
    private Scanner scanner = new Scanner(System.in);
    ClienteDAO clienteDAO = new ClienteDAO();
    ClienteController clienteController = new ClienteController(clienteDAO);

    public void exibirMenu() {
        
        while (true) {
            System.out.println("\n--- Gerenciamento de Clientes ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Buscar Cliente por ID");
            System.out.println("5. Listar Clientes");
            System.out.println("6. Voltar");        

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    atualizarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    buscarClientePorId();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    Menu menu = new Menu();
                    menu.menuPrincipal(); 
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void cadastrarCliente() {
        System.out.println("Cadastrando Cliente...");

       
        System.out.print("Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

       
        Cliente cliente = new Cliente(id , nome, endereco, telefone, email, cpf);

       
        clienteController.cadastrar(cliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void atualizarCliente() {
        System.out.println("Atualizando Cliente...");
        
        System.out.print("Digite o ID do Cliente que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

       
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();

        
        Cliente cliente = new Cliente(id, nome, endereco, telefone, email, cpf);

        
        clienteController.atualizar(cliente);

        System.out.println("Cliente atualizado com sucesso!");
    }

    private void excluirCliente() {
        System.out.println("Excluindo Cliente...");
        
        System.out.print("Digite o ID do Cliente que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        clienteController.excluir(id);

        System.out.println("Cliente excluído com sucesso!");
    }

    private void buscarClientePorId() {
        System.out.println("Buscando Cliente por ID...");
      
        System.out.print("Digite o ID do Cliente que deseja buscar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Cliente cliente = clienteController.buscar(id);

        if (cliente != null) {
            
            System.out.println("Cliente encontrado:");
            System.out.println(cliente.getNome());
            System.out.println(cliente.getEndereco());
            System.out.println(cliente.getTelefone());
            System.out.println(cliente.getEmail());
            System.out.println(cliente.getCpf());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void listarClientes() {
        System.out.println("Listando Clientes...");
        
        List<Cliente> clientes = clienteController.listar();

        if (!clientes.isEmpty()) {
          
            System.out.println("Clientes cadastrados:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } else {
            System.out.println("Nenhum cliente cadastrado.");
        }
    }
}
