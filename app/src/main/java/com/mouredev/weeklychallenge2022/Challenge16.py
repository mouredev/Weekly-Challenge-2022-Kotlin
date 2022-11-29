""" package com.mouredev.weeklychallenge2022

/*
 * Reto #16
 * EN MAYÚSCULA
 * Fecha publicación enunciado: 18/04/22
 * Fecha publicación resolución: 25/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println(capitalize("¿hola qué tal estás?"))
    println(capitalize("¿hola      qué tal estás?"))
    println(capitalize("El niño ñoño"))
}

private fun capitalize(text: String): String {

    var capitalizedText = text

    text.replace("[^A-zÀ-ú]".toRegex(), " ").split(" ").forEach { word ->
        capitalizedText = capitalizedText.replace(word, word.replaceFirstChar { it.uppercase() })
    }

    return capitalizedText
} """

import re, string

def capitalized(text):

    symbols = string.punctuation + string.whitespace + "?¿"

    pattern = "[a-zà-ú]"
    new_text = ""

    for i in range(len(text)):
        char = text[i]
        previous_char = text[i-1]

        if char not in symbols and previous_char in symbols or char == text[0]:
            s = re.sub(pattern, char.upper(), char)
            new_text += s
        else:
            new_text += char

    return new_text

print(capitalized("¿hola qué tal estás?"))
print(capitalized("¿hola      qué tal estás?"))
print(capitalized("El niño ñoño"))
print(capitalized("á"))