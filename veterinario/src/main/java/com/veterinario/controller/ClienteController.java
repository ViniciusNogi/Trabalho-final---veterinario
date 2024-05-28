package com.veterinario.controller;

import java.util.List;

import com.veterinario.model.DAO.IDAO;
import com.veterinario.model.entity.Cliente;

public class ClienteController {

    private final IDAO<Cliente> clienteDAO;

    public ClienteController(IDAO<Cliente> clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public String cadastrar(Cliente cliente) {
        clienteDAO.cadastrar(cliente);
        return "Cliente cadastrado";
    }

    public String atualizar(Cliente cliente) {
        clienteDAO.atualizar(cliente);
        return "Cliente atualizado com sucesso!";
    }

    public String excluir(int id) {
        clienteDAO.excluir(id);
        return "Cliente excluído com sucesso!";
    }

    public Cliente buscar(int id) {
        return (Cliente) clienteDAO.buscar(id);
    }

    public List<Cliente> listar() {
        return clienteDAO.listar();
    }

}
