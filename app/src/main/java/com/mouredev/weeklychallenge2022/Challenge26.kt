package com.mouredev.weeklychallenge2022

/*
 * Reto #26
 * CUADRADO Y TRIÁNGULO 2D
 * Fecha publicación enunciado: 27/06/22
 * Fecha publicación resolución: 07/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 *
 */

//SOLO ESTÁ TERMINADO EL CUADRADO, EL TRIANGULO ESTA PENDIENTE.
fun main(){
    paintSquare(6)
}

fun paintSquare(side : Int){

    val topAndBottonSideOfTheSquare = Array(side){" "}
    val rightAndLeftSideOfTheSquare = Array(side){" "}

    for (i in topAndBottonSideOfTheSquare.indices){
        topAndBottonSideOfTheSquare[i] = "*"

        if (i == 0 || i == topAndBottonSideOfTheSquare.size -1){
            rightAndLeftSideOfTheSquare[i] = "*"
        }else{
            rightAndLeftSideOfTheSquare[i] = " "
        }
    }

    for (i in topAndBottonSideOfTheSquare.indices){
        /*La función de extensión joinToString() es una utilidad que transforma una colección de
        elementos en un String. Puedes personalizar al construcción a partir de parámetros que
        especifican el separador, prefijo, sufijo, límite o transformación.*/

        if (i == 0 || i == topAndBottonSideOfTheSquare.size -1){
            println(topAndBottonSideOfTheSquare.joinToString(" "))
        }else{
            println(rightAndLeftSideOfTheSquare.joinToString(" "))
        }
    }
}