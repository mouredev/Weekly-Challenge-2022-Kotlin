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

private enum class Operation {
    ENCRYPT, DECRYPT
}

fun main() {
    println(Karaca("apple", Operation.ENCRYPT))
    println(Karaca("avión", Operation.ENCRYPT))
    println(Karaca("banana", Operation.ENCRYPT))
    println(Karaca("0v23n", Operation.ENCRYPT))
    println(Karaca("1lpp0aca", Operation.DECRYPT))
    println(Karaca("n32v0aca", Operation.DECRYPT))
    println(Karaca("0n0n0baca", Operation.DECRYPT))
    println(Karaca("0n0n0baaa", Operation.DECRYPT))
}

private fun Karaca(text: String, operation: Operation): String {

    var result = ""

    when(operation){
        Operation.ENCRYPT -> {
            if (!text.contains("[0-9]".toRegex())) {
                result = KaracaEncrypt(text)
            }
            else {
                result = "Error: El texto no puede contener números."
            }

        }
        Operation.DECRYPT -> {
            if (text.substring(text.length-3,text.length).equals("aca")) {
                result = KaracaDecrypt(text)
            }
            else {
                result = "Error: El texto debe acabar en aca."
            }
        }

    }

    return result
}

private fun KaracaEncrypt(text: String): String {

    var result = ""

    for (i in text.lowercase().length - 1 downTo 0) {
        result += when (text[i]) {
            'a', 'á', 'ä' -> 0
            'e', 'é', 'ë' -> 1
            'i', 'í', 'ï' -> 2
            'o', 'ó', 'ö' -> 3
            'u', 'ú', 'ü' -> 4
            else -> text[i]
        }
    }
    result += "aca"

    return result
}

private fun KaracaDecrypt(text: String): String {

    var result = ""

    for (i in text.length - 4 downTo 0) {
        result += when (text[i]) {
            '0' -> 'a'
            '1' -> 'e'
            '2' -> 'i'
            '3' -> 'o'
            '4' -> 'u'
            else -> text[i]
        }
    }

    return result
}