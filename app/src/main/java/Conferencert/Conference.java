package Conferencert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 29/06/16.
 */
public class Conference {
    private final List<Lecture> lectures;

    Track trackADia1 = new Track(Track.MORNING_LIMIT);
    Track trackBDia1 = new Track(Track.AFTERNOON_LIMIT);
    Track trackADia2 = new Track(Track.MORNING_LIMIT);
    Track trackBDia2 = new Track(Track.AFTERNOON_LIMIT);



    public Conference(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public void buildTracks() {
        for (Lecture l : lectures) {
            Boolean add = false;
            add = trackADia1.addLecture(l);
        }

    }
}
