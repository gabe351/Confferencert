package Conferencert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 17/06/16.
 */

public class Experiment {

    public int calculaFatorial(int value){

            if (value == 0){
                value += 1;
                return value;
            }
        return value*calculaFatorial(value-1);
    }



    public static void main(String[] args){
            Experiment f = new Experiment();

        int a = f.calculaFatorial(0);
//        System.out.println(a);
        boolean nome = "Maria".matches("Maria");
        if (nome == true){
//            System.out.println("RODOU PAI ");
        }
        String cep = "\\d\\d\\d\\d\\d-\\d\\d\\d";
        boolean valida = "99855-000".matches(cep);
//        System.out.println(valida);

//          TENTANDO USAR EXPRESSÕES REGULARES
//        -----------------------------------------------------------------------------------------------------

        String fonte = "mouse da cor 8min ";
        String fonte2= "mouse estilo lighting";
        String queremosIsso ="\\dmin|lighting";
        String querotbm = "\\w";
        String queromermo = "lighting";

        Pattern p = Pattern.compile(queremosIsso);
        Pattern p2 = Pattern.compile(queromermo);
//        Pattern p2 = Pattern.compile(querotbm);
        Matcher m = p.matcher(fonte);
        Matcher m3 = p2.matcher(fonte2);
//        Matcher m2 = p2.matcher(fonte);

        while (m.find()){

            System.out.println(fonte.replace(m.group(),""));

        }
        while (m3.find()){
            System.out.print(fonte.replace(m3.group(),""));
        }
    }
//        -----------------------------------------------------------------------------------------------------
}
