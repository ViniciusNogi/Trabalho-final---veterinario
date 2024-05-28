package com.veterinario.controller;

import java.util.List;

import com.veterinario.model.DAO.IDAO;
import com.veterinario.model.entity.Consulta;

public class ConsultaController {

    private final IDAO<Consulta> consultaDAO;

    public ConsultaController(IDAO<Consulta> consultaDAO) {
        this.consultaDAO = consultaDAO;
    }

    public String cadastrar(Consulta consulta) {
        consultaDAO.cadastrar(consulta);
        return "Consulta cadastrado";
    }

    public String atualizar(Consulta consulta) {
        consultaDAO.atualizar(consulta);
        return "Consulta atualizado com sucesso!";
    }

    public String excluir(int id) {
        consultaDAO.excluir(id);
        return "Consulta excluída com sucesso!";
    }

    public Consulta buscar(int id) {
        return (Consulta) consultaDAO.buscar(id);
    }

    public List<Consulta> listar() {
        return consultaDAO.listar();
    }

}
