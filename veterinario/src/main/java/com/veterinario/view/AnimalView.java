package com.veterinario.view;

import java.util.List;
import java.util.Scanner;

import com.veterinario.controller.AnimalController;
import com.veterinario.model.DAO.AnimalDAO;
import com.veterinario.model.DAO.ClienteDAO;
import com.veterinario.model.entity.Animal;
import com.veterinario.model.entity.Cliente;

public class AnimalView {
  
    private Scanner scanner = new Scanner(System.in);
    AnimalDAO animalDAO = new AnimalDAO();
    AnimalController animalController = new AnimalController(animalDAO);
    ClienteDAO clienteDAO = new ClienteDAO();


    public void exibirMenu() {
        
        
        while (true) {

            System.out.println("\n--- Gerenciamento de Animais ---");
            System.out.println("1. Cadastrar Animal");
            System.out.println("2. Atualizar Animal");
            System.out.println("3. Excluir Animal");
            System.out.println("4. Buscar Animal");
            System.out.println("5. Listar Animais");
            System.out.println("6. Voltar");        

            
            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    cadastrarAnimal(); 
                    break;
                case 2:
                    atualizarAnimal();
                    break;
                case 3:
                    excluirAnimal();
                    break;
                case 4:
                    buscarAnimal(); 
                    break;
                case 5:
                    listaAnimal(); 
                    break;
                case 6:
                    Menu menu = new Menu();
                    menu.menuPrincipal(); 
                default:
                    System.out.println("Escolha inválida.");
                    return;
            }
        }
    }


    private void cadastrarAnimal() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("ID do Cliente (Dono): ");
        int idCliente = Integer.parseInt(scanner.nextLine());

        Cliente dono = new Cliente(idCliente, null, null, null, null, null);

        Animal animal = new Animal(id, nome, raca, idade, sexo, dono);
        animalController.cadastrar(animal);
        System.out.println("Animal cadastrado com sucesso!");
    }

    
    private void atualizarAnimal() {
        System.out.print("ID do Animal: ");
        int id = Integer.parseInt(scanner.nextLine());
        Animal animal = animalDAO.buscar(id);
        if (animal == null) {
            System.out.println("Animal não encontrado!");
            return;
        }

        System.out.print("Nome (" + animal.getNome() + "): ");
        String nome = scanner.nextLine();
        System.out.print("Raça (" + animal.getRaca() + "): ");
        String raca = scanner.nextLine();
        System.out.print("Idade (" + animal.getIdade() + "): ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Sexo (" + animal.getSexo() + "): ");
        String sexo = scanner.nextLine();
        System.out.print("ID do Cliente (Dono) (" + animal.getDono().getId() + "): ");
        int idCliente = Integer.parseInt(scanner.nextLine());

        Cliente dono = clienteDAO.buscar(idCliente);
        if (dono == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        animal.setNome(nome);
        animal.setRaca(raca);
        animal.setIdade(idade);
        animal.setSexo(sexo);
        animal.setDono(dono);

        animalController.atualizar(animal);
        System.out.println("Animal atualizado com sucesso!");
    }

  
    private void excluirAnimal() {
        System.out.print("ID do Animal: ");
        int id = Integer.parseInt(scanner.nextLine());
        animalController.excluir(id);
        System.out.println("Animal excluído com sucesso!");
    }

    private void buscarAnimal() {
        System.out.print("ID do Animal: ");
        int id = Integer.parseInt(scanner.nextLine());
        Animal animal = animalController.buscar(id);
        if (animal != null) {
            System.out.println("Animal encontrado:");
            System.out.println(animal.getNome());
            System.out.println(animal.getRaca());
            System.out.println(animal.getIdade());
            System.out.println(animal.getSexo());
            System.out.println(animal.getDono());
            
            System.out.println(animal);
        } else {
            System.out.println("Animal não encontrado.");
        }
    }

     private void listaAnimal() {
        List<Animal> animais = animalController.listar();
        if (!animais.isEmpty()) {
            System.out.println("Lista de Animais:");
            for (Animal animal : animais) {
                System.out.println("Animal ID: " + animal.getId());
                System.out.println("Nome: " + animal.getNome());
                System.out.println("Raca: " + animal.getRaca());
                System.out.println("Idade: " + animal.getIdade());
                System.out.println("Sexo: " + animal.getSexo());
                System.out.println("Dono ID: " + animal.getDono().getId());
                System.out.println(" ");
            }
        } else {
            System.out.println("Nenhum animal cadastrado.");
        }
    }
}
