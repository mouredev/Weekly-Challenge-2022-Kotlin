package com.openai.chat

/*
 * Reto #13
 * FACTORIAL RECURSIVO
 * Fecha publicación enunciado: 28/03/22
 * Fecha publicación resolución: 04/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función en Kotlin que calcule y retorne el factorial de un número dado de forma recursiva.
 *
 * Resuelto: Sí
 * Iteracciones: 2
 * Explicación: Esta función toma un número entero n como parámetro y devuelve su factorial como resultado. La función primero comprueba si n es igual a 0.
 * Si es así, devuelve 1, ya que el factorial de 0 es 1. Si n no es igual a 0, la función se llama a sí misma para calcular el factorial de n-1 y luego multiplica el resultado por n para calcular el factorial de n.
 * Conversación:
 * - Evita que falle si se le pasa un número entero negativo como parámetro
 *
 */

fun factorial(n: Int): Int? {
    if (n < 0) {
        // Si n es negativo, devuelve null
        return null
    }
    return if (n == 0) {
        // El factorial de 0 es 1
        1
    } else {
        // La función se llama a sí misma para calcular el factorial de n-1
        // y luego multiplica el resultado por n para calcular el factorial de n
        n * factorial(n - 1)!!
    }
}

fun main() {
    // Brais cases
    println(factorial(0) ?:run { "No tiene factorial" })    // 1
    println(factorial(7) ?:run { "No tiene factorial" })    // 5040
    println(factorial(1) ?:run { "No tiene factorial" })    // 1
    println(factorial(-1) ?:run { "No tiene factorial" })   // 1 No tiene factorial

    // Jaime case
    val number = 10
    println("$number! = ${factorial(number)}")  // 3628800
}

