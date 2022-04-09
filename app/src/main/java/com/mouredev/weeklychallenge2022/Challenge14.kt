package com.mouredev.weeklychallenge2022

/*
 * Reto #14
 * ¿ES UN NÚMERO DE ARMSTRONG?
 * Fecha publicación enunciado: 04/04/22
 * Fecha publicación resolución: 11/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información al respecto.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val t1: Long = 153
    val t2: Long = 54748
    val t3: Long = 9926315
    val f1: Long = 815
    val f2: Long = 65423115
    println("El número $t1 ${if(! isArmstrong(t1)) "no " else ""}es Armstrong.")
    println("El número $t2 ${if(! isArmstrong(t2)) "no " else ""}es Armstrong.")
    println("El número $t3 ${if(! isArmstrong(t3)) "no " else ""}es Armstrong.")
    println("El número $f1 ${if(! isArmstrong(f1)) "no " else ""}es Armstrong.")
    println("El número $f2 ${if(! isArmstrong(f2)) "no " else ""}es Armstrong.")
}

fun Long.positivePow(n: Int): Long {
    var counter = 1L
    for (i in 1..n) counter *= this
    return counter
}

fun isArmstrong(n: Long): Boolean {
    var number = n
    var counter: Long = 0
    val length = n.toString().length
    for (i in 0 until length){
        counter += (number % 10).positivePow(length)
        number /= 10
    }

    return counter == n
}