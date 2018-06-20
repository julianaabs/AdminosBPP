/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adminos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 	
 *
 * @author Juliana Barbosa
 */
@Entity
@Table(name = "processo")

public class Processo {

    @Id
    private int id;
    @Column
    private String processo;
    @Column
    private String observacao;
    @Column
    private String assunto;
    @Column
    private int ano;
    @Column
    private int idTipo;
    @Column
    private int idStatus;
    @Column
    private int idInteressado;
    @Column
    private int idUnidadeOrigem;

    public int getId() {
        return id;
    }

    public String getProcesso() {
        return processo;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getAssunto() {
        return assunto;
    }

    public int getAno() {
        return ano;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public int getIdInteressado() {
        return idInteressado;
    }

    public int getIdUnidadeOrigem() {
        return idUnidadeOrigem;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public void setIdInteressado(int idInteressado) {
        this.idInteressado = idInteressado;
    }

    public void setIdUnidadeOrigem(int idUnidadeOrigem) {
        this.idUnidadeOrigem = idUnidadeOrigem;
    }

}
