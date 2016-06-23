package Conferencert;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by root on 23/06/16.
 */

public class LectureTest {
    @Test
    public void parseIntTime(){

        Lecture lecture = new Lecture("palestra de ruby", "60min");
        int timeInt = lecture.getTimeInt(lecture.getTimeStr());

        assertEquals(60, timeInt);
    }
}
