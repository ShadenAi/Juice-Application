package com.example.juice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MenuClass extends AppCompatActivity {

    Button buyBtn, preBtnM;
    AlertDialog.Builder builder;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Intent intent;
    TextView viewOrangeV, viewAppleV,viewKiwiV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_class);

        builder = new AlertDialog.Builder(this);



        buyBtn = findViewById(R.id.buyBtn);
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        viewOrangeV = findViewById(R.id.viewOrangeV);
        viewAppleV = findViewById(R.id.viewAppleV);
        viewKiwiV = findViewById(R.id.viewKiwiV);
        preBtnM = findViewById(R.id.preBtnM);

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selected);

                switch (selected){
                    case R.id.radioOrange:
                        intent = new Intent(MenuClass.this,Bill.class);
                        intent.putExtra("name1","Orange Juice");
                        intent.putExtra("price1","15 SR");
                        startActivity(intent);
                        return;

                    case R.id.radioApple:
                        intent = new Intent(MenuClass.this,Bill.class);
                        intent.putExtra("name1","Apple Juice");
                        intent.putExtra("price1","20 SR");
                        startActivity(intent);
                        return;

                    case R.id.radioKiwi:
                        intent = new Intent(MenuClass.this,Bill.class);
                        intent.putExtra("name1","Kiwi Juice");
                        intent.putExtra("price1","25 SR");
                        startActivity(intent);
                        return;

                    default:
                        builder.setMessage("You Have To Choose First !!");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog alert = builder.create();
                alert.setTitle("ERROR");
                alert.show();
                }
            }
        });

        preBtnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuClass.this,LoginActivity.class);
                startActivity(intent);
            }
        });



        viewOrangeV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuClass.this,ViewImg.class);
                intent.putExtra("URL",R.drawable.orangejuice);
                intent.putExtra("name","Orange Juice");
                intent.putExtra("price","15 SR");
                intent.putExtra("calories","150 cal");
                startActivity(intent);
            }
        });

        viewAppleV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuClass.this,ViewImg.class);
                intent.putExtra("URL",R.drawable.applejuice);
                intent.putExtra("name","Apple Juice");
                intent.putExtra("price","20 SR");
                intent.putExtra("calories","100 cal");
                startActivity(intent);
            }
        });

        viewKiwiV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuClass.this,ViewImg.class);
                intent.putExtra("URL",R.drawable.kiwijuice);
                intent.putExtra("name","Kiwi Juice");
                intent.putExtra("price","25 SR");
                intent.putExtra("calories","50 cal");
                startActivity(intent);
            }
        });





}
}
