package com.me.model.service;

import com.me.model.confige.HibernateUtils;
import com.me.model.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CategoryService implements GenericService<Category> {
    private static CategoryService service = new CategoryService();

    private CategoryService() {
    }

    public static CategoryService getInstance() {
        return service;
    }

    public void save(Category category) {

       EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(category);
        transaction.commit();
        entityManager.close();

    }

    @Override
    public void update(Category typeObject) throws Exception {

    }

    @Override
    public void remove(int id) throws Exception {

    }

    @Override
    public List<Category> findAll() throws Exception {
        return null;
    }

    public Category findOne (int id){
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Category category = entityManager.find(Category.class, id);
        entityManager.close();
        return category;
    }

    public List<Category> findByName (String categoryName){
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Query query = entityManager.createNativeQuery("select * from category where category_name = ?1", Category.class);
        query.setParameter(1,categoryName);
        List<Category> categoryList =query.getResultList();
        entityManager.close();
        System.out.println("end of the CategoryName");
        return categoryList;
    }
    public void vacationCategorySave(String vacationCategory){
        Category category = new Category();
        category.setCategoryName(vacationCategory);
        save(category);
    }
}
