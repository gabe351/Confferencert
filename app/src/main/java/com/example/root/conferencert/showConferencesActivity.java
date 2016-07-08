package com.example.root.conferencert;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Conferencert.Lecture;
import Conferencert.Track;

/**
 * Created by root on 06/07/16.
 */
public class showConferencesActivity extends ListActivity {

    private TextView title;
    private ListView lectures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_conferences);

        title =(TextView) findViewById(R.id.title);
        lectures = (ListView) findViewById(android.R.id.list);

        Intent in= getIntent();
        Bundle b = in.getExtras();
        List<Lecture> l = new ArrayList<>();

        String[] planets = new String[] { };

        if(b!=null)
        {
            Track j = (Track) b.get("Track");
            j.getLectures();

        }else{
            String j = "Arquivo está vazio";
            title.setText(j);
        }
    }   
}
