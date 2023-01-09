package com.mouredev.weeklychallenge2022

import java.util.*
import kotlin.collections.ArrayList

/*
 * Reto #31
 * AÑOS BISIESTOS
 * Fecha publicación enunciado: 01/08/22
 * Fecha publicación resolución: 08/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que imprima los 30 próximos años bisiestos siguientes a uno dado.
 * - Utiliza el menor número de líneas para resolver el ejercicio.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
fun main() {
    println(whitCalendar(2020))
    println(classic(2020))
    println(whitCalendar(2050))
    println(classic(2050))
}

private fun whitCalendar(year: Int): ArrayList<String> {
    val results = arrayListOf<String>()
    val cal = Calendar.getInstance()
    cal.set(Calendar.YEAR, year)
    for (i in 0..30) {
        if (cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365) {
            results.add(cal.get(Calendar.YEAR).toString())
        }
        cal.add(Calendar.YEAR, 1)
    }
    return results
}
private fun classic(year: Int): ArrayList<Int> {
    val results = arrayListOf<Int>()
    for (i in year..year+30) {
        if(i % 4 == 0){
            results.add(i)
        }
    }
    return results
}
fun mainOtro() {
    thirtyLeapYears(1999)
    thirtyLeapYears(-500)
}

private fun thirtyLeapYears(year: Int) {

    var currentYear = year + 1
    var yearCount = 0

    while (yearCount < 30) {

        if (currentYear % 4 == 0 && (currentYear % 100 != 0 || currentYear % 400 == 0)) {
            println(currentYear)
            yearCount++
        }

        currentYear++
    }
}