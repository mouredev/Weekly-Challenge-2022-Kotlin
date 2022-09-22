package com.mouredev.weeklychallenge2022

import kotlin.math.pow

/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/**
 * Funcion principal
 */
fun main(){

    println(binaryToDecimal("1010"))
    println(binaryToDecimal("010111101111100001"))
    println(binaryToDecimal("01200011"))

}

/**
 * Funcion que transforma un numero binario a decimal
 * @param binary numero binario
 * @return numero decimal
 */
fun binaryToDecimal(binary: String): Int {
    var decimal = 0
    if(binary.isBinary){
        binary.reversed().forEachIndexed { index, value ->
            decimal += (value.toString().toInt() * 2.0.pow(index.toDouble())).toInt()
        }
    }
    else{
        println("El número binario no es correcto")
    }
    return decimal


}

/**
 * Funcion de extension de String que comprueba si el numero binario es correcto
 * @return true si es correcto, false si no lo es
 */

 val String.isBinary : Boolean
    get() = Regex("^[0-1]+\$").matches(this)

