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
        launch{Addition(1, 1, 10L, 1)}
        launch{Addition(4, 3, 2L, 2)}
        launch{Addition(3, 5, 5L, 3)}
        launch{Addition(5, 1, 3L, 4)}
        launch{Addition(-1, 10, 8L, 5)}
        launch{Addition(20, -12, 7L, 6)}
        launch{Addition(-10, -10, 1L, 7)}
    }
}

private suspend fun Addition(numberOne: Int, numberTwo: Int, seconds: Long, count: Int) {
    CoroutineScope(Dispatchers.IO).launch {
        delay(seconds*1000)
    }.join()
    println("El resultado de la suma  $count es: ${numberOne + numberTwo}")
}

