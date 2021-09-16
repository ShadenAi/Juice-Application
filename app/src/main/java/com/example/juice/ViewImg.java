package com.example.juice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

public class ViewImg extends AppCompatActivity {

    TextView name,price,calories;
    ImageView img;
    Button preBtnVI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_img);

        name = findViewById(R.id.nameID);
        price = findViewById(R.id.priceID);
        img = findViewById(R.id.img);
        calories = findViewById(R.id.CaloriesID);
        preBtnVI = findViewById(R.id.preBtnVI);

        Intent intent = getIntent();

        int url = intent.getIntExtra("URL",0);
        img.setImageResource(url);

        String name1 = intent.getStringExtra("name");
        name.setText(name1);

        String price1 = intent.getStringExtra("price");
        price.setText(price1);

        String calories1 = intent.getStringExtra("calories");
        calories.setText(calories1);

        preBtnVI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewImg.this,MenuClass.class);
                startActivity(intent);
            }
        });


    }
}