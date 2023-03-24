package com.mouredev.weeklychallenge2022

/*
 * Reto #24
 * ITERATION MASTER
 * Fecha publicación enunciado: 13/06/22
 * Fecha publicación resolución: 20/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno). ¿De cuántas maneras eres capaz de hacerlo? Crea el código para cada una de ellas.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {

    // 1

    println("**** 1 ****")

    for (index in (1..100)) {
        println(index)
    }

    // 2

    println("**** 2 ****")

    (1..100).forEach { index ->
        println(index)
    }

    // 3

    println("**** 3 ****")

    var whileIndex = 1

    while (whileIndex <= 100) {
        println(whileIndex)
        whileIndex += 1
    }

    // 4

    println("**** 4 ****")

    whileIndex = 1

    do {
        println(whileIndex)
        whileIndex += 1
    } while (whileIndex <= 100)

    // 5

    println("**** 5 ****")

    fun print100(index: Int) {
        if (index <= 100) {
            println(index)
            print100(index + 1)
        }
    }

    print100(1)

    // 6

    println("**** 6 ****")

    println((1..100).filter {
        true
    })

    // 7

    println("**** 7 ****")

    println((1..100).map { it })
}
