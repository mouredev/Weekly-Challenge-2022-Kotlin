package com.mouredev.weeklychallenge2022

import java.text.DateFormat
import java.text.ParseException
import java.util.*

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
 * - Retos obtenidos de https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
 *
 */

var df: DateFormat = DateFormat.getDateInstance(DateFormat.SHORT)
var dias = 0

fun main(args: Array<String>) {
    println(calcularDias("20/06/2003", "20/06/2002"))
    println(calcularDias("20-06-2003", "20-06-2002"))
}

fun calcularDias(f1: String, f2: String): Int {
    try {
        df.parse(f1)
        df.parse(f2)

        val s1 = f1.indexOf("/")
        val s2 = f1.lastIndexOf("/")

        var dia = f1.substring(0, s1).toInt()
        var mes = f1.substring(s1 + 1, s2).toInt()
        var año = f1.substring(s2 + 1).toInt()

        val gc1 = GregorianCalendar(año, mes - 1, dia)

        dia = f2.substring(0, s1).toInt()
        mes = f2.substring(s1 + 1, s2).toInt()
        año = f2.substring(s2 + 1).toInt()

        val gc2 = GregorianCalendar(año, mes - 1, dia)
        dias = ((gc1.getTimeInMillis() - gc2.getTimeInMillis()) / (24 * 3600 * 1000)).toInt()
    } catch (ex: ParseException) {
        throw IllegalArgumentException("Entrada inválida, la fecha debe tener el siguiente formato: \"dd/MM/yyyy\"")
    }

    return if (dias < 0) -dias else dias
}