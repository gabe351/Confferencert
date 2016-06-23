package Conferencert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 17/06/16.
 */

public class ReadFile {
    public List<String> archive = new ArrayList<>();

    public List<String> read(InputStream file){

        try {

            BufferedReader readf = new BufferedReader(new InputStreamReader(file));

            String line = readf.readLine();

            while (line != null){

                archive.add(line);
                line = readf.readLine();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (archive.size() == 0)
            return null;
        return archive;
    }
}
