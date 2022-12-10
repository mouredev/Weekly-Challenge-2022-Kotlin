package com.mouredev.weeklychallenge2022

/*
 * Reto #27
 * VECTORES ORTOGONALES
 * Fecha publicación enunciado: 07/07/22
 * Fecha publicación resolución: 11/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que determine si dos vectores son ortogonales.
 * - Los dos array deben tener la misma longitud.
 * - Cada vector se podría representar como un array. Ejemplo: [1, -2]
 *
 * Para determinar que son ortogonales es necesario que el producto punto (o producto escalar) de
 * ambos vectores sea igual a cero: U.V = 0. Entonces resolvemos de la siguiente manera:
 * tenemos U = (1, 2) y V = (-2, 1), debemos hallar U · V. Quedaría de esta manera:
 * U · V = (1)*(-2) + (2)*(1) = 0
 */

fun main (){
    val vecOne = arrayOf(4, -2, 1)
    val vecTwo = arrayOf(1, 2, 0)
    println(areOrthogonal(vecOne, vecTwo))
}

fun areOrthogonal(vecOne : Array<Int>, vecTwo : Array<Int>) : Boolean{

    if (vecOne.size != vecTwo.size){
        return false
    }else{
        var sum = 0
        for (i in vecOne.indices){
            sum += vecOne[i]*vecTwo[i]
        }
        return sum == 0
    }
}
