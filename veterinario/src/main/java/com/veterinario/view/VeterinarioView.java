package com.veterinario.view;

import java.util.List;
import java.util.Scanner;
import com.veterinario.controller.VeterinarioController;
import com.veterinario.model.DAO.VeterinarioDAO;
import com.veterinario.model.entity.Veterinario;

public class VeterinarioView {

    private Scanner scanner = new Scanner(System.in);
    private VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
    private VeterinarioController veterinarioController = new VeterinarioController(veterinarioDAO);

    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- Gerenciamento de Veterinários ---");
            System.out.println("1. Cadastrar Veterinário");
            System.out.println("2. Atualizar Veterinário");
            System.out.println("3. Excluir Veterinário");
            System.out.println("4. Buscar Veterinário por ID");
            System.out.println("5. Listar Veterinários");
            System.out.println("6. Voltar");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    cadastrarVeterinario();
                    break;
                case 2:
                    atualizarVeterinario();
                    break;
                case 3:
                    excluirVeterinario();
                    break;
                case 4:
                    buscarVeterinarioPorId();
                    break;
                case 5:
                    listarVeterinarios();
                    break;
                case 6:
                    Menu menu = new Menu();
                    menu.menuPrincipal();
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void cadastrarVeterinario() {
        System.out.println("Cadastrando Veterinário...");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Especialização: ");
        String especializacao = scanner.nextLine();

        Veterinario veterinario = new Veterinario(id, nome, especializacao);
        veterinarioController.cadastrar(veterinario);

        System.out.println("Veterinário cadastrado com sucesso!");
    }

    private void atualizarVeterinario() {
        System.out.println("Atualizando Veterinário...");
        System.out.print("Digite o ID do Veterinário que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Especialização: ");
        String especializacao = scanner.nextLine();

        Veterinario veterinario = new Veterinario(id, nome, especializacao);
        veterinarioController.atualizar(veterinario);

        System.out.println("Veterinário atualizado com sucesso!");
    }

    private void excluirVeterinario() {
        System.out.println("Excluindo Veterinário...");
        System.out.print("Digite o ID do Veterinário que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        veterinarioController.excluir(id);
        System.out.println("Veterinário excluído com sucesso!");
    }

    private void buscarVeterinarioPorId() {
        System.out.println("Buscando Veterinário por ID...");
        System.out.print("Digite o ID do Veterinário que deseja buscar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Veterinario veterinario = veterinarioController.buscar(id);

        if (veterinario != null) {
            System.out.println("Veterinário encontrado:");
            System.out.println(veterinario);
        } else {
            System.out.println("Veterinário não encontrado.");
        }
    }

    private void listarVeterinarios() {
        System.out.println("Listando Veterinários...");
        List<Veterinario> veterinarios = veterinarioController.listar();

        if (!veterinarios.isEmpty()) {
            System.out.println("Veterinários cadastrados:");
            for (Veterinario veterinario : veterinarios) {
                System.out.println(veterinario);
            }
        } else {
            System.out.println("Nenhum veterinário cadastrado.");
        }
    }
}
