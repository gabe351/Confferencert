package com.example.root.conferencert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import Conferencert.Lecture;

/**
 * Created by root on 08/07/16.
 */

public class LectureAdapter extends ArrayAdapter<Lecture> {

    private Context context;
    private LayoutInflater mInflater;
    private List<Lecture> itens;
    private int resource;
//    initialize adapter
    public LectureAdapter(Context context, int resource, List<Lecture> items) {
        super(context, resource, items);
        this.resource=resource;
        this.itens = items;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount(){
        return itens.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view;
        ViewHolder holder = null;

        if( convertView == null) {
//            view = mInflater.from(context).inflate(R.layout.item_listview, parent, false);
            view = mInflater.inflate(R.layout.item_listview, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
        }

        //Get the current Lecture
        Lecture l = getItem(position);
        holder.comboOfLectures.setText(l.getTitle() + " - "  +l.getTimeStr());
//        ((TextView) view.findViewById(R.id.text)).setText(l.getTitle() + " - "  +l.getTimeStr());
        return view;
    }

    public static class ViewHolder{

        final TextView comboOfLectures;

        public ViewHolder(View v) {

            comboOfLectures = (TextView) v.findViewById(R.id.text);
        }

    }
}
