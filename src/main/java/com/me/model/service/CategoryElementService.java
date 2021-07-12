package com.me.model.service;

import com.me.model.confige.HibernateUtils;
import com.me.model.entity.Category;
import com.me.model.entity.CategoryElement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CategoryElementService implements GenericService<CategoryElement> {
    private static CategoryElementService service = new CategoryElementService();

    private CategoryElementService() {
    }

    public static CategoryElementService getInstance() {
        return service;
    }

    @Override
    public void save(CategoryElement categoryElement) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(categoryElement);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void update(CategoryElement typeObject) throws Exception {

    }

    @Override
    public void remove(int id) throws Exception {

    }

    @Override
    public List<CategoryElement> findAll() throws Exception {
        EntityManager manager = HibernateUtils.getEntityManager();
        Query query = manager.createNativeQuery("select * from category_element", CategoryElement.class);
        List<CategoryElement> categoryElements = query.getResultList();
        manager.close();
        return categoryElements;
    }

    public CategoryElement findByFarsiName(String farsiName) {
        EntityManager manager = HibernateUtils.getEntityManager();
        Query query = manager.createNativeQuery("select * from category_element  where farsi_name =?1", CategoryElement.class);
        query.setParameter(1, farsiName);
        /*List<CategoryElement> categoryElementList = manager.createNativeQuery(
                "select * from category_element where farsi_name = :param",
                CategoryElement.class)
                .setParameter("param",farsiName)
                .getResultList();*/
       /* List<CategoryElement> categoryElementList = manager.createQuery(
                "select o from CategoryElement o where o.farsiName = :param",
                CategoryElement.class)
                .setParameter("param", farsiName)
                .getResultList();*/

        System.out.println("method findBuyName categoryElement query ish ejra shod!");
        CategoryElement categoryElement = (CategoryElement) query.getSingleResult();
        System.out.println("method findBuyName categoryElement resultlist esh ejra shod!");
        manager.close();
        return categoryElement;
    }

    public CategoryElement findOneById(int categoryElementId){
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CategoryElement categoryElement = entityManager.find(CategoryElement.class, categoryElementId);
        entityManager.close();
        return categoryElement;
    }
    public List<CategoryElement> findByCategory(Category category){
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Query query = entityManager.createNativeQuery("select * from category_element where category_id =?1",CategoryElement.class);
        query.setParameter(1,category.getCategoryId());
        List<CategoryElement> resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    public void vacationTypeCatgElmSave() {
        List<Category> vacationTypes = CategoryService.getInstance().findByName("vacationType");
        CategoryElement categoryElement1 = new CategoryElement();
        categoryElement1.setCategory(vacationTypes.get(0));
        categoryElement1.setFarsiName("استحقاقی");
        CategoryElement categoryElement2 = new CategoryElement();
        categoryElement2.setCategory(vacationTypes.get(0));
        categoryElement2.setFarsiName("استعلاجی");
        CategoryElement categoryElement3 = new CategoryElement();
        categoryElement3.setCategory(vacationTypes.get(0));
        categoryElement3.setFarsiName("شیر");
        CategoryElement categoryElement4 = new CategoryElement();
        categoryElement4.setCategory(vacationTypes.get(0));
        categoryElement4.setFarsiName("سفر");
        CategoryElement categoryElement5 = new CategoryElement();
        categoryElement5.setCategory(vacationTypes.get(0));
        categoryElement5.setFarsiName("فوت");
        CategoryElement categoryElement6 = new CategoryElement();
        categoryElement6.setCategory(vacationTypes.get(0));
        categoryElement6.setFarsiName("ازدوج");
        CategoryElement categoryElement7 = new CategoryElement();
        categoryElement7.setCategory(vacationTypes.get(0));
        categoryElement7.setFarsiName("بدون حقوق");

        save(categoryElement1);
        save(categoryElement2);
        save(categoryElement3);
        save(categoryElement4);
        save(categoryElement5);
        save(categoryElement6);
        save(categoryElement7);

    }

    public void vacationStatusCatgElmSave() {
        List<Category> vacationTypes = CategoryService.getInstance().findByName("vacationStatus");
        CategoryElement categoryElement1 = new CategoryElement();
        categoryElement1.setCategory(vacationTypes.get(0));
        categoryElement1.setFarsiName("تائید شده");
        CategoryElement categoryElement2 = new CategoryElement();
        categoryElement2.setCategory(vacationTypes.get(0));
        categoryElement2.setFarsiName("رد شده");
        CategoryElement categoryElement3 = new CategoryElement();
        categoryElement3.setCategory(vacationTypes.get(0));
        categoryElement3.setFarsiName("در انتظار");

        save(categoryElement1);
        save(categoryElement2);
        save(categoryElement3);
    }
}
