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
 *
 * @author jubss
 */
@Stateless
public class HistoricoJpaDAO implements IServiceRemoteDAO {

    private static HistoricoJpaDAO instance;
    private EntityManager entityManager;

    public static HistoricoJpaDAO getInstance() {
        if (instance == null) {
            instance = new HistoricoJpaDAO();
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

    public Historico getById(final int id) {
        return entityManager.find(Historico.class, id);
    }

    public List<Historico> findAll() {
        return entityManager.createQuery("FROM" + Historico.class.getName()).getResultList();
    }

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
