package com.veterinario.controller;

import java.util.List;

import com.veterinario.model.DAO.IDAO;
import com.veterinario.model.entity.Veterinario;

public class VeterinarioController {

    private final IDAO<Veterinario> VeterinarioDAO;

    public VeterinarioController(IDAO<Veterinario> veterinarioDAO) {
        this.VeterinarioDAO = veterinarioDAO;
    }

    public String cadastrar(Veterinario veterinario) {
        VeterinarioDAO.cadastrar(veterinario);
        return "Veterinário cadastrado";
    }

    public String atualizar(Veterinario veterinario) {
        VeterinarioDAO.atualizar(veterinario);
        return "Veterinário atualizado com sucesso!";
    }

    public String excluir(int id) {
        VeterinarioDAO.excluir(id);
        return "Veterinário excluído com sucesso!";
    }

    public Veterinario buscar(int id) {
        return (Veterinario) VeterinarioDAO.buscar(id);
    }

    public List<Veterinario> listar() {
        return VeterinarioDAO.listar();
    }
}
