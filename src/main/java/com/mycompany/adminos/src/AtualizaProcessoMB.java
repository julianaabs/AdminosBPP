package com.mycompany.adminos.src;

import DAO.ProcessoJpaDAO;
import com.mycompany.adminos.domain.Processo;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="updateProcessoManagedBean")
@RequestScoped

/**
 * 	Classe responsável por atualizar o processo na aplicação.
 * 
 * @author Juliana Barbosa
 *
 */

public class AtualizaProcessoMB {
	
	/**
	 * 	Managed Bean do processo.
	 */
	@EJB
	private static ProcessoJpaDAO daoProcesso;
	
	public Processo processo = new Processo();
	
	/**
	 * 	Atualiza o processo e retorna a lista atualizada.	
	 * 
	 * @return employeelist
	 */
	public String updateNewProcesso() {
		daoProcesso.update(processo);
		return "employeelist";
	}

}
