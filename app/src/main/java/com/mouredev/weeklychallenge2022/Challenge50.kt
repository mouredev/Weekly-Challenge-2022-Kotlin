package com.mouredev.weeklychallenge2022

import java.text.Normalizer

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

fun main(){

    printKaraca("Reto#50MoureDev")
    printKaraca("La cria de berberechos en cautividad es una actividad que ha ganado popularidad " +
            "en los últimos años debido a la alta demanda de este marisco en el mercado. Los berberechos son una especie de " +
            "molusco bivalvo que se encuentra en aguas templadas y salobres, y que se caracteriza por su sabor y textura únicos")

}


/***************************** NOTA IMPORTANTE *************************
 * Aunque el algoritmo diseñado tiene en cuenta los acentos y caracteres especiales, al desencriptar suponemos cierta
 * "perdida" de información en los acentos , ya que al ser tan simple el algoritmo de encriptacion no se puede recuperar
 * la información original de los acentos y caracteres especiales en las vocales.
 *
 * Ademas tambien a la hora de desencriptar se asume que los numeros que se encuentran en el texto son los que se han
 * encriptado, por lo que si el texto contiene numeros se asume que son parte del texto encriptado , lo que puede dar
 * lugar a errores en la desencriptación.
 */

/**
 * Mapa de sustitución de vocales
 */

val vowelsMap = mapOf(
    'a' to 0,
    'e' to 1,
    'i' to 2,
    'o' to 4,
    'u' to 5,
    'A' to 6,
    'E' to 7,
    'I' to 8,
    'O' to 9,
)
/**
 * Funcion que encripta un texto utilizando el algoritmo de encriptación de Karaca
 * El algoritmo consiste en:
 * 1. Invertir el texto
 * 2. Reemplazar las vocales por los siguientes números segun el siguiente mapa:
 *   a -> 0
 *   e -> 1
 *   i -> 2
 *   o -> 2
 *   u -> 4
 *   A -> 5
 *   E -> 6
 *   I -> 7
 *   O -> 8
 *   U -> 9
 * 3. Añadir al final la cadena "aca"

 * @param text Texto a encriptar
 */
fun karacaEncrypt(text: String): String {
    return Normalizer.normalize(text.lowercase(), Normalizer.Form.NFD).split(' ').map { word ->
        word.reversed().replace(Regex("[aeiouAEIOU]")) { vowelsMap[it.value[0]].toString()
        }.plus("aca")
    }.joinToString(" ")

}

/**
 * Función que desencripta un texto utilizando el algoritmo de encriptación de Karaca inverso al de encriptación
 * El algoritmo consiste en:
 * 1. Quitar los 3 últimos caracteres (aca)
 * 2. Reemplazar los números por las vocales segun el siguiente mapa:
 *  0 -> a
 *  1 -> e
 *  2 -> i
 *  3 -> o
 *  4 -> u
 *  5 -> A
 *  6 -> E
 *  7 -> I
 *  8 -> O
 *  9 -> U
 *  3. Invertir el texto
 *
 * @param text
 */
fun karacaDecrypt(text: String): String {
    return Normalizer.normalize(text.lowercase(), Normalizer.Form.NFD).split(' ').map { word ->
        word.removeSuffix("aca").reversed().replace(Regex("[0-9]")) {
            vowelsMap.filterValues { value -> value == it.value[0].toString().toInt() }.keys.first().toString()
        }

    }.joinToString(" ")
}

/**
 * Funcion que imprime por pantalla el texto encriptado y desencriptado
 */
fun printKaraca(text: String) {
    println("Original Text: $text")
    val encrypted = karacaEncrypt(text)
    println("Encrypt: $encrypted")
    println("Decrypt: ${karacaDecrypt(encrypted)}")
}
