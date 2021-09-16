package com.example.juice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomerInfo extends AppCompatActivity {

    Controllerdb controllerdb;
    SQLiteDatabase db;
    ListView listView;
    Button preBtnCI;

    private ArrayList<String> CustomerName = new ArrayList<String>();
    private ArrayList<String> CustomerEmail = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        controllerdb = new Controllerdb(this);

        listView = findViewById(R.id.Lview);
        preBtnCI = findViewById(R.id.preBtnCI);

        preBtnCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerInfo.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        DisplayData();
        super.onResume();
    }

    public void DisplayData(){

        db = controllerdb.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM  customers",null);

        CustomerName.clear();
        CustomerEmail.clear();

        if (cursor.moveToFirst()) {
            do {

                CustomerName.add(cursor.getString(cursor.getColumnIndex("CustomerName")));
                CustomerEmail.add(cursor.getString(cursor.getColumnIndex("CustomerEmail")));


            } while (cursor.moveToNext());
        }

        Adapter ad = new Adapter(CustomerInfo.this,CustomerName,CustomerEmail);
        listView.setAdapter(ad);
        cursor.close();
    }
}