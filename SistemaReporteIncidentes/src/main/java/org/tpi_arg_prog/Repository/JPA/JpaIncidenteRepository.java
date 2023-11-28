package org.tpi_arg_prog.Repository.JPA;

import org.tpi_arg_prog.Entidades.Incidente;
import org.tpi_arg_prog.Repository.Dao.Dao;
import org.tpi_arg_prog.Repository.Interfaces.IncidenteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaIncidenteRepository implements IncidenteRepository {

    private final Dao dao;

    public JpaIncidenteRepository(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Incidente incidente) {

        System.out.println("salvando el Incidente desde la base");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(incidente);
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
    public void update(Incidente incidente) {
        System.out.println("actualizando el Incidente desde la base");
    }

    @Override
    public void delete(int idIncidente) {
        System.out.println("borrando el Incidente desde la base");
    }

    @Override
    public Incidente getById(int idIncidente) {

        System.out.println("Recuperando Incidente desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(Incidente.class, idIncidente);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<Incidente> getAll() {


        System.out.println("trayendo los Incidentes desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createNativeQuery("SELECT descripcion FROM incidentes").getResultList();
        } finally {
            entityManager.close();
        }

    }
}
