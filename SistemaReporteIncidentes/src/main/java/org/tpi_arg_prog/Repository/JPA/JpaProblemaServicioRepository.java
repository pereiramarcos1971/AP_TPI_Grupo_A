package org.tpi_arg_prog.Repository.JPA;

import org.tpi_arg_prog.Entidades.ProblemaServicio;
import org.tpi_arg_prog.Repository.Dao.Dao;
import org.tpi_arg_prog.Repository.Interfaces.ProblemaServicioRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaProblemaServicioRepository implements ProblemaServicioRepository {


    private final Dao dao;

    public JpaProblemaServicioRepository(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void save(ProblemaServicio problemaServicio) {

        System.out.println("salvando el Problema Servicio desde la base");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(problemaServicio);
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
    public void update(ProblemaServicio problemaServicio) {
        System.out.println("actualizando el Problema Servicio desde la base");
    }

    @Override
    public void delete(int idProblemaServicio) {
        System.out.println("borrando el Problema Servicio desde la base");
    }

    @Override
    public ProblemaServicio getById(int idProblemaServicio) {

        System.out.println("Recuperando Problema Servicio desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(ProblemaServicio.class, idProblemaServicio);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<ProblemaServicio> getAll() {

        System.out.println("trayendo los Problemas Servicios desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createNativeQuery("SELECT id_problema_servicio FROM problemas_servicios").getResultList();
        } finally {
            entityManager.close();
        }


    }
}
