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
        Track trackAfternoonA = new Track(Track.AFTERNOON_LIMIT);
        Track trackMorningB = new Track(Track.MORNING_LIMIT);
        Track trackAfternoonB = new Track(Track.AFTERNOON_LIMIT);

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
        Lecture palestra5 = new Lecture("Erros comuns em Ruby", "45min");
        Lecture palestra6 = new Lecture("Rails para usuários de Django", "5min");
        Lecture palestra7 = new Lecture("Trabalho remoto: prós e cons", "60min");
        Lecture palestra8 = new Lecture("Desenvolvimento orientado a gambiarras", "45min");
        Lecture palestra9 = new Lecture("Aplicações isomórficas: o futuro (que talvez nunca chegaremos)", "30min");
        Lecture palestra10 = new Lecture("Codifique menos, Escreva mais!","30min");
        Lecture palestra11 = new Lecture("Programação em par","45min");
        Lecture palestra12 = new Lecture("A mágica do Rails: como ser mais produtivo","60min");
        Lecture palestra13 = new Lecture("Ruby on Rails: Por que devemos deixá-lo para trás","60min");
        Lecture palestra14 = new Lecture("Clojure engoliu Scala: migrando minha aplicação","45min");
        Lecture palestra15 = new Lecture("Ensinando programação nas grotas de Maceió","30min");
        Lecture palestra16 = new Lecture("Ruby vs. Clojure para desenvolvimento backend","30min");
        Lecture palestra17 = new Lecture("Manutenção de aplicações legadas em Ruby on Rails","60min");
        Lecture palestra18 = new Lecture("Um mundo sem StackOverflow","30min");
        Lecture palestra19 = new Lecture("Otimizando CSS em aplicações Rails","30min");


        trackMorningA.addLecture(palestra1);
        trackMorningA.addLecture(palestra2);
        trackMorningA.addLecture(palestra3);
        trackMorningA.addLecture(palestra4);

        trackAfternoonA.addLecture(palestra5);
        trackAfternoonA.addLecture(palestra6);
        trackAfternoonA.addLecture(palestra7);
        trackAfternoonA.addLecture(palestra8);
        trackAfternoonA.addLecture(palestra9);
        trackAfternoonA.addLecture(palestra10);

        trackMorningB.addLecture(palestra11);
        trackMorningB.addLecture(palestra12);
        trackMorningB.addLecture(palestra13);

        trackAfternoonB.addLecture(palestra14);
        trackAfternoonB.addLecture(palestra15);
        trackAfternoonB.addLecture(palestra16);
        trackAfternoonB.addLecture(palestra17);
        trackAfternoonB.addLecture(palestra18);
        trackAfternoonB.addLecture(palestra19);


        for (int i =0;i<3;i++)
            assertEquals(trackMorningA.getLectures().get(i).getTitle(), conference.getTrackMorningA().getLectures().get(i).getTitle());

        for (int i =0; i<6; i++)
            assertEquals(trackAfternoonA.getLectures().get(i).getTitle(), conference.getTrackAfternoonA().getLectures().get(i).getTitle());

        for (int i =0; i<3; i++)
            assertEquals(trackMorningB.getLectures().get(i).getTitle(), conference.getTrackMorningB().getLectures().get(i).getTitle());

        for (int i =0; i<6; i++)
            assertEquals(trackAfternoonB.getLectures().get(i).getTitle(), conference.getTrackAfternoonB().getLectures().get(i).getTitle());

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




        assertTrue(trackMorning.equals(trackMorningt));


    }
}
