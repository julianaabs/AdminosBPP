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
 *	Bean stateless de sessão do Interessado, responsável por instanciar a entidade Interessado na
 * aplicação.
 * 
 * @author Juliana Barbosa
 */
@Stateless
public class InteressadoJpaDAO implements IServiceRemoteDAO {

	/**
	 * 	Instância do Interessado.
	 */
    private static UnidadeJpaDAO instance;
    
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
    public static UnidadeJpaDAO getInstance() {
        if (instance == null) {
            instance = new UnidadeJpaDAO();
        }

        return instance;
    }

    /**
     * 	Acessa o gerenciador de entidade caso ele já exista. Se não, ele é criado.
     * 
     * @return entityManager
     * 
     */
    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminosPU");
        if (entityManager == null) {
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
    public Interessado getById(final int id) {
        return entityManager.find(Interessado.class, id);
    }

    /**
     * 	Acessa a lista de interessados.
     * 
     * @return entityManager list
     */
    public List<Interessado> findAll() {
        return entityManager.createQuery("FROM" + Interessado.class.getName()).getResultList();
    }

    /**
     * 
     * @param interessado
     * 
     */
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

    /**
     * 
     * @param interessado
     * 
     */
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

    /**
     * 	Remove interessado da entidade.
     * 
     * @param interessado
     * 
     */
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

    /**
     * 	Remove interessado da entidade através do id.
     * 
     * @param id
     * 
     */
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
