package com.veterinario.controller;

import java.util.List;

import com.veterinario.model.DAO.IDAO;
import com.veterinario.model.entity.Animal;

public class AnimalController {

    private final IDAO<Animal> animalDAO;

    public AnimalController(IDAO <Animal> animalDAO){
        this.animalDAO = animalDAO;
    }

    public String cadastrar(Animal animal){
        animalDAO.cadastrar(animal);
        return "Animal cadastrado!";
    }

    public String atualizar(Animal animal) {
    animalDAO.atualizar(animal);
    return "Animal atualizado com sucesso!";
    }

    public String excluir(int id) {
    animalDAO.excluir(id);
    return "Livro excluído com sucesso!";
    }

    public Animal buscar(int id) {
    return (Animal) animalDAO.buscar(id);
    }

    public List<Animal> listar() {
    return animalDAO.listar();
    }
}
