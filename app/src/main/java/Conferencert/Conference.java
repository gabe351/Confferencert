package Conferencert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 29/06/16.
 */
public class Conference {
    private final List<Lecture> lectures;
    List<Lecture> standby = new ArrayList<>();
    List<String> lecturesFromA = new ArrayList<>();

    Track trackMorningA = new Track(Track.MORNING_LIMIT);
    Track trackAfternoonA = new Track(Track.AFTERNOON_LIMIT);
    Track TrackMorningB = new Track(Track.MORNING_LIMIT);
    Track trackAftenoonB = new Track(Track.AFTERNOON_LIMIT);



    public Conference(List<Lecture> lectures) {
        this.lectures = lectures;
    }
    public void buildTracks(Lecture lecture) throws FileNotFoundException {

        InputStream file = new FileInputStream("src/test/res/proposals.txt");
        ReadFile openFile = new ReadFile();
        List<String> results = openFile.read(file);


    }
    public void buildTracks() {
        for (Lecture l : lectures) {
            Boolean add = false;
            add = trackMorningA.addLecture(l);
//            if (trackMorningA.sumLecturesTimes(l)> Track.MORNING_LIMIT){
//                standby.add(l);
//            }
        }

    }
}

