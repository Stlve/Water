package com.example.sss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//排行榜
public class Rankinglist extends AppCompatActivity {
    static String token;
    static int id;
    static int player_id;
    static String name;
    static int score;
    private List<leaderResponse> leader = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rankinglist);

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Rankinglist.this,Opening1.class));
            }
        });
        leaderboard();


    }
    private void leaderboard(){
        Intent ittDataIn = getIntent();
        token = ittDataIn.getStringExtra("token");
        Network.api.getrank().enqueue(new Callback<List<leaderResponse>>() {
            @Override
            public void onResponse(Call<List<leaderResponse>> call, Response<List<leaderResponse>> response) {
                leader = response.body();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LeaderAdapter adapter = new LeaderAdapter(Rankinglist.this,R.layout.leader_item,leader);
//                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Oldtime.this,android.R.layout.simple_list_item_1,cards);
                        ListView listView =  findViewById(R.id.list_view2);
                        listView.setAdapter(adapter);
                    }
                });

            }

            @Override
            public void onFailure(Call<List<leaderResponse>> call, Throwable t) {

            }
        });
    }
}
