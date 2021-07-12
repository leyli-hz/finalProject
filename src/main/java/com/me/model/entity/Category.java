package com.me.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
@Table(name = "category")
@SequenceGenerator(initialValue = 1 ,name="category_generator",sequenceName = "category_seq")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator ="category_generator")
    @Column(columnDefinition = "int" , name = "category_id")
    private int categoryId;

    @Column(columnDefinition = "varchar(50)", name = "category_name",nullable = false)
    private String categoryName;

   /* @OneToMany(mappedBy = "category")
    private List<CategoryElement> categoryElements;

    public List<CategoryElement> getCategoryElements() {
        return categoryElements;
    }

    public Category setCategoryElements(List<CategoryElement> categoryElements) {
        this.categoryElements = categoryElements;
        return this;
    }
*/

    public Category() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Category setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
