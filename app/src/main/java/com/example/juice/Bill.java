package com.example.juice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Bill extends AppCompatActivity {

    TextView name, price, remainTime;
    Button preBtnB;
    private static final String FORMAT = "%02d:%02d:%02";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        remainTime = findViewById(R.id.remainTime);
        preBtnB = findViewById(R.id.preBtnB);

//        long duration = TimeUnit.MINUTES.toMillis(1);

//        new CountDownTimer(1606900, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d", TimeUnit.MILLISECONDS.toMinutes(1),
//                        TimeUnit.MILLISECONDS.toSeconds(1) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(1)));
//                remainTime.setText(sDuration);
//            }
//
//            @Override
//            public void onFinish() {
//                remainTime.setVisibility(View.GONE);
//            Toast.makeText(getApplicationContext(), "Your Order Is Arrived", Toast.LENGTH_LONG).show();
//            }
//        }.start();






 reverseTimer(500,remainTime);





        name = findViewById(R.id.nameID2);
        price = findViewById(R.id.priceID2);

        Intent intent = getIntent();

        String name1 = intent.getStringExtra("name1");
        name.setText(name1);

        String price1 = intent.getStringExtra("price1");
        price.setText(price1);

        preBtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bill.this,MenuClass.class);
                startActivity(intent);
            }
        });
    }

    public void reverseTimer(int Seconds,final TextView tv){

        new CountDownTimer(Seconds* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("Completed");
            }
        }.start();
    }

}
