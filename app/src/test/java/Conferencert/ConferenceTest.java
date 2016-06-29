package Conferencert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by root on 29/06/16.
 */

public class ConferenceTest {

    @Test
    public void buildTracks(){
        List<Lecture> lectures = new ArrayList<Lecture>();
        lectures.add(new Lecture("Ruby 1", "60min"));
        lectures.add(new Lecture("Ruby 2", "60min"));
        lectures.add(new Lecture("Ruby 3", "60min"));

        Conference conference = new Conference(lectures);

        conference.buildTracks();


    }

    @Test
    public void deliverTracks(){
        //Recuperar as lectures que não entrarem nas tracks e armazenar em um standby list
        Track trackMorning = new Track(Track.MORNING_LIMIT);
        Track trackAfternoon = new Track(Track.AFTERNOON_LIMIT);
        List<Lecture> lectures = new ArrayList<>();
        List<Lecture> standby = new ArrayList<>();

        Conference conference = new Conference(lectures);

        Lecture palestra1 = new Lecture("Ruby 1", "60min");
        Lecture palestra2 = new Lecture("Ruby 2", "60min");
        Lecture palestra3 = new Lecture("Ruby 3", "65min");
        Lecture palestra4 = new Lecture("Ruby 4", "60min");



        trackMorning.addLecture(palestra1);
        trackMorning.addLecture(palestra2);
        trackMorning.addLecture(palestra4);

        Boolean adicionou3 = trackMorning.addLecture(palestra3);
        assertFalse(adicionou3);

        //PRECISO SABER ONDE ESSA PALESTRA 3 FOI PARAR E SALVAR ELA NO STANDBY




        conference.buildTracks();




    }
}
