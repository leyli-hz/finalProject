package com.me.model.confige;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {
    private  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MYDATABASECONNECTION");
    static {
        System.out.println("jpa at the beginning");
    }
    public static EntityManager getEntityManager(){
        System.out.println("in jpa at the end");
        return entityManagerFactory.createEntityManager();
    }

}
