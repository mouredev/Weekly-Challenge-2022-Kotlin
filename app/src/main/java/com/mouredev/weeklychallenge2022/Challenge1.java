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
 */
package weeklychallenge2022;

import java.util.Scanner;

public class Challenge1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingresar dos palabras para veificar que sean anagramas.");
        System.out.print("Escriba la primera palabra: ");
        String palabra1 = leer.next();
        System.out.print("Escriba la segunda palabra: ");
        String palabra2 = leer.next();

        boolean anagrama;
        anagrama = esAnagrama(palabra1, palabra2);

        System.out.println("Ambas frases son un anagrama: " + anagrama);

    }

    public static boolean esAnagrama(String palabra1, String palabra2) {

        if (palabra1.equalsIgnoreCase(palabra2)) {                     //si las dos palabras son iguales: FALSE
            return false;
        } else if (palabra1.length() != palabra2.length()) {           //si las dos tienen longitud distinta: FALSE
            return false;
        }

        Character caracter;
        for (int i = 0; i < palabra1.length(); i++) {                  //recorro la palabra1 con bucle for
            caracter = palabra1.charAt(i);                             //extraigo cada caracter de la palabra1
            if (palabra2.contains(Character.toString(caracter))) {     //verifico si palabra2 contiene el caracter extraído
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
