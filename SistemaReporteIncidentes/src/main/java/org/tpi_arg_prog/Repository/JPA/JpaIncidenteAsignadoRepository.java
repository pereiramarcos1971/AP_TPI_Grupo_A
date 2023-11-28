package org.tpi_arg_prog.Repository.JPA;

import org.tpi_arg_prog.Entidades.IncidenteAsignado;
import org.tpi_arg_prog.Repository.Dao.Dao;
import org.tpi_arg_prog.Repository.Interfaces.IncidenteAsignadoRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaIncidenteAsignadoRepository implements IncidenteAsignadoRepository {

    private final Dao dao;

    public JpaIncidenteAsignadoRepository(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void save(IncidenteAsignado incidenteAsignado) {

        System.out.println("salvando el Incidente Asignado desde la base");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(incidenteAsignado);
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
    public void update(IncidenteAsignado incidenteAsignado) {

        System.out.println("actualizando el Incidente Asignado desde la base");

        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(incidenteAsignado);
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
    public void delete(int idIncidenteAsignado) {
        System.out.println("borrando el Incidente Asignado desde la base");
    }

    @Override
    public IncidenteAsignado getById(int idIncidenteAsignado) {

        System.out.println("Recuperando Incidente Asignado desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(IncidenteAsignado.class, idIncidenteAsignado);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<IncidenteAsignado> getAll() {


        System.out.println("trayendo los Incidentes Asignados desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createNativeQuery("SELECT descripcion FROM incidentes").getResultList();
        } finally {
            entityManager.close();
        }

    }


}
