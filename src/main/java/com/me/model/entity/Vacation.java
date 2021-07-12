
package com.me.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "vacation")
@Table(name = "vacation")
@SequenceGenerator(name = "vacation_generator", sequenceName = "vacation_seq")
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacation_generator")
    @Column(columnDefinition = "int", name = "vacation_id")
    private int vacationId;

    @Column(columnDefinition = "varchar(150)", name = "expression")
    private String expression;

    @Column(columnDefinition = "Time", name = "start_time", nullable = false)
    private Time startTime;

    @Column(columnDefinition = "Time", name = "end_time", nullable = false)
    private Time endTime;

    @Column(columnDefinition = "date", name = "start_day", nullable = false)
    private Date startDate;

    @Column(columnDefinition = "date", name = "end_day", nullable = false)
    private Date endDate;

/*    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "vacation_employee", joinColumns = {@JoinColumn(name = "vacation_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    private Set<Employee> employees;*/
    /* public Set<Employee> getEmployees() {
        return employees;
    }

    public Vacation setEmployees(Set<Employee> employees) {
        this.employees = employees;
        return this;
    }*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "vacation_categoryElement", joinColumns = {@JoinColumn(name = "vacation_id")}
            , inverseJoinColumns = {@JoinColumn(name = "categoryElement_id")})
    @OrderBy
    private Set<CategoryElement> categoryElements = new LinkedHashSet<>();

    public Employee getEmployee() {
        return employee;
    }

    public Vacation setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public String getExpression() {
        return expression;
    }

    public Vacation setExpression(String expression) {
        this.expression = expression;
        return this;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Vacation setEndTime(Time endTime) {
        this.endTime = endTime;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Vacation setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Set<CategoryElement> getCategoryElements() {
        return categoryElements;
    }

    public Vacation setCategoryElements(Set<CategoryElement> categoryElements) {
        this.categoryElements = categoryElements;
        return this;
    }



    public int getVacationId() {
        return vacationId;
    }

    public Vacation setVacationId(int vacationId) {
        this.vacationId = vacationId;
        return this;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Vacation setStartTime(Time startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Vacation setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "vacationId=" + vacationId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}


