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
public class Main {
    public static void main(String[] args) {
        var boomerang = Arrays.asList(2, 1, 2, 3, 3, 4, 2, 4);
        System.out.println(boomerang);
        System.out.println(getBoomerangs(boomerang));
    }

    private static Map<Integer, List<List<Integer>>> getBoomerangs(List<Integer> array) {
        var result = new HashMap<Integer, List<List<Integer>>>();
        var count = 0;
        var boomerang = new ArrayList<List<Integer>>();
        for (int i = 0; i < array.size() - 2; i++) {
            // Asignación de numeros
            var one = array.get(i);
            var two = array.get(i + 1);
            var three = array.get(i + 2);
            if (one.equals(three) && !one.equals(two)) {
                ++count;
                // Crea sublista para añadir a la lista principal
                var boom = new ArrayList<Integer>();
                boom.add(one);
                boom.add(two);
                boom.add(three);
                // Añade la sublista a la lista principal
                boomerang.add(boom);
            }
        }
        result.put(count, boomerang);
        return result;
    }
}