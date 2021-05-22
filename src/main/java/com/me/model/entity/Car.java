package com.me.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Car")
@Table(name = "car")

public class Car {
    @Id
    private int id ;
    @Column(name = "model")
    private String model;

    public Car() {
    }

    public Car(int id, String model) {
        this.id = id;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public Car setId(int id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }
}
