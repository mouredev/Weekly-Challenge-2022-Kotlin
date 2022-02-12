package com.mouredev.weeklychallenge2022

/*
 * Reto #6
 * INVIRTIENDO CADENAS
 * Fecha publicación enunciado: 07/02/22
 * Fecha publicación resolución: 14/02/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
  var res = ownReverse("racecar")
  println(res)

  res = ownReverse("robot")
  println(res)

  res = ownReverse("Ramen")
  println(res)

  res = ownReverse("I'm hungry!")
  println(res)

  res = ownReverse("drawer")
  println(res)

  res = ownReverse("子猫")
  println(res)

  res = ownReverse("uüu")
  println(res)

  res = ownReverse("εγγραφή")
  println(res)
}

fun ownReverse(s: String): String {
  if (s.isEmpty()) return ""

  val chars = s.toCharArray()
  val size = chars.size

  val reverseInput = CharArray(size)
  var start = size

  var i = 0
  while (i < size) {
    var j = i + 1

    while (j < size) {
      val code = chars[j].category.value
      val charCategory = CharCategory.valueOf(code)

      val isSafe = CharCategory.COMBINING_SPACING_MARK == charCategory ||
          CharCategory.NON_SPACING_MARK == charCategory ||
          CharCategory.ENCLOSING_MARK == charCategory

      if (!isSafe) break

      if (isSafe) j += 1
    }

    for (k in (j - 1) downTo i) {
      start -= 1
      reverseInput[start] = chars[k]
    }

    i = j
  }

  return String(reverseInput)
}