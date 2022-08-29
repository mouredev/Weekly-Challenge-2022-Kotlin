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

fun main (){
    // Los primeros números narcisistas: 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474 y 54748.
    isNarcissist("1")
    isNarcissist("5")
    isNarcissist("20")
    isNarcissist("100")
    isNarcissist("153")
    isNarcissist("8208")
}

private fun isNarcissist(n:String){
    val result = n.toList().map { it.toString().toInt() }.sumOf {
        var x : Int = 1
        if (n.length>1){
            for(i in 1..n.length){x*=it}
        } else x = it
        x
    }
    println("If $n is equal to $result then $n is narcissist : ${n.toInt()==result}")
}