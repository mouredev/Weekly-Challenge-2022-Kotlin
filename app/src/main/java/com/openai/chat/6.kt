package com.openai.chat

/*
 * Reto #6
 * INVIRTIENDO CADENAS
 * Fecha publicación enunciado: 07/02/22
 * Fecha publicación resolución: 14/02/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa en Kotlin que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 *
 * Resuelto: Sí
 * Iteracciones: 2
 * Explicación: Puedes usar un ciclo for para iterar sobre los caracteres de la cadena en orden inverso, y luego agregarlos a una nueva cadena.
 * Conversación:
 * - ¿Y de forma recursiva?
 * - Falta la última letra de la salida
 *
 */

fun reverseString(str: String): String {
    // Creamos una nueva cadena vacía donde agregaremos los caracteres en orden inverso
    val reversed = StringBuilder()

    // Iteramos sobre la cadena en orden inverso
    for (i in str.length - 1 downTo 0) {
        // Agregamos cada caracter a la cadena reversed
        reversed.append(str[i])
    }

    // Retornamos la cadena reversed como resultado
    return reversed.toString()
}

fun reverseStringRecursively(str: String, index: Int): String {
    // Si el índice es uno, la recursión ha llegado al final de la cadena y se retorna el primer caracter de la cadena original (que representa la cadena invertida hasta este punto)
    if (index == 0) return str[0].toString()

    // De lo contrario, se retorna el caracter en la posición del índice más la cadena invertida del resto de la cadena (calculada recursivamente)
    return str[index] + reverseStringRecursively(str, index - 1)
}

fun main() {
    val str = "Hola mundo"
    val reversed = reverseString(str)
    println(reversed)  // imprime "odnum aloH"
    val reversedRecursively = reverseStringRecursively(str, str.length - 1)
    println(reversedRecursively)  // imprime "odnum aloH"
}

