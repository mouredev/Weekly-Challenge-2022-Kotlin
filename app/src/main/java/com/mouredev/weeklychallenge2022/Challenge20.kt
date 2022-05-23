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

/**
 * Funcion principal de la aplicacion
 */
suspend fun main(){

    coroutineScope {

        launch {
            execute(6, 2,3,sum)
        }
        launch {
            execute(1, 1,1, sum)
        }
        launch {
            execute(3, 555,345,sum)
        }

    }

}

/**
 * Expresion Lambda que devuelve la suma de dos entero
 * @param a Primer entero
 * @param b Segundo entero
 * @return Int con la suma de los dos enteros
 */
val sum = { a: Int, b: Int -> a + b }




/**
 * Funcion de suspension que ejecuta una operacion que devuelve un entero tras unos segundos de espera*
 * @param seconds Long con los segundos que tiene que esperar
 * @param operation Lambda con la operacion a ejecutar
 * @return Int con el resultado de la operacion
 */
suspend fun executeWithDelay(seconds: Long, operation: () -> Int): Int {

        delay(seconds * 1000)
        return operation()

}

/**
 * Funcion para testear la aplicacion
 * @param seconds segundos que queremos que espere
 * @param a primer parametro de la operacion
 * @param b segundo parametro de la operacion
 * @param operation lambda con la ooperacion que queremos ejecutar
 */
suspend fun execute(seconds: Long,a:Int,b:Int, operation : (Int,Int) -> Int) {

    println("Lanzando la operacion $a+$b con $seconds de espera")
    println("El resultado de $a+$b tras $seconds segundos de espera es: ${executeWithDelay(seconds) { operation(a,b) }}")


}