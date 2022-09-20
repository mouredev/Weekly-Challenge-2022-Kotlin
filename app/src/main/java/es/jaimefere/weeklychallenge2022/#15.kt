package es.jaimefere.weeklychallenge2022

import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat
import kotlin.math.abs

/*
 * Reto #15
 * ¿CUÁNTOS DÍAS?
 * Fecha publicación enunciado: 11/04/22
 * Fecha publicación resolución: 18/04/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que calcule y retorne cuántos días hay entre dos cadenas de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println(daysInterval("16/04/2022", "16-04-2022"))
    println(daysInterval("16/04/2022", "16/13/2022"))
    println(daysInterval("16/04/2022", "32/04/2022"))
    println(daysInterval("16/04/2022", "17/04/2022"))
    println(daysInterval("17/04/2022", "16/04/2022"))
    println(daysInterval("17/04/2022", "16/04/2023"))
}

fun daysInterval(dateText1: String, dateText2: String): Int {
    val dayMillis = 1000 * 60 * 60 * 24
    var days = -1
    val dateFormat = SimpleDateFormat("dd/MM/yyyy")
    dateFormat.isLenient = false
    try {
        val date1 = dateFormat.parse(dateText1)
        val date2 = dateFormat.parse(dateText2)
        days = abs((date1.time - date2.time) / dayMillis).toInt()
    } catch (pe: ParseException) {
        println(pe)
    }
    return days
}
