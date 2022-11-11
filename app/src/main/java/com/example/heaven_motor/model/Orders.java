package com.example.heaven_motor.model;

public class Orders {
    private String id;
    private String user_id;
    private String vehicle_id;
    private String start_time;
    private String end_time;
    private int status;
    private int total;
    private int phatsinh;


    public Orders() {
    }

    public Orders(String id, String user_id, String vehicle_id, String start_time, String end_time, int status, int total, int phatsinh) {
        this.id = id;
        this.user_id = user_id;
        this.vehicle_id = vehicle_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
        this.total = total;
        this.phatsinh = phatsinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPhatsinh() {
        return phatsinh;
    }

    public void setPhatsinh(int phatsinh) {
        this.phatsinh = phatsinh;
    }
}
