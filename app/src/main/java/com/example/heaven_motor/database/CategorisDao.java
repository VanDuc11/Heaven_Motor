package com.example.heaven_motor.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.heaven_motor.model.Categoris;

import java.util.ArrayList;
import java.util.List;

public class CategorisDao {
    SQL sqlite;
    SQLiteDatabase db;
    Context context;
    public CategorisDao(Context context){
        this.context = context;
        sqlite = new SQL(context);
        db = sqlite.getWritableDatabase();
    }

    public int insert(Categoris c){
        ContentValues values = new ContentValues();
        values.put("id",c.getId());
        values.put("name",c.getName());
        values.put("cave",c.getCave());

        long kq = db.insert("Categoris",null,values);
        if (kq <= 0){
            return -1;
        }
        return 1;
    }
    public int Update(Categoris c){
        ContentValues values = new ContentValues();
        values.put("id",c.getId());
        values.put("name",c.getName());
        values.put("cave",c.getCave());


        long kq = db.update("Categoris",values,"id=?",new String[]{String.valueOf(c.getId())});
        if (kq <= 0){
            return -1;
        }
        return 1;
    }
    public int delete(String id){
        return db.delete("Categoris","id=?",new String[]{id});
    }
    @SuppressLint("Range")
    public List<Categoris> getData(String sql, String ...selectionArgs){
        List<Categoris> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            Categoris cg = new Categoris();
            cg.setId(c.getInt(c.getColumnIndex("id")));
            cg.setName(c.getString(c.getColumnIndex("name")));
            cg.setCave(c.getString(c.getColumnIndex("cave")));

            list.add(cg);
        }
        return list;
    }
    public Categoris getID(String id){
        String sql = "SELECT * FROM Categoris WHERE id=?";
        List<Categoris> list = getData(sql,id);

        return list.get(0);
    }
    public List<Categoris> getAll(){
        String sql ="SELECT * FROM Categoris";
        return getData(sql);
    }
}
