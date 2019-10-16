package com.example.sss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Opening1 extends AppCompatActivity {


    static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening1);
        //点击对战的按钮
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open();
                //登录界面传进来的token
                token = getIntent().getStringExtra("token");
                Intent itt = new Intent(Opening1.this, Porker.class);
                itt.putExtra("token", token);
                //itt.putExtra("card3",)
                // submit();
                startActivityForResult(itt, 0);
                //startActivity(new Intent(Opening1.this,Porker.class));
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Opening1.this, Playrules.class));
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itt = new Intent(Opening1.this, Rankinglist.class);
                itt.putExtra("token", token);
                startActivityForResult(itt,0);
                //startActivity(new Intent(Opening1.this, Rankinglist.class));
            }
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Opening1.this, Oldtime.class);
                it.putExtra("token", token);
                //itt.putExtra("card3",)
                // submit();
                startActivityForResult(it, 0);
                //startActivity(new Intent(Opening1.this, Oldtime.class));
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Opening1.this, MainActivity.class));
            }
        });
    }
}

