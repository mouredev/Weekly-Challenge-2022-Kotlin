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
public class Reto44MoureDev {

    public static void main(String[] args) {
        
        Integer[] array = {2, 1, 2, 3, 3, 4, 2, 4};
        Integer contador = 0;
        
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i] == array[i + 2] && array[i] != array[i + 1]) {
                System.out.println("[" + array[i] + "," + array[i + 1] + "," + array[i + 2] + "]");
                contador++;
            }
        }
        System.out.println("Hay " + contador + " boomerangs.");
    }
}
