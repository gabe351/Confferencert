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
}
