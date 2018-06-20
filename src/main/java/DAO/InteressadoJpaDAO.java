/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Interessado;
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
public class InteressadoJpaDAO implements IServiceRemoteDAO {

    private static UnidadeJpaDAO instance;
    private EntityManager entityManager;

    public static UnidadeJpaDAO getInstance() {
        if (instance == null) {
            instance = new UnidadeJpaDAO();
        }

        return instance;
    }

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminosPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Interessado getById(final int id) {
        return entityManager.find(Interessado.class, id);
    }

    public List<Interessado> findAll() {
        return entityManager.createQuery("FROM" + Interessado.class.getName()).getResultList();
    }

    public void persist(Interessado interessado) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(interessado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Interessado interessado) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(interessado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Interessado interessado) {
        try {
            entityManager.getTransaction().begin();
            interessado = entityManager.find(Interessado.class, interessado.getId());
            entityManager.remove(interessado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void removeById(final int id) {
        try {
            Interessado interessado = getById(id);
            remove(interessado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
