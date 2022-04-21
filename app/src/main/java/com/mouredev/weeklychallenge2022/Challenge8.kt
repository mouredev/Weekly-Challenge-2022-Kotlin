package com.mouredev.weeklychallenge2022
/*
 * Reto #8
 * DECIMAL A BINARIO
 * Fecha publicación enunciado: 18/02/22
 * Fecha publicación resolución: 02/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 *
 *
 */

fun main() {
    println(decimalToBinaryMartinez(77))
    println(decimalToBinaryMoure(77))
}

/*
FUNCION DE MARTINEZ
 */
fun decimalToBinaryMartinez(number : Int) : String{

    var quotient = number
    var binaryNumberString = " "

    while(quotient != 1){

        binaryNumberString += (quotient % 2).toString()
        quotient /= 2

        if(quotient == 1){
            binaryNumberString += "1"
        }
    }
    return binaryNumberString.reversed()
}

/*
FUNCION DE MOURE
 */
fun decimalToBinaryMoure(decimal: Int): String {

    var number = decimal
    var binary = ""

    while (number != 0) {

        val reminder = number % 2
        number /= 2

        binary = "$reminder$binary"
    }

    return binary.ifEmpty { "0" }
}