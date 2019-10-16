package com.example.sss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.List;

public class DataAdapter extends ArrayAdapter<HistoryResponse.Data> {
    private int resourceId;
    public DataAdapter(Context context, int textViewResourceId, List<HistoryResponse.Data> object){
        super(context,textViewResourceId,object);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HistoryResponse.Data historyResponseData = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        TextView historyresponse1 = (TextView) view.findViewById(R.id.historyresponse_1);
        historyresponse1.setText(String.valueOf(historyResponseData.getId()));
        TextView historyresponse2 = (TextView) view.findViewById(R.id.historyresponse_2);
        historyresponse2.setText(historyResponseData.get());
        TextView historyresponse3 = (TextView) view.findViewById(R.id.historyresponse_3);
        historyresponse3.setText(String.valueOf(historyResponseData.getScore()));
        TextView historyresponse4 = (TextView) view.findViewById(R.id.historyresponse_4);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String time = sdf.format(historyResponseData.timestamp);
        historyresponse4.setText(time);//我有问题 我这个 那string list要咋输出来

        return view;
    }

}
