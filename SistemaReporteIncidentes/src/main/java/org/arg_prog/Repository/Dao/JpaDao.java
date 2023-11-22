package org.arg_prog.Repository.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDao implements Dao {

    private static final String PERSISTENCE_UNIT_NAME = "JPA_PU";
    private final EntityManagerFactory entityManagerFactory;

    public JpaDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
