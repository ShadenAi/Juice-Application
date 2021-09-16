package com.example.juice;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Controllerdb extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "juiceDatabase";

    public Controllerdb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query1,query2,query3;

        query1 = " CREATE TABLE IF NOT EXISTS users (username VARCHAR PRIMARY KEY, pass VARCHAR, type VARCHAR );";
        db.execSQL(query1);

        query2 = " CREATE TABLE IF NOT EXISTS customers (Id INTEGER PRIMARY KEY AUTOINCREMENT, CustomerName VARCHAR, CustomerEmail VARCHAR);";
        db.execSQL(query2);

        query3 = " CREATE TABLE IF NOT EXISTS admins (Id INTEGER PRIMARY KEY AUTOINCREMENT, AdminName VARCHAR, AdminEmail VARCHAR);";
        db.execSQL(query3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query1,query2,query3 ;
        query1 = "DROP TABLE IF EXISTS users";
        db.execSQL(query1);

        query2 = "DROP TABLE IF EXISTS customers";
        db.execSQL(query2);

        query3 = "DROP TABLE IF EXISTS admins";
        db.execSQL(query3);


        onCreate(db);

    }
}
