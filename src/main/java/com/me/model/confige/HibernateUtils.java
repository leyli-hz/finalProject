package com.me.model.confige;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MYDATABASECONNECTION");

    public static EntityManager getEntityManager(){

        return entityManagerFactory.createEntityManager();
    }

}
