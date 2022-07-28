package com.mouredev.weeklychallenge2022

/*
 * Reto #30
 * MARCO DE PALABRAS
 * Fecha publicación enunciado: 26/07/22
 * Fecha publicación resolución: 01/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
 * un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

package retosemanal;

import java.util.StringTokenizer;

/**
 *
 * @author elio
 */
public class RetoSemanal {

    public static void main(String[] args) {

        System.out.println(marco("Esto es una prueba."));
        System.out.println("\n\n");
        System.out.println(marco("Mi primer reto superado con exito."));
    }

    public static String marco(String texto) {

        StringTokenizer palabras = new StringTokenizer(texto);
        String palabra;
        int numPalabras = palabras.countTokens();
        int palabraMasLarga = longitudPalabras(texto);

        String cadena = lineaAsteriscos(palabraMasLarga) + "\n";

        for (int i = 0; i < numPalabras; i++) {
            palabra = palabras.nextToken();
            while (palabra.length() < palabraMasLarga) 
                palabra = palabra + " ";
            
            cadena = cadena + "* " + palabra + " *" + "\n";
        }
        
        cadena = cadena + lineaAsteriscos(palabraMasLarga);
        return cadena;
    }

    public static int longitudPalabras(String texto) {

        StringTokenizer palabras = new StringTokenizer(texto);
        int palabraMasLarga = 0;
        String palabra;
        int numPalabras = palabras.countTokens();

        for (int i = 0; i < numPalabras; i++) {
            palabra = palabras.nextToken();
            if (palabraMasLarga < palabraMasLarga(palabra)) 
                    palabraMasLarga = palabraMasLarga(palabra);
            
        }
        return palabraMasLarga;
    }

    public static int palabraMasLarga(String palabra) {
        return palabra.length();
    }

    public static String lineaAsteriscos(int numeroAsteriscos) {
        String lineaAsteriscos = new String();

        for (int i = 0; i < numeroAsteriscos + 4; i++) 
            lineaAsteriscos = lineaAsteriscos + "*";        
        return lineaAsteriscos;
    }

}
