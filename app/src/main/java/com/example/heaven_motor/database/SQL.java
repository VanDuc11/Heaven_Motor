package com.example.heaven_motor.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQL extends SQLiteOpenHelper {


    public static final String Table_Users = "CREATE TABLE Users" +
            "(id text PRIMARY KEY ," +
            "name text," +
            "passwork text," +
            "phone text," +
            "date integer," +
            "address text," +
            "cccd text);";

    public static final String Table_Categories = "CREATE TABLE Categories " +
            "(id integer PRIMARY KEY AUTOINCREMENT," +
            "name text," +
            "brand text);";


    public static final String Table_Vehicle = "CREATE TABLE Vehicle" +
            "(id text PRIMARY KEY," +
            "categorie_id integer REFERENCES Categories(id)," +
            "capacity integer," +
            "status integer," +
            "amount integer," +
            "price integer);";


    public static final String Table_Orders = "CREATE TABLE Orders" +
            "(id text PRIMARY KEY ," +
            "user_id text REFERENCES Users(id)," +
            "vehicle_id text REFERENCES Vehicle(id)," +
            "start_time date ," +
            "end_time date," +
            "status integer," +
            " total integer," +
            "phatsinh integer);";


    public SQL(@Nullable Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table_Users);
        db.execSQL(Table_Categories);
        db.execSQL(Table_Vehicle);
        db.execSQL(Table_Orders);

        //inser data

        db.execSQL(Data_SQL.INSERT_User);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if EXISTS Users");
        db.execSQL("DROP TABLE if EXISTS Categories");
        db.execSQL("DROP TABLE if EXISTS Vehicle");
        db.execSQL("DROP TABLE if EXISTS Orders");

        onCreate(db);
    }

}
