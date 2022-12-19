package com.mouredev.weeklychallenge2022

/*
 * Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/11/22
 * Fecha publicación resolución: 19/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
 * algoritmo de encriptación de Karaca (debes buscar información sobre él).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

 /*
 * ENCRIPTACION DE KARACA:
 *  - Paso 1: invierte la palabra.
 *            Ej: "hola" -> "aloh"
 *  - Paso 2: Sustituye las vocales de la siguiente manera:
 *            a -> 0
 *            e -> 1
 *            i -> 2
 *            o -> 3
 *            u -> 4
 *            Ej: "0l3h"
 *  - Paso 3: añade "aca" al final
 *            Ej: "0l3haca"
 *
 * DOC:https://colab.research.google.com/drive/1JwC4OIgz5nrQqoK8riDsmnZoprRTdT8D#scrollTo=5kBinzKxn3hd
 */

fun main() {
    val input = listOf(
        "hola",
        "perrito",
        "supercalifragilisticoespialidoso"
    )

    var inputEnc: String

    input.forEach {
        println("Palabra original.....: $it")

        inputEnc = karacasEncrypt(it)
        println("Palabra encriptada...: ${inputEnc}")
        println("Palabra Desencriptada: ${karacasDecrypt(inputEnc)}\n")
    }
}

fun karacasEncrypt(input: String): String {
    var tupni = input.reversed()
    val map = mapOf("a" to "0", "e" to "1", "i" to "2", "o" to "3", "u" to "4")

    for ((vowel, number) in map) tupni = tupni.replace(vowel, number)

    return tupni + "aca"
}

fun karacasDecrypt(tupni: String): String {
    if (tupni.substring(tupni.length - 3, tupni.length) != "aca")
        return "No es una cadena codificada"

    var input = tupni.substring(0, tupni.length - 3)
    val map = mapOf("0" to "a", "1" to "e", "2" to "i", "3" to "o", "4" to "u")

    for ((number, vowel) in map) input = input.replace(number, vowel)

    return input.reversed()
}