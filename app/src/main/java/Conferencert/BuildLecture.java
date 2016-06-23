package Conferencert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 22/06/16.
 */
public class BuildLecture {

    public static Lecture build(String extractedText) {
        String title;
        String timeStr;

        List<String> strTimes = new ArrayList<String>();

        //Tentar colocar em uma só.
        String expressionPattern = "([0-9])+min";
        String lightningExpressionPattern = "(lightning)";

        //Patern e Matcher normal
        Pattern pattern = Pattern.compile(expressionPattern);
        Matcher matcher = pattern.matcher(extractedText);

        //Pattern e Matcher do lightning
        Pattern lightningPatern = Pattern.compile(lightningExpressionPattern);
        Matcher lightningMatcher = lightningPatern.matcher(extractedText);


        while(matcher.find()){
            strTimes.add(matcher.group());
        }

        if (strTimes.size() > 0) {
            title = extractedText.replace(strTimes.get(0).trim(), "").trim();
            timeStr = strTimes.get(0).trim();
            return new Lecture(title, timeStr);

        }else {

            if (lightningMatcher.find()){
                title   = extractedText.replace("lightning".trim(), "").trim();
                timeStr = "5min";
                return new Lecture(title, timeStr);

            }
        }

        return null;
    }
}
