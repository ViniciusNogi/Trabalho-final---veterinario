package com.veterinario.model.DAO;

import java.util.List;

import com.veterinario.model.entity.AbstractEntity;
public interface IDAO <T extends AbstractEntity>{
    
    void cadastrar(T entidade);

    void atualizar(T entidade);

    void excluir(int id);

    T buscar(int id);

    List<T> listar();

}
