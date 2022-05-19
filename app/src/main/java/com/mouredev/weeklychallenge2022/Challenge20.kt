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
 * - Si el lenguaje lo soporta, deberá retornar el resultado de forma asíncrona, es decir, sin detener la ejecución del programa principal. Se podría ejecutar varias veces al mismo tiempo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

suspend fun main() {
    coroutineScope {
        launch { println("Result 1 = ${stop(8, 2, 1000)}") }
        launch { println("Result 2 = ${stop(5, 1, 3000)}") }
        launch { println("Result 3 = ${stop(0, 7, 500)}") }
        launch { println("Result 4 = ${stop(3, 4, 2500)}") }
    }
}

private suspend fun stop(num1: Int, num2: Int, time: Long): Int {
    val total = num1 + num2
    val job = CoroutineScope(Dispatchers.IO).launch {
        delay(time)
    }
    job.join()
    return total
}