package com.mouredev.weeklychallenge2022

import java.util.ArrayList

/*
 * Reto #23
 * MÁXIMO COMÚN DIVISOR Y MÍNIMO COMÚN MÚLTIPLO
 * Fecha publicación enunciado: 07/06/22
 * Fecha publicación resolución: 13/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el
 * mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 */

fun main(){
    //println(mcd(53667, 25527))
    println(mcm(625, 500))
}

fun mcd (num1 : Int, num2:Int) : Int{
    val commonDividers = getDividers(num1).filter { getDividers(num2).contains(it) }
    return commonDividers.last()
}

fun mcm (num1 : Int, num2:Int) : Int{
    var haveCommonMultiple = false
    var commonMultiple = 0
    var iterator = 1
    val listOfMultiples = arrayListOf<Int>()

    while(!haveCommonMultiple){

        var actualMultipleNum1 = num1 * iterator
        var actualMultipleNum2 = num2 * iterator

        if (listOfMultiples.contains(actualMultipleNum1)){
            haveCommonMultiple = true
            commonMultiple = actualMultipleNum1
        }else if(listOfMultiples.contains(actualMultipleNum2)){
            haveCommonMultiple = true
            commonMultiple = actualMultipleNum2
        }else{
            listOfMultiples.add(actualMultipleNum1)
            listOfMultiples.add(actualMultipleNum2)
        }
        iterator++
    }
    return commonMultiple
}

fun getDividers(num : Int) : ArrayList<Int>{
    val listOfDividers = arrayListOf<Int>()

    for (potentialDivider in 1..num){

        if (num.mod(potentialDivider) == 0){
            listOfDividers.add(potentialDivider)
        }
    }
   return listOfDividers
}