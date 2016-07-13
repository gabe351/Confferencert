package com.example.root.conferencert;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

import Conferencert.Lecture;
import Conferencert.Track;

/**
 * Created by root on 06/07/16.
 */
public class showConferencesActivity extends ListActivity {


    private ListView lectures;
    private LectureAdapter lectureAdapter;
    private List<Lecture> listL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_conferences);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        lectures = (ListView) findViewById(android.R.id.list);

        Intent in= getIntent();
        Bundle b = in.getExtras();


        if(b!=null)
        {

            Track j = (Track) b.get("Track");
            listL = j.getLectures();

        }else{

            String j = "Arquivo está vazio";

        };

            //Cria o adapter
            lectureAdapter = new LectureAdapter(this, R.layout.activity_show_conferences, listL);
            //Define o Adapter
            lectures.setAdapter(lectureAdapter);

    }
    public void lecturesD(View v){

        AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(this);
        caixaAlerta.setTitle("DETALHES DA PALESTRA");
        caixaAlerta.setMessage("Posso colocar aqui os tempos ou descrição da palestra");
        caixaAlerta.setNeutralButton("ok", null);
        caixaAlerta.show();
    }
}
