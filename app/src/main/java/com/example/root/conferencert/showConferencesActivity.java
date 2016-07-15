package com.example.root.conferencert;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import java.util.List;

import Conferencert.Lecture;
import Conferencert.Track;

/**
 * Created by root on 06/07/16.
 */
public class showConferencesActivity extends AppCompatActivity {



    private List<Lecture> listL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recylerview);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Intent in= getIntent();
        Bundle b = in.getExtras();


        if(b!=null)
        {

            Track j = (Track) b.get("Track");
            listL = j.getLectures();

        }else{

            String j = "Arquivo está vazio";

        }

        recyclerView.setAdapter(new recyclerLectureAdapter(listL, this));

    }
    public void lecturesD(View v){

        AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(this);
        caixaAlerta.setTitle("DETALHES DA PALESTRA");
        caixaAlerta.setMessage("Posso colocar aqui os tempos ou descrição da palestra");
        caixaAlerta.setNeutralButton("ok", null);
        caixaAlerta.show();
    }
}
