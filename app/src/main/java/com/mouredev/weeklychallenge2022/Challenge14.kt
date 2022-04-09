package com.mouredev.weeklychallenge2022

import kotlin.math.pow

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
    val numero = 407
    println("¿Es $numero un número de Armstrong? " + isArmstrong(numero))
    println("¿Es ${numero+1} un número de Armstrong? " + isArmstrong(numero+1))
}

fun isArmstrong(numero: Int):Boolean{
    val exponente = numero.toString().length
    val resultado = getSuma(numero, exponente)

    if(resultado == numero) return true
    return false
}

fun getSuma(numero: Int, exponente: Int):Int {
    if(numero == 0) return 0
    return ((numero % 10).toDouble().pow(exponente.toDouble()) + getSuma(
        numero / 10, exponente)).toInt()
}