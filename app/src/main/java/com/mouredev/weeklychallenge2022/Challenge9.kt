package com.mouredev.weeklychallenge2022

/*
 * Reto #9
 * CÓDIGO MORSE
 * Fecha publicación enunciado: 02/03/22
 * Fecha publicación resolución: 07/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
  val text = "Hola mundo"

  val codigoMorse = hashMapOf(".-" to "A", "-..." to "B", "-.-." to "C", "-.." to "D", "." to "E", "..-." to "F", "--." to "G", "...." to "H", ".." to "I", ".---" to "J", "-.-" to "K", ".-.." to "L", "--" to "M", "-." to "N", "---" to "O", ".--." to "P", "--.-" to "Q", ".-." to "R", "..." to "S", "-" to "T", "..-" to "U", "...-" to "V", ".--" to "W", "-..-" to "X", "-.--" to "Y", "--.." to "Z", "-----" to "0", ".----" to "1", "..---" to "2", "...--" to "3", "....-" to "4", "....." to "5", "-...." to "6", "--..." to "7", "---.." to "8", "----." to "9", ".-.-.-" to ".", "--..--" to ",", "..--.." to "?", ".----." to "'", " " to " ")

  if (check(text)) {
    println(toNatural(text, codigoMorse))
  } else {
    println(toMorse(text, codigoMorse))
  }
}

fun check(text: String): Boolean {
  val textArray = text.toCharArray()

  for (i in textArray.indices) {
    if (textArray[i] != '.' && textArray[i] != '-' && textArray[i] != ' ') {
      return false
    }
  }
  return true
}

fun toMorse(text: String, codigoMorse: HashMap<String, String>): String {
  var morse = ""
  val textArray = text.uppercase().toCharArray()

  for (i in textArray.indices) {
    for ((key, value) in codigoMorse) {
      if (textArray[i] == value[0] && key != " ") morse += key
    }
    morse += " "
  }
  return morse.trim()
}

fun toNatural(text: String, codigo: Map<String, String>): String {
  var natural=""
  val frase = text.uppercase().split("  ")

  for (i in frase.indices) {
    val palabra = frase[i].split(" ")
    for (j in palabra.indices) {
      natural += codigo[palabra[j]]
    }
    natural += " "
  }
  return natural.trim()
}
