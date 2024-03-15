package com.mouredev.weeklychallenge2022

/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Challenge32 {
    private static final int BASE_NUMBER = -9999;

    public static void main(String[] args) {
        int result;
        ArrayList<Integer> myNumbers = new ArrayList<>(Arrays.asList(1, 5, 17, 50));
        result = getSecBiggest(myNumbers);

        if (result != BASE_NUMBER) {
            System.out.println("The second biggest number from the list " + myNumbers + " is    --> " + result);
        } else {
            System.out.println("The list " + myNumbers + " has not second biggest number");
        }
    }

    private static int getSecBiggest(ArrayList<Integer> myNumbers) {
        int biggest = BASE_NUMBER;
        int result = BASE_NUMBER;
        for (int num : myNumbers) {
            if (num > biggest) {
                result = biggest;
                biggest = num;
            }
        }
        return result;
    }
}