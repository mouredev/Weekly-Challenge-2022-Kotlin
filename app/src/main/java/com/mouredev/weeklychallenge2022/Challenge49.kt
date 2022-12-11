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

fun main(){
    println(matchHandles("www.linkedin.es #hashtag  @Martha"))
    println(matchHandles("xww.linkedin.es hashtag  @Martha"))
    println(matchHandles("http://www.linkedin.es #hashtag  @Martha"))
    println(matchHandles("https://www.linkedin.es #ha_45htag"))
    println(matchHandles("www.linkedin @Barry"))
}

private fun matchHandles(text:String):List<String> {
    var handlesList = arrayListOf<String>()
    val hashtagHandle = Regex("#\\w+")
    val userHandle = Regex("@\\w+")
    val webHandle = Regex("(((http|https)://.)|(www.))[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)")

    val patternList = arrayListOf(hashtagHandle, userHandle,webHandle)

    patternList.forEach { pattern->
        val found=pattern.findAll(text)
        found.forEach { match->
            handlesList.add(match.value)
        }

    }
    return handlesList
}


