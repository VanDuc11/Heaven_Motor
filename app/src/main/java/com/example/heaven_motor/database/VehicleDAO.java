package com.example.heaven_motor.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.heaven_motor.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    SQL sqLite;
    SQLiteDatabase db;
    Context context;
    public VehicleDAO(Context context){
        this.context = context;
        sqLite = new SQL(context);
        db = sqLite.getWritableDatabase();
    }
    public int insert(Vehicle v){
        ContentValues values = new ContentValues();
        values.put("id",v.getId());
        values.put("categorie_id",v.getCategorie_id());
        values.put("name",v.getName());
        values.put("imager",v.getImager());
        values.put("BKS",v.getBKS());
        values.put("capacity",v.getCapacity());
        values.put("status",v.getStatus());
        values.put("amount",v.getAmount());
        values.put("price",v.getPrice());
        values.put("year",v.getYear());

        long kq = db.insert("Vehicle",null,values);
        if (kq <= 0){
            return -1;
        }
        return 1;
    }
    public int Update(Vehicle v){
        ContentValues values = new ContentValues();
        values.put("id",v.getId());
        values.put("categorie_id",v.getCategorie_id());
        values.put("name",v.getName());
        values.put("imager",v.getImager());
        values.put("BKS",v.getBKS());
        values.put("capacity",v.getCapacity());
        values.put("status",v.getStatus());
        values.put("amount",v.getAmount());
        values.put("price",v.getPrice());
        values.put("year",v.getYear());

        long kq = db.update("Vehicle",values,"id=?",new String[]{String.valueOf(v.getId())});
        if (kq <= 0){
            return -1;
        }
        return 1;
    }

    public int delete(String id){
        return db.delete("Vehicle","id=?",new String[]{id});
    }

    @SuppressLint("Range")
    public List<Vehicle> getData(String sql, String ...selectionArgs){
        List<Vehicle> list =  new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            Vehicle v = new Vehicle();
            v.setId((c.getString(c.getColumnIndex("id"))));
            v.setCategorie_id(c.getInt(c.getColumnIndex("categorie_id")));
            v.setName(c.getString(c.getColumnIndex("name")));
            v.setImager(c.getInt(c.getColumnIndex("imager")));
            v.setBKS(c.getString(c.getColumnIndex("BKS")));
            v.setCapacity(c.getInt(c.getColumnIndex("capacity")));
            v.setStatus(c.getInt(c.getColumnIndex("status")));
            v.setAmount(c.getInt(c.getColumnIndex("amount")));
            v.setPrice(c.getInt(c.getColumnIndex("price")));
            v.setPrice(c.getInt(c.getColumnIndex("year")));

            list.add(v);
        }
        return list;
    }
    public Vehicle getID(String id){
        String sql = "SELECT * FROM Vehicle WHERE id=?";
        List<Vehicle> list = getData(sql,id);
        return list.get(0);
    }
    public List<Vehicle> getAll(){
        String sql ="SELECT * FROM Vehicle";
        return getData(sql);
    }
}
