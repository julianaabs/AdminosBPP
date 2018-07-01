/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adminos.src;

import DAO.ProcessoJpaDAO;
import com.mycompany.adminos.domain.Processo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *	Managed Bean do processo.
 *
 * 	@author Juliana Barbosa
 */
@ManagedBean(name = "processoManagedBean")
@RequestScoped
public class ProcessoMB {

	/**
	 *	Bean do processo.
	 */
    @EJB
    private static ProcessoJpaDAO dao;

    /**
     * 	Campos auxiliares para o JSF.
     */
    private List<Processo> processoList = new ArrayList<>();
    
    public Processo processo = new Processo();

    /**
     *	Adiciona novo processo na lista.	
     * 
     * @return employeelist
     */
    public String addNewProcesso() {
        dao.persist(processo);
        processoList = dao.findAll();
        return "employeelist";
    }
}
