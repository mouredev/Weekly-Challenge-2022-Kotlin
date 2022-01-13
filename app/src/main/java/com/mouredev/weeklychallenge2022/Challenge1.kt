package com.mouredev.weeklychallenge2022

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

    var resultAnagrama = anagrama("ana", "aan")
    println("el resultado de comparar es $resultAnagrama")






}
fun anagrama(
    word1: String,
    word2: String
): Boolean {
    val arrayWord1 : CharArray = word1.toCharArray()
    val arrayWord2 : CharArray = word2.toCharArray()

    var resultadoWord1 = true
    var resultadoWord2 = true
    if ((arrayWord1.size != arrayWord2.size) || (word1==word2)){
        return false

    }
    else {
        for (i in arrayWord1.indices){
            if (!arrayWord2.contains (arrayWord1[i])){
                resultadoWord1= false
            }
            if (!arrayWord1.contains (arrayWord2[i])){
                resultadoWord2= false
            }

        }
        return resultadoWord1&&resultadoWord2
    }

}


