package com.mouredev.weeklychallenge2022

/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {

    // Input
    val input = "loremp ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua "

    // Output
    println("Texto: $input")
    if(mostCommonVowel(input).isBlank()){
        println("No hay vocales")
    } else {
        println("Vocal más común: ${mostCommonVowel(input)}")
        println("Vocal más común: ${mostCommonVowel2(input)}")
    }
}

/// [mostCommonVowel] devuelve la vocal que más veces se repite en un texto que se pasa a travers
/// del parámetro [input].
fun mostCommonVowel(input: String): String {


    /// [vowelRegex] es una expresión regular que busca todas las vocales del alfabeto español
    /// y sus acentos.
    val vowelRegex = Regex("[aeiouáéíóúü]")


    return if (input.lowercase().contains(vowelRegex)) {

        /// [vowels] es una lista que contiene las vocales como clave y el número de veces que se repiten
        val vowels = vowelRegex.findAll(input.lowercase()).map { it.value }.toList()

        /*
        *   mostCommonVowel es la vocal que más veces se repite en el texto
        *   [groupBy()] agrupa las vocales por su valor y devuelve un mapa con la vocal como clave y
        *   el número de veces que se repite como valor.
        *   [eachCount()] devuelve un mapa con la vocal como clave y el número de veces que se repite
        *   [maxByOrNull] devuelve el elemento que más veces se repite en la lista
        */

        val mostCommonVowel = vowels.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key

        mostCommonVowel ?: ""

    } else {
        ""
    }
}

fun mostCommonVowel2(input: String): String {

    val aCount: Int = input.count { it == 'a' || it == 'á' }
    val eCount: Int = input.count { it == 'e' || it == 'é' }
    val iCount: Int = input.count { it == 'i' || it == 'í' }
    val oCount: Int = input.count { it == 'o' || it == 'ó' }
    val uCount: Int = input.count { it == 'u' || it == 'ú' || it == 'ü' }

    val max = maxOf(aCount, eCount, iCount, oCount, uCount)

    return when (max) {
        aCount -> "a"
        eCount -> "e"
        iCount -> "i"
        oCount -> "o"
        uCount -> "u"
        else -> ""
    }
}



