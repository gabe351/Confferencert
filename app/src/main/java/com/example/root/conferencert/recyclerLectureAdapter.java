package com.example.root.conferencert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import Conferencert.Lecture;

/**
 * Created by root on 13/07/16.
 */
public class recyclerLectureAdapter extends RecyclerView.Adapter {

    private List<Lecture> l;
    private Context context;

    public recyclerLectureAdapter(List<Lecture> l, Context context){
        this.l = l;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.item_listview, parent, false);
        NossoViewHolder holder = new NossoViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return l.size();
    }
    public class NossoViewHolder extends RecyclerView.ViewHolder{

        final TextView comboOfLectures;


        public NossoViewHolder(View v) {
            super(v);
            comboOfLectures = (TextView) v.findViewById(R.id.text);
        }

    }
}
