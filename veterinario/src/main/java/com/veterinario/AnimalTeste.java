package com.veterinario;

import java.util.List;

import com.veterinario.controller.AnimalController;
import com.veterinario.model.DAO.AnimalDAO;
import com.veterinario.model.entity.Animal;
import com.veterinario.model.entity.Cliente;

public class AnimalTeste {
    private static AnimalController animalController;

    public static void main(String[] args) {
        AnimalDAO animalDAO = new AnimalDAO();
        animalController = new AnimalController(animalDAO);

        // Execute os testes
        testarCadastro();
        //testarListagem();
        //testarBusca();
        // testarAtualizacao();
        // testarExclusao();
    }

    public static void testarCadastro() {
    
        Cliente dono = new Cliente(2 , null,null,null,null,null );
        Animal animal = new Animal( 12, "chupança", "labrador", 1, "M", dono);
        System.out.println(animalController.cadastrar(animal));
    }



    
    public static void testarListagem() {
        List<Animal> animais = animalController.listar();
        for (Animal animal : animais) {
            System.out.println("Animal ID: " + animal.getId());
            System.out.println("Nome: " + animal.getNome());
            System.out.println("Raca: " + animal.getRaca());
            System.out.println("Idade: " + animal.getIdade());
            System.out.println("Sexo: " + animal.getSexo());
            System.out.println("Dono ID: " + animal.getDono().getId());
            System.out.println("Dono Nome: " + animal.getDono().getNome());
            System.out.println(" ");
        }
    }

    // public static void testarListagem() {
    //     AnimalDAO animalDAO = new AnimalDAO();
    //     List<Animal> animais = animalDAO.listar();
    //     for (Animal animal : animais) {
    //         System.out.println("Animal: " + animal.getNome() + " (" + animal.getId() + ")");
    //         System.out.println("  Dono: " + animal.getDono().getNome() + " (" + animal.getDono().getId() + ")");
    //         System.out.println();
    //     }
    // }

    public static void testarBusca() {
        Animal animalBuscar = animalController.buscar(1);
        System.out.println("Animal buscado: " + animalBuscar.getNome());
    }

    // public static void testarAtualizacao() {
    //     Cliente cliente = new Cliente("Carlos Souza", "Rua E, 345", "456456456", "carlos@example.com", "55566677788");
    //     clienteController.cadastrar(cliente);
    //     cliente.setEndereco("Rua F, 678");
    //     System.out.println(clienteController.atualizar(cliente));
    // }

    // public static void testarExclusao() {
    //     Cliente cliente = new Cliente("Juliana Mota", "Rua G, 901", "789789789", "juliana@example.com", "66677788899");
    //     clienteController.cadastrar(cliente);
    //     System.out.println(clienteController.excluir(cliente.getId()));
    // }

    // private static void limparBancoDeDados() {
    // List<Cliente> clientes = clienteController.listar();
    // for (Cliente cliente : clientes) {
    // clienteController.excluir(cliente.getId());
    // }
    //}
}
