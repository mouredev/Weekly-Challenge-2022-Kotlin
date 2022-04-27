package com.mouredev.weeklychallenge2022

/*
 * Reto #16
 * EN MAYÚSCULA
 * Fecha publicación enunciado: 18/04/22
 * Fecha publicación resolución: 25/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 */

fun main (){
    println(putFirstLetterToUpperCase("el perro de san roque no tiene rabo porque pedro se lo ha cortado"))
}

/*
FUNCION DE MARTINEZ
 */
fun putFirstLetterToUpperCase (sentence : String) : String{

    val splitSentence = sentence.split(" ")
    var finalSentence = ""

    splitSentence.forEach{
        val wordWithFirstLetterUpperCase = it.replaceFirst(it[0], it[0].uppercaseChar()) + " "
        finalSentence += wordWithFirstLetterUpperCase
    }
    return finalSentence
}

/*
FUNCION DE MOURE
 */
private fun capitalize(text: String): String {

    var capitalizedText = text

    text.replace("[^A-zÀ-ú]".toRegex(), " ").split(" ").forEach { word ->
        capitalizedText = capitalizedText.replace(word, word.replaceFirstChar { it.uppercase() })
    }

    return capitalizedText
}