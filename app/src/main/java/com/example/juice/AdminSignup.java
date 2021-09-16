package com.example.juice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminSignup extends AppCompatActivity {

    EditText editUsername,editPassword,editEmail;
    Button signupBtn,preBtnA;
    String username,password,email;
    Controllerdb controllerdb;
    SQLiteDatabase db;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup);

        controllerdb = new Controllerdb(this);
        builder = new AlertDialog.Builder(this);

        editUsername = findViewById(R.id.editUsernameA);
        editPassword = findViewById(R.id.editPasswordA);
        editEmail = findViewById(R.id.editEmailA);
        signupBtn = findViewById(R.id.signUpBtnA);
        preBtnA = findViewById(R.id.preBtnA);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUserToDataBase();
            }
        });

        preBtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminSignup.this,LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    public void addUserToDataBase(){

        username = editUsername.getText().toString();
        password = editPassword.getText().toString();
        email = editEmail.getText().toString();

        db = controllerdb.getWritableDatabase();

        String q1,q2;
        db = controllerdb.getWritableDatabase();
        q1 = "INSERT INTO users (username,pass,type ) VALUES ('"+username+"','"+password+"','Admin')";
        db.execSQL(q1);
        q2 = "INSERT INTO admins (AdminName,AdminEmail ) VALUES ('"+username+"','"+email+"')" ;
        db.execSQL(q2);

        builder.setMessage("Your Information Are Added Successfully");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(AdminSignup.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alert = builder.create();
        alert.setTitle("Sign Up (Admin)");
        alert.show();


    }



}


