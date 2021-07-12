package com.me.model.service;

import com.me.model.confige.HibernateUtils;
import com.me.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class EmployeeService implements GenericService<Employee> {
    private  static EmployeeService employeeService = new EmployeeService();

    private EmployeeService(){
    }
    public static EmployeeService getInstance(){
        return employeeService;
    }

    @Override
    public void save(Employee employee) throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(employee);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void update(Employee employee) throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee newEmployee = entityManager.find(Employee.class, employee.getEmployeeId());
        newEmployee.setEmployeeId(employee.getEmployeeId());
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setNationalCode(employee.getNationalCode());
        newEmployee.setManager(employee.getManager());
        newEmployee.setCategoryElement(employee.getCategoryElement());
        entityManager.merge(newEmployee);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void remove(int id) throws Exception {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
        transaction.commit();
        entityManager.close();

    }

    @Override
    public List<Employee> findAll()  {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Query query = entityManager.createNativeQuery("select * from employee", Employee.class);
        List<Employee> employeeList = query.getResultList();
        System.out.println("findAll() resultlist esh ejra shod!");
        entityManager.close();
        System.out.println("findAll() haamaash ejra shod!");
        return employeeList;
    }

    public Employee findOne(int id){
        EntityManager entityManager =HibernateUtils.getEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return employee;
    }

    public Employee findByNationalCode(String nationalCode){
        EntityManager entityManager = HibernateUtils.getEntityManager();
        Query query = entityManager.createNativeQuery("select * from employee where national_code =?1",Employee.class);
        query.setParameter(1,nationalCode);
        Employee employee = (Employee) query.getSingleResult();
        return employee;
    }
}
