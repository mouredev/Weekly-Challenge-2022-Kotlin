package com.mouredev.weeklychallenge2022

/*
 * Reto #44
 * BUMERANES
 * Fecha publicación enunciado: 02/10/22
 * Fecha publicación resolución: 07/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que retorne el número total de bumeranes de un array de números
 * enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números seguidos, en el que el
 *   primero y el último son iguales, y el segundo es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

import java.util.Random;
import java.util.Arrays;


public class Bumeranes {
    
    /**
     * Método que busca en un array bumeranes y los imprime.
     * @param array
     * @return el número de bumeranes
     */
    public static int numerosBumerans(int array[]) {
        int contadorBumerans = 0;
        System.out.println("/(");
        for (int x =0; x< array.length-3; x++) {
            if (array[x] == array[x+2] && array[x+1] != array[x]) {
                contadorBumerans++;
                System.out.print("["+array[x] + ", "+ array[x+1]+", "+array[x+2]+")");
            }
        }
        System.out.println("/)");
        return contadorBumerans;
    }

    /**
     * Método para crear un array de forma aleatoría, con el fin de probar despues el metodo anterior.
     * @param lonxitude
     * @param maxValor
     * @return
     */
    public static int[] crearTaboaAleatoria(int lonxitude, int maxValor) {
        int x;
        int taboaCreada [] = new int [lonxitude];
        Random r = new Random();
        for (x = 0; x < lonxitude; x++) {
            taboaCreada[x] = r.nextInt(maxValor);
        }
        //Arrays.sort(taboaCreada);
        return taboaCreada;
    }

    public static void main(String[] args) {
        int taboa[];
        taboa = crearTaboaAleatoria(200, 10);
        System.out.println(Arrays.toString(taboa));
        System.out.println("************************************************");
        int bumerans = numerosBumerans(taboa);
        System.out.println(bumerans);
    }
}
