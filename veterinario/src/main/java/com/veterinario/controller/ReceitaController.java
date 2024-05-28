package com.veterinario.controller;

import java.util.List;

import com.veterinario.model.DAO.IDAO;
import com.veterinario.model.entity.Receita;

public class ReceitaController {

    private final IDAO<Receita> receitaDAO;

    public ReceitaController(IDAO <Receita> animalDAO){
        this.receitaDAO = animalDAO;
    }

    public String cadastrar(Receita receita){
        receitaDAO.cadastrar(receita);
        return "Receita cadastrado!";
    }

    public String atualizar(Receita receita) {
    receitaDAO.atualizar(receita);
    return "Receita atualizado com sucesso!";
    }

    public String excluir(int id) {
    receitaDAO.excluir(id);
    return "Receita excluído com sucesso!";
    }

    public Receita buscar(int id) {
    return (Receita) receitaDAO.buscar(id);
    }

    public List<Receita> listar() {
    return receitaDAO.listar();
    }
}
