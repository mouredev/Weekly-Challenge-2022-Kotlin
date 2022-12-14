package com.example.weekly_challenge_2022_java;

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

    public static void main(String[] args) {

        boolean a = anagrama("hola", "aloh");
        System.out.println(a);

    }

    public static boolean anagrama(String palabra1, String palabra2) {

        boolean misma = false;

        if (palabra1.length() == palabra2.length()) {

            for (int i = 0; i < palabra1.length(); i++) {
                if (palabra1.charAt(i) == palabra2.charAt((palabra1.length() - 1) - i)) {
                    misma = true;
                } else {
                    misma = false;
                    break;
                }
            }
        }
        return misma;
    }
}
