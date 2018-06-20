/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Tipo;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jubss
 */
public class TipoJpaDAO {
    
    private static TipoJpaDAO instance;
    private EntityManager entityManager;
    
    public static TipoJpaDAO getInstance(){
        if(instance == null){
            instance = new TipoJpaDAO();
        }
        
        return instance;
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminosPU");
        if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;
    }
    
    public Tipo getById(final int id){
        return entityManager.find(Tipo.class, id);
    }
    
    public List<Tipo> findAll(){
        return entityManager.createQuery("FROM" + Tipo.class.getName()).getResultList();        
    }
    
    public void persist(Tipo tipo){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(tipo);
            entityManager.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Tipo tipo){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(tipo);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Tipo tipo){
        try{
            entityManager.getTransaction().begin();
            tipo = entityManager.find(Tipo.class, tipo.getId());
            entityManager.remove(tipo);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id){
        try{
            Tipo tipo = getById(id);
            remove(tipo);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
