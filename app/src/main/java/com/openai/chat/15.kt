package com.openai.chat

import es.jaimefere.weeklychallenge2022.daysInterval
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/*
 * Reto #15
 * ¿CUÁNTOS DÍAS?
 * Fecha publicación enunciado: 11/04/22
 * Fecha publicación resolución: 18/04/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función en Kotlin que calcule y retorne cuántos días hay entre dos cadenas de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se lanzará una excepción.
 *
 * Resuelto: No. No detecta algunas fechas erróneas.
 * Iteracciones: 3
 * Explicación: Para calcular la diferencia en días entre dos fechas en Kotlin, primero debes parsear las cadenas de texto a objetos Date usando un SimpleDateFormat.
 * Luego, puedes calcular la diferencia en milisegundos entre ambas fechas y dividir el resultado por el número de milisegundos en un día (86400000) para obtener el resultado en días.
 * Esta función parseará las fechas a objetos Date usando el formato "dd/MM/yyyy" y luego calculará la diferencia en milisegundos entre ambas fechas. Finalmente, dividirá el resultado en milisegundos
 * entre el número de milisegundos en un día (86400000) para obtener el resultado en días y lo retornará como un entero.

Es importante tener en cuenta que esta función lanzará una excepción ParseException si alguna de las dos cadenas de texto no representa una fecha correcta. Por lo tanto, es recomendable manejar esta excepción y lanzar una excepción personalizada en su lugar si es necesario.
 * Conversación:
 * - Ponme ejemplos de prueba, alguno de ellos con fecha errónea
 * - Si pruebo con daysBetween("16/04/2022", "16/13/2022") el mes de la segunda fecha es erróneo pero no captura la excepción
 * - Sigue sin resolverlo, el mensaje "El mes o el año de la fecha 2 son inválidos" nunca se muestra para el caso daysBetween("16/04/2022", "16/13/2022") o el caso daysBetween("16/04/2022", "32/04/2022")
 *
 */
class InvalidDateException(message: String): Exception(message)

fun daysBetween(date1: String, date2: String): Int {
    try {
        // Parsear las fechas a objetos Calendar
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val calendar1 = Calendar.getInstance()
        calendar1.time = dateFormat.parse(date1)
        val calendar2 = Calendar.getInstance()
        calendar2.time = dateFormat.parse(date2)

        // Comprobar que el mes y el año de cada fecha son válidos
        if (calendar1.get(Calendar.MONTH) < 0 || calendar1.get(Calendar.MONTH) > 11 ||
            calendar1.get(Calendar.YEAR) <= 0) {
            throw InvalidDateException("El mes o el año de la fecha 1 son inválidos")
        }
        if (calendar2.get(Calendar.MONTH) < 0 || calendar2.get(Calendar.MONTH) > 11 ||
            calendar2.get(Calendar.YEAR) <= 0) {
            throw InvalidDateException("El mes o el año de la fecha 2 son inválidos")
        }

        // Calcular la diferencia en milisegundos entre ambas fechas
        val diffInMilliseconds = Math.abs(calendar1.timeInMillis - calendar2.timeInMillis)

        // Dividir la diferencia en milisegundos entre el número de milisegundos en un día
        // para obtener el resultado en días
        return (diffInMilliseconds / 86400000).toInt()
    } catch (e: ParseException) {
        // Lanzar una excepción personalizada si se produce un error al parsear las fechas
        throw InvalidDateException("La fecha especificada no tiene el formato correcto")
    }
}

fun main() {
    try {
        // Ejemplo 1: Diferencia de 3 días entre el 1 de enero de 2020 y el 4 de enero de 2020
        val result = daysBetween("01/01/2020", "04/01/2020")
        println("Resultado: $result días")
    } catch (e: InvalidDateException) {
        println("Error: ${e.message}")
    }
    try {
        // Ejemplo 2: Cadena de texto con formato incorrecto (lanzará una excepción InvalidDateException)
        val result = daysBetween("01-01-2020", "01/01/2020")
        println("Resultado: $result días")
    } catch (e: InvalidDateException) {
        println("Error: ${e.message}")
    }

    // Brais cases
    println(try { daysBetween("18/05/2022", "29/05/2022") } catch(e: InvalidDateException) { "Error: ${e.message}" })   // 10
    println(try { daysBetween("mouredev", "29/04/2022") } catch(e: InvalidDateException) { "Error: ${e.message}" })     // Error en el parse de alguna fecha
    println(try { daysBetween("18/5/2022", "29/04/2022") } catch(e: InvalidDateException) { "Error: ${e.message}" })    // 19

    // Jaime cases
    println(try { daysBetween("16/04/2022", "16-04-2022") } catch(e: InvalidDateException) { "Error: ${e.message}" })   // java.text.ParseException: Unparseable date: "16-04-2022"
    println(try { daysBetween("16/04/2022", "16/13/2022") } catch(e: InvalidDateException) { "Error: ${e.message}" })   // java.text.ParseException: Unparseable date: "16/13/2022"
    println(try { daysBetween("16/04/2022", "32/04/2022") } catch(e: InvalidDateException) { "Error: ${e.message}" })   // java.text.ParseException: Unparseable date: "32/04/2022"
    println(try { daysBetween("16/04/2022", "17/04/2022") } catch(e: InvalidDateException) { "Error: ${e.message}" })   // 1
    println(try { daysBetween("17/04/2022", "16/04/2022") } catch(e: InvalidDateException) { "Error: ${e.message}" })   // 1
    println(try { daysBetween("17/04/2022", "16/04/2023") } catch(e: InvalidDateException) { "Error: ${e.message}" })   // 364
}

