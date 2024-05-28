package com.veterinario.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends AbstractEntity {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;    
    private List<Animal> animais;
    

    public Cliente(String nome,String endereco,String telefone, String email, String cpf ){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.animais = new ArrayList<>();

    }

    public Cliente(int idCliente,String nome,String endereco,String telefone, String email, String cpf ){
        super.setId(idCliente);
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.animais = new ArrayList<>();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

}