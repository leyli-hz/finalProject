package com.me.model.service;

import com.me.model.confige.HibernateUtils;
import com.me.model.entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CarServiceImpl implements GenericService<Car> {
    private static CarServiceImpl service = new CarServiceImpl();

    private CarServiceImpl() {
    }

    public static CarServiceImpl getInstance() {
        return service;
    }


    @Override
    public void save(Car car) throws Exception {
       /* try (CarRepo repository = new CarRepo()) {
            repository.insert(car);
        }*/
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(car);
        transaction.commit();
        entityManager.close();
        System.out.println("car service at the end ");
    }

    @Override
    public void update(Car car) throws Exception {

    }

    @Override
    public void remove(int id) throws Exception {
       /* try (CarRepo repository = new CarRepo()) {
            repository.delete(id);
        }*/
    }

    @Override
    public List<Car> findAll() throws Exception {
        /*try (CarRepo repository = new CarRepo()) {
            return  repository.selectAll();
        }*/

    return null;
    }


}
