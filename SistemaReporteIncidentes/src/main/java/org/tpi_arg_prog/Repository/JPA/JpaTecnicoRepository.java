package org.tpi_arg_prog.Repository.JPA;

import org.tpi_arg_prog.Repository.Dao.Dao;

import org.tpi_arg_prog.Entidades.Tecnico;
import org.tpi_arg_prog.Repository.Interfaces.TecnicoRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class JpaTecnicoRepository implements TecnicoRepository {

    private final Dao dao;

    public JpaTecnicoRepository(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Tecnico tecnico) {

        System.out.println("salvando el Tecnico desde la base");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(tecnico);
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
    public void update(Tecnico tecnico) {
        System.out.println("actualizando el Tecnico desde la base");
    }

    @Override
    public void delete(int idTecnico) {
        System.out.println("borrando el Tecnico desde la base");
    }

    @Override
    public Tecnico getById(int idTecnico){

        System.out.println("Recuperando Tecnico desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(Tecnico.class, idTecnico);
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public List<Tecnico> getAll(){


        System.out.println("trayendo los Tecnicos desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createNativeQuery("SELECT apellido FROM tecnicos").getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
            public List getTecnicoConMasIncidentesResueltosEnNDias(int dias) {

        System.out.println("trayendo los Tecnicos desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("tecnico_con_mas_incidentes_resueltos_en_n_dias");
            storedProcedure.registerStoredProcedureParameter("dias", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("dias", dias);
            storedProcedure.execute();
            return storedProcedure.getResultList();

         } finally {
            entityManager.close();
        }
    }

    @Override
    public List getTecnicoConMasIncidentesResueltosParaServicioEnNDias(String descServicio, int dias) {

        System.out.println("trayendo los Tecnicos desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("tecnico_mas_incidentes_resueltos_de_un_servicio_en_n_dias");
            storedProcedure.registerStoredProcedureParameter("descripcion_servicio", String.class, ParameterMode.IN);
            storedProcedure.setParameter("descripcion_servicio", dias);
            storedProcedure.registerStoredProcedureParameter("dias", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("dias", descServicio);
            storedProcedure.execute();
            return storedProcedure.getResultList();

        } finally {
            entityManager.close();
        }
    }

    @Override
    public List getTecnicoMasRapido() {

        System.out.println("trayendo los Tecnicos desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("tecnico_mas_rapido");
            storedProcedure.execute();
            return storedProcedure.getResultList();

        } finally {
            entityManager.close();
        }
    }


    @Override
    public List<Integer> getDisponibles(){


        System.out.println("trayendo los Tecnicos Disponibles desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createNativeQuery("SELECT id_tecnico FROM tecnicos WHERE disponible=1").getResultList();
        } finally {
            entityManager.close();
        }

    }



}
