package com.veterinario.controller;

import java.util.List;

import com.veterinario.model.DAO.IDAO;
import com.veterinario.model.entity.Medicamento;

public class MedicamentoController {

    private final IDAO<Medicamento> medicamentoDAO;

    public MedicamentoController(IDAO<Medicamento> medicamentoDAO) {
        this.medicamentoDAO = medicamentoDAO;
    }

    public String cadastrar(Medicamento medicamento) {
        medicamentoDAO.cadastrar(medicamento);
        return "Medicamento cadastrado";
    }

    public String atualizar(Medicamento medicamento) {
        medicamentoDAO.atualizar(medicamento);
        return "Medicamento atualizado com sucesso!";
    }

    public String excluir(int id) {
        medicamentoDAO.excluir(id);
        return "Medicamento excluído com sucesso!";
    }

    public Medicamento buscar(int id) {
        return (Medicamento) medicamentoDAO.buscar(id);
    }

    public List<Medicamento> listar() {
        return medicamentoDAO.listar();
    }

}
