package gals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConvertIdToClass {

    private static List<Integer> palavrasReservadas = Arrays.asList(6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26);
    private static List<Integer> simbolosEspeciais = Arrays.asList(27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44);
    private static List<Integer> identificadores = Collections.singletonList(2);
    private static List<Integer> constantesInteiras = Collections.singletonList(3);
    private static List<Integer> constantesReais = Collections.singletonList(4);
    private static List<Integer> constantesCaracter = Collections.singletonList(5);

       public static String getClassFromID(int id){

        if(palavrasReservadas.contains(id)){
            return "Palavra reservada";
        }
        if(simbolosEspeciais.contains(id)){
            return "Simbolo especial";
        }
        if(identificadores.contains(id)){
            return "Identificador";
        }
        if(constantesCaracter.contains(id)){
            return "Caractere";
        }
        if(constantesInteiras.contains(id)){
            return "Constante inteira";
        }
        if(constantesReais.contains(id)){
            return "Constante real";
        }

        return "";
    }

}
