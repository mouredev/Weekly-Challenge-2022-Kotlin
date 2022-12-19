package com.openai.chat

/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función en Kotlin que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 *
 * Resuelto: No.
 * Explicación: Una forma de resolver este problema en Kotlin sería utilizar dos diccionarios (mapas) para contar la cantidad de veces que cada letra aparece en cada una de las
 * palabras. Luego, se comparan los dos diccionarios y se retorna verdadero si tienen las mismas letras y las mismas cantidades de cada letra, y falso en caso contrario.
 * La función anterior convierte las dos palabras a minúsculas para evitar problemas con las mayúsculas, y utiliza un diccionario mutable (que puede ser modificado)
 * para contar la cantidad de veces que cada letra aparece en cada una de las palabras. Luego, se comparan los dos diccionarios utilizando el operador de igualdad ==,
 * que retorna verdadero si los dos diccionarios tienen las mismas claves y los mismos valores, y falso en caso contrario.
 * Conversación:
 * - Con dos palabras exactamente iguales también devuelve true y dos palabras idénticas no son anagrama
 */

fun main() {
    // ChatGPT
    println(esAnagrama("casa", "acas")) // debería imprimir "true"
    println(esAnagrama("casa", "casa")) // debería imprimir "false"
    println(esAnagrama("casa", "cama")) // debería imprimir "false"
    println(esAnagrama("abcd", "abcd")) // debería imprimir "true"

    // Brais case
    println(esAnagrama("amor", "roma"))

    // Jaime cases
    println(esAnagrama("Roma",""))
    println(esAnagrama("Roma","Roma"))
    println(esAnagrama("Roma","romana"))
    println(esAnagrama("Roma","Peru"))
    println(esAnagrama("Roma","ramo"))
    println(esAnagrama("Roma","mora"))
    println(esAnagrama("Roma","moar"))
    println(esAnagrama("Roma","amor"))
}

fun esAnagrama(palabra1: String, palabra2: String): Boolean {
    // Convierte las palabras en arreglos de caracteres
    val arreglo1 = palabra1.toCharArray()
    val arreglo2 = palabra2.toCharArray()

    // Ordena los arreglos
    arreglo1.sort()
    arreglo2.sort()

    // Compara los arreglos ordenados
    return arreglo1.contentEquals(arreglo2)
}
