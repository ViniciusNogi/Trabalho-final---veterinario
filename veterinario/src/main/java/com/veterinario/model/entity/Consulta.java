package com.veterinario.model.entity;

import java.sql.Date;

public class Consulta extends AbstractEntity {

    private int idVeterinario;
    private int idCliente;
    private int idAnimal;
    private Date data;
    private String hora;
    private String motivoConsulta;
    private String diagnostico;

    public Consulta(int idVeterinario, int idCliente, int idAnimal,  Date data, String hora, String motivoConsulta, String diagnostico) {
        this.idVeterinario = idVeterinario;
        this.idCliente = idCliente;
        this.idAnimal = idAnimal;
        this.data = data;
        this.hora = hora;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;

    }

    public Consulta(int idConsulta, int idVeterinario, int idCliente, int idAnimal,  Date data, String hora, String motivoConsulta, String diagnostico) {
        super.setId(idConsulta);
        this.idVeterinario = idVeterinario;
        this.idCliente = idCliente;
        this.idAnimal = idAnimal;
        this.data = data;
        this.hora = hora;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;

    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

   
}