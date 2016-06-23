package Conferencert;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;
/**
 * Created by root on 22/06/16.
 */

public class BuildLectureTest {

    @Test
    public void buildLecture() throws FileNotFoundException {
        String extractedText = "Ruby on Rails 60min";

        Lecture lecture = BuildLecture.build(extractedText);

        assertEquals("Ruby on Rails", lecture.getTitle());
        assertEquals("60min", lecture.getTimeStr());
    }

    @Test
    public void lightningBuildLectureTest(){
        //ver o lighting
        String extractedText = "Ruby on rails lightning";

        Lecture lecture = BuildLecture.build(extractedText);

        assertEquals("Ruby on rails", lecture.getTitle());
        assertEquals("5min", lecture.getTimeStr());
    }

    @Test
    public void nullValues(){
        String extractedText = "none";

        Lecture lecture = BuildLecture.build(extractedText);

        assertNull(lecture);
    }



}
