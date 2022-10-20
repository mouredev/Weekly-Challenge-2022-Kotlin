package com.mouredev.weeklychallenge2022;

/*
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class celsius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceª Grados Celsius 'C' para cambiar a Fahrenheit 'F'");
        String num = sc.nextLine();


        String numSinString = num.substring(0, num.length() - 2);
        int numInt = Integer.parseInt(numSinString);


        if (num.charAt(num.length()-1) == 'C'){
            int f = (numInt * 9 / 5) + 32;
            System.out.println(numSinString + "°C = " + f + "F");
        }else if(num.charAt(num.length()-1) == 'F'){
            int c = (numInt - 32 ) * 5 / 9;
            System.out.println(numSinString + "°F = " + c + "°C");
        }else{
            System.out.println("Has introducido un valor incorrecto, revise las unidades de su temperatura");
        }
    }
}
