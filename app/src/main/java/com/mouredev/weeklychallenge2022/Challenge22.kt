package com.mouredev.weeklychallenge2022

import java.util.ArrayList

/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 */

fun main(){
    /*
    FUNCION DE MARTINEZ
    */
    val arrayUno = arrayOf("cerdo", "perro","periquito","manzana","plátano","fresa")
    val arrayDos = arrayOf("cerdo", "periquito", "fresa", "rojo", "amarillo", "verde")
    val comunes = false
    println(conjuntos(arrayUno, arrayDos, comunes).forEach { println(it) })

    /*
    FUNCION DE MOURE
    */
    println(calculateSet(listOf(1, 2, 3, 3, 4), listOf(2, 2, 3, 3, 3, 4, 6), true))
    println(calculateSet(listOf(1, 2, 3, 3, 4), listOf(2, 2, 3, 3, 3, 4, 6), false))
}

/*
FUNCION DE MARTINEZ
*/
fun conjuntos(arrayUno: Array<String>, arrayDos: Array<String>, comunes : Boolean ) : Array<String>{

    val resultado: Array<String>

    if (comunes){
        resultado = arrayUno.filter { arrayDos.contains(it) }.toTypedArray()
    }else{
        resultado = (arrayUno.filter { !arrayDos.contains(it) }.toTypedArray())
            .plus(arrayDos.filter { !arrayUno.contains(it) }.toTypedArray())
    }
    return resultado
}

/*
FUNCION DE MOURE
*/

private fun calculateSet(first: List<Int>, second: List<Int>, common: Boolean): List<Int> {

    val commonResult = mutableListOf<Int>()

    for (firstValue in first) {
        if (!commonResult.contains(firstValue)) {
            for (secondValue in second) {
                if (firstValue == secondValue && !commonResult.contains(firstValue)) {
                    commonResult.add(firstValue)
                    break
                }
            }
        }
    }

    return if (common) {
        commonResult
    } else {
        val nonCommonResult = mutableListOf<Int>()
        nonCommonResult.addAll(first)
        nonCommonResult.addAll(second)

        commonResult.forEach { commonValue ->
            nonCommonResult.removeAll { nonCommonValue ->
                commonValue == nonCommonValue
            }
        }

        nonCommonResult
    }
}