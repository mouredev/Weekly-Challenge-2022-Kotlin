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

 */

import java.util.*

import java.text.*

import kotlin.math.abs

val format = SimpleDateFormat("dd/MM/yyyy")

fun main() {

    println("Ingrese 2 fechas (dd/MM/yyyy): ")

    val fechas = Array(2) {readln()}

    val offset = compareDays(fechas[0], fechas[1])

    println("Hay una diferencia de $offset dias entre ${fechas[0]} y ${fechas[1]}")

}

private fun compareDays(date1: String, date2: String): Int{

    if(isValidDate(date1.replace(" ", "")) && isValidDate(date2.replace(" ", ""))){

        val calendar1 = Calendar.getInstance()

        val calendar2 = Calendar.getInstance()

        calendar1.time = format.parse(date1)

        calendar2.time = format.parse(date2)

        var difference = calendar2.timeInMillis - calendar1.timeInMillis

        

        return (abs(difference) / (1000 * 60 * 60 * 24)).toInt()

    } else {

        throw InvalidDateException("$date1 o $date2 no son una fecha")

    }

}

private fun isValidDate(date: String): Boolean {

    try{

        val calendar = Calendar.getInstance()

        val mDate = format.parse(date) //soltará una excepción si no es una fecha

        val partitionedDate = Array(3) {0}

        var n = 0; var digitedDate = ""

        for(char in date){

            if(char in '0'..'9' || char == '-'){

                digitedDate += char.toString()

            } else {

                partitionedDate[n] = digitedDate.toInt()

                digitedDate = ""

                n += 1

            }

        } /*ara checar si cada una de las partes de la fecha estan correctas (si los días están dentro del rango del mes
        si los meses están del 1 al 12 y si los años están entre 1 y el máximo de la máquina. No reconoce eras)*/

        if(digitedDate != "") partitionedDate[n] = digitedDate.toInt() 

        if(!partitionedDate[0].isInRange(1..calendar.getActualMaximum(Calendar.DAY_OF_MONTH))){

            return false

        } else if(!partitionedDate[1].isInRange(1..12)) return false

        else if(!partitionedDate[2].isInRange(1..calendar.getActualMaximum(Calendar.YEAR))) return false

        return true

    } catch(e: ParseException) {

        return false

    }

    

}

private fun Int.isInRange(range: IntRange): Boolean = if(this in range) true else false

 

class InvalidDateException(msg: String) : RuntimeException(msg){}
