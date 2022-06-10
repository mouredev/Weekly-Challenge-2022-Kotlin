package com.mouredev.weeklychallenge2022

import java.io.File
import java.util.ArrayList

/*
 * Reto #21
 * CALCULADORA .TXT
 * Fecha publicación enunciado: 23/05/22
 * Fecha publicación resolución: 01/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*" y división "/".
 * - El resultado se muestra al finalizar la lectura de la última línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han podido resolver las operaciones.
 *
 */

fun main(){
    println(readAndCalculateFileContent())
}

fun readAndCalculateFileContent() : Float{
    val pathName = "C:\\Users\\Brais\\StudioProjects\\Weekly-Challenge-2022-Kotlin\\app\\src\\main\\res\\raw\\challenge21.txt"
    val miArchivo = File(pathName)
    val listOflineas = miArchivo.readLines()
    var listOfSymbols= arrayListOf<String>("+","-","*","/")
    var result = listOflineas[0].toFloat()

    for(indiceLinea in listOflineas.indices){

        var symbol = ""

        if (listOfSymbols.contains(listOflineas[indiceLinea])){
            symbol = listOflineas[indiceLinea]
            when (symbol){
                "+" -> result += listOflineas[indiceLinea + 1].toInt()
                "-" -> result -= listOflineas[indiceLinea + 1].toInt()
                "*" -> result *= listOflineas[indiceLinea + 1].toInt()
                else -> result /= listOflineas[indiceLinea + 1].toInt()
            }
        }
    }
    return result
}