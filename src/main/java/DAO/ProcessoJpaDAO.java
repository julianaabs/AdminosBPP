/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Processo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 	Bean stateless de sess�o do Processo, respons�vel por instanciar a entidade Processo na
 * aplica��o.
 *
 * @author Juliana Barbosa
 */
@Stateless
public class ProcessoJpaDAO {//implements IServiceRemoteDAO {

	/**
	 * 	Inst�ncia do interessado.
	 */
    private static ProcessoJpaDAO instance;
    
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
    public static ProcessoJpaDAO getInstance() {
        if (instance == null) {
            instance = new ProcessoJpaDAO();
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
    public Processo getById(final int id) {
        return entityManager.find(Processo.class, id);
    }

    /**
     * 	Acessa a lista de interessados.
     * 
     * @return entityManager list
     */
    public List<Processo> findAll() {
        return entityManager.createQuery("FROM" + Processo.class.getName()).getResultList();
    }

    /**
     * 
     * @param processo
     *
     */
    public void persist(Processo processo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(processo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 
     * @param processo
     * 
     */
    public void merge(Processo processo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(processo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 	Remove processo da entidade.
     * 
     * @param processo
     * 
     */
    public void remove(Processo processo) {
        try {
            entityManager.getTransaction().begin();
            processo = entityManager.find(Processo.class, processo.getId());
            entityManager.remove(processo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     *  Remove processo da entidade atrav�s do Id.
     *  
     * @param id
     */
    public void removeById(final int id) {
        try {
            Processo processo = getById(id);
            remove(processo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
