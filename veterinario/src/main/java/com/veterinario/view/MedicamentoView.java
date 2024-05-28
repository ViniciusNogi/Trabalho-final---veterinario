package com.veterinario.view;

import java.util.List;
import java.util.Scanner;
import com.veterinario.controller.MedicamentoController;
import com.veterinario.model.DAO.MedicamentoDAO;
import com.veterinario.model.entity.Medicamento;

public class MedicamentoView {

    private Scanner scanner = new Scanner(System.in);
    private MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
    private MedicamentoController medicamentoController = new MedicamentoController(medicamentoDAO);

    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- Gerenciamento de Medicamentos ---");
            System.out.println("1. Cadastrar Medicamento");
            System.out.println("2. Atualizar Medicamento");
            System.out.println("3. Excluir Medicamento");
            System.out.println("4. Buscar Medicamento por ID");
            System.out.println("5. Listar Medicamentos");
            System.out.println("6. Voltar");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    cadastrarMedicamento();
                    break;
                case 2:
                    atualizarMedicamento();
                    break;
                case 3:
                    excluirMedicamento();
                    break;
                case 4:
                    buscarMedicamentoPorId();
                    break;
                case 5:
                    listarMedicamentos();
                    break;
                case 6:
                    Menu menu = new Menu();
                    menu.menuPrincipal();
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void cadastrarMedicamento() {
        System.out.println("Cadastrando Medicamento...");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Medicamento medicamento = new Medicamento(id, nome, descricao);
        medicamentoController.cadastrar(medicamento);

        System.out.println("Medicamento cadastrado com sucesso!");
    }

    private void atualizarMedicamento() {
        System.out.println("Atualizando Medicamento...");
        System.out.print("Digite o ID do Medicamento que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Descrição: ");
        String descricao = scanner.nextLine();

        Medicamento medicamento = new Medicamento(id, nome, descricao);
        medicamentoController.atualizar(medicamento);

        System.out.println("Medicamento atualizado com sucesso!");
    }

    private void excluirMedicamento() {
        System.out.println("Excluindo Medicamento...");
        System.out.print("Digite o ID do Medicamento que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        medicamentoController.excluir(id);
        System.out.println("Medicamento excluído com sucesso!");
    }

    private void buscarMedicamentoPorId() {
        System.out.println("Buscando Medicamento por ID...");
        System.out.print("Digite o ID do Medicamento que deseja buscar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Medicamento medicamento = medicamentoController.buscar(id);

        if (medicamento != null) {
            System.out.println("Medicamento encontrado:");
            System.out.println(medicamento);
        } else {
            System.out.println("Medicamento não encontrado.");
        }
    }

    private void listarMedicamentos() {
        System.out.println("Listando Medicamentos...");
        List<Medicamento> medicamentos = medicamentoController.listar();

        if (!medicamentos.isEmpty()) {
            System.out.println("Medicamentos cadastrados:");
            for (Medicamento medicamento : medicamentos) {
                System.out.println(medicamento);
            }
        } else {
            System.out.println("Nenhum medicamento cadastrado.");
        }
    }
}
