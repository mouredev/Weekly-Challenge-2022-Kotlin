package com.mouredev.weeklychallenge2022

/*
 * Reto #49
 * EL DETECTOR DE HANDLES
 * Fecha publicación enunciado: 05/11/22
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
    println("${findHandles("Hola @mouredev, ¿qué tal? #retosdeprogramacion #kotlin #android https://mouredev.com")}")
    println("${findHandles("@elonmusk va a destruir #Twitter. @mouredev, ¿qué opinas?")}")
}

fun findHandles(input: String): List<String> {
    val handles = mutableListOf<String>()
    val userHandlePattern = "@\\w+".toRegex()
    val hashtagHandlePattern = "#\\w+".toRegex()
    val webHandlePattern = "https?://(www\\.)?\\w+\\.[a-zA-Z]{2,3}".toRegex()

    val userHandles = userHandlePattern.findAll(input)
    val hashtagHandles = hashtagHandlePattern.findAll(input)
    val webHandles = webHandlePattern.findAll(input)

    userHandles.forEach { handles.add(it.value) }
    hashtagHandles.forEach { handles.add(it.value) }
    webHandles.forEach { handles.add(it.value) }

    return handles
}



