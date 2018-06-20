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
 *
 * @author jubss
 */
public class StatusJpaDAO {

    private static StatusJpaDAO instance;
    private EntityManager entityManager;

    public static StatusJpaDAO getInstance() {
        if (instance == null) {
            instance = new StatusJpaDAO();
        }

        return instance;
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminosPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Status getById(final int id) {
        return entityManager.find(Status.class, id);
    }

    public List<Status> findAll() {
        return entityManager.createQuery("FROM" + Status.class.getName()).getResultList();
    }

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

    public void removeById(final int id) {
        try {
            Status status = getById(id);
            remove(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
