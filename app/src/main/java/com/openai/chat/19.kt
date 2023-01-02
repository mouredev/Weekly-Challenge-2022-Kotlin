package com.openai.chat

/*
 * Reto #19
 * CONVERSOR TIEMPO
 * Fecha publicación enunciado: 09/05/22
 * Fecha publicación resolución: 16/05/22
 * Dificultad: FACIL
 *
 * Enunciado: Crea una función en Kotlin que reciba días, horas, minutos y segundos (como enteros) y retorne su resultado en milisegundos.
 *
 * Resuelto: Sí
 * Iteracciones: 1
 * Explicación: Esta función toma cuatro argumentos: days, hours, minutes, y seconds, todos ellos enteros.
 * Luego, define cuántos milisegundos hay en cada unidad de tiempo (un día, una hora, un minuto y un segundo, respectivamente).
 * Luego, calcula el total de milisegundos sumando todas las unidades de tiempo en milisegundos. Finalmente, la función retorna el resultado como un valor Long.
 *
 */

fun convertToMilliseconds(days: Int, hours: Int, minutes: Int, seconds: Int): Long {
    val millisecondsPerDay = 86400000L
    val millisecondsPerHour = 3600000L
    val millisecondsPerMinute = 60000L
    val millisecondsPerSecond = 1000L

    val totalMilliseconds = days * millisecondsPerDay + hours * millisecondsPerHour + minutes * millisecondsPerMinute + seconds * millisecondsPerSecond

    return totalMilliseconds
}

fun main() {
    val totalMilliseconds = convertToMilliseconds(1, 12, 30, 45)
    println(totalMilliseconds)  // 131445000

    println("\nBrais cases:")
    println(convertToMilliseconds(0, 0, 0, 10))          // 10000
    println(convertToMilliseconds(2, 5, -45, 10))        // 188110000
    println(convertToMilliseconds(2000000000, 5, 45, 10))// 172800000020710000

    println("\nJaime cases:")
    println(convertToMilliseconds(-365, 0, 0 , 0))  // 31536000000
    println(convertToMilliseconds(365, 0, 0 , 0))   // 31536000000
}

