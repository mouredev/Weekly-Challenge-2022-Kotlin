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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println(reverse("Hola mundo"))
    println(recursiveReverse("Hola mundo"))
}

private fun reverse(text: String): String {
    val textCount = text.count() - 1
    var reversedText = ""
    for (index in 0..textCount) {
        reversedText += text[textCount - index]
    }
    return reversedText
}

// Sin un bucle, mediante una función recursiva
private fun recursiveReverse(text: String, index: Int = 0, reversedText: String = ""): String {
    val textCount = text.count() - 1
    var newReversedText = reversedText
    newReversedText += text[textCount - index]
    if (index < textCount) {
        val newIndex = index + 1
        newReversedText = recursiveReverse(text, newIndex, newReversedText)
    }
    return newReversedText
}

//Sin usar ninguna funcion predeterminda de Python
def invertir_cadena(text):
  
  text = list(text)

  print(text)

  l1 = text[-1]
  l2 = text[-2]
  l3 = text[-3]
  l4 = text[-4]
  l5 = text[-5]
  l6 = text[-6]
  l7 = text[-7]
  l8 = text[-8]
  l9 = text[-9]
  l10 = text[-10]

  inver = l1+l2+l3+l4+l5+l6+l7+l8+l9+l10

  print(inver)  

invertir_cadena("Hola mundo")


