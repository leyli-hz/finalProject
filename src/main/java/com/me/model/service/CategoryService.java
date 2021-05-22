package com.me.model.service;

import com.me.model.confige.HibernateUtils;
import com.me.model.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoryService {
    private static CategoryService service = new CategoryService();

    private CategoryService() {
    }

    public static CategoryService getInstance() {
        return service;
    }

    public void save() {

        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Category category = new Category().setCategoryId(1).setCategoryName("Role Type");
//        Category category1 = new Category().setCategoryId(2).setCategoryName("Vacation State");
//        Category category2 = new Category().setCategoryId(2).setCategoryName("Vacation Type");
//        Category category3 = new Category().setCategoryId(2).setCategoryName("Email Type");
        entityManager.persist(category);
//        entityManager.persist(category1);
//        entityManager.persist(category2);
//        entityManager.persist(category3);
        transaction.commit();
        entityManager.close();

    }



}
