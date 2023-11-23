package Repository;

import Entidades.TipoServicio;
import Repository.Dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaTipoServicioRepository implements TipoServicioRepository {

    private final Dao dao;

    public JpaTipoServicioRepository(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void save(TipoServicio tipoServicio) {

        System.out.println("salvando el TipoServicio desde la base");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(tipoServicio);
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
    public void update(TipoServicio tipoServicio) {
        System.out.println("actualizando el TipoServicio desde la base");
    }

    @Override
    public void delete(int idTipoServicio) {
        System.out.println("borrando el TipoServicio desde la base");
    }

    @Override
    public  TipoServicio getById(int idTipoServicio){

    System.out.println("Recuperando TipoServicio desde la base");
    EntityManager entityManager = dao.getEntityManager();
    try {
        return entityManager.find(TipoServicio.class, idTipoServicio);
    }
    finally {
        entityManager.close();
    }

    }

    @Override
    public List<TipoServicio> getAll(){

        System.out.println("trayendo todos los TipoServicio de la base");
        return null;

    }

}
