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
 *
 */

fun main() {
    for (num in 1..100) {

        if (esPrimo(num)) {
            println(num)
        }
    }
}

/*
FUNCION DE MARTINEZ
 */
fun esPrimo(num : Int) : Boolean {

    var contador = 0
    for (divisor in 1..num) {

        if (num % divisor == 0) {
            contador ++

            if(contador > 2){
                return false
            }
        }
    }
    return true
}

/*
FUNCION DE MOURE
 */
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