package com.example.heaven_motor.model;

public class Categoris {
    private int id;
    private String name;
    private String cave;

    public Categoris() {
    }

    public Categoris(int id, String name, String cave) {
        this.id = id;
        this.name = name;
        this.cave = cave;
    }

    public String getCave() {
        return cave;
    }

    public void setCave(String cave) {
        this.cave = cave;
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
}
