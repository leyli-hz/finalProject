package com.me.configuration;

import com.me.model.confige.HibernateUtils;
import com.me.model.service.CategoryService;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener method to start it");
        EntityManager entityManager = HibernateUtils.getEntityManager();
       // CategoryService.getInstance().save();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("listener method to destroy it");

    }
}
