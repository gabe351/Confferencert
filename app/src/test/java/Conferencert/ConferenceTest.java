package Conferencert;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by root on 29/06/16.
 */

public class ConferenceTest {

//    @Test
//    public void buildTracks(){
//        List<Lecture> lectures = new ArrayList<Lecture>();
//        lectures.add(new Lecture("Ruby 1", "60min"));
//        lectures.add(new Lecture("Ruby 2", "60min"));
//        lectures.add(new Lecture("Ruby 3", "60min"));
//
//        Conference conference = new Conference(lectures);
//
//        conference.buildTracks();
//
//
//    }

    //Pegar lista de lectures e colocar nas tracks!!! ------ CORAÇÃO


    @Test
    public void buildTrack() throws FileNotFoundException {
        //puxando um arquivo e criando uma lista de String
        InputStream file = new FileInputStream("src/main/res/raw/proposals.txt");
        ReadFile openFile = new ReadFile();
        List<String> results = openFile.read(file);
        List<Lecture> listL = new ArrayList<>();
//        //DECLARANDO Track para ser adicionada
        Track trackMorningA = new Track(Track.MORNING_LIMIT);
        Track trackMorningB = new Track(Track.MORNING_LIMIT);
//        Track trackAfternoonA = new Track(Track.AFTERNOON_LIMIT);
//        Track trackAfternoonB = new Track(Track.AFTERNOON_LIMIT);

        //Pegar lista de String e transformar em Lectures para colocar numa lista de Lectures
        for(String result : results){
            Lecture lecture = BuildLecture.build(result);
            listL.add(lecture);
        }

        Conference conference = new Conference(listL);

        conference.buildTracks();

        Lecture palestra1 = new Lecture("Diminuindo tempo de execução de testes em aplicações Rails enterprise", "60min");
        Lecture palestra2 = new Lecture ("Reinventando a roda em ASP clássico", "45min");
        Lecture palestra3 = new Lecture("Apresentando Lua para as massas", "30min");
        Lecture palestra4 = new Lecture("Erros de Ruby oriundos de versões erradas de gems", "45min");
//        Lecture palestra5 = new Lecture("Erros comuns em Ruby", "45min");
//        Lecture palestra6 = new Lecture("Rails para usuários de Django", "5min");
//        Lecture palestra7 = new Lecture("Trabalho remoto: prós e cons", "60min");

        trackMorningA.addLecture(palestra1);
        trackMorningA.addLecture(palestra2);
        trackMorningA.addLecture(palestra3);
        trackMorningA.addLecture(palestra4);

        trackMorningB.addLecture(palestra1);
        trackMorningB.addLecture(palestra2);
        trackMorningB.addLecture(palestra3);
        trackMorningB.addLecture(palestra4);


        assertEquals(trackMorningA.getLectures().get(0).getTitle(), conference.getTrackMorningA().getLectures().get(0).getTitle());
        assertEquals(trackMorningA.getLectures().get(1).getTitle(), conference.getTrackMorningA().getLectures().get(1).getTitle());
        assertEquals(trackMorningA.getLectures().get(2).getTitle(), conference.getTrackMorningA().getLectures().get(2).getTitle());
        assertEquals(trackMorningA.getLectures().get(3).getTitle(), conference.getTrackMorningA().getLectures().get(3).getTitle());

//        assertEquals(trackMorningB.getLectures().get(0).getTitle(), conference.getTrackMorningB().getLectures().get(0).getTitle());
//        assertEquals(trackMorningB.getLectures().get(1).getTitle(), conference.getTrackMorningB().getLectures().get(1).getTitle());
//        assertEquals(trackMorningB.getLectures().get(2).getTitle(), conference.getTrackMorningB().getLectures().get(2).getTitle());
//        assertEquals(trackMorningB.getLectures().get(3).getTitle(), conference.getTrackMorningB().getLectures().get(3).getTitle());

    }

    @Test
    public void deliverTracks(){
        //Recuperar as lectures que não entrarem nas tracks e armazenar em um standby list
        Track trackMorning = new Track(Track.MORNING_LIMIT);
        Track trackAfternoon = new Track(Track.AFTERNOON_LIMIT);
        List<Lecture> lectures = new ArrayList<>();
        List<Lecture> standby = new ArrayList<>();

        Conference conference = new Conference(lectures);

        //8 PALESTRAS PARA ENCHER DUAS TRACKS, UMA MANHÃ E OUTRA TARDE
        Lecture palestra1 = new Lecture("Ruby 1 - track m", "60min");
        Lecture palestra2 = new Lecture("Ruby 2 - track m", "60min");
        Lecture palestra3 = new Lecture("Ruby 3", "65min");
        Lecture palestra4 = new Lecture("Ruby 4 - track m", "60min");
        Lecture palestra5 = new Lecture("Ruby 5", "60min");
        Lecture palestra6 = new Lecture("Ruby 6", "40min");
        Lecture palestra7 = new Lecture("Ruby 7", "40min");
        Lecture palestra8 = new Lecture("Ruby 8", "30min");






        Track trackMorningt = new Track(Track.MORNING_LIMIT);
        trackMorningt.addLecture(palestra1);
        trackMorningt.addLecture(palestra2);
        trackMorningt.addLecture(palestra4);

        Track trackAfternoont = new Track(Track.AFTERNOON_LIMIT);
        trackAfternoont.addLecture(palestra3);
        trackAfternoont.addLecture(palestra5);
        trackAfternoont.addLecture(palestra6);
        trackAfternoont.addLecture(palestra7);
        trackAfternoont.addLecture(palestra8);




        trackMorning.equals(trackMorningt);

        //PRECISO SABER ONDE ESSA PALESTRA 3 FOI PARAR E SALVAR ELA NO STANDBY


    }
}
