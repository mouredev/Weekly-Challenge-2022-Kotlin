package com.mouredev.weeklychallenge2022

import java.io.IOException


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

fun Int.isLeapYear(): Boolean = this % 4 == 0 && ((this % 100 == 0 && this % 400 == 0) || this % 100 != 0)

fun Int.daysInYear() = if (this.isLeapYear()) 366 else 365

fun Int.monthDays(year: Int): Int = when (this) {
    2 -> if(year.isLeapYear()) 29 else 28
    1,3,5,7,8,10,12 -> 31
    else -> 30
}

fun Int.between(from:Int, to:Int): Boolean = this in from..to

@Throws(IOException::class)
fun String.isDate(): Boolean{
    val thisParts = this.split("/")

    if(thisParts.size == 3){
        val day = thisParts[0].toInt()
        val month = thisParts[1].toInt()
        val year = thisParts[2].toInt()
        val returnValue = year >= 0 && month.between(1,12) && day.between(1, month.monthDays(year))
        if (returnValue)
            return  returnValue
        else
            throw  IOException("$this NO es una fecha válida (No cumple alguno de los criterios: rangos de días por mes, mes por año, año positivo)")
    }else {
        throw IOException("$this NO es una fecha válida (Formato incorrecto)")
    }
}

fun String.daysFromZero(): Int{
    if (this.isDate()){
        val dateParts = this.split("/")
        val year = dateParts[2].toInt()
        val month = dateParts[1].toInt()
        val days = dateParts[0].toInt()

        val yearRange = IntRange(0, year)
        val monthRange = IntRange(1, month)

        // Se establece toInt en sumOf para evitar ambigüedad
        var totalDays: Int = yearRange.sumOf { y -> y.daysInYear() }

        // tenemos el total de días entre el año 0 y el año de la fecha...
        // ahora, hay que restar los días que llevamos consumidos del año...
        totalDays -= (year.daysInYear () - monthRange.sumOf { m -> m.monthDays(year) } +
                (month.monthDays(year) - days) + 1)

        return totalDays
    }

    return 0
}

@Throws(IOException::class)
fun String.diffDays(other: String): Int{
    if (this.isDate() && other.isDate()){
        val returnValue = other.daysFromZero() - this.daysFromZero()

        if (returnValue > 0)
            return returnValue
        else
            throw IOException("La fecha superior ($other) NO puede ser menor que la inferior ($this)")
    }

    return -1
}

