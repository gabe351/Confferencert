package com.example.root.conferencert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import java.util.List;

import Conferencert.Lecture;

/**
 * Created by root on 08/07/16.
 */

public class lectureAdapter extends ArrayAdapter<Lecture> {
    int resource;
    String response;
    Context context;

    public lectureAdapter(Context context, int resource, List<Lecture> items) {
        super(context, resource, items);
        this.resource=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //ACHO QUE NÃO PRECISO DESSA LINHA
        LinearLayout contentOfScreen;
        //Get the current Lecture
        Lecture l = getItem(position);

        if(convertView==null)
        {
            contentOfScreen = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource, contentOfScreen, true);
        }
        else
        {
            contentOfScreen = (LinearLayout) convertView;
        }

        return contentOfScreen;
    }

}
