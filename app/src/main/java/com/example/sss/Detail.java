package com.example.sss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity {
    static int gameId;
    private List<HistoryDetailResponse.Data> detailList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail.this,Oldtime.class));
            }
        });
//        Intent ittDataIn = getIntent();
//        token = ittDataIn.getStringExtra("token");
        Intent play = getIntent();
        gameId = play.getIntExtra("gameId",0);

        Network.api.historydetail(User.currentUser.token, gameId).enqueue(new Callback<HistoryDetailResponse>() {
            @Override
            public void onResponse(Call<HistoryDetailResponse> call, Response<HistoryDetailResponse> response) {
                try {
                    List<HistoryDetailResponse.Otherdata> details = response.body().data.detail;
                    DetailAdapter adapter = new DetailAdapter(getApplicationContext(), R.layout.historydetail_item, details);

                    ListView listView = findViewById(R.id.list_view11);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(Detail.this, "对局未结束或不存在", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HistoryDetailResponse> call, Throwable t) {

            }
        });

//        DetailAdapter adapter = new DetailAdapter(Detail.this,R.layout.historydetail_item,detailList);
//        ListView dataillistView = (ListView)findViewById(R.id.list_view11);
//        dataillistView.setAdapter(adapter);

    }
}
