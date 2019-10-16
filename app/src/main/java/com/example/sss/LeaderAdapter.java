package com.example.sss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class LeaderAdapter extends ArrayAdapter<leaderResponse> {
    private int resourceId;
    public LeaderAdapter(Context context, int textViewResourceId, List<leaderResponse> object){
        super(context,textViewResourceId,object);
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        leaderResponse leaderResponse= getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView leader = (TextView) view.findViewById(R.id.leader_item);
        leader.setText(leaderResponse.getPlayer_id()+"\n"+leaderResponse.getName()+"\n"+leaderResponse.getScore()+"\n");
        return view;
    }

}
