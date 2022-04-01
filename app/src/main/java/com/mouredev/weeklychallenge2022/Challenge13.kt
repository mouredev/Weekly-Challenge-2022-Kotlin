package com.mouredev.weeklychallenge2022

import java.math.BigInteger

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

/*
 * Factorial: Producto de números enteros positivos.
 * El 0 está aceptado en la secuencia.
 *
 * NOTA: Al solo admitir números naturales usamos Long por ser la clase con más tamaño de números naturales.
 *
 * Como bonus lo he hecho con una extension y dejo también la forma de hacerlo con BigInteger
 * para aceptar números muy altos.
 *
 * Comprobar factoriales de 0 a 10 usando la wikipedia:
 * https://es.wikipedia.org/wiki/Factorial
 */
fun main() {
  println("factorial")
  for (i in 0L..10L) {
    println("$i! = ${factorial(i)}")
  }
  println("getFactorial")
  for (i in 0L..10L) {
    println("$i! = ${i.getFactorial()}")
  }
  println("bigFactorial")
  for (i in 0L..100L) {
    //10 para pasarlo a formato decimal. Se puede usar 2 para pasarlo a binario
    println("$i! = ${bigFactorial(i).toString(10)}")
  }
}

private fun factorial(number: Long): Long {
  if (number < 0) throw IllegalArgumentException("negatives values not allowed")
  return if (number <= 1) 1 else number * factorial(number - 1)
}

private fun Long.getFactorial(): Long {
  if (this < 0) throw IllegalArgumentException("negatives values not allowed")
  return if (this <= 1) 1 else this * (this - 1).getFactorial()
}

private fun bigFactorial(number: Long): BigInteger {
  if (number < 0) throw IllegalArgumentException("negatives values not allowed")
  val validValue = if (number == 0L) 1 else number
  val bigNumber = BigInteger.valueOf(validValue)
  return if (number <= 1) bigNumber else bigNumber.multiply(bigFactorial(number - 1))
}