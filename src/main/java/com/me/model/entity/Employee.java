package com.me.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(columnDefinition = "int" ,name = "employee_id")
    private  int employeeId;
    @Column(columnDefinition = "varchar(100)",name = "first_name" ,nullable =false )
    private String firstName;
    @Column(columnDefinition = "varchar(100)",name = "last_name" ,nullable =false )
    private String lastName;
    @Column(columnDefinition = "varchar(30)",name = "national_code" ,nullable =false, unique = true)
    private String nationalCode;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    Employee manager;

    @OneToMany(mappedBy = "manager")
    List<Employee> employeeList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private CategoryElement categoryElement;

    @OneToMany(mappedBy = "senderID")
    private List<Email> sentEmailList;

    @ManyToMany(mappedBy = "receiversID")
    private Set<Email> receivedEmailList;

    @ManyToMany(mappedBy = "employees")
    private Set<Vacation> vacations;

    public Set<Vacation> getVacations() {
        return vacations;
    }

    public Employee setVacations(Set<Vacation> vacations) {
        this.vacations = vacations;
        return this;
    }

    public Set<Email> getReceivedEmailList() {
        return receivedEmailList;
    }

    public Employee setReceivedEmailList(Set<Email> receivedEmailList) {
        this.receivedEmailList = receivedEmailList;
        return this;
    }
    public List<Email> getSentEmailList() {
        return sentEmailList;
    }

    public Employee setSentEmailList(List<Email> sentEmailList) {
        this.sentEmailList = sentEmailList;
        return this;
    }

    public CategoryElement getCategoryElement() {
        return categoryElement;
    }

    public Employee setCategoryElement(CategoryElement categoryElement) {
        this.categoryElement = categoryElement;
        return this;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Employee setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public Employee setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public Employee getManager() {
        return manager;
    }

    public Employee setManager(Employee manager) {
        this.manager = manager;
        return this;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
        return this;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", manager=" + manager +
                ", employeeList=" + employeeList +
                '}';
    }
}
