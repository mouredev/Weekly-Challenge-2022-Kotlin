package com.example.weeklychallenge2022

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

    var num: Int = 153
    println("Es número de Armstrong el $num : " + esArmstrong(num))
    num = 15
    println("Es número de Armstrong el $num : " + esArmstrong(num))
    num = 370
    println("Es número de Armstrong el $num : " + esArmstrong(num))
    num = 93084
    println("Es número de Armstrong el $num : " + esArmstrong(num))
}

fun esArmstrong (num: Int): Boolean{

    for (i in 1..num.toString().length){
        var sum = 0
        val number = num.toString()
        for (i in number.indices){
            val digit = number.subSequence(i, i+1).toString().toInt()
            val potency = Math.pow(digit.toDouble(), number.length.toDouble())
            sum += potency.toInt()
        }
        if (sum != num){
            return false
        }
    }
    return true
}