package com.example.sss;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.sss.Opening1.token;

//往期对战情况
public class Oldtime extends AppCompatActivity {

    static String token;
    static int playid;//没初始化 = 0
    static int limit;
    static int page;
    static int id;
    private List<HistoryResponse.Data> cards = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oldtime);

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Oldtime.this,Opening1.class));
            }
        });

        history();


    }

    private void history() {

        String token = User.currentUser.token;
        int id = User.currentUser.playid;
        Network.api.history(token, id, 10, page).enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                cards = response.body().data;
                System.out.println(cards);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DataAdapter adapter = new DataAdapter(Oldtime.this,R.layout.historyresponse_item,cards);
                        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(Oldtime.this,android.R.layout.simple_list_item_1,cards);
                        ListView listView = findViewById(R.id.list_view);
                        listView.setAdapter(adapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                historydetail(cards.get(position).id);
                            }
                        });
                    }
                });

            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {

            }
        });


    }
    private void historydetail(int gameId){
        Intent intent = new Intent(Oldtime.this,Detail.class);
        intent.putExtra("gameId",gameId);//这里把战局Id传下去 在那个Activity发请求 好 我来了
        startActivity(intent);

    }
}
