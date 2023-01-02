package com.openai.chat

import kotlinx.coroutines.*

/*
 * Reto #20
 * PARANDO EL TIEMPO
 * Fecha publicación enunciado: 16/05/22
 * Fecha publicación resolución: 23/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función en Kotlin que sume 2 números y retorne su resultado pasados unos segundos.
 * - Recibirá por parámetros los 2 números a sumar y los segundos que debe tardar en finalizar su ejecución.
 * - Si el lenguaje lo soporta, deberá retornar el resultado de forma asíncrona, es decir, sin detener la ejecución del programa principal. Se podría ejecutar varias veces al mismo tiempo.
 *
 * Resuelto: Sí
 * Iteracciones: 2
 * Explicación: Puedes utilizar la función delay de la biblioteca kotlinx.coroutines para pausar la ejecución de la función durante un tiempo determinado. También puedes utilizar async para ejecutar la función de forma asíncrona.
 * Es posible que el problema se deba a que no estás esperando a que se complete la tarea asíncrona. Puedes usar el bloque runBlocking para esperar a que se complete la tarea antes de continuar con la ejecución del programa.
 * Conversación:
 * - Imprime el "Hola mundo" pero la suma no
 *
 */

fun sumarConRetraso(num1: Int, num2: Int, segundos: Int): Deferred<Int> {
    return GlobalScope.async {
        delay(segundos * 1000L) // pausa la ejecución durante segundos segundos
        num1 + num2
    }
}

fun main() = runBlocking {
    val resultado = withContext(Dispatchers.Default) {
        sumarConRetraso(1, 2, 3).await()
    }
    println(resultado) // imprime "3" después de 3 segundos
}

