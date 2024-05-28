package com.veterinario.model.entity;

public class Medicamento extends AbstractEntity {
    private String nome;
    private String descricao;

    public Medicamento(String nome, String descricao){
        this.nome = nome; 
        this.descricao = descricao;

    
    }
    public Medicamento(int idMedicamento, String nome, String descricao){
        super.setId(idMedicamento);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
