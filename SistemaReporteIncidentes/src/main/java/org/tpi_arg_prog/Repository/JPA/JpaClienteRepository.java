package org.tpi_arg_prog.Repository.JPA;

import org.tpi_arg_prog.Entidades.Cliente;
import org.tpi_arg_prog.Repository.Interfaces.ClienteRepository;
import org.tpi_arg_prog.Repository.Dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaClienteRepository implements ClienteRepository {


    private final Dao dao;

    public JpaClienteRepository(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Cliente cliente) {

        System.out.println("salvando el Cliente desde la base");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Cliente cliente) {
        System.out.println("actualizando el Cliente desde la base");
    }

    @Override
    public void delete(int idCliente) {
        System.out.println("borrando el Cliente desde la base");
    }

    @Override
    public Cliente getById(int idCliente){

        System.out.println("Recuperando Cliente desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(Cliente.class, idCliente);
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public List<Cliente> getAll(){


        System.out.println("trayendo los Clientes desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createNativeQuery("SELECT razon_social FROM clientes").getResultList();
        } finally {
            entityManager.close();
        }

    }





}
