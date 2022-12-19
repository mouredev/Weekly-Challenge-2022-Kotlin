package com.mouredev.weeklychallenge2022

/*
 * Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/11/22
 * Fecha publicación resolución: 19/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
 * algoritmo de encriptación de Karaca (debes buscar información sobre él).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */
fun karacaEncrypt(text: String): String {
    val vowels = "aeiou"
    var result = ""
    text.reversed().forEach {
        result = "$result${if(vowels.contains(it)) vowels.indexOf(it) else it}"
    }
    return "${result}aca"
}

fun karacaDecrypt(text: String): String {
    val vowels = "aeiou"
    var result = ""
    text.substring(0, text.length - 3).reversed().forEach {
        result = "$result${if(it.code in 48..52) vowels[it.code - 48] else it}"
    }
    return result
}

fun main() {
    var text = "apple"
    var encryptedText = karacaEncrypt(text)
    println(encryptedText)  // Imprime "1lpp0aca"
    var decryptedText = karacaDecrypt(encryptedText)
    println(decryptedText)  // Imprime "apple"
    text = "banana"
    encryptedText = karacaEncrypt(text)
    println(encryptedText)  // Imprime "0n0n0baca"
    decryptedText = karacaDecrypt(encryptedText)
    println(decryptedText)  // Imprime "banana"
}