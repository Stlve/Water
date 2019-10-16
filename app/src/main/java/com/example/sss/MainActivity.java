package com.example.sss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    static String token;
    static String card;
    static int gameId;
    static String name="";
    static String password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button10 = findViewById(R.id.button10);//登录的按钮
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Network.init();
                //register();
                EditText username = findViewById(R.id.editText2);//用户名
                EditText uesrpassword = findViewById(R.id.editText3);//密码
                 name = username.getText().toString();
                password = uesrpassword.getText().toString();
                login();


            }
        });


    }

    private void login() {
        Network.api.login(new UserDto(name,password)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse.Data data = response.body().data;
                token = (data.token);
                int playid = (data.user_id);
                //open();
                Intent itt = new Intent(MainActivity.this, Opening1.class);
                //itt.putExtra("card",card);
                itt.putExtra("token",token);
                User.setUser(token,playid);
                startActivityForResult(itt,0);
                //startActivity(new Intent(MainActivity.this, Opening1.class));
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
    private static void register() {
        Network.api.register(new UserDto(name,password)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                System.out.println(response.body().data.msg);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }

    private static void open() {
        Network.api.open(token).enqueue(new Callback<OpenResponse>() {
            @Override
            public void onResponse(Call<OpenResponse> call, Response<OpenResponse> response) {
                OpenResponse.Data data = response.body().data;
                card = data.card;
                gameId = data.id;
                System.out.println(card);
                submit();
            }

            @Override
            public void onFailure(Call<OpenResponse> call, Throwable t) {

            }
        });
    }

    private static void submit() {
        System.out.println(token);
        String[] splitted = card.split(" ");

        List<String> cards = new ArrayList<>();
        cards.add(splitted[0]+" "+splitted[1]+" "+splitted[2]);
        cards.add(splitted[3]+" "+splitted[4]+" "+splitted[5]+" "+splitted[6]+" "+splitted[7]);
        cards.add(splitted[8]+" "+splitted[9]+" "+splitted[10]+" "+splitted[11]+" "+splitted[12]);
        Network.api.submit(token,new SubmitRequest(gameId,cards)).enqueue(new Callback<SubmitResponse>() {
            @Override
            public void onResponse(Call<SubmitResponse> call, Response<SubmitResponse> response) {

            }

            @Override
            public void onFailure(Call<SubmitResponse> call, Throwable t) {

            }
        });
    }
}
