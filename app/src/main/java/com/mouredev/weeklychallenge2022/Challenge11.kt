package com.mouredev.weeklychallenge2022

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
    printNonCommon("brais","moure")
    printNonCommon("Me gusta Java","Me gusta Kotlin")
    printNonCommon("Usa el canal de nuestro discord (https://mouredev.com/discord) \"\uD83D\uDD01reto-semanal\" para preguntas, dudas o prestar ayuda a la comunidad",
        "Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.")

    // Otra solución utilizando funciones de orden superior
    printNonCommonWithFilter("Usa el canal de nuestro discord (https://mouredev.com/discord) \"\uD83D\uDD01reto-semanal\" para preguntas, dudas o prestar ayuda a la comunidad",
        "Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.")
}

private fun printNonCommon(str1: String, str2: String) {
    println("out1: ${findNonCommon(str1, str2)}")
    println("out2: ${findNonCommon(str2, str1)}")
}

private fun findNonCommon(str1: String, str2: String): String {

    var out = ""

    str1.lowercase().forEach {
        if (!str2.lowercase().contains(it)) {
            out += it
        }
    }

    return out
}

private fun printNonCommonWithFilter(str1: String, str2: String) {
    println("out1: ${str1.lowercase().filter { !str2.lowercase().contains(it) }}")
    println("out2: ${str2.lowercase().filter { !str1.lowercase().contains(it) }}")
}