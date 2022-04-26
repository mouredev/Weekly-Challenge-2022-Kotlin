package com.mouredev.weeklychallenge2022

/*
 * Reto #6
 * INVIRTIENDO CADENAS
 * Fecha publicación enunciado: 07/02/22
 * Fecha publicación resolución: 14/02/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 *
 *
 */

fun main() {
    println(invertirCadena("Hola mundo"))
    decimalToBinary(28)
}

fun invertirCadena(cadena : String) : String{
    var cadenaInvertida = ""

    for (index in (cadena.length-1).downTo(0)){
        cadenaInvertida += cadena[index]
    }
    return cadenaInvertida
}

fun decimalToBinary(number : Int){

    var quotient = number
    var binaryNumber = arrayListOf<Int>()

    while(quotient != 1){
        binaryNumber.add(quotient % 2)
        quotient /= 2

        if(quotient == 1){
            binaryNumber.add(1)
        }
    }
    println(binaryNumber)
}