package com.mouredev.weeklychallenge2022

import java.util.*

/*
 * Reto #12
 * ¿ES UN PALÍNDROMO?
 * Fecha publicación enunciado: 21/03/22
 * Fecha publicación resolución: 28/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba un texto y retorne verdadero o falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */




/**
 * Funcion main que ejecuta el programa
 */
fun main(){

    println(isPalindrome("Ana lleva al oso la avellana."))
    println(isPalindrome("Eva se lame mal, es ave."))
    println(isPalindrome("Hecha al revés, o no hay ojo ya, o no sé ver la hache"))
    println(isPalindrome("Isaac no ronca así."))
    println(isPalindrome("No lata, no: la totalidad arada dilato talón a talón"))
    println(isPalindrome("¿Son robos o sobornos?"))
    println(isPalindrome("a1001a"))

}

/**
 * Función que recibe un cadena de texto y develve true o falso si es o no un palíndromos.
 * @param text : Cadena de texto
 * return : Boolean (true si es palíndromo, false si no lo es)
 */
fun isPalindrome(text: String): Boolean {
    val str = text.removeSpecialChar()
    for (i in 0 until str.length / 2) {
        if (str[i] != str[str.length - i - 1]) {
            return false
        }
    }

    return true

}


/**
 * Funcion de extensión que elimina los caracteres especiales de la propia cadena de texto
 * Primero elimina los acentos usando un mapa y sobre la cadena resultante aplica una expresión regular que elimina los
 * carecteres especiales y los espacios en blanco.
 * @see Map
 * @return Cadena de texto sin caracteres especiales y espacios en blanco
 */
fun String.removeSpecialChar():String {

    val specialChars = mapOf('á' to 'a', 'é' to 'e', 'í' to 'i', 'ó' to 'o', 'ú' to 'u', 'ü' to 'u')
    var str = this.lowercase(Locale.getDefault())

    str.forEach {
        if(specialChars.containsKey(it)){
            str = str.replace (it,specialChars.getValue(it))
        }
    }

    return str.replace("[^a-zA-Z0-9]".toRegex(), "")



}

