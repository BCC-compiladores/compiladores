package gals;

import java.util.*;

public class ConvertIdToClass {

    private static Map<String, List<Integer>> valores = new HashMap<>();

    static{
        valores.put("palavra reservada", Arrays.asList(6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26));
        valores.put("simbolo especial", Arrays.asList(27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44));
        valores.put("identificador", Collections.singletonList(2));
        valores.put("constante inteira", Collections.singletonList(3));
        valores.put("constante real", Collections.singletonList(4));
        valores.put("constante str", Collections.singletonList(5));
        valores.put("fim de arquivo", Collections.singletonList(1));
    }

       public static String getClassFromID(int id){
           for (String key : valores.keySet()) {
               Optional<Integer> valorEncontrado = valores.get(key).stream().filter(i -> i == id).findAny();
               if(valorEncontrado.isPresent()){
                   return key;
               }
           }
        return ""+id;
    }
}
