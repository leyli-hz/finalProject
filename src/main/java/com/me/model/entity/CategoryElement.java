package com.me.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category_element")
@SequenceGenerator(name="categoryElement_generator",sequenceName = "categoryElement_seq")
public class CategoryElement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "categoryElement_generator")
    @Column(columnDefinition = "int", name = "category_element_id" )
    private int categoryElementId;
    @Column(columnDefinition = "varchar(100)", name = "farsi_name",nullable = false)
    private String farsiName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

  /*  @OneToMany(mappedBy = "categoryElement")
    private List<Employee> employeeList;

   @ManyToMany(mappedBy = "categoryElements")
    private Set<Vacation> vacations;

    public Set<Vacation> getVacations() {
        return vacations;
    }

    public CategoryElement setVacations(Set<Vacation> vacations) {
        this.vacations = vacations;
        return this;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public CategoryElement setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
        return this;
    }*/

    public int getCategoryElementId() {
        return categoryElementId;
    }

    public CategoryElement setCategoryElementId(int categoryElementId) {
        this.categoryElementId = categoryElementId;
        return this;
    }

    public String getFarsiName() {
        return farsiName;
    }

    public CategoryElement setFarsiName(String farsiName) {
        this.farsiName = farsiName;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public CategoryElement setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "CategoryElement{" +
                "categoryElementId=" + categoryElementId +
                ", farsiName='" + farsiName + '\'' +
                ", category=" + category +
                '}';
    }
}
