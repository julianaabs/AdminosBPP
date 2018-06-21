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
 *	Bean stateless de sessão do Tipo, responsável por instanciar a entidade Tipo na
 * aplicação.
 * 
 * @author Juliana Barbosa
 * 
 */
public class TipoJpaDAO {
    
	/**
	 * 	Instância do Tipo.
	 */
    private static TipoJpaDAO instance;
    
    /**
     * 	Gerenciador de entidade.
     */
    private EntityManager entityManager;
    
    /**
     * 	Acessa a instância e, se ela ainda não existir, é criada.
     * 
     * @return instance
     * 
     */
    public static TipoJpaDAO getInstance(){
        if(instance == null){
            instance = new TipoJpaDAO();
        }
        
        return instance;
    }
    
    /**
     * 	Acessa o gerenciador de entidade caso ele já exista. Se não, ele é criado.
     * 
     * @return entityManager
     * 
     */
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminosPU");
        if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;
    }
    
    /**
     * 	Retorna a instância através do Id.
     * 
     * @param id
     * @return entityManager
     */
    public Tipo getById(final int id){
        return entityManager.find(Tipo.class, id);
    }
    
    /**
     * 	Acessa a lista de interessados.
     * 
     * @return entityManager list
     */
    public List<Tipo> findAll(){
        return entityManager.createQuery("FROM" + Tipo.class.getName()).getResultList();        
    }
    
    /**
     * 
     * @param tipo
     * 
     */
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
    
    /**
     * 
     * @param tipo
     * 
     */
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
    
    /**
     * 	Remove Tipo da entidade.
     * 
     * @param tipo
     * 
     */
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
    
    /**
     * 	Remove Tipo da entidade através do Id.
     * 
     * @param id
     * 
     */
    public void removeById(final int id){
        try{
            Tipo tipo = getById(id);
            remove(tipo);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
