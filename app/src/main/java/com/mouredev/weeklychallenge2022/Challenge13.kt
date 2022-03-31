package com.mouredev.weeklychallenge2022

/*
 * Reto #13
 * FACTORIAL RECURSIVO
 * Fecha publicación enunciado: 28/03/22
 * Fecha publicación resolución: 04/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule y retorne el factorial de un número dado de forma recursiva.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
  //Check factorials 1 to 10 using wikipedia:
  //https://en.wikipedia.org/wiki/Factorial
  for (i in 1..10) {
    println(factorial(i))
  }
  for (i in 1..10) {
    println(i.getFactorial())
  }
}

private fun factorial(number: Int): Int {
  return if (number == 1) number else number * factorial(number - 1)
}

/*
 * Bonus: using extensions
 */
private fun Int.getFactorial(): Int = if (this == 1) this else this * (this - 1).getFactorial()