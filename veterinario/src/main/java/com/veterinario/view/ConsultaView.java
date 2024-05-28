package com.veterinario.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.veterinario.controller.ConsultaController;
import com.veterinario.model.DAO.ConsultaDAO;
import com.veterinario.model.entity.Consulta;

public class ConsultaView {

    private Scanner scanner = new Scanner(System.in);
    private ConsultaDAO consultaDAO = new ConsultaDAO();
    private ConsultaController consultaController = new ConsultaController(consultaDAO);

    public void exibirMenu() {
        while (true) {
            System.out.println("\n--- Gerenciamento de Consultas ---");
            System.out.println("1. Cadastrar Consulta");
            System.out.println("2. Atualizar Consulta");
            System.out.println("3. Excluir Consulta");
            System.out.println("4. Buscar Consulta por ID");
            System.out.println("5. Listar Consultas");
            System.out.println("6. Voltar");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    cadastrarConsulta();
                    break;
                case 2:
                    atualizarConsulta();
                    break;
                case 3:
                    excluirConsulta();
                    break;
                case 4:
                    buscarConsultaPorId();
                    break;
                case 5:
                    listarConsultas();
                    break;
                case 6:
                    Menu menu = new Menu();
                    menu.menuPrincipal();
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void cadastrarConsulta() {
        System.out.println("Cadastrando Consulta...");
        System.out.print("ID do Veterinário: ");
        int idVeterinario = Integer.parseInt(scanner.nextLine());
        System.out.print("ID do Cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        System.out.print("ID do Animal: ");
        int idAnimal = Integer.parseInt(scanner.nextLine());
        System.out.print("Data (AAAA-MM-DD): ");
        Date data = Date.valueOf(scanner.nextLine());
        System.out.print("Hora: ");
        String hora = scanner.nextLine();
        System.out.print("Motivo da Consulta: ");
        String motivoConsulta = scanner.nextLine();
        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine();

        Consulta consulta = new Consulta(idVeterinario, idCliente, idAnimal, data, hora, motivoConsulta, diagnostico);
        consultaController.cadastrar(consulta);

        System.out.println("Consulta cadastrada com sucesso!");
    }

    private void atualizarConsulta() {
        System.out.println("Atualizando Consulta...");
        System.out.print("Digite o ID da Consulta que deseja atualizar: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo ID do Veterinário: ");
        int idVeterinario = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo ID do Cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo ID do Animal: ");
        int idAnimal = Integer.parseInt(scanner.nextLine());
        System.out.print("Nova Data (AAAA-MM-DD): ");
        Date data = Date.valueOf(scanner.nextLine());
        System.out.print("Nova Hora: ");
        String hora = scanner.nextLine();
        System.out.print("Novo Motivo da Consulta: ");
        String motivoConsulta = scanner.nextLine();
        System.out.print("Novo Diagnóstico: ");
        String diagnostico = scanner.nextLine();

        Consulta consulta = new Consulta(idConsulta, idVeterinario, idCliente, idAnimal, data, hora, motivoConsulta,
                diagnostico);
        consultaController.atualizar(consulta);

        System.out.println("Consulta atualizada com sucesso!");
    }

    private void excluirConsulta() {
        System.out.println("Excluindo Consulta...");
        System.out.print("Digite o ID da Consulta que deseja excluir: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        consultaController.excluir(idConsulta);
        System.out.println("Consulta excluída com sucesso!");
    }

    private void buscarConsultaPorId() {
        System.out.println("Buscando Consulta por ID...");
        System.out.print("Digite o ID da Consulta que deseja buscar: ");
        int idConsulta = Integer.parseInt(scanner.nextLine());
        Consulta consulta = consultaController.buscar(idConsulta);

        if (consulta != null) {
            System.out.println("Consulta encontrada:");
            System.out.println(consulta);
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    private void listarConsultas() {
        System.out.println("Listando Consultas...");
        List<Consulta> consultas = consultaController.listar();

        if (!consultas.isEmpty()) {
            System.out.println("Consultas cadastradas:");
            for (Consulta consulta : consultas) {
                System.out.println(consulta);
            }
        } else {
            System.out.println("Nenhuma consulta cadastrada.");
        }
    }
}
