package Conferencert;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by root on 17/06/16.
 */

public class ReadFileTest {

    @Test
    public void readingAFile() throws FileNotFoundException{
        InputStream file = new FileInputStream("src/test/res/proposals.txt");

        ReadFile openFile = new ReadFile();
        List<String> result = openFile.read(file);
        List<String> lista = new ArrayList<String>();
        lista.add("Diminuindo tempo de execução de testes em aplicações Rails enterprise 60min");
        lista.add("Reinventando a roda em ASP clássico 45min");
        assertEquals(result, lista);
    }
    
    @Test
    public void failReadingFile() throws FileNotFoundException{
        InputStream file = new FileInputStream("src/test/res/proposalsNull.txt");

        ReadFile openFile = new ReadFile();
        List<String> result = openFile.read(file);


        assertNull(result);
    }

}
