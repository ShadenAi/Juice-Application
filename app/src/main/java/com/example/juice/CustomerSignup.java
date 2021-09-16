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
import android.widget.ImageButton;

public class CustomerSignup extends AppCompatActivity {


    EditText editTextUsername,editTextPassword,editEmail;
    Button signUpBtn,preBtnS;
    String username,password,email;
    Controllerdb controllerdb;
    SQLiteDatabase db;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);

        controllerdb = new Controllerdb(this);
        builder = new AlertDialog.Builder(this);

        editTextUsername = findViewById(R.id.editUsernameC);
        editTextPassword = findViewById(R.id.editPasswordC);
        editEmail = findViewById(R.id.editEmailC);
        signUpBtn = findViewById(R.id.signUpBtnC);
        preBtnS = findViewById(R.id.preBtnS);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
                email = editEmail.getText().toString();


                db = controllerdb.getWritableDatabase();

                String q1, q2;
                db = controllerdb.getWritableDatabase();
                q1 = "INSERT INTO users (username,pass,type ) VALUES ('" + username + "','" + password + "','Customer')";
                db.execSQL(q1);
                q2 = "INSERT INTO customers (CustomerName,CustomerEmail ) VALUES ('" + username + "','" + email + "')";
                db.execSQL(q2);

                builder.setMessage("Your Information Are Added Successfully");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(CustomerSignup.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("Sign Up (Customer)");
                alert.show();


            }
        });

        preBtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerSignup.this,LoginActivity.class);
                startActivity(intent);
            }
        });

   

    }
}