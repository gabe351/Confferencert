package com.example.root.conferencert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Conferencert.Conference;
import Conferencert.Track;

public class ConferencertActivity extends AppCompatActivity {

    Conference conference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferencert);
        configButtons();
        conference = new Conference(buildTrackOnActivity);

    }

    public Track buildTrackOnActivity(Track t){
        openFileInput();
        return t;
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


    public void showTrackMorningA(){

    }
    public void showTrackAfternoonA(View v){
        setContentView(R.layout.activity_tracks_screen);

    }
    public void showTrackMorningB(View v){
        setContentView(R.layout.activity_tracks_screen);

    }
    public void showTrackAfternoonB(View v){
        setContentView(R.layout.activity_tracks_screen);

    }
    public void creaListView(){

    }
}
