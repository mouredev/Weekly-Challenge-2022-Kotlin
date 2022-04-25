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
 * Información adicional:
 * - Retos obtenidos de https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
 *
 */


fun main() {
    println(titleCase("Yo vivo en Granada, una ciudad pequeña que tiene monumentos muy importantes como la Alhambra."))
}

fun titleCase(input: String): String {
    val frase = input.split(" ").toTypedArray()
    var palabra = ""
    var respuesta = ""

    frase.indices.forEach { i ->
        palabra = frase[i]
        for (j in palabra.indices) {
            var caracter = palabra[j]
            if (j == 0) {
                caracter = Character.toUpperCase(caracter)
            }
            respuesta += caracter
        }
        respuesta += " "
    }
    return respuesta
}
