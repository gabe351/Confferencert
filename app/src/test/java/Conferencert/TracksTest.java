package Conferencert;

import static junit.framework.Assert.*;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 23/06/16.
 */

public class TracksTest {

    @Test
    public void addLectureWhenTrackIsMorning(){

        Track trackManha = new Track(Track.MORNING_LIMIT);

        Lecture palestra1 = new Lecture("Ruby 1", "60min");
        Lecture palestra2 = new Lecture("Ruby 2", "60min");
        Lecture palestra3 = new Lecture("Ruby 3", "60min");
        Lecture palestra4 = new Lecture("Ruby 4", "60min");

        Boolean adicionou1 = trackManha.addLecture(palestra1);
        assertTrue(adicionou1);

        Boolean adicionou2 = trackManha.addLecture(palestra2);
        assertTrue(adicionou2);

        Boolean adicionou3 = trackManha.addLecture(palestra3);
        assertTrue(adicionou3);

        Boolean adicionou4 = trackManha.addLecture(palestra4);
        assertFalse(adicionou4);

        List<Lecture> lecturesAdded = new ArrayList<Lecture>();
        lecturesAdded.add(palestra1);
        lecturesAdded.add(palestra2);
        lecturesAdded.add(palestra3);


        assertEquals(lecturesAdded, trackManha.getLectures());
    }

    @Test
    public void addLectureWhenTrackIsMorningAndTheSumWhitTheThirdIsLessThan(){

        Track trackManha = new Track(Track.MORNING_LIMIT);

        Lecture palestra1 = new Lecture("Ruby 1", "60min");
        Lecture palestra2 = new Lecture("Ruby 2", "60min");
        Lecture palestra3 = new Lecture("Ruby 3", "65min");
        Lecture palestra4 = new Lecture("Ruby 4", "61min");

        Boolean adicionou1 = trackManha.addLecture(palestra1);
        assertTrue(adicionou1);

        Boolean adicionou2 = trackManha.addLecture(palestra2);
        assertTrue(adicionou2);

        Boolean adicionou3 = trackManha.addLecture(palestra3);
        assertFalse(adicionou3);

        Boolean adicionou4 = trackManha.addLecture(palestra4);
        assertFalse(adicionou4);

        List<Lecture> lecturesAdded = new ArrayList<Lecture>();
        lecturesAdded.add(palestra1);
        lecturesAdded.add(palestra2);

        assertEquals(lecturesAdded, trackManha.getLectures());
    }

    @Test
    public void fromTxtToTracks() throws FileNotFoundException {

        //puxando um arquivo e criando uma lista de String
        InputStream file = new FileInputStream("src/test/res/proposals.txt");
        ReadFile openFile = new ReadFile();
        List<String> results = openFile.read(file);

        //DECLARANDO Track para ser adicionada
        Track trackMorningA = new Track(Track.MORNING_LIMIT);

        //Pegar lista de String e transformar em Lectures para colocar numa lista de Lectures
        for(String result : results){
            Lecture lecture = BuildLecture.build(result);
            trackMorningA.addLecture(lecture);
        }

        Track tracktest = new Track(Track.MORNING_LIMIT);
        Lecture l1 = new Lecture("Diminuindo tempo de execução de testes em aplicações Rails enterprise","60min");
        Lecture l2 = new Lecture("Reinventando a roda em ASP clássico", "45min");

        tracktest.addLecture(l1);
        tracktest.addLecture(l2);

        assertTrue(trackMorningA.equals(tracktest));
    }

}
