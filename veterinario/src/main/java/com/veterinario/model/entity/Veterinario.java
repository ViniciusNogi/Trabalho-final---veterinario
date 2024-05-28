package com.veterinario.model.entity;

public class Veterinario extends AbstractEntity {

    private String nome;
    private String especializacao;

    public Veterinario(String nome, String especializacao) {
        this.nome = nome;
        this.especializacao = especializacao;
    }

    public Veterinario(int idVeterinario, String nome, String especializacao) {
        super.setId(idVeterinario);
        this.nome = nome;
        this.especializacao = especializacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
