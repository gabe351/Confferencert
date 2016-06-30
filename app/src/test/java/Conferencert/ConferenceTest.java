package Conferencert;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
    public void fromTxtToListOfLectures() throws FileNotFoundException {

        //puxando um arquivo e criando uma lista de String
        InputStream file = new FileInputStream("src/test/res/proposals.txt");
        ReadFile openFile = new ReadFile();
        List<String> results = openFile.read(file);

        //DECLARANDO Track para ser adicionada
        Track trackManhaA = new Track(Track.MORNING_LIMIT);

        String ShowTitles = null;

        //Pegar lista de String e transformar em Lectures
        //Pegar lectures e colocar numa lista de Lectures
        for(String result : results){
            Lecture lecture = BuildLecture.build(result);
            trackManhaA.addLecture(lecture);
            ShowTitles = lecture.getTitle();
        }

        Track tracktest = new Track(Track.MORNING_LIMIT);

        Lecture l1 = new Lecture("Diminuindo tempo de execução de testes em aplicações Rails enterprise","60min");
        Lecture l2 = new Lecture("Reinventando a roda em ASP clássico", "45min");
        tracktest.addLecture(l1);
        tracktest.addLecture(l2);

        String b = "Reinventando a roda em ASP clássico";

        assertEquals(trackManhaA, tracktest);


        //Pegar lista de lectures e colocar nas tracks!!! ------ CORAÇÃO



    }


    @Test
    public void deliverTracks(){
        //Recuperar as lectures que não entrarem nas tracks e armazenar em um standby list
        Track trackMorning = new Track(Track.MORNING_LIMIT);
        Track trackAfternoon = new Track(Track.AFTERNOON_LIMIT);
        List<Lecture> lectures = new ArrayList<>();
        List<Lecture> standby = new ArrayList<>();

        Conference conference = new Conference(lectures);


        //8 PALESTRAS PARA ENCHER DUAS TRACKS, UMA MANHÃ E OUTRA TARDE
        Lecture palestra1 = new Lecture("Ruby 1 - track m", "60min");
        Lecture palestra2 = new Lecture("Ruby 2 - track m", "60min");
        Lecture palestra3 = new Lecture("Ruby 3", "65min");
        Lecture palestra4 = new Lecture("Ruby 4 - track m", "60min");
        Lecture palestra5 = new Lecture("Ruby 5", "60min");
        Lecture palestra6 = new Lecture("Ruby 6", "40min");
        Lecture palestra7 = new Lecture("Ruby 7", "40min");
        Lecture palestra8 = new Lecture("Ruby 8", "30min");



        trackMorning.addLecture(palestra1);
        trackMorning.addLecture(palestra2);
        trackMorning.addLecture(palestra4);

        trackAfternoon.addLecture(palestra3);
        trackAfternoon.addLecture(palestra5);
        trackAfternoon.addLecture(palestra6);
        trackAfternoon.addLecture(palestra7);
        trackAfternoon.addLecture(palestra8);


        Boolean adicionou3 = trackMorning.addLecture(palestra3);
        assertFalse(adicionou3);

        //PRECISO SABER ONDE ESSA PALESTRA 3 FOI PARAR E SALVAR ELA NO STANDBY



        conference.buildTracks();




    }
}
