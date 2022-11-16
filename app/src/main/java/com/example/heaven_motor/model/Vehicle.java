package com.example.heaven_motor.model;

public class Vehicle {
    private String  id;
    private int categorie_id;
    private String name;
    private int imager;
    private String BKS;
    private int capacity;
    private int status;
    private int amount;
    private int price;
    private int year;
    public Vehicle() {
    }

    public Vehicle(String id, int categorie_id, String name, int imager, String BKS, int capacity, int status, int amount, int price, int year) {
        this.id = id;
        this.categorie_id = categorie_id;
        this.name = name;
        this.imager = imager;
        this.BKS = BKS;
        this.capacity = capacity;
        this.status = status;
        this.amount = amount;
        this.price = price;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImager() {
        return imager;
    }

    public void setImager(int imager) {
        this.imager = imager;
    }

    public String getBKS() {
        return BKS;
    }

    public void setBKS(String BKS) {
        this.BKS = BKS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
