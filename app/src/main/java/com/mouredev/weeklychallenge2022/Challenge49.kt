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

/**
 * Funcion principal con los casos de ejemplo
 */
fun main(){
    println(handleDetector("Retos de programacion : (https://mouredev.com/discord) #reto-semanal #reto49 #MoureDev @malopezrom @mouredev https://mouredev.com .moure.es https://retosdeprogramacion.com/semanales2022 #retosdeprogramacion"))
    println(handleDetector("Hola a todos! Hoy es un día hermoso y estoy muy emocionada. #feliz #sol #playa.Estoy disfrutando de un día de descanso en la playa con mis amigos @paula @juan @maria.No puedo esperar para compartir fotos en mis redes sociales con todos ustedes. #friends #beachday #relax"))
    println(handleDetector("Acabo de encontrar el mejor café de la ciudad gracias a la recomendación de @cafes. ¡Definitivamente lo voy a probar y compartir en mis redes con el hashtag #elmejorCafe! www.elmejorcafe.es"))
}

/**
 * class Enum con las expresiones regulares necesarias para detectar los handles
 * @type {RegExp}
 * USER: Detecta los handles de usuario (@)
 *  Busca un @ seguido de una o más letras o números
 * HASHTAG: Detecta los handles de hashtag (#)
 *  Busca un # seguido de una o más letras o números
 * WEB: Detecta los handles de web (www., http://, https://)
 * Esta expresión está formada por cuatro patrones distintos que se unen con un OR (|)
 *  -El primero busca direcciones URL que comiencen con "https" o "http" seguidas de nombre de subdominio opcional y el dominio que puede contener letras, números y guiones y acabe con un . con 2 o mas caracteres
 *  -El segundo busca direcciones URL que comiencen con "https" o "http" seguidas de nombre de dominio que puede contener letras, números y guiones y acabe con un . con 2 o mas caracteres
 *  -El tercero busca direcciones URL que comiencen con "www."  seguidas de un nombre de dominio que puede contener letras, números y guiones, y termina con un punto seguido de una extensión de dominio de al menos dos caracteres.
 *
 */
enum class HandleType(val regex: Regex) {
    USER("@([a-zA-Z0-9_-]+)".toRegex()),
    HASHTAG("#([a-zA-Z0-9_-]+)".toRegex()),
    WEB("(https?://(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.\\S{2,}|https?://(?:www\\.|(?!www))[a-zA-Z0-9]+\\.\\S{2,}|www\\.[a-zA-Z0-9]+\\.\\S{2,})".toRegex())
}

/**
 * Función que detecta los handles de un texto y los devuelve en un array.
 * Realiza un flatmap de los tipos definidos en el enum HandleType
 * @param text {String} Texto a analizar
 * @return {Array} Array con los handles encontrados
 */
fun handleDetector(text: String): List<String> = HandleType.values().flatMap { detectHandles(text, it) }

/**
 * Función que detecta el handle especifico de un texto  y devuelve todas sus coincidencias en un array.
 * @param text {String} Texto a analizar
 * @param type {HandleType} Tipo de handle a buscar
 * @return {Array} Array con los handles encontrados
 */
private fun detectHandles(text: String, type: HandleType): List<String> = type.regex.findAll(text).map { it.value }.toList()


