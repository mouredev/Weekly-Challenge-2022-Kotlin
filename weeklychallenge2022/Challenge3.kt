package com.mouredev.weeklychallenge2022

/*
 * Reto #3
 * ¿ES UN NÚMERO PRIMO?
 * Fecha publicación enunciado: 17/01/22
 * Fecha publicación resolución: 24/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {

    (1..100).forEach { number ->
        if (isPrime(number)) {
            println(number)
        }
    }
}

private fun isPrime(number: Int): Boolean {

    if (number < 2) {
        return false
    }

    for (i in 2 until number) {
        if (number % i == 0) {
            return false
        }
    }

    return true
}



