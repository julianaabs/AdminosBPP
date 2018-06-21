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
@Table(name = "tipo")

/**
 * 	Essa entidade é responsável pelas informações relativas ao tipo do processo administrativo.
 *
 * @author Juliana Barbosa
 */
public class Tipo {

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
     * 	Acessa a descrição do tipo de processo.
     * 
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * 	Seta a descrição do tipo de processo.
     * 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
