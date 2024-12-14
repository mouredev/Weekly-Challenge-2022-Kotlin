package com.mouredev.weeklychallenge2022;

/**
 * Solución Reto #1 "¿ES UN ANAGRAMA?" Lenguaje: Java
 *
 * @author JoseSerpaCode
 */

public class Challenge1 {

    public static void main(String[] args) {
        // Casos de prueba para verificar si las palabras son anagramas
        System.out.println(isAnagram("aeiou", "aioue"));  // Expected: false (Same letters in same position)
        System.out.println(isAnagram("amor", "roma"));    // Expected: true (Anagram)
        System.out.println(isAnagram("hello", "lleho"));  // Expected: false (Same letters in same position)
        System.out.println(isAnagram("word", "drow"));    // Expected: true (Anagram)
        System.out.println(isAnagram("hello", "hello"));  // Expected: false (Same words)
        System.out.println(isAnagram("word", "words"));   // Expected: false (Different length)
    }

    public static boolean isAnagram(String wordOne, String wordTwo) {

        // Si las dos palabras son iguales (ignorando mayúsculas/minúsculas) o tienen tamaños diferentes: no son anagramas
        if (wordOne.equalsIgnoreCase(wordTwo) || wordOne.length() != wordTwo.length()) {
            return false;  // Devuelve false si son iguales o tienen diferente longitud
        }

        // Recorre cada caracter de la palabra 'wordOne'
        for (int i = 0; i < wordOne.length(); i++) {
            // Extrae el caracter actual de 'wordOne' en la posición i
            char caracter = wordOne.charAt(i);

            // Verifica si 'wordTwo' contiene el caracter extraído de 'wordOne'
            if (wordTwo.contains(Character.toString(caracter))) {

                // Si el caracter coincide en la misma posición en ambas palabras, no son anagramas
                if (wordOne.charAt(i) == wordTwo.charAt(i)) {
                    return false;  // Devuelve false si el caracter coincide en la misma posición
                }

            } else {
                return false;  // Si 'wordTwo' no contiene el caracter extraído, devuelve false
            }
        }
        return true;  // Si pasa todas las comprobaciones, las palabras son anagramas y devuelve true
    }
}
