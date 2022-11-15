package com.example.heaven_motor.model;

public class Categoris {
    private int id;
    private String name;
    private String brand;

    public Categoris() {
    }

    public Categoris(int id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
