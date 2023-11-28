package org.tpi_arg_prog.Repository.JPA;

import org.tpi_arg_prog.Entidades.Servicio;
import org.tpi_arg_prog.Repository.Dao.Dao;
import org.tpi_arg_prog.Repository.Interfaces.ServicioRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaServicioRepository implements ServicioRepository {


    private final Dao dao;

    public JpaServicioRepository(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Servicio servicio) {

        System.out.println("salvando el Servicio desde la base");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(servicio);
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
    public void update(Servicio servicio) {
        System.out.println("actualizando el Servicio desde la base");
    }

    @Override
    public void delete(int idServicio) {
        System.out.println("borrando el Servicio desde la base");
    }

    @Override
    public Servicio getById(int idServicio) {

        System.out.println("Recuperando Servicio desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(Servicio.class, idServicio);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<Servicio> getAll() {

        System.out.println("trayendo los Servicios desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createNativeQuery("SELECT descripcion FROM servicios").getResultList();
        } finally {
            entityManager.close();
        }


    }
}
