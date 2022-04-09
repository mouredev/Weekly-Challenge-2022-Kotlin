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
    println("El numero 153 es numero de Armstrong?: ${isArmstrongNumber(153)}"); //True
    println("El numero 371 es numero de Armstrong?: ${isArmstrongNumber(371)}"); //True
    println("El numero 2015 es numero de Armstrong?: ${isArmstrongNumber(2015)}"); //False
    println("El numero 24678051 es numero de Armstrong?: ${isArmstrongNumber(24678051)}"); //True
    println("El numero 24678052 es numero de Armstrong?: ${isArmstrongNumber(24678052)}"); //False
}

private fun isArmstrongNumber(number: Int): Boolean {

    var numberToString = number.toString();
    var exp = numberToString.length;
    var calculateNumber = 0;

    numberToString.forEach {
        calculateNumber += it.toString().toDouble().pow(exp.toDouble()).toInt()
    }

    return number == calculateNumber
}