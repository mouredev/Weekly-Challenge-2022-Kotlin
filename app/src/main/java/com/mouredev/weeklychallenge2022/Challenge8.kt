package com.mouredev.weeklychallenge2022

/*
 * Reto #8
 * DECIMAL A BINARIO
 * Fecha publicación enunciado: 18/02/22
 * Fecha publicación resolución: 02/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println("Enter number to calculate binary")
    val number = readLine()
    try {
        number?.let {
            val result = toBinary(it.toLong())
            println("$number in binary is -> $result")
        }
    }catch (e:NumberFormatException){
        println("$number isn't a number, please enter a number")
    }
}

private tailrec fun toBinary(number: Long, result: String = ""): String {
    return if (number == 0L || number == 1L) {
        "$number$result"
    } else {
        val rest = number % 2
        val newNumber = getNewNumber(rest, number)
        toBinary(newNumber, "$rest$result")
    }
}

private fun getNewNumber(rest: Long, number: Long) : Long = if (rest == 0L){
    number / 2
} else {
    (number / 2 + DECIMAL).toLong()
}

private const val DECIMAL = 0.5