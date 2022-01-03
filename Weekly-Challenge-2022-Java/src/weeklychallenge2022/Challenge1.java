package weeklychallenge2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Reto #1
  ¿ES UN ANAGRAMA?
  Fecha publicación enunciado: 03/01/22
  Fecha publicación resolución: 10/01/22
  Dificultad: MEDIA
 
  Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
  Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
  NO hace falta comprobar que ambas palabras existan.
  Dos palabras exactamente iguales no son anagrama.
 
  Información adicional:
  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🗓reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.*/
/**
 *
 * @author Brais
 */
public class Challenge1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String palabra1, palabra2;

        System.out.println("Escribe una palabra");
        palabra1 = teclado.nextLine();
        System.out.println("Escribe otra palabra");
        palabra2 = teclado.nextLine();

        System.out.println((isAnagrama(palabra1, palabra2)) ? "anagrama" : "no es anagrama");
    }

    /*
        
        Ordenando string
    
     */
    private static boolean isAnagrama(String cadena1, String cadena2) {
        return (cadena1.length() == cadena2.length()) ? ((!cadena1.equals(cadena2)) ? (compara(cadena1, cadena2)) : false) : false;
    }

    private static boolean compara(String uno, String dos) {
        char[] unoChar = uno.toCharArray(), dosChar = dos.toCharArray();
        Arrays.sort(unoChar);
        Arrays.sort(dosChar);
        return new String(unoChar).equals(new String(dosChar));
    }

    /*
    
    hecho a mano
    
    
    private static boolean isAnagrama(String cadena1, String cadena2) {
        return (cadena1.length() == cadena2.length()) ? ((!cadena1.equals(cadena2)) ? (compara(cadena1, cadena2)) : false) : false;
    }

    private static boolean compara(String cadena1, String cadena2) {
        int len = cadena1.length();
        ArrayList<Character> uno = new ArrayList<>(cadena1.length());
        ArrayList<Character> dos = new ArrayList<>(cadena1.length());

        for (int i = 0; i < len; i++) {
            uno.add(cadena1.charAt(i));
            dos.add(cadena2.charAt(i));
        }

        for (int i = 0; i < uno.size(); i++) {
            for (int j = 0; j < dos.size(); j++) {
                if (uno.get(i).equals(dos.get(j))) {
                    uno.remove(i);
                    dos.remove(j);
                    i--;
                    break;
                }
            }
        }

        return uno.isEmpty();
    }*/
}
