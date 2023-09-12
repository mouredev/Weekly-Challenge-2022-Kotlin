package com.mouredev.weeklychallenge2022;
/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
public class Challenge1 {
    public static boolean isAnAnagrama(String t1, String t2){
        if(t1.equals(t2)){
            return false;
        }
        //Convertimos los String a un Array de char
        char[] a1 = t1.toCharArray();
        char[] a2 = t2.toCharArray();

        // Usamos el algoritmo de Fisher-Yates para desordenar el arreglo 1
        for(int i=a1.length-1; i>0; i--){
            // Genera un indice aleatorio entre 0 y i
            int sorteo = (int) (Math.random() * (i + 1));

            // Intercambio el elemento en la posicion i con el elemento en la posicion sorteo
            char temp = a1[i];
            a1[i] = a1[sorteo];
            a1[sorteo] = temp;
        }

        // Usamos el algoritmo de Fisher-Yates para desordenar el segundo arreglo
        for(int i=a2.length-1; i>0; i--){
            // Genera un indice aleatorio entre 0 y i
            int sorteo = (int) (Math.random() * (i + 1));

            // Intercambio el elemento en la posicion i con el elemento en la posicion sorteo
            char temp = a2[i];
            a2[i] = a2[sorteo];
            a2[sorteo] = temp;
        }

        //Mostramos en pantalla los anagramas
        System.out.print("Anagrama 1: ");
        for(char ana : a1){
            System.out.print(ana);
        }
        System.out.println();
        System.out.print("Anagrama 2: ");
        for(char ana2 : a2){
            System.out.print(ana2);
        }
        System.out.println();

        // Retornamos true que simboliza que si es un anagrama
        return true;
    }

    public static void main(String[] args){
        boolean isAnagrama = isAnAnagrama("Hola","Programador");

        System.out.println(isAnagrama);
    }
}
