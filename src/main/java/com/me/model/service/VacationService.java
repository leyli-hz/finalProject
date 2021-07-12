package com.me.model.service;

import com.me.model.confige.HibernateUtils;
import com.me.model.entity.Vacation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class VacationService implements GenericService<Vacation> {
    private static VacationService service = new VacationService();

    private VacationService() {
    }

    public static VacationService getInstance() {
        return service;
    }

    @Override
    public void save(Vacation vacationObject) throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(vacationObject);
        transaction.commit();
        entityManager.close();

    }

    @Override
    public void update(Vacation vacationObject) throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Vacation newVacation = entityManager.find(Vacation.class, vacationObject.getVacationId());
        newVacation.setVacationId(vacationObject.getVacationId());
        newVacation.setStartTime(vacationObject.getStartTime());
        newVacation.setEndTime(vacationObject.getEndTime());
        newVacation.setStartDate(vacationObject.getStartDate());
        newVacation.setEndDate(vacationObject.getEndDate());
        newVacation.setExpression(vacationObject.getExpression());
        newVacation.setEmployee(vacationObject.getEmployee());
        newVacation.setCategoryElements(vacationObject.getCategoryElements());
        entityManager.merge(newVacation);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void remove(int id) throws Exception {

    }

    @Override
    public List<Vacation> findAll() throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Query query = entityManager.createNativeQuery("select * from vacation", Vacation.class);
        List<Vacation> vacations = query.getResultList();
        entityManager.close();
        return vacations;
    }

    public List<Vacation> vacationJoinEmployee(int managerId) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Query query = entityManager.createNativeQuery("select  vacation.* from employee inner join vacation on employee.employee_id=vacation.employee_id where employee.manager_id =?1", Vacation.class);
        query.setParameter(1, managerId);
        System.out.println("join anjam shod !!");
        List<Vacation> vacationList = query.getResultList();
        entityManager.close();
        return vacationList;
    }

    public Vacation findOneByID(int vacationId) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Vacation vacation = entityManager.find(Vacation.class, vacationId);
        return vacation;
    }

}
