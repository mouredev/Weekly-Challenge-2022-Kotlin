package com.mouredev.weeklychallenge2022

/*
 * Reto #0
 * EL FAMOSO "FIZZ BUZZ"
 * Fecha publicación enunciado: 27/12/21
 * Fecha publicación resolución: 03/01/22
 * Dificultad: FÁCIL
 * Enunciado: Escribe un programa que muestre por consola (con un print) los números de 1 a 100 (ambos incluidos y con un salto de línea entre cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🗓reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println("Moure Solution:")
    mouredev()
    println()
    println("My Solution:")
    mySolution()
    println()
    println("When Solution:")
    whenSolution()
}
fun mouredev() {
    for (index in 1..100) {
        val divisibleByThree = index % 3 == 0
        val divisibleByFive = index % 5 == 0
        if (divisibleByThree && divisibleByFive) {
            println("fizzbuzz")
        } else if (divisibleByThree) {
            println("fizz")
        } else if (divisibleByFive) {
            println("buzz")
        } else {
            println(index)
        }
    }
}

fun mySolution() {
    for (f in 1..100){
        if (f%3 == 0 && f%5 == 0) {
            println("fizzbuzz")
        } else if (f%3 == 0){
            println("fizz")
        } else if (f%5 == 0){
            println("buzz")
        } else {
            println(f)
        }
    }
}
fun whenSolution() {
    for (i in 1..100){
        when {
            (i % 3 == 0 && i % 5 == 0) -> print("fizzbuzz\n")
            i % 3 == 0 -> print("fizz\n")
            i % 5 == 0 -> print("buzz\n")
            else -> println(i)
        }
    }
}