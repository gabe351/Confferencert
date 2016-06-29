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

}
