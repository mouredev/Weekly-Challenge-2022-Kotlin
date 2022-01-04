package com.mouredev.weeklychallenge2022

import java.util.*

/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🗓reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    var scan = Scanner(System.`in`)
    print("Introduzca la primera palabra: ")
    var word1 = scan.nextLine()
    print("Introduzca la segunda palabra: ")
    var word2 = scan.nextLine()
    println("¿Són las palabras introducidas anagramas? "+esAnagrama(word1, word2))
}
fun esAnagrama(w1: String, w2: String): Boolean{
    if(w1.length != w2.length)
        return false;
    else{

        var aW1 = w1.lowercase().toCharArray().sorted()
        var aw2 = w2.lowercase().toCharArray().sorted()
        if(aW1.equals(aw2))
            return true
        else
            return false
    }
    return false
}
