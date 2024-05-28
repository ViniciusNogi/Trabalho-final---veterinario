package com.veterinario.view;

import java.util.Scanner; 

public class Menu { 
    
    private Scanner scanner = new Scanner(System.in); 
    
    private AnimalView animalView = new AnimalView();
    private ClienteView donoView = new ClienteView();
    private VeterinarioView funcionarioView = new VeterinarioView();
    private ConsultaView consultaView = new ConsultaView();
    private ReceitaView servicoView = new ReceitaView();
    private MedicamentoView medicamentoView = new MedicamentoView();

  
    public void menuPrincipal() {
        int escolha;

        do { 
            System.out.println("\n--- Sistema de Clínica Veterinária ---");
            System.out.println("1. Gerenciamento de Animais.");
            System.out.println("2. Gerenciamento de Cliente.");
            System.out.println("3. Gerenciamento de Veterinarios.");
            System.out.println("4. Gerenciamento de Consultas.");
            System.out.println("5. Gerenciamento de Receitas.");
            System.out.println("6. Gerenciamento de Medicamentos.");
            System.out.println("7. Sair");
            
            escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    animalView.exibirMenu();
                    break;
                case 2:
                    donoView.exibirMenu();
                    break;
                case 3:
                    funcionarioView.exibirMenu();
                    break;
                case 4:
                    consultaView.exibirMenu();
                    break;
                case 5:
                    servicoView.exibirMenu();
                    break;
                case 6:
                    medicamentoView.exibirMenu();
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    break;
            }
        } while (escolha != 7);
    }
 
}