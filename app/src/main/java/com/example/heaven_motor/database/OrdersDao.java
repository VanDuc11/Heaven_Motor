package com.example.heaven_motor.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.heaven_motor.model.Orders;
import com.example.heaven_motor.model.Top;
import com.example.heaven_motor.model.Vehicle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {
    SQL sqLite;
    SQLiteDatabase db;
    Context context;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public OrdersDao(Context context){
        this.context = context;
        sqLite = new SQL(context);
        db = sqLite.getWritableDatabase();
    }
    public int insert(Orders o){
        ContentValues values = new ContentValues();
        values.put("user_id",o.getUser_id());
        values.put("vehicle_id",o.getVehicle_id());
        values.put("start_time",o.getStart_time());
        values.put("end_time",o.getEnd_time());
        values.put("total",o.getTotal());
        values.put("phatsinh",o.getPhatsinh());
        values.put("timethuc",o.getTimethuc());
        long kq = db.insert("Orders",null,values);
        if (kq <= 0){
            return -1;
        }
        return 1;
    }
    public int Update(Orders o){
        ContentValues values = new ContentValues();
        values.put("user_id",o.getUser_id());
        values.put("vehicle_id",o.getVehicle_id());
        values.put("start_time",o.getStart_time());
        values.put("end_time",o.getEnd_time());
        values.put("total",o.getTotal());
        values.put("phatsinh",o.getPhatsinh());
        values.put("timethuc",o.getTimethuc());

        long kq = db.update("Orders",values,"id=?",new String[]{String.valueOf(o.getId())});
        if (kq <= 0){
            return -1;
        }
        return 1;
    }
    @SuppressLint("Range")
    public List<Orders> getData(String sql, String ...selectionArgs){
        List<Orders> list =  new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            Orders o = new Orders();
            o.setId(Integer.parseInt(c.getString(c.getColumnIndex("id"))));
            o.setUser_id(c.getString(c.getColumnIndex("user_id")));
            o.setVehicle_id(c.getString(c.getColumnIndex("vehicle_id")));
            o.setStart_time(c.getString(c.getColumnIndex("start_time")));
            o.setEnd_time(c.getString(c.getColumnIndex("end_time")));
            o.setTotal(c.getInt(c.getColumnIndex("total")));
            o.setPhatsinh(Integer.parseInt(c.getString(c.getColumnIndex("phatsinh"))));

            list.add(o);
        }
        return list;
    }
    public Orders getID(String id){
        String sql = "SELECT * FROM Orders WHERE id=?";
        List<Orders> list = getData(sql,id);
        return list.get(0);
    }

    @SuppressLint("Range")
    public int getDate(){
        String Sql = "SELECT (end_time - start_time) as Date FROM Orders";
        List<Integer> list = new ArrayList<>();
        Cursor c = db.rawQuery(Sql,null);
        while (c.moveToNext()){
            try {
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("Date"))));
            }catch (Exception e){
                list.add(0);
            }

        }

        return list.get(0);
    }
    public List<Orders> getAll(){
        String sql ="SELECT * FROM Orders";
        return getData(sql);
    }
    @SuppressLint("Range")
    public int getStatus(){
        String sql ="SELECT Vehicle.trangthai as status FROM Orders INNER JOIN Vehicle ON Vehicle.id = Orders.vehicle_id";
        List<Integer> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,null);
        while (c.moveToNext()){
            try {
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("status"))));
            }catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }

    @SuppressLint("Range")
    public List<Orders> getDonhang(String id){
        String sql ="SELECT * FROM Orders WHERE user_id=?";
        return getData(sql,id);
    }
    @SuppressLint("Range")
    public List<Top> getTop(){
    String sqlTop ="SELECT vehicle_id,count(vehicle_id) as soluong From Orders  as OD join Vehicle as Xe on OD.vehicle_id = Xe.id  join Categories as ca on ca.id = Xe.categorie_id  GROUP BY vehicle_id ORDER BY soluong DESC LIMIT 10 ";

        List<Top> list = new ArrayList<Top>();
    VehicleDAO vehicleDAO = new VehicleDAO(context);
    Cursor c =db.rawQuery(sqlTop,null);
    while (c.moveToNext()){
        Top top = new Top();
        Vehicle vehicle =vehicleDAO.getID(String.valueOf(c.getInt(c.getColumnIndex("vehicle_id"))));
        top.setId(vehicle.getId());
        top.setName(vehicle.getName());
//        top.setBrand(vehicle.getBrand());

        top.setCapacity(vehicle.getCapacity());
        top.setBKS(vehicle.getBKS());
        top.setCategorie_id(vehicle.getCategorie_id());
        top.setSoluong(c.getInt(c.getColumnIndex("soluong")));
//        String s ="ID: " +top.getId() + "\t\t\t\t\t" +" " +top.getName()+ "\t\t\t\t\t" +" "+top.getBrand()+ "\t\t\t\t\t" +" "+top.getCapacity()+ "\t\t\t\t\t" +" "+top.getBKS()+ "\t\t\t\t\t" +" "+top.getSoluong();
        list.add(top);
    }
    return list;
    }
    @SuppressLint("Range")
    public int getdoanhthu(String tungay, String denngay) {
        String sqldoanhthu = "SELECT SUM(total) as doanhthu from Orders WHERE start_time BETWEEN ? AND ? ";
        List<Integer> list = new ArrayList<Integer>();
        Cursor c = db.rawQuery(sqldoanhthu, new String[]{tungay, denngay});
        while (c.moveToNext()) {
            try {
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("doanhthu"))));
            } catch (Exception e) {
                list.add(0);
            }
        }
        return list.get(0);
    }
    }

