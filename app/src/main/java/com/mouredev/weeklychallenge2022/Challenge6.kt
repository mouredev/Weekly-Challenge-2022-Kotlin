package com.mouredev.weeklychallenge2022

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
 * - Retos obtenidos de https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
 *
 */

fun main() {
    val textoOrdenado = "Hola mundo"
    InvertirCadena(textoOrdenado).
}

fun InvertirCadena(textoOrdenado: String) {
    val cadenaOrdenada = textoOrdenado.toCharArray()
    val cadenaInvertida = CharArray(cadenaOrdenada.size)

    for (i in cadenaOrdenada.indices.reversed()) {
        cadenaInvertida[cadenaInvertida.size - i - 1] = cadenaOrdenada[i]
    }
    val textoInvertido = String(cadenaInvertida)

    println("Texto ordenado: $textoOrdenado")
    println("Texto invertido: $textoInvertido")
}