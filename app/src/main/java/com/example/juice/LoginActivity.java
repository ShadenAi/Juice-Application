package com.example.juice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername,editPassword;
    Button signinBtn,signupBtn,preBtnL;

    Controllerdb controllerdb;
    SQLiteDatabase db;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        controllerdb = new Controllerdb(this);
        builder = new AlertDialog.Builder(this);

        editUsername = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPass);
        signinBtn = findViewById(R.id.signinButton);
        signupBtn = findViewById(R.id.signupButton);
        preBtnL = findViewById(R.id.preBtnL);


        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                boolean isExist = checkUserExist(username,password);

                if(isExist){
                    String type = checkUserType(username);
                    if(type.equals("Customer")){
                        Intent intent = new Intent(LoginActivity.this,MenuClass.class);
                        startActivity(intent);
                    }
                    else if(type.equals("Admin")){
                        Intent intent = new Intent(LoginActivity.this,CustomerInfo.class);
                        startActivity(intent);
                    }

                }
                else {
                    editPassword.setText(null);
                    builder.setMessage("Invalid username or password");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Error");
                    alert.show();


                }

            }

        });


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(LoginActivity.this,signupBtn);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.customer:
                                Intent intent = new Intent(LoginActivity.this, CustomerSignup.class);
                                startActivity(intent);
                                return true;

                            case R.id.admin:
                                Intent intent2 = new Intent(LoginActivity.this, AdminSignup.class);
                                startActivity(intent2);
                                return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });


        preBtnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


            }




public boolean checkUserExist(String username, String password){
        String[] columns = {"username"};

        db = controllerdb.getReadableDatabase();

        String selection = "username=? and pass = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();

        if(count > 0){
        return true;
        } else {
        return false;
        }
        }

public String checkUserType(String username){

        String type="";
        String[] columns = {"type"};
        db = controllerdb.getReadableDatabase();

        String selection = "username=?";
        String[] selectionArgs = {username};

        // select type from users where username=username
        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);


        if(cursor.moveToFirst()){ // move to first result
        type=cursor.getString(cursor.getColumnIndex("type"));
        }
        return type;
        }
}