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
    println("1.1- For loop")
    loopFor()

    println("1.2- While loop")
    loopWhile()

    println("1.3- Do-while loop")
    loopDoWhile()

    println("1.4- Repeat loop")
    loopRepeat()

    println("2.- Recursion")
    recursion()

    println("3.- Random")
    random()
}

private fun loopFor() {
    for (i in 1..100) {
        print(i)
        if (i != 100) {
            print(", ")
        }
        if (i % 10 == 0) {
            println()
        }
    }
    println("---------------------\n")
}

private fun loopWhile() {
    var i = 1
    while (i <= 100) {
        print(i)
        if (i != 100) {
            print(", ")
        }
        if (i % 10 == 0) {
            println()
        }
        i++
    }
    println("---------------------\n")
}

private fun loopDoWhile() {
    var i = 1
    do {
        print(i)
        if (i != 100) {
            print(", ")
        }
        if (i % 10 == 0) {
            println()
        }
        i++
    } while (i <= 100)
    println("---------------------\n")
}

private fun loopRepeat() {
    repeat(100) { i ->
        val num = i +1
        print(num)
        if (num != 100) {
            print(", ")
        }
        if (num % 10 == 0) {
            println()
        }
    }
    println("---------------------\n")
}

private fun recursion(i: Int = 1) {
    print(i)
    if (i != 100) {
        print(", ")
    }
    if (i % 10 == 0) {
        println()
    }
    if (i < 100) {
        recursion(i + 1)
    }
    if (i == 100) {
        println("---------------------\n")
    }
}

private fun random() {
    // This is the way how every programmer should count BTW
    val alNumbers = arrayListOf<Int>()
    var tries = 0
    while (alNumbers.size < 100) {
        val random = (1..100).random()
        if (!alNumbers.contains(random)) {
            alNumbers.add(random)
        }
        tries++
    }
    alNumbers.sorted().forEach {
        print(it)
        if (it != 100) {
            print(", ")
        }
        if (it % 10 == 0) {
            println()
        }
    }
    println("\nIt only took me $tries tries!")
    println("---------------------\n")
}