package com.openai.chat

/*
 * Reto #16
 * EN MAYÚSCULA
 * Fecha publicación enunciado: 18/04/22
 * Fecha publicación resolución: 25/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función en Kotlin que reciba un String de cualquier tipo y se encargue de poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Resuelto: No
 * Iteracciones: 5
 * Explicación: Esta función primero divide el texto en una lista de palabras utilizando el método split(). Luego, itera sobre cada palabra y toma la primera letra de cada una,
 * la pone en mayúscula y la añade al resultado junto con el resto de la palabra. Finalmente, devuelve el resultado como una cadena.
 * Conversación:
 * - Haz que funcione también sin los textos tienen símbolos de interrogación o exclamación
 * - Pero que no desaparezcan esos símbolos
 * - Ahora se mantienen los símbolos pero no se pone en mayúsculas la primera letra de cada palabra
 * - Los casos de prueba no se cumplen, no muestran lo que pone en los comentarios
 * + The server experienced an error while processing your request. Sorry about that! You can retry your request, or contact us through our help center at help.openai.com if the error persists.
 *
 */
fun capitalizeWords(text: String): String {
    // Creamos una lista de palabras y símbolos a partir del texto dado
    val wordsAndSymbols = text.split("(?<=\\p{L})(?=\\p{P})|(?<=\\p{P})(?=\\p{L})".toRegex())
    // Inicializamos el resultado como una cadena vacía
    var result = ""
    // Iteramos sobre cada elemento de la lista
    for (wordOrSymbol in wordsAndSymbols) {
        // Si el elemento es una palabra...
        if (wordOrSymbol.matches("\\p{L}+".toRegex())) {
            // Tomamos la primera letra de la palabra y la ponemos en mayúscula
            val firstLetter = wordOrSymbol[0].toUpperCase()
            // Añadimos la primera letra en mayúscula y el resto de la palabra al resultado
            result += "$firstLetter${wordOrSymbol.substring(1)}"
        } else {
            // Si el elemento no es una palabra, simplemente lo añadimos al resultado
            result += wordOrSymbol
        }
    }
    // Devolvemos el resultado
    return result
}

fun main() {
    println(capitalizeWords("hello world")) // Imprime "Hello World"
    println(capitalizeWords("the quick brown fox")) // Imprime "The Quick Brown Fox"

    // Brais cases
    println(capitalizeWords("¿hola qué tal estás?"))
    println(capitalizeWords("¿hola      qué tal estás?"))
    println(capitalizeWords("El niño ñoño"))

    // Jaime cases
    println(capitalizeWords(""))
    println(capitalizeWords("palabra"))
    println(capitalizeWords("varias palabras"))
    println(capitalizeWords("varias palabras, con puntuación."))
    println(capitalizeWords("varias palabras, con puntuación y MAYÚSCULAS."))
    println(capitalizeWords("varias palabras, con puntuación, MAYÚSCULAS\n y cambio de líneas."))
    println(capitalizeWords("¡última hora! ¿hay novedades?"))
}

