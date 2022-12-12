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

fun main (){
    println( getHandleListFrom( "@ ad@saf @firulais @gsar$-sad #gatoVerde " +
            "asf# www.perros.woff htp://algo.com 3- asf www.perros.wof http://algo.com https://otracosa.mmm ") )
}

private fun getHandleListFrom( inputText : String ) : List<String>{

    val handleList = mutableListOf<String>()

    val userHandlePatter = Regex("^(@)\\w+")
    val hashtagHandlePatter = Regex("^(#)\\w+")
    val webHandlePatter = Regex("^((www.)|(http[s]?://))\\w+(.\\w{2,3})\$")

    val segmentedInput = inputText.split(" ")

    fun findHandler( evaluationPatter : Regex , title : String) {
        handleList.add(title)
        segmentedInput.forEach{
            if (it.matches(evaluationPatter)){
                handleList.add(it)
            }
        }
    }

    findHandler(userHandlePatter, "~User(s)~")
    findHandler(hashtagHandlePatter ,"~Hashtag(s)~")
    findHandler(webHandlePatter, "~Web(s)~")

    return handleList
}



