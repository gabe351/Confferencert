package com.example.root.conferencert;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

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

        if(b!=null)
        {
            Track j = (Track) b.get("Track");
            title.setText(j.getLectures().size());

        }else{
            String j = "Arquivo está vazio";
            title.setText(j);
        }
    }
}
