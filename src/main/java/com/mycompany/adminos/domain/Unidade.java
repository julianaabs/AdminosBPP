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
@Table(name = "unidade")

/**
 *	Gerencia as informações da unidade do processo administrativo.
 *
 * @author Juliana Barbosa
 */
public class Unidade {

	/**
	 *	Id da unidade no banco.
	 */
    @Id
    private int id;
    
    /**
     *	Nome da unidade do processo.
     */
    @Column
    private String nomeUnidade;
    
    /**
     * Acessa o Id no banco.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Seta o Id.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 	Acessa o nome da unidade.
     * 
     * @return nomeUnidade
     * 
     */
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    /**
     * 	Seta o nome da unidade do processo.
     * 
     * @param nomeUnidade
     */
    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

}
