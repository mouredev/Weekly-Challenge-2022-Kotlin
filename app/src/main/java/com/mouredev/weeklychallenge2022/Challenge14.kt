package com.mouredev.weeklychallenge2022

import java.lang.IllegalArgumentException
import java.math.BigInteger

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

fun main(){
    println("Welcome to isArmstrong.")
    println("Introduce the number to check Armstrong: ")
    val number = readLine()
    number?.let {
        try {
            println("Is $number Armstrong ? -> ${number.toBigInteger().isArmstrong()}")
        }catch (e: Exception){
            println("The text introduced is not a number")
        }
    }
}

private fun BigInteger.isArmstrong(digitAdded: BigInteger = BigInteger.ZERO, n: Int = 0): Boolean{
    return when{
        digitAdded>this || this == BigInteger.ZERO -> false
        digitAdded==this-> true
        digitAdded<this-> {
            this.isArmstrong(this.toDigits().plusDigitsWithPow(n+1), n+1)
        }
        else -> throw IllegalArgumentException()
    }
}

private fun BigInteger.toDigits(): List<BigInteger> = toString().map {
    it.toString().toBigInteger()
}

private fun List<BigInteger>.plusDigitsWithPow(n:Int): BigInteger{
    var result: BigInteger = 0.toBigInteger()
    forEach{
        result += it.pow(n)
    }
    return result
}