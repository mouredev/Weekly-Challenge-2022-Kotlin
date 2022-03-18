package com.mouredev.weeklychallenge2022

import java.util.*

/*
 * Reto #11
 * ELIMINANDO CARACTERES
 * Fecha publicación enunciado: 14/03/22
 * Fecha publicación resolución: 21/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos cadenas como parámetro (str1, str2) e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO estén presentes en str1.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


fun main() {


    val str1 ="El veloz murciélago hindú comía feliz cardillo y kiwi"
    val str2 ="La cigüeña tocaba el saxofón detrás del palenque de paja"
    removeChars(str1, str2)
}



/** Metodo removeChars
 * Elimina los caracteres que esten en str1 pero no esten en str2 y los caracteres que esten en str2 pero no esten en str1
 * y los imprime por pantalla
 * @param str1: String Cadena de caracteres 1
 * @param str2: String Cadena de caracteres 2
 * @return void
 */

private fun removeChars(str1: String, str2: String) {


    //Hemos de suponer que los caracters mayusculas y minusculas son iguales  Ej : A==a
    //Tambien que los caracteres con acentos o caracteres especiales tambien son iguales (ej: a==á,u==ü)


    val specialChars = mapOf('á' to 'a', 'é' to 'e', 'í' to 'i', 'ó' to 'o', 'ú' to 'u', 'ü' to 'u')



    val out1 = str1.lowercase(Locale.getDefault())
        .removeSpecialChar(specialChars).filterNot {  str2.lowercase(Locale.getDefault())
            .removeSpecialChar(specialChars).contains(it) }
    val out2 = str2.lowercase(Locale.getDefault())
        .removeSpecialChar(specialChars).filterNot {  str1.lowercase(Locale.getDefault())
            .removeSpecialChar(specialChars).contains(it) }

    println("'$str1' -> '$out1'")
    println("'$str2' -> '$out2'")
}



fun String.removeSpecialChar(map:Map<Char,Char>):String {
    var str = this
    map.forEach {
        str = str.replace(it.key, it.value)

    }
    return str


}


