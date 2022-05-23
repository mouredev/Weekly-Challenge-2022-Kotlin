package com.mouredev.weeklychallenge2022

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
 * Reto #20
 * PARANDO EL TIEMPO
 * Fecha publicación enunciado: 16/05/22
 * Fecha publicación resolución: 23/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sume 2 números y retorne su resultado pasados unos segundos.
 * - Recibirá por parámetros los 2 números a sumar y los segundos que debe tardar en finalizar su ejecución.
 * - Si el lenguaje lo soporta, deberá retornar el resultado de forma asíncrona, es decir, sin detener la ejecución del programa principal. Se podría ejecutar varias veces al mismo tiempo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() = runBlocking{
    val time = measureTimeMillis {
        launch { println(matrixMath(10,20, 3000)) }
        launch { println(matrixMath(15,8, 5000)) }
        launch { println(matrixMath(-50,200, 1000)) }
    }
    println("Time passed for launch: $time")

    // For Moure Dev solution
    asyncSum(5, 2, 10) { result ->
        println(result)
    }

    asyncSum(1, 3, 5) { result ->
        println(result)
    }
}

private suspend fun matrixMath(num1 : Int, num2 : Int, time : Long) : Int {
    if (time >= 0)
        delay(time)
    return num1 + num2
}

// For Moure Dev solution
private fun asyncSum(numberOne: Int, numberTwo: Int, seconds: Int, result: (Int) -> Unit) {
    Thread {
        Thread.sleep((seconds * 1000).toLong())
        result(numberOne + numberTwo)
    }.start()
}

