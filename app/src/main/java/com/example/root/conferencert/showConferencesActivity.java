package com.example.root.conferencert;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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


    private ListView lectures;
    private List<String> listS;
    private ArrayAdapter<String> adapter;
    private LectureAdapter lectureAdapter;
    private List<Lecture> listL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_conferences);

        lectures = (ListView) findViewById(android.R.id.list);
        //Initialize our ArrayList

        //Initialize our array adapter notice how it references the listitems.xml layout
//        lectureAdapter = new LectureAdapter(this, R.layout.activity_show_conferences, listL);

        //Set the above adapter as the adapter of choice for our list
//        lectures.setAdapter(lectureAdapter);


        Intent in= getIntent();
        Bundle b = in.getExtras();

        if(b!=null)
        {
            Track j = (Track) b.get("Track");
            listL = j.getLectures();


        }else{
            String j = "Arquivo está vazio";

        }

//        lectures.addView(findViewById(R.id.afternoon_a));

        //Criamos nossa lista que preenchera o ListView
//        Lecture palestra1 = new Lecture("Palestra 10", "50min");
//        listL.add(palestra1);

            //Cria o adapter
            lectureAdapter = new LectureAdapter(this, R.layout.activity_show_conferences, listL);
            //Define o Adapter
            lectures.setAdapter(lectureAdapter);



    }
}
