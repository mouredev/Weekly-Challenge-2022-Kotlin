package com.mouredev.weeklychallenge2022

/*
 * Reto #49
 * EL DETECTOR DE HANDLES
 * Fecha publicación enunciado: 05/12/22
 * Fecha publicación resolución: 12/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de detectar y retornar todos los handles de un texto usando solamente Expresiones Regulares.
 * Debes crear una expresión regular para cada caso:
 * - Handle usuario: Los que comienzan por "@"
 * - Handle hashtag: Los que comienzan por "#"
 * - Handle web: Los que comienzan por "www.", "http://", "https://" y finalizan con un dominio (.com, .es...)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    println(handlesDetector("En esta actividad de @mouredev, resolvemos #retos de #programacion desde https://retosdeprogramacion.com/semanales2022, que @braismoure aloja en www.github.com"))
}

private fun handlesDetector(text: String): Map<String, List<String>> {

    val handles = mutableMapOf<String, List<String>>()

    handles["user"] = "@(\\w{2,15})".toRegex().findAll(text).toList().map { it.value }
    handles["hashtag"] = "#[^ !@$^#&,.?():%<>{}\\[\\]|\"]+".toRegex().findAll(text).toList().map { it.value }
    handles["url"] = "((https?://(www\\.)?)|www\\.)[\\w#+\\=]{2,256}\\.[a-zA-Z]{2,7}[\\w\\/?=&.+-]*".toRegex().findAll(text).toList().map { it.value }

    return handles
}