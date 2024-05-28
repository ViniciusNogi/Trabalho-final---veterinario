package com.veterinario.model.entity;

public class Animal extends AbstractEntity{

    private String nome;
    private String raca;
    private int idade;
    private String sexo;
    private Cliente dono;
    
    
    // o codigo esta incompleto precisa preencher os atributos, os dois metodos construtores e os getters e setters
    public Animal(String nome, String raca, int idade, String sexo, Cliente dono){
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.dono = dono;
    }

    public Animal(int idAnimal, String nome, String raca, int idade, String sexo, Cliente dono){
        super.setId(idAnimal);
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.dono = dono;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

}
