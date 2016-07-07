package com.example.root.conferencert;

import android.support.annotation.RawRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.InputStream;
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

    }

    public List buildTrackOnActivity(){

        InputStream file = getResources().openRawResource(R.raw.proposals);
        ReadFile openFile = new ReadFile();
        List<String> results = openFile.read(file);

        //DECLARANDO Track para ser adicionada
        Track tracks = new Track(Track.MORNING_LIMIT);

        //Pegar lista de String e transformar em Lectures para colocar numa lista de Lectures
        for(String result : results){
            Lecture lecture = BuildLecture.build(result);
            tracks.addLecture(lecture);
        }
        return results;
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
    }


    public void creaListView(){

    }
}
