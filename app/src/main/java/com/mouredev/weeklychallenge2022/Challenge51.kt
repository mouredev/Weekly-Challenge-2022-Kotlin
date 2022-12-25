package com.mouredev.weeklychallenge2022

/*
 * Reto #51
 * EL RETO RANDOM
 * Fecha publicación enunciado: 19/12/22
 * Fecha publicación resolución: 26/12/22
 * Dificultad: ?
 *
 * Mi enunciado : Dados tres números deducir cuál es el central.
 *
 */

//mi solucion

fun main() {
    numeroCentral(5, 6, 7)
    numeroCentral(10, 2, 2)
}

private fun numeroCentral(numeroUno: Int, numeroDos: Int, numeroTres: Int) {

    if (numeroUno >= numeroDos && numeroUno <= numeroTres) {
        println("El numero Centrado es : $numeroUno")
    }

    if (numeroDos >= numeroUno && numeroDos <= numeroTres) {
        println("El numero Centrado es : $numeroDos")
    }

    if (numeroTres >= numeroDos && numeroTres <= numeroUno) {
        println("El numero Centrado es : $numeroTres")
    }
}
