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
 *
 * @author jubss
 */
@Stateless
public class ProcessoJpaDAO {//implements IServiceRemoteDAO {

    private static ProcessoJpaDAO instance;
    private EntityManager entityManager;

    public static ProcessoJpaDAO getInstance() {
        if (instance == null) {
            instance = new ProcessoJpaDAO();
        }

        return instance;
    }

    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminosPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Processo getById(final int id) {
        return entityManager.find(Processo.class, id);
    }

    public List<Processo> findAll() {
        return entityManager.createQuery("FROM" + Processo.class.getName()).getResultList();
    }

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

    public void removeById(final int id) {
        try {
            Processo processo = getById(id);
            remove(processo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
