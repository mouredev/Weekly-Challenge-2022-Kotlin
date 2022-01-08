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
    val scanner = Scanner(System.`in`)
    var firstWord = scanner.nextLine()
    var secondWord = scanner.nextLine()
    val anagrama = evaluteAnagrama(firstWord, secondWord)
    if (anagrama == true){
        println("Son anagramas")
    }else{
        println("No son anagramas")
    }
}

fun evaluteAnagrama(correctWord: String, disorderedWord: String): Boolean {
    var evaluation = false
    if (correctWord.length != disorderedWord.length || correctWord == disorderedWord) {
        return evaluation
    } else {
        var counterCorrect = 0
        var counterIncorrect = 0
        var individualCorrectWord: Char
        var individualDisorderedWord: Char
        for (i in 0 until disorderedWord.length) {
            individualCorrectWord = correctWord[i]
            individualDisorderedWord = disorderedWord[i]
            if (individualCorrectWord == individualDisorderedWord) {
                counterCorrect++
            } else {
                for (j in 0 until correctWord.length) {
                    individualCorrectWord = correctWord[j]
                    if (individualCorrectWord != individualDisorderedWord) {
                        counterIncorrect++
                    } else {
                        counterCorrect++
                        counterIncorrect = 0
                        break
                    }
                }
            }
        }
        if (counterCorrect == correctWord.length) {
            evaluation = true
        }
        if (counterIncorrect == correctWord.length) {
            evaluation = false
        }
    }
    return evaluation
}
