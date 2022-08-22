package com.mouredev.weeklychallenge2022

import kotlin.collections.last

/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main(){
  val array = arrayOf(1, 20, 3, 4, 6, 20)
  val lost = returnLostNumbers(array)
  print(lost)
}


class ArraySortedError: Exception()

fun returnLostNumbers(array: Array<Int>): MutableList<Int> {
  val menor = array[0]
  val mayor = array[array.size - 1]

  val result = mutableListOf<Int>()


  if (!array.contentEquals(array.sortedArray())) {
    throw ArraySortedError()
  }


  (menor..mayor).forEach { n ->
    if (array.indexOf(n) == -1) {
      result.add(n)
    }
  }

  return result

}