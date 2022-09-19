@file:RequiresApi(Build.VERSION_CODES.O)

package com.mouredev.weeklychallenge2022

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period
import kotlin.math.absoluteValue

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
    println(calculateTime(mapZeldaGames.entries.elementAt(2), mapZeldaGames.entries.elementAt(3)))
    println(calculateTime(mapZeldaGames.entries.elementAt(6), mapZeldaGames.entries.elementAt(4)))
    println(calculateTime(mapZeldaGames.entries.elementAt(0), mapZeldaGames.entries.elementAt(8)))
    println(
        calculateTime(
            mapZeldaGames.entries.elementAt((0 until mapZeldaGames.size).random()),
            mapZeldaGames.entries.elementAt((0 until mapZeldaGames.size).random())
        )
    )
}

private val mapZeldaGames = mapOf(
    "The Legend of Zelda: A Link to the Past" to LocalDate.of(1992, 9, 24),
    "The Legend of Zelda: Link's Awakening" to LocalDate.of(1993, 12, 1),
    "The Legend of Zelda: Ocarina of Time" to LocalDate.of(1998, 11, 21),
    "The Legend of Zelda: Majora's Mask" to LocalDate.of(2000, 11, 17),
    "The Legend of Zelda: The Wind Waker" to LocalDate.of(2003, 5, 2),
    "The Legend of Zelda: Twilight Princess" to LocalDate.of(2006, 12, 8),
    "The Legend of Zelda: A Link Between Worlds" to LocalDate.of(2013, 11, 22),
    "The Legend of Zelda: Breath of the Wild" to LocalDate.of(2017, 3, 3),
    "The Legend of Zelda: Tears of the Kingdom" to LocalDate.of(2023, 5, 12),
)

private fun calculateTime(
    gameOne: Map.Entry<String, LocalDate>,
    gameTwo: Map.Entry<String, LocalDate>
): String {
    return "The difference between ${gameOne.key} and ${gameTwo.key} is " +
            "${Period.between(gameOne.value, gameTwo.value).years.absoluteValue} years, " +
            "${Period.between(gameOne.value, gameTwo.value).months.absoluteValue} months and " +
            "${Period.between(gameOne.value, gameTwo.value).days.absoluteValue} days."
}