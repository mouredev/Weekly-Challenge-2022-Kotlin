package com.mouredev.weeklychallenge2022

import java.awt.SystemColor.text

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

//En Kotlin, podríamos crear una función que tome una cadena de texto como entrada y utilice expresiones regulares para buscar y retornar handles en el texto.
// Podríamos utilizar la clase Regex de Kotlin para facilitar el trabajo con expresiones regulares. La función podría tener la siguiente apariencia:
fun detectHandles(text: String): List<String> {
    val handles = mutableListOf<String>()

    // Expresión regular para detectar handles de usuario
    val userHandleRegex = Regex("@[a-zA-Z0-9_]+")
    // Expresión regular para detectar handles de hashtag
    val hashtagHandleRegex = Regex("#[a-zA-Z0-9_]+")
    // Expresión regular para detectar handles de sitios web
    val webHandleRegex = Regex("(www\\.[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+)|(https?://[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+)")

    // Buscamos todos los handles de usuario en el texto
    handles.addAll(userHandleRegex.findAll(text).map { it.value })
    // Buscamos todos los handles de hashtag en el texto
    handles.addAll(hashtagHandleRegex.findAll(text).map { it.value })
    // Buscamos todos los handles de sitios web en el texto
    handles.addAll(webHandleRegex.findAll(text).map { it.value })

    return handles
}
// La función utiliza tres expresiones regulares diferentes para buscar handles de usuario, hashtag y sitios web en el texto. Luego, agrega cada handle encontrado a una lista mutable y la retorna al final.

fun main() {
    println(detectHandles("Sorteo #aDEViento2022 - Sábado 10 de diciembre (10/24) - (x2) Libros 'Inteligencia matemática/Apocalipsis matemático' de Eduardo Sáenz de Cabezón - Ganadores/as sorteo: @DanMaG175, @fUIHq39Ym40q4Ul - Más sobre estos libros en https://amzn.to/3F9x16w"))
}

