/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Unidade;
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
public class UnidadeJpaDAO {

    private static UnidadeJpaDAO instance;
    private EntityManager entityManager;

    public static UnidadeJpaDAO getInstance() {
        if (instance == null) {
            instance = new UnidadeJpaDAO();
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

    public Unidade getById(final int id) {
        return entityManager.find(Unidade.class, id);
    }

    public List<Unidade> findAll() {
        return entityManager.createQuery("FROM" + Unidade.class.getName()).getResultList();
    }

    public void persist(Unidade unidade) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(unidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Unidade unidade) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(unidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Unidade unidade) {
        try {
            entityManager.getTransaction().begin();
            unidade = entityManager.find(Unidade.class, unidade.getId());
            entityManager.remove(unidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Unidade unidade = getById(id);
            remove(unidade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
