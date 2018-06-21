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
 * 	Entidade responsável por todas as informações relativas ao processo administrativo, 
 * incluindo seu estado atual. Todo o controle de processo é localizado nessa entidade.
 *
 * @author Juliana Barbosa
 */

@Entity
@Table(name = "processo")

public class Processo {

	/**
	 * 	Id do processo no banco.
	 */
    @Id
    private int id;
    
    /**
     * 	Nome do processo.
     */
    @Column
    private String processo;
    
    /**
     * 	Contém possíveis observações sobre o processo.
     */
    @Column
    private String observacao;
    
    /**
     *	Assunto sobre o qual se trata processo.	
     */
    @Column
    private String assunto;
    
    /**
     * 	Ano do processo.
     */
    @Column
    private int ano;
    
    /**
     * 	Id do tipo de processo.
     */
    @Column
    private int idTipo;
    
    /**
     * 	Id do status do projeto.
     */
    @Column
    private int idStatus;
    
    /**
     * 	Id do interessado no processo.
     */
    @Column
    private int idInteressado;
    
    /**
     * 	Id da unidade de origem do processo.
     * 
     */
    @Column
    private int idUnidadeOrigem;
    
    /**
     * Acessa o Id no banco.
     * 
     * @return id
     * 
     */
    public int getId() {
        return id;
    }
    
    /**
     * 	Seta o Id.
     * @param id
     * 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * 	Acessa o nome do processo.
     * 
     * @param id
     * 
     */
    public String getProcesso() {
        return processo;
    }
    
    /**
     * 
     * @param processo
     */
    public void setProcesso(String processo) {
        this.processo = processo;
    }

    /**
     * 	Acessa a observação do processo.
     * 
     * @return observacao
     * 
     */
    public String getObservacao() {
        return observacao;
    }
    
    /**
     * 	Seta a observação do processo.
     * 
     * @param observacao
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * 	Acessa o assunto do processo.
     * 
     * @return assunto
     * 
     */
    public String getAssunto() {
        return assunto;
    }
    
    /**
     * 	Seta o assunto do processo.
     * 
     * @param assunto
     * 
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    /**
     * 	Acessa o ano do processo.
     * 
     * @return ano
     * 
     */
    public int getAno() {
        return ano;
    }
    
    /**
     * 
     * @param ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * 	Acessa o Id do tipo do processo.
     * 
     * @return idTipo
     * 
     */
    public int getIdTipo() {
        return idTipo;
    }
    
    /**
     * 
     * @param idTipo
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * 	Acessa o Id do status.
     * 
     * @return idStatus
     * 
     */
    public int getIdStatus() {
        return idStatus;
    }
    
    /**
     * 	Seta o Id do status do processo.
     * 
     * @param idStatus
     * 
     */
    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    /**
     * 	Acessa o Id do interessado no processo.
     * 
     * @return idInteressado
     * 
     */
    public int getIdInteressado() {
        return idInteressado;
    }
    
    /**
     * 	Seta o Id do interessado no processo.
     * 
     * @param idInteressado
     * 
     */
    public void setIdInteressado(int idInteressado) {
        this.idInteressado = idInteressado;
    }

    /**
     * 	Acessa o Id da unidade de origem do processo.
     * 
     * @return idUnidadeOrigem
     * 
     */
    public int getIdUnidadeOrigem() {
        return idUnidadeOrigem;
    }

    /**
     * 	Seta o Id da unidade de origem do processo.
     * 
     * @param idUnidadeOrigem
     * 
     */
    public void setIdUnidadeOrigem(int idUnidadeOrigem) {
        this.idUnidadeOrigem = idUnidadeOrigem;
    }

}
