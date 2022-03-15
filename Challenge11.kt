package com.example.weeklychallenge2022

import java.sql.Array

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

/*
*
 */

fun main() {
    val expres1 = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme..."
    val expres2 = "La heroica ciudad dormía la siesta. El viento Sur, caliente y perezoso ..."
    removal(expres1,expres2)
}


private fun removal (str1: String, str2:String) {
    var out1 = str1
    var out2 = str2

    str2.forEach { character->
        out1=out1.replace( character.toString(), "", true)
    }
    str1.forEach { character->
        out2= out2.replace(character.toString(), "", true)
    }
    println(out1)
    println(out2)

}


