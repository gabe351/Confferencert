package Conferencert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 29/06/16.
 */
public class Conference {
    private final List<Lecture> lectures;
    private Map<Integer, Track> map = new HashMap<Integer, Track>();

    public static final Integer TRACK_MORNING_A   = 0;
    public static final Integer TRACK_AFTERNOON_A = 1;
    public static final Integer TRACK_MORNING_B   = 2;
    public static final Integer TRACK_AFTERNOON_B = 3;

    public Conference(List<Lecture> lectures) {
        this.lectures = lectures;

        map.put(TRACK_MORNING_A,   new Track(Track.MORNING_LIMIT));
        map.put(TRACK_AFTERNOON_A, new Track(Track.AFTERNOON_LIMIT));
        map.put(TRACK_MORNING_B,   new Track(Track.MORNING_LIMIT));
        map.put(TRACK_AFTERNOON_B, new Track(Track.AFTERNOON_LIMIT));
    }

    public void buildTracks() {

        buildTrack(TRACK_MORNING_A, lectures);
    }

    private void buildTrack(Integer nextTrackKey, List<Lecture> lectures) {
        List<Lecture> standby = new ArrayList<Lecture>();

        for (Lecture l : lectures) {
            Boolean added = map.get(nextTrackKey).addLecture(l);
            if (!added) {
                standby.add(l);
            }
        }

        if (!standby.isEmpty()) {
            buildTrack(nextTrackKey + 1, standby);
        }

    }

    public Track getTrackMorningA() {
        return map.get(TRACK_MORNING_A);
    }

    public Track getTrackAfternoonA() {
        return map.get(TRACK_AFTERNOON_A);
    }

    public Track getTrackMorningB() {
        return map.get(TRACK_MORNING_B);
    }

    public Track getTrackAfternoonB() {
        return map.get(TRACK_AFTERNOON_B);
    }


    public Track getTrack(Integer trackKey) {
        return map.get(trackKey);
    }
}

