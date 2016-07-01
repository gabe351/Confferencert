package Conferencert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 23/06/16.
 */
public class Track {
    public final static Integer MORNING_LIMIT = 180;
    public final static Integer AFTERNOON_LIMIT = 239;



    private List<Lecture> lectures = new ArrayList<Lecture>();
    private final Integer limit;

    public Track(Integer limit) {
        this.limit = limit;
    }

    public void getLecturesTitle(){
        for (Lecture l : lectures){
            l.getTitle();
        }
    }
    public Integer sumLecturesTimes(Lecture lecture){
        Integer totalTimes = 0;
        totalTimes += lecture.getTimeInt();
        for (Lecture l : lectures) {
            totalTimes += l.getTimeInt();
        }

        return totalTimes;
    }


    public Boolean addLecture(Lecture lecture) {
        if(sumLecturesTimes(lecture) <= limit){
            lectures.add(lecture);
            return true;
        }

        return false;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (!lectures.equals(track.lectures)) return false;
        return limit.equals(track.limit);

    }
//    //tirei o @Override daqui e ele passou no teste...
//    public boolean equals(Track o) {
//        o.getLecturesTitle();
//        return true;
//    }
}
