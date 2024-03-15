package com.mouredev.weeklychallenge2022;

import java.util.ArrayList;
import java.util.List;

/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
public class Challenge22 {
    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();

        // Inicializo los arrays
        array1.add(1);
        array1.add(2);
        array1.add(3);
        array1.add(1);
        array2.add(4);
        array2.add(2);
        array2.add(3);


        // Selecciono los comunes
        boolean commons = true;
        
        ArrayList<Integer> lastList = (ArrayList<Integer>) getFinalArray(array1, array2, commons);

        // Los muestro por pantalla
        lastList.forEach(System.out::println);
    }

    private static List<Integer> getFinalArray(List<Integer> array1, List<Integer> array2, boolean commons) {
        ArrayList<Integer> bigger = getBigger(array1, array2);
        ArrayList<Integer> smaller = array1.equals(bigger) ? (ArrayList<Integer>) array2 : (ArrayList<Integer>) array1;

        if (commons) {
            return getCommons(bigger, smaller);
        } else {
            return getNotCommons(bigger, smaller);
        }
    }

    private static List<Integer> getCommons(List<Integer> bigger, List<Integer> smaller) {
        List<Integer> endList = new ArrayList<>();
        for (Integer integer : bigger) {
            if (smaller.contains(integer)) {
                endList.add(integer);
            }
        }
        return endList;
    }

    private static List<Integer> getNotCommons(List<Integer> bigger, List<Integer> smaller) {
        List<Integer> endList = new ArrayList<>();
        for (Integer integer : bigger) {
            if (!smaller.contains(integer)) {
                endList.add(integer);
            }
        }
        return endList;
    }

    private static ArrayList<Integer> getBigger(List<Integer> array1, List<Integer> array2) {
        return (ArrayList<Integer>)(array1.size() > array2.size() ? array1 : array2);
    }
}
