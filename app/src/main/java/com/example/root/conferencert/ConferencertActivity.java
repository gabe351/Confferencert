package com.example.root.conferencert;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import Conferencert.BuildLecture;
import Conferencert.Conference;
import Conferencert.Lecture;
import Conferencert.ReadFile;
import Conferencert.Track;

public class ConferencertActivity extends AppCompatActivity {

    Conference conference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferencert);
        configButtons();
        conference = new Conference(buildTrackOnActivity());
        conference.buildTracks();

        AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(this);
        caixaAlerta.setTitle("SEJA BEM VINDO A APLICAÇÃO");
        caixaAlerta.setMessage("Conferencert é um app que gerencia seu evento, clique nos turnos e serão mostradas as respectivas palestras");
        caixaAlerta.setNeutralButton("ok", null);
        caixaAlerta.show();

    }

    public List<Lecture> buildTrackOnActivity(){

        InputStream file = getResources().openRawResource(R.raw.proposals);
        ReadFile openFile = new ReadFile();
        List<String> results = openFile.read(file);

        //DECLARANDO Track para ser adicionada
        List<Lecture> l = new ArrayList<Lecture>();

        //Pegar lista de String e transformar em Lectures para colocar numa lista de Lectures
        for(String result : results){
            Lecture lecture = BuildLecture.build(result);
            l.add(lecture);
        }
        return l;
    }

    private void configButtons() {

        TextView morningA  = (TextView) findViewById(R.id.morning_a);
        TextView afternonA = (TextView) findViewById(R.id.afternoon_a);
        TextView morningB  = (TextView) findViewById(R.id.morning_b);
        TextView afternonB = (TextView) findViewById(R.id.afternoon_b);

        morningA.setTag(Conference.TRACK_MORNING_A);
        afternonA.setTag(Conference.TRACK_AFTERNOON_A);
        morningB.setTag(Conference.TRACK_MORNING_B);
        afternonB.setTag(Conference.TRACK_AFTERNOON_B);
    }


    public void showTrack(View button) {
        Integer trackKey = (Integer)button.getTag();
        Track track = conference.getTrack(trackKey);
        Intent i = new Intent(this, showConferencesActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("Track", track);
        i.putExtras(bundle);

        startActivity(i);
    }
}
