package org.tpi_arg_prog.Repository.JPA;

import org.tpi_arg_prog.Entidades.TipoProblema;
import org.tpi_arg_prog.Repository.Dao.Dao;
import org.tpi_arg_prog.Repository.Interfaces.TipoProblemaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaTipoProblemaRepository implements TipoProblemaRepository {

    private final Dao dao;

    public JpaTipoProblemaRepository(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void save(TipoProblema tipoProblema) {

        System.out.println("salvando el TipoProblema desde la base");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(tipoProblema);
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
    public void delete(TipoProblema tipoProblema) {

        System.out.println("borrando el TipoProblema desde la base");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(tipoProblema);
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
    public void update(TipoProblema tipoProblema) {
        System.out.println("actualizando el TipoProblema desde la base");
    }


/*    @Override
   public void delete(int idTipoProblema) {
        System.out.println("borrando el TipoProblema desde la base");
    }
*/

    @Override
    public  TipoProblema getById(int idTipoProblema){

        System.out.println("Recuperando TipoProblema desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(TipoProblema.class, idTipoProblema);
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public List<TipoProblema> getAll() {


        System.out.println("trayendo los TipoProblema desde la base");
        EntityManager entityManager = dao.getEntityManager();
        try {
            String consulta = "SELECT descripcion FROM tipos_problema";
            return entityManager.createNativeQuery(consulta).getResultList();
        } finally {
            entityManager.close();
        }



    }


    }



