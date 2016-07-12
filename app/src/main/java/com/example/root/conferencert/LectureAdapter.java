package com.example.root.conferencert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import Conferencert.Lecture;

/**
 * Created by root on 08/07/16.
 */

public class LectureAdapter extends ArrayAdapter<Lecture> {
    private LayoutInflater mInflater;
    private List<Lecture> itens;
    private int resource;
    String response;
    Context context;
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
        //Get the current Lecture
        Lecture l = getItem(position);
        convertView = mInflater.inflate(R.layout.item_listview, null);
        ((TextView) convertView.findViewById(R.id.text)).setText(l.getTitle());


//        if(convertView==null)
//        {
//            contentOfScreen = new LinearLayout(getContext());
//            String inflater = Context.LAYOUT_INFLATER_SERVICE;
//            LayoutInflater vi;
//            vi = (LayoutInflater)getContext().getSystemService(inflater);
//            vi.inflate(resource, contentOfScreen, true);
//        }
//        else
//        {
//            contentOfScreen = (LinearLayout) convertView;
//        }

//        Get the text boxes from the listitem.xml file
//        TextView alertText =(TextView)alertView.findViewById(R.id.txtAlertText);
//        TextView alertDate =(TextView)alertView.findViewById(R.id.txtAlertDate);
//
//        //Assign the appropriate data from our alert object above
//        alertText.setText(al.alerttext);
//        alertDate.setText(al.alertdate);

        return convertView;
    }

}
