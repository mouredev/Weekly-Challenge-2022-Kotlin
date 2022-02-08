/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package weeklychallenge2022;

import java.util.Scanner;

/**
 *
 * @author braiso-22
 */
public class Challenge06 {

    /*
        * Reto #6
        * INVIRTIENDO CADENAS
        * Fecha publicación enunciado: 07/02/22
        * Fecha publicación resolución: 14/02/22
        * Dificultad: FÁCIL
        *
        * Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
        * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
        *
        * Información adicional:
        * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
        * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
        * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
        * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
        *
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce texto");
        String textoEntrada = teclado.nextLine();
        System.out.println(invertirCadena(textoEntrada));
    }

    private static String invertirCadena(String cadena) {
        char[] charArray = new char[cadena.length()];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = cadena.charAt(charArray.length - 1 - i);
        }
        return String.valueOf(charArray);
    }

}
