package Conferencert;

import java.io.Serializable;

/**
 * Created by root on 22/06/16.
 */
public class Lecture implements Serializable{

    private String title;
    private String timeStr;

    public Lecture(String title, String timeStr) {
        this.title   = title;
        this.timeStr = timeStr;
    }

    public String getTitle() {
        return title;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public Integer getTimeInt() {

        String numberTime = getTimeStr().replace("min", "");
        Integer timeInt = Integer.parseInt(numberTime);

        return timeInt;
    }
}
