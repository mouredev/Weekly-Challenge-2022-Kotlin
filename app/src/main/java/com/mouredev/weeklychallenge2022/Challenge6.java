package com.mouredev.weeklychallenge2022;
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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
public class Challenge6 {
    public static String invertirTexto(String text){
        char[] vecT = text.toCharArray();
        char[] vecTVacio = new char[8];
        for(int i=0; i<vecTVacio.length; i++){
            vecTVacio[i] = vecT[vecTVacio.length - 1 - i];
        }
        String textInverso = String.valueOf(vecTVacio);
        return textInverso;
    }
    public static void main(String[] args){
        String textInvertido = invertirTexto("Hola Man");
        System.out.print(textInvertido);
        System.out.println();
    }
}
