package com.example.sss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sss.HistoryDetailResponse.Otherdata;

import java.util.List;

public class DetailAdapter extends ArrayAdapter<Otherdata> {

    private List<Otherdata> dataList;
    private int resourceId;
    public DetailAdapter(Context context,int textViewResourceId, List<Otherdata> object){
        super(context,textViewResourceId,object);
        resourceId=textViewResourceId;

    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        Otherdata data = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView detail1 = (TextView) view.findViewById(R.id.historydetail_1);
        TextView detail2 = (TextView) view.findViewById(R.id.historydetail_2);
        TextView detail3 = (TextView) view.findViewById(R.id.historydetail_3);
        TextView detail4 = (TextView) view.findViewById(R.id.historydetail_4);
        TextView detail5 = (TextView) view.findViewById(R.id.historydetail_5);
        detail1.setText(data.player_id+"\n"+data.card+"\n"+data.score);


        return view;
    }
}
