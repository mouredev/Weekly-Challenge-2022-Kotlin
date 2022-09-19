package com.mouredev.weeklychallenge2022

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
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


/**
 * Enumerado que representa los juegos de Zelda con su titulo y su fecha de lanzamiento
 */
enum class ZeldaGame(val title: String, val releaseDate: String) {

    THE_LEGEND_OF_ZELDA("The Legend of Zelda", "21/02/1986"),
    ADVENTURE_OF_LINK("The Adventure of Link", "21/12/1987"),
    A_LINK_TO_THE_PAST("A Link to the Past", "21/11/1991"),
    LINKS_AWAKENING("Link's Awakening", "21/09/1993"),
    OCARINA_OF_TIME("Ocarina of Time", "21/11/1998"),
    MAJORA_MASK("Majora's Mask", "27/02/2000"),
    WIND_WAKER("The Wind Waker", "21/09/2002"),
    FOUR_SWORDS_ADVENTURES("Four Swords Adventures", "21/11/2004"),
    THE_MINISH_CAP("The Minish Cap", "21/11/2004"),
    TWILIGHT_PRINCESS("Twilight Princess", "21/11/2006"),
    PHANTOM_HOURGLASS("Phantom Hourglass", "21/11/2007"),
    SPIRIT_TRACKS("Spirit Tracks", "21/11/2009"),
    SKYWARD_SWORD("Skyward Sword", "20/11/2011"),
    TWILIGHT_PRINCESS_HD("Twilight Princess HD", "04/03/2016"),
    BREATH_OF_THE_WILD("Breath of the Wild", "03/03/2017"),
    AGE_OF_CALAMITY("Age of Calamity", "20/11/2021"),
    TEARS_OF_THE_KINGDOM("Tears of the Kingdom", "12/05/2023");


    fun calculateDaysBetweenGames(game: ZeldaGame): Pair<Int,Int> {
        return Pair(daysBetween(this.releaseDate,game.releaseDate)%365, yearsBetween(this.releaseDate,game.releaseDate))
    }

}


fun main() {

    val diff = ZeldaGame.AGE_OF_CALAMITY.calculateDaysBetweenGames(ZeldaGame.MAJORA_MASK)
    println("La diferencia entre ${ZeldaGame.AGE_OF_CALAMITY.title} y ${ZeldaGame.MAJORA_MASK.title} " +
            "es de  ${diff.second} años y ${diff.first} días")
}


/**
 * Calcula los días que hay entre dos fechas
 * @param date1 fecha 1
 * @param date2 fecha 2
 * @return número de días entre las dos fechas
 * @throws Exception si alguna de las fechas no es correcta
 */
@SuppressLint("SimpleDateFormat")
private fun daysBetween(firstDate: String, secondDate: String): Int {

    val formatter = SimpleDateFormat("dd/MM/yyyy")
    val firstParsedDate = formatter.parse(firstDate)
    val secondParsedDate = formatter.parse(secondDate)

    val regex = "^([0-9]){2}[/]([0-9]){2}[/]([0-9]){4}$".toRegex()

    if (firstParsedDate != null
        && secondParsedDate != null
        && firstDate.contains(regex)
        && secondDate.contains(regex)
    ) {

        return TimeUnit.DAYS.convert(
            firstParsedDate.time - secondParsedDate.time,
            TimeUnit.MILLISECONDS
        ).toInt().absoluteValue
    }
    throw DaysBetweenError()
}

/**
 * Calcula los años que hay entre dos fechas
 * @param date1 fecha 1
 * @param date2 fecha 2
 * @return número de años entre las dos fechas
 *
 */
private fun yearsBetween(firstDate: String, secondDate: String): Int {
    return daysBetween(firstDate, secondDate) / 365
}


