package com.veterinario.model.entity;


public class Receita extends AbstractEntity {
   
    private int idConsulta;
    private int idMedicamento;

    public Receita(int idConsulta, int idMedicamento) {
        
        this.idConsulta = idConsulta;
        this.idMedicamento = idMedicamento;
    
    }

    public Receita(int idReceita, int idConsulta, int idMedicamento) {
        super.setId(idReceita);
        this.idConsulta = idConsulta;
        this.idMedicamento = idMedicamento;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    
}
