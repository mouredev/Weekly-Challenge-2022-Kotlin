package com.openai.chat

/*
 * Reto #14
 * ¿ES UN NÚMERO DE ARMSTRONG?
 * Fecha publicación enunciado: 04/04/22
 * Fecha publicación resolución: 11/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función en Kotlin que calcule si un número dado es un número de Amstrong (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información al respecto.
 *
 * Resuelto: Sí
 * Iteracciones: 2
 * Explicación: Para calcular si un número es un número de Armstrong, primero convertimos el número a una cadena para poder iterar sobre cada dígito del número.
 * Luego, utilizamos un bucle para calcular la suma de los dígitos elevados al número de dígitos del número. Por último, comparamos la suma calculada con el número original y
 * devolvemos el resultado de esta comparación como un valor booleano.
 * Conversación:
 * - Los parámetros a la función Math.pow deberían ser de tipo Double
 *
 */
fun isArmstrongNumber(number: Int): Boolean {
    val numString = number.toString()
    val numLength = numString.length
    var sum = 0
    for (char in numString) {
        sum += Math.pow((char.code - '0'.code).toDouble(), numLength.toDouble()).toInt()
    }
    return sum == number
}

fun main() {
    println(isArmstrongNumber(153))  // Output: true
    println(isArmstrongNumber(1634)) // Output: true
    println(isArmstrongNumber(371))  // Output: true
    println(isArmstrongNumber(123))  // Output: false

    // Brais cases
    println(isArmstrongNumber(371))   // Output: true
    println(isArmstrongNumber(-371))  // Output: false
    println(isArmstrongNumber(372))   // Output: false
    println(isArmstrongNumber(0))     // Output: true

    // Jaime cases
    println(isArmstrongNumber(123))   // Output: false
    println(isArmstrongNumber(153))   // Output: true
    println(isArmstrongNumber(371))   // Output: true
    println(isArmstrongNumber(1080))  // Output: false
    println(isArmstrongNumber(1634))  // Output: true
    println(isArmstrongNumber(8208))  // Output: true
}

