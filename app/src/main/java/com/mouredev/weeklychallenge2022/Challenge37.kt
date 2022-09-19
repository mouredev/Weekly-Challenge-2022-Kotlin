package com.mouredev.weeklychallenge2022

import java.util.*

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

    val milliseconds = timeBetweenGames(
        "The Legend of Zelda: Ocarina of Time",
        "The Legend of Zelda: Breath of the Wild"
    )
    println(
        "Diferencia es: " + (getDays(milliseconds) / 365) + " años y días: " + (getDays(milliseconds) % 365)
    )
}

val allGames = hashMapOf(
    "The Legend of Zelda: Ocarina of Time" to Date(1986, 2, 21),
    "Zelda II: The Adventure of Link" to Date(1987, 1, 14),
    "The Legend of Zelda: A Link to the Past" to Date(1991, 11, 21),
    "The Legend of Zelda: Link's Awakening" to Date(1993, 9, 20),
    "The Legend of Zelda: Ocarina of Time" to Date(1998, 11, 21),
    "The Legend of Zelda: Majora's Mask" to Date(2000, 4, 27),
    "The Legend of Zelda: Oracle of Seasons y Oracle of Ages" to Date(2001, 2, 27),
    "The Legend of Zelda: The Wind Waker" to Date(2002, 12, 13),
    "The Legend of Zelda: A Link to the Past#Four Swords" to Date(2003, 3, 14),
    "The Legend of Zelda: Four Swords Adventures" to Date(2004, 3, 18),
    "The Legend of Zelda: The Minish Cap" to Date(2004, 11, 4),
    "The Legend of Zelda: Twilight Princess" to Date(2006, 12, 2),
    "The Legend of Zelda: Phantom Hourglass" to Date(2007, 6, 23),
    "The Legend of Zelda: Spirit Tracks" to Date(2009, 12, 23),
    "The Legend of Zelda: Skyward Sword" to Date(2011, 11, 23),
    "The Legend of Zelda: A Link Between Worlds" to Date(2013, 12, 26),
    "The Legend of Zelda: Tri Force Heroes" to Date(2015, 9, 22),
    "The Legend of Zelda: Breath of the Wild" to Date(2017, 3, 3),
)

fun timeBetweenGames(game1: String, game2: String): Long {
    var date1 = getDate(game1)
    var date2 = getDate(game2)

    if (date2!! > date1) {
        val aux = date1
        date1 = date2
        date2 = aux
    }

    return date1?.time!! - date2?.time!!
}

fun getDate(game: String): Date? {
    return allGames[game]
}

fun getDays(miliseconds: Long): Int {
    return ((miliseconds / (1000 * 60 * 60 * 24)).toInt())
}

