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

@Entity
@Table(name = "historico")

/**
 * 
 * Histórico referente ao processo administrativo.
 * 
 * @author Juliana Barbosa
 */
public class Historico {
    
	/**
	 * Id do processo no banco de dados.
	 */	
    @Id
    private int id;
    /**
     * Data de criação do processo.
     */
    @Column
    private long data;
    /**
     * Unidade na qual o processo se encontra no momento.
     */
    @Column
    private int idUnidade;

    /**
     * Acessa o Id do processo.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Seta o Id do processo.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Acessa a data do processo.	
     *
     * @return data
     */
    public long getData() {
        return data;
    }

    /**
     * Seta a data do processo.
     * 
     * @param data
     */
    public void setData(long data) {
        this.data = data;
    }

    /**
     * Acessa o Id da unidade do processo.
     * 
     * @return idUnidade;
     */
    public int getIdUnidade() {
        return idUnidade;
    }

    /**
     * Seta o Id da unidade do processo.
     * 
     * @param idUnidade
     */
    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }
    
    

}
