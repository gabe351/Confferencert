package Conferencert;

import static junit.framework.Assert.*;

import org.junit.Test;

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
        Lecture palestra2 = new Lecture("Ruby 2", "30min");
        Lecture palestra3 = new Lecture("Ruby 3", "40min");
        Lecture palestra4 = new Lecture("Ruby 4", "60min");

        Boolean adicionou1 = trackManha.adicionarPalestra(palestra1);
        assertTrue(adicionou1);

        Boolean adicionou2 = trackManha.adicionarPalestra(palestra2);
        assertTrue(adicionou2);

        Boolean adicionou3 = trackManha.adicionarPalestra(palestra3);
        assertTrue(adicionou3);

        Boolean adicionou4 = trackManha.adicionarPalestra(palestra4);
        assertFalse(adicionou4);

        List<Lecture> lecturesAdded = new ArrayList<Lecture>();
        lecturesAdded.add(palestra1);
        lecturesAdded.add(palestra2);
        lecturesAdded.add(palestra3);

        assertEquals(lecturesAdded, trackManha.getLectures());

    }
}
