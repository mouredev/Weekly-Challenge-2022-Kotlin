package com.mouredev.weeklychallenge2022

import java.util.*

/*
 * Reto #11
 * ELIMINANDO CARACTERES
 * Fecha publicación enunciado: 14/03/22
 * Fecha publicación resolución: 21/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val a = "Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación"
    val b = "Subiré una posible solución al ejercicio el lunes siguiente al de su publicación"

    println("Example strings\nString1: $a\nString2: $b")
    aSinByBSinA(a , b)
}

fun aSinByBSinA(a : String, b : String){

    println("\nClassification by words")
    wordsSegregation(a,b)

    println("\nClassification by letters")
    characterSegregation(a,b)
}

fun separationInLetters(phrase: String): CharArray {
    val step1 = phrase.lowercase(Locale.ROOT).split(" ")

    var step2 = ""
    step1.forEach {
        step2 += it
    }

    return step2.toCharArray()
}

fun characterSegregation(a: String, b: String){
    val componentsOfA = separationInLetters(a)
    val componentsOfB = separationInLetters(b)

    val aSinB = componentsOfA.filter {
        !componentsOfB.contains(it)
    }

    val bSinA = componentsOfB.filter {
        !componentsOfA.contains(it)
    }

    println("$aSinB\n$bSinA")
}

private fun wordsSegregation(a: String, b: String){
    val step1A = a.lowercase(Locale.ROOT).split(" ")
    val step1B = b.lowercase(Locale.ROOT).split(" ")

    val step2A = makeOfMap(step1A)
    val step2B = makeOfMap(step1B)

    val aSinB :String = step1A.filter {
        !step2B.containsKey(it)
    }.toString()

    val bSinA :String = step1B.filter {
        !step2A.containsKey(it)
    }.toString()

    println("$aSinB\n$bSinA")
}

private fun makeOfMap(words : List<String>) : MutableMap<String,Int>{
    val resultMap = mutableMapOf<String,Int>()
    words.forEach{
        if(!resultMap.containsKey(it)){
            resultMap[it] = 1
        }else{
            resultMap[it] = resultMap[it]!!+1
        }
    }
    return  resultMap
}
