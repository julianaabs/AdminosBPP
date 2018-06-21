/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Status;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *	Bean stateless de sess�o do Status, respons�vel por instanciar a entidade Status na
 * aplica��o.
 * 
 * @author Juliana Barbosa
 */
public class StatusJpaDAO {

	/**
	 * 	Inst�ncia do interessado.
	 */
    private static StatusJpaDAO instance;
    
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
    public static StatusJpaDAO getInstance() {
        if (instance == null) {
            instance = new StatusJpaDAO();
        }

        return instance;
    }

    /**
     * 	Acessa o gerenciador de entidade caso ele j� exista. Se n�o, ele � criado.
     * 
     * @return entityManager
     * 
     */
    private EntityManager getEntityManager() {
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
    public Status getById(final int id) {
        return entityManager.find(Status.class, id);
    }

    /**
     * 	Acessa a lista de interessados.
     * 
     * @return entityManager list
     */
    public List<Status> findAll() {
        return entityManager.createQuery("FROM" + Status.class.getName()).getResultList();
    }

    /**
     * 
     * @param status
     * 
     */
    public void persist(Status status) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(status);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 
     * @param status
     * 
     */
    public void merge(Status status) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(status);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 	Remove Status da entidade.
     * 
     * @param status
     * 
     */
    public void remove(Status status) {
        try {
            entityManager.getTransaction().begin();
            status = entityManager.find(Status.class, status.getId());
            entityManager.remove(status);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 	Remove Status da entidade atrav�s do Id.
     * 
     * @param id
     * 
     */
    public void removeById(final int id) {
        try {
            Status status = getById(id);
            remove(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
