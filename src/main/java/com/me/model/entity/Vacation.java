package com.me.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity(name = "vacation")
@Table(name = "vacation")
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "int" , name = "vacation_id")
    private int vacationId;

    @Column(columnDefinition = "varchar(50)" , name = "duration",nullable = false)
    private String duration;

    @Column(columnDefinition = "date" , name = "day",nullable = false)
    private Date date;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "vacation_employee" ,joinColumns = {@JoinColumn(name="vacation_id")},
    inverseJoinColumns = {@JoinColumn(name="employee_id")})
    private Set<Employee> employees;

    @ManyToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name ="vacation_categoryElement" ,joinColumns = {@JoinColumn(name ="vacation_id")}
    ,inverseJoinColumns = {@JoinColumn(name = "categoryElement_id")})
    private Set<CategoryElement> categoryElements;

    public Set<CategoryElement> getCategoryElements() {
        return categoryElements;
    }

    public Vacation setCategoryElements(Set<CategoryElement> categoryElements) {
        this.categoryElements = categoryElements;
        return this;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Vacation setEmployees(Set<Employee> employees) {
        this.employees = employees;
        return this;
    }

    public int getVacationId() {
        return vacationId;
    }

    public Vacation setVacationId(int vacationId) {
        this.vacationId = vacationId;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public Vacation setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Vacation setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "vacationId=" + vacationId +
                ", duration='" + duration + '\'' +
                ", date=" + date +
                '}';
    }
}
