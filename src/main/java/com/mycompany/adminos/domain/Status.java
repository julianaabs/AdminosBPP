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
@Table(name = "status")

/**
 * 	Descreve o status atual do processo administrativo.
 *
 * @author Juliana Barbosa
 */
public class Status {

    @Id
    private int id;
    @Column
    private String descricao;

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
     * 	Acessa a descri��o do status do processo administrativo.
     * 
     * @return descricao
     * 
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * 	Seta a descri��o do status do processo administrativo.
     * 
     * @param descricao
     * 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
