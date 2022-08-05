package com.mouredev.weeklychallenge2022

/*
 * Reto #30
 * MARCO DE PALABRAS
 * Fecha publicación enunciado: 26/07/22
 * Fecha publicación resolución: 01/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
 * un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

/**
 * Funcion principal
 */
fun main(){

    "¿Qué te parece el reto?".Frame()
    "En un lugar de la Mancha, de cuyo nombre no quiero acordarme...".Frame()
}

/**
 * Funcion de extension que formatea dentro de un marco de asteriscos
 */

fun String.Frame() {
    val words = this.split(" ")
    var maxLength = 0

    words.forEach {
        if (it.length > maxLength) maxLength = it.length
    }

    println("*".repeat(maxLength + 4))
    words.forEach{
        val spaces = " ".repeat(maxLength - it.length)
        println("* $it$spaces *")

    }
    println("*".repeat(maxLength + 4))


}
