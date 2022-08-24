package com.mouredev.weeklychallenge2022

/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
import java.util.*;

public class Program
{
    public static void main(String[] args) {
        ArrayList<Integer> numerosEntrada = new ArrayList<>(List.of(3,7));
        ArrayList<Integer> numerosPerdidos = new ArrayList<>();

        if(calcularNumerosPerdidos(numerosEntrada, numerosPerdidos)) {
            System.out.println(numerosPerdidos.toString());
        } else {
            System.out.println("El array es incorrecto.");
        }

    }

    public static boolean calcularNumerosPerdidos(ArrayList<Integer> numerosEntrada, ArrayList<Integer> numerosPerdidos) {
        if(numerosEntrada.size() < 2) {
            return false;
        }

        for(int i = 0; i < numerosEntrada.size() - 1; i++) {
            if (numerosEntrada.get(i) >= numerosEntrada.get(i + 1)) {
                return false;
            }

            for(int j = numerosEntrada.get(i) + 1; j < numerosEntrada.get(i + 1); j++) {
                numerosPerdidos.add(j);
            }
        }

        return true;
    }
}
