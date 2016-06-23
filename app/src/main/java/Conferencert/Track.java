package Conferencert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 23/06/16.
 */
public class Track {
    public final static Integer MORNING_LIMIT = 120;
    public final static Integer AFTERNOON_LIMIT = 239;

    private List<Lecture> lectures = new ArrayList<Lecture>();
    private final Integer limit;

    public Track(Integer limit) {
        this.limit = limit;
    }

    public Integer sumLecturesTimes(Lecture lecture){

        Integer totalTimes = lecture.getTimeInt(lecture.getTimeStr()) + lecture.getTimeInt(lecture.getTimeStr());

        return totalTimes;
    }

    public Boolean adicionarPalestra(Lecture lecture) {
        if (sumLecturesTimes(lecture)> MORNING_LIMIT){

        }
        return null;
    }


    public List<Lecture> getLectures() {
        return lectures;
    }
}
