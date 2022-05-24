package com.mouredev.weeklychallenge2022
import kotlinx.coroutines.*

/*
 * Reto #20
 * PARANDO EL TIEMPO
 * Fecha publicación enunciado: 16/05/22
 * Fecha publicación resolución: 23/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sume 2 números y retorne su resultado pasados unos segundos.
 * - Recibirá por parámetros los 2 números a sumar y los segundos que debe tardar en finalizar su ejecución.
 * - Si el lenguaje lo soporta, deberá retornar el resultado de forma asíncrona, es decir,
 *  sin detener la ejecución del programa principal. Se podría ejecutar varias veces al mismo tiempo.
 */

fun main(){

    sumInSeconds(2,5, 4){
        println(it)
    }

    sumInSeconds(2,9, 2){
        println(it)
    }

}

fun sumInSeconds (num1 : Int, num2 : Int, seconds : Int, result : (Int) -> Unit){
    val miliseconds = (seconds * 1000).toLong()
    Thread{
        Thread.sleep(miliseconds)
        result(num1+num2)
    }.start()
}