package com.mouredev.weeklychallenge2022

import kotlin.math.absoluteValue
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.concurrent.TimeUnit

/*
 * Reto #37
 * LOS LANZAMIENTOS DE "THE LEGEND OF ZELDA"
 * Fecha publicación enunciado: 14/09/22
 * Fecha publicación resolución: 19/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡Han anunciado un nuevo "The Legend of Zelda"! Se llamará "Tears of the Kingdom"
 * y se lanzará el 12 de mayo de 2023.
 * Pero, ¿recuerdas cuánto tiempo ha pasado entre los distintos "The Legend of Zelda" de la historia?
 * Crea un programa que calcule cuántos años y días hay entre 2 juegos de Zelda que tú selecciones.
 * - Debes buscar cada uno de los títulos y su día de lanzamiento (si no encuentras el día exacto
 *   puedes usar el mes, o incluso inventártelo)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
  var date1 = Zelda.a_link_to_the_past.date
  val date2 = Zelda.ocarina_of_time.date

  println(days_between(date1, date2))
}

enum class Zelda(val date:LocalDate){
  ocarina_of_time (LocalDate.of(1998,12,11)),
  majora_mask (LocalDate.of(2000,11,17)),
  a_link_to_the_past (LocalDate.of(2003,3,24))
}


fun days_between(date1: LocalDate, date2: LocalDate):Int{
  val formatter = SimpleDateFormat("yyyy-MM-dd")
  val firstParsedDate = formatter.parse(date1.toString())
  val secondParsedDate = formatter.parse(date2.toString())

  return TimeUnit.DAYS.convert(
      firstParsedDate.time - secondParsedDate.time,
      TimeUnit.MILLISECONDS
  ).toInt().absoluteValue

}