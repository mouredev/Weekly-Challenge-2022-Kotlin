package com.mouredev.weeklychallenge2022

import es.jaimefere.weeklychallenge2022.daysInterval
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.ceil

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
 * https://en.wikipedia.org/wiki/List_of_The_Legend_of_Zelda_media
 *
 */

private enum class ZeldaEdition(val releaseDate: String) {
    THE_LEGEND_OF_ZELDA("21/02/1986"),
    THE_ADVENTURE_OF_LINK("14/01/1987"),
    A_LINK_TO_THE_PAST("21/11/1991"),
    LINKS_AWAKENING("06/06/1993"),
    OCARINA_OF_TIME("21/11/1998"),
    MEJORAS_MASK("27/04/2000"),
    ORACLE_OF_SEASONS("27/02/2001"),
    ORACLE_OF_AGES("27/02/2001"),
    A_LINK_TO_THE_PAST_AND_FOUR_SWORDS("03/12/2002"),
    THE_WIND_WAKER("03/12/2002"),
    FOUR_SWORDS_ADVENTURES("18/03/2004"),
    THE_MINISH_CAP("04/11/2004"),
    TWILIGHT_PRINCESS("19/11/2006"),
    PHANTOM_HOURGLASS("23/06/2007"),
    SPIRIT_TRACKS("07/12/2009"),
    SKYWORD_SWORD("18/11/2011"),
    A_LINK_BETWEEN_WORLDS("22/11/2013"),
    TRI_FORCE_HEROES("22/11/2015"),
    BREATH_OF_THE_WILD("03/03/2017"),
    TEARS_OF_THE_KINGDOM("12/05/2023");

    companion object {
        fun name(obj: ZeldaEdition): String {
            return when (obj) {
                THE_LEGEND_OF_ZELDA -> "The Legend of Zelda"
                THE_ADVENTURE_OF_LINK -> "The Adventure of Link"
                A_LINK_TO_THE_PAST -> "A Link to the Past"
                LINKS_AWAKENING -> "Link's Awakening"
                OCARINA_OF_TIME -> "Ocarina of Time"
                MEJORAS_MASK -> "Majora's Mask"
                ORACLE_OF_SEASONS -> "Oracle of Seasons"
                ORACLE_OF_AGES -> "Oracle of Ages"
                A_LINK_TO_THE_PAST_AND_FOUR_SWORDS -> "A Link to the Past & Four Swords"
                THE_WIND_WAKER -> "The Wind Waker"
                FOUR_SWORDS_ADVENTURES -> "Four Swords Adventures"
                THE_MINISH_CAP -> "The Minish Cap"
                TWILIGHT_PRINCESS -> "Twilight Princess"
                PHANTOM_HOURGLASS -> "Phantom Hourglass"
                SPIRIT_TRACKS -> "Spirit Tracks"
                SKYWORD_SWORD -> "Skyward Sword"
                A_LINK_BETWEEN_WORLDS -> "A Link Between Worlds"
                TRI_FORCE_HEROES -> "Tri Force Heroes"
                BREATH_OF_THE_WILD -> "Breath of the Wild"
                TEARS_OF_THE_KINGDOM -> "Tears of the Kingdom"
            }
        }
    }
}

private fun timeBetweenZeldaEditions(anEdition: ZeldaEdition, otherEdition: ZeldaEdition): String {
    // Implemented in Challenge #15
    val days = daysInterval(anEdition.releaseDate, otherEdition.releaseDate)
    val years = ceil(days / 365.0).toInt()
    return "$years años y ${days % 365} días de diferencia entre el lanzamiento de '${ZeldaEdition.name(anEdition)}' y '${ZeldaEdition.name(otherEdition)}'"
}

fun main() {
    println(timeBetweenZeldaEditions(ZeldaEdition.THE_LEGEND_OF_ZELDA, ZeldaEdition.TEARS_OF_THE_KINGDOM))
}