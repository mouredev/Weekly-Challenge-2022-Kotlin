package com.mouredev.weeklychallenge2022

/*
 * Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/12/22
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

fun main() {

    println(karaca("placa", false))
    println(karaca("0c0lpaca", true))

    println(karaca("Este es el penúltimo reto de programación del año", false))
    println(karaca("1ts1aca s1aca l1aca 3m2tlún1paca 3t1raca 1daca nó2c0m0rg3rpaca l1daca 3ñ0aca", true))

    // El algoritmo no soporta estos casos
    println(karaca("1", false))
    println(karaca("1aca ", true))
}

private fun karaca(text: String, isKaraca: Boolean): String {

    var result = ""

    text.lowercase().split(" ").forEach { word ->

        if (isKaraca) {
            result += word
                .dropLast(3)
                .replace("0", "a")
                .replace("1", "e")
                .replace("2", "i")
                .replace("3", "o")
                .replace("4", "u")
                .reversed().plus(" ")
        } else {
            result += word
                .reversed()
                .replace("a", "0")
                .replace("e", "1")
                .replace("i", "2")
                .replace("o", "3")
                .replace("u", "4")
                .plus("aca ")
        }
    }

    return result
}