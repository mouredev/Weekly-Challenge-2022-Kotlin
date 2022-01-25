package com.mouredev.weeklychallenge2022

/*
 * Reto #2
 * LA SUCESIÓN DE FIBONACCI
 * Fecha publicación enunciado: 10/01/22
 * Fecha publicación resolución: 17/01/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
 * La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
 * 0, 1, 1, 2, 3, 5, 8, 13...
 *
 *
 */

fun main() {
    fiboCincuenta()
}


/*
FUNCIÓN DE MARTINEZ
 */
fun fiboCincuenta(){

    val losCincuentaDeFibo = arrayListOf<Float>()

    for(i in 1 until 50) {

        if(i == 1){
            losCincuentaDeFibo.add(i.toFloat()-1)
            losCincuentaDeFibo.add(i.toFloat())
        }
        losCincuentaDeFibo.add(losCincuentaDeFibo[i] + losCincuentaDeFibo[i-1])
    }

    for(i in 0 until losCincuentaDeFibo.size) {
        println("Este es el valor $i de la serie de Fibo: ${losCincuentaDeFibo[i]}")
    }
}


