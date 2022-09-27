package com.mouredev.weeklychallenge2022

import java.text.SimpleDateFormat
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
    println(ZeldaGame.THE_LEGEND_OF_ZELDA.timeBetweenRelease(ZeldaGame.TEARS_OF_THE_KINGDOM))
    println(ZeldaGame.TEARS_OF_THE_KINGDOM.timeBetweenRelease(ZeldaGame.THE_LEGEND_OF_ZELDA))
    println(ZeldaGame.THE_LEGEND_OF_ZELDA.timeBetweenRelease(ZeldaGame.THE_ADVENTURE_OF_LINK))
    println(ZeldaGame.THE_ADVENTURE_OF_LINK.timeBetweenRelease(ZeldaGame.THE_LEGEND_OF_ZELDA))
    println(ZeldaGame.THE_LEGEND_OF_ZELDA.timeBetweenRelease(ZeldaGame.THE_LEGEND_OF_ZELDA))
    println(ZeldaGame.ORACLE_OF_SEASONS.timeBetweenRelease(ZeldaGame.ORACLE_OF_AGES))
}

enum class ZeldaGame(val title: String) {

    THE_LEGEND_OF_ZELDA("The Legend of Zelda"),
    THE_ADVENTURE_OF_LINK("Zelda II: The Adventure of Link"),
    A_LINK_TO_THE_PAST("The Legend of Zelda: A Link to the Past"),
    LINKS_AWAKENING("The Legend of Zelda: Link's Awakening"),
    OCARINA_OF_TIME("The Legend of Zelda: Ocarina of Time"),
    MAJORAS_MASK("Zelda: Majora's Mask"),
    ORACLE_OF_SEASONS("The Legend of Zelda: Oracle of Seasons"),
    ORACLE_OF_AGES("The Legend of Zelda: Oracle of Ages"),
    FOUR_SWORDS("The Legend of Zelda: Four Swords"),
    THE_WIND_WAKER("The Legend of Zelda: The Wind Waker"),
    FOUR_SWORDS_ADVENTURES("The Legend of Zelda: Four Swords Adventures"),
    THE_MINISH_CUP("The Legend of Zelda: The Minish Cap"),
    TWILIGHT_PRINCES("The Legend of Zelda: Twilight Princess"),
    PHANTHOM_HOURGLASS("The Legend of Zelda: Phantom Hourglass"),
    SPIRIT_TRACKS("The Legend of Zelda: Spirit Tracks"),
    SKYWARD_SWORD("The Legend of Zelda: Skyward Sword"),
    A_LINK_BETWEEN_WORLDS("The Legend of Zelda: A Link Between Worlds"),
    TRI_FORCE_HEROES("The Legend of Zelda: Tri Force Heroes"),
    BREATH_OF_THE_WILD("The Legend of Zelda:  Breath of the Wild"),
    TEARS_OF_THE_KINGDOM("The Legend of Zelda: Tears of the Kingdom");

    private var releaseDate: Date? = null
        get() {
            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            return when (this) {
                THE_LEGEND_OF_ZELDA -> formatter.parse("21/02/1986")
                THE_ADVENTURE_OF_LINK -> formatter.parse("14/01/1987")
                A_LINK_TO_THE_PAST -> formatter.parse("21/11/1991")
                LINKS_AWAKENING -> formatter.parse("06/06/1993")
                OCARINA_OF_TIME -> formatter.parse("21/11/1998")
                MAJORAS_MASK -> formatter.parse("27/04/2000")
                ORACLE_OF_SEASONS, ORACLE_OF_AGES -> formatter.parse("27/02/2001")
                FOUR_SWORDS -> formatter.parse("03/12/2002")
                THE_WIND_WAKER -> formatter.parse("13/12/2002")
                FOUR_SWORDS_ADVENTURES -> formatter.parse("18/03/2004")
                THE_MINISH_CUP -> formatter.parse("04/11/2004")
                TWILIGHT_PRINCES -> formatter.parse("19/11/2006")
                PHANTHOM_HOURGLASS -> formatter.parse("23/06/2007")
                SPIRIT_TRACKS -> formatter.parse("07/12/2009")
                SKYWARD_SWORD -> formatter.parse("18/11/2011")
                A_LINK_BETWEEN_WORLDS -> formatter.parse("23/11/2013")
                TRI_FORCE_HEROES -> formatter.parse("11/10/2015")
                BREATH_OF_THE_WILD -> formatter.parse("03/03/2017")
                TEARS_OF_THE_KINGDOM -> formatter.parse("12/05/2023")
            }
        }

    fun timeBetweenRelease(game: ZeldaGame): String {

        if (this == game) {
            return "Se está intentando comparar el mismo juego"
        }

        this.releaseDate?.let { currentReleaseDate ->
            game.releaseDate?.let { newReleaseDate ->

                val startDate = if (currentReleaseDate < newReleaseDate) currentReleaseDate else newReleaseDate
                val endDate = if (newReleaseDate > currentReleaseDate) newReleaseDate else currentReleaseDate

                val startCalendar = Calendar.getInstance()
                startCalendar.time = startDate
                val startReleaseYear = startCalendar.get(Calendar.YEAR)

                val endCalendar = Calendar.getInstance()
                endCalendar.time = endDate
                val endReleaseYear = endCalendar.get(Calendar.YEAR)

                var years = endReleaseYear - startReleaseYear

                startCalendar.set(Calendar.YEAR, endReleaseYear)

                // Nos encontramos con un día y un mes en la fecha inicial posterior a la final
                if (startCalendar.timeInMillis > endCalendar.timeInMillis) {
                    startCalendar.set(Calendar.YEAR, endReleaseYear - 1)
                    years -= 1
                }

                val startMillis = if (startCalendar.timeInMillis < endCalendar.timeInMillis) startCalendar.timeInMillis else endCalendar.timeInMillis
                val endMillis = if (endCalendar.timeInMillis > startCalendar.timeInMillis) endCalendar.timeInMillis else startCalendar.timeInMillis

                val days =  (endMillis - startMillis) / (60 * 60 * 24 * 1000)

                return "Entre la fecha de lanzamiento de ${this.title} y ${game.title} hay $years años y $days días"
            }

        }

        return "No se ha podido calcular el tiempo entre fechas de lanzamiento"
    }

}