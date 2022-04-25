package com.mouredev.weeklychallenge2022

import java.util.*

/*
 * Reto #16
 * EN MAYÚSCULA
 * Fecha publicación enunciado: 18/04/22
 * Fecha publicación resolución: 25/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *

 */

fun main() {

    var string1 = "crea una función que reciba un String de cualquier tipo y se encargue de poner en mayúscula la primera letra de cada palabra.no se pueden utilizar operaciones del lenguaje que lo resuelvan directamente"
    println(toUpCase(string1))
    string1 = "¿no se me , ocurre 9df"
    println(toUpCase(string1))
    string1 = "¿'/!ahora si empiezo"
    println(toUpCase(string1))
    string1 = ""
    println(toUpCase(string1))


}


fun toUpCase (string: String): String {
    val reg ="""[^\w]""".toRegex() //lo que no es 0-9 a-z A-Z
    var stringTemp=""

    //con stringtokenizer
    val st = StringTokenizer(string)
    while (st.hasMoreTokens()) {
        val t=st.nextToken()
        var cont=0
        do {
            cont++
        }while (t.substring(cont-1,cont).contains(reg) && cont<t.length)

        var ant : String
        var may = ""
        var min = ""
        if (t.length>1){
            ant = t.substring(0, cont-1)
            may = t.substring(cont-1,cont).uppercase()
            min = t.substring(cont,t.length)
        }else{
            ant = t.substring(0, cont)
        }

        stringTemp += "$ant$may$min "
    }

    return stringTemp
}

