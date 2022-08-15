package com.mouredev.weeklychallenge2022

import java.lang.Exception

/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */
fun main(){


    val listNumber = arrayListOf<Int>(1,4,5,6,3,8,7,9,10)
    val listNumber2 = arrayListOf<Int>(1,4,5,6,3,8,7,9,10,10,10,10,10)
    val listNumber3 = arrayListOf<Int>(9,6,8,2,3,4)
    val listNumber4 = arrayListOf<Int>(1,1)
    val listNumber5 = arrayListOf<Int>(1,2)
    val listNumber6 = arrayListOf<Int>(9,1)
    val listNumber1 = arrayListOf<Int>(1)
    print(getSecondHighest(listNumber1));


}

fun getSecondHighest(listNumber: List<Int>):Int{

    if(listNumber.size<2) {
        throw Exception("The list should have more than 2 values")
    }
    var secondMax =0
    var setList = mutableSetOf<Int>()
    for(number in listNumber){
        setList.add(number)
    }
    secondMax = if(setList.size <= 1) {
        setList.first()
    }else
    {
        setList.sorted().elementAt(setList.size-2)
    }
    return secondMax;
}