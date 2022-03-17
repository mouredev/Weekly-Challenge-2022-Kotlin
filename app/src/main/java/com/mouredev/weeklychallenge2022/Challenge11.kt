package com.mouredev.weeklychallenge2022

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
    RemoveCharacterInOtherString("Listos para un nuevo reto de MoureDev", "Este parece que es facil pero siemrpe hay sorpresas")
    RemoveCharacterInOtherString("Mi mama me mima", "Pablito clavo un clavito")
    RemoveCharacterInOtherString("C#, Java, PHP, Kotlin", "Modula2, Basic, Fortran, Cobol")
}

private fun RemoveCharacterInOtherString(str1: String, str2: String) {

    var out1 = ""
    var out2 = ""
    val clearStr1 = str1.lowercase().replace(" ","").toSet()
    val clearStr2 = str2.lowercase().replace(" ","").toSet()

    clearStr1.forEach {
        if (!clearStr2.contains(it))
            out1 += it.toString()
    }

    clearStr2.forEach {
        if (!clearStr1.contains(it))
            out2 += it.toString()
    }

    println("La cadena --> '$str1' se queda reducida a --> '$out1'")
    println("La cadena --> '$str2' se queda reducida a --> '$out2'")
}