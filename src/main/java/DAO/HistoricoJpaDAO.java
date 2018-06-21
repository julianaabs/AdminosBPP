/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Historico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *	Bean stateless de sess�o do hist�rico, respons�vel por instanciar a entidade Hist�rico na
 * aplica��o. 
 *
 * @author Juliana Barbosa
 */
@Stateless
public class HistoricoJpaDAO implements IServiceRemoteDAO {

	/**
	 * 	Inst�ncia do hist�rico.
	 */
    private static HistoricoJpaDAO instance;
    
    /**
     * 	Gerenciador de entidade.
     */
    private EntityManager entityManager;

    /**
     * 	Acessa a inst�ncia e, se ela ainda n�o existir, � criada.
     * 
     * @return instance
     * 
     */
    public static HistoricoJpaDAO getInstance() {
        if (instance == null) {
            instance = new HistoricoJpaDAO();
        }

        return instance;
    }

    /**
     * 	Acessa o gerenciador de entidade caso ele j� exista. Se n�o, ele � criado.
     * 
     * @return entityManager
     * 
     */
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminosPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    /**
     * 	Retorna a inst�ncia atrav�s do Id.
     * 
     * @param id
     * @return entityManager
     */
    public Historico getById(final int id) {
        return entityManager.find(Historico.class, id);
    }

    /**
     * 	Acessa a lista de hist�ricos.
     * 
     * @return entityManager list
     */
    public List<Historico> findAll() {
        return entityManager.createQuery("FROM" + Historico.class.getName()).getResultList();
    }

    /**
     * 
     * @param historico
     * 
     */
    public void persist(Historico historico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(historico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 
     * @param historico
     * 
     */
    public void merge(Historico historico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(historico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    /**
     * 	Remove hist�rico da entidade.
     * 
     * @param historico
     * 
     */
    public void remove(Historico historico) {
        try {
            entityManager.getTransaction().begin();
            historico = entityManager.find(Historico.class, historico.getId());
            entityManager.remove(historico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 	Remove hist�rico da entidade atrav�s do Id.
     * 
     * @param id
     * 
     */
    @Override
    public void removeById(final int id) {
        try {
            Historico historico = getById(id);
            remove(historico);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
