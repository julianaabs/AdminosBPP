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
@Table(name = "interessado")

/**
 * 	Essa clase gerencia o usu�rio interessado no processo administrativo, suas a��es
 * e informa��es.	
 *
 * 	@author Juliana Barbosa
 */
public class Interessado {

	/**
	 * 	Id do usu�rio no banco de dados.
	 */
    @Id
    private int id;    
    /**
     * 	Nome do usu�rio interessado no processo.
     */
    @Column
    private String nome;
    /**
     * 
     */
    @Column
    private String tipo;
    /**
     * 	Matr�cula do usu�rio interessado no processo.
     */
    @Column
    private String matricula;

    /**
     * 	Acessa o Id do usu�rio interessado.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 	Seta o Id do usu�rio interessado.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 	Acessa o nome do usu�rio interessado.
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * 	Seta o nome do usu�rio interessado.
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *	Acessa a matr�cula do interessado.
     * 
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * 	Seta a matr�cula do interessado.
     * 
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
