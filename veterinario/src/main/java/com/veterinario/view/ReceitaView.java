package com.veterinario.view;

import java.util.List;
import java.util.Scanner;
import com.veterinario.controller.ReceitaController;
import com.veterinario.model.DAO.ReceitaDAO;
import com.veterinario.model.entity.Receita;

public class ReceitaView {

    private Scanner scanner = new Scanner(System.in);
    private ReceitaDAO receitaDAO = new ReceitaDAO();
    private ReceitaController receitaController = new ReceitaController(receitaDAO);

    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- Gerenciamento de Receitas ---");
            System.out.println("1. Cadastrar Receita");
            System.out.println("2. Atualizar Receita");
            System.out.println("3. Excluir Receita");
            System.out.println("4. Buscar Receita por ID");
            System.out.println("5. Listar Receitas");
            System.out.println("6. Voltar");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    cadastrarReceita();
                    break;
                case 2:
                    atualizarReceita();
                    break;
                case 3:
                    excluirReceita();
                    break;
                case 4:
                    buscarReceitaPorId();
                    break;
                case 5:
                    listarReceitas();
                    break;
                case 6:
                    Menu menu = new Menu();
                    menu.menuPrincipal();
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void cadastrarReceita() {
        System.out.println("Cadastrando Receita...");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("ID da Consulta: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        System.out.print("ID do Medicamento: ");
        int idMedicamento = Integer.parseInt(scanner.nextLine());

        Receita receita = new Receita(id, idConsulta, idMedicamento);
        receitaController.cadastrar(receita);

        System.out.println("Receita cadastrada com sucesso!");
    }

    private void atualizarReceita() {
        System.out.println("Atualizando Receita...");
        System.out.print("Digite o ID da Receita que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo ID da Consulta: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo ID do Medicamento: ");
        int idMedicamento = Integer.parseInt(scanner.nextLine());

        Receita receita = new Receita(id, idConsulta, idMedicamento);
        receitaController.atualizar(receita);

        System.out.println("Receita atualizada com sucesso!");
    }

    private void excluirReceita() {
        System.out.println("Excluindo Receita...");
        System.out.print("Digite o ID da Receita que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());
        receitaController.excluir(id);
        System.out.println("Receita excluída com sucesso!");
    }

    private void buscarReceitaPorId() {
        System.out.println("Buscando Receita por ID...");
        System.out.print("Digite o ID da Receita que deseja buscar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Receita receita = receitaController.buscar(id);

        if (receita != null) {
            System.out.println("Receita encontrada:");
            System.out.println(receita);
        } else {
            System.out.println("Receita não encontrada.");
        }
    }

    private void listarReceitas() {
        System.out.println("Listando Receitas...");
        List<Receita> receitas = receitaController.listar();

        if (!receitas.isEmpty()) {
            System.out.println("Receitas cadastradas:");
            for (Receita receita : receitas) {
                System.out.println(receita);
            }
        } else {
            System.out.println("Nenhuma receita cadastrada.");
        }
    }
}
