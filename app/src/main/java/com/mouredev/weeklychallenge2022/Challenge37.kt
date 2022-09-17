package com.mouredev.weeklychallenge2022

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.*
import java.time.format.DateTimeFormatter


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



@RequiresApi(Build.VERSION_CODES.O)
fun main(){

    println(timeBetweenZeldaGames(ZELDA_GAMES.A_LINK_BETWEEN_WORLDS, ZELDA_GAMES.A_LINK_TO_THE_PAST))

    println(timeBetweenZeldaGames(ZELDA_GAMES.MAJORAS_MASK_3D, ZELDA_GAMES.TRI_FORCE_HEROES))

}



@RequiresApi(Build.VERSION_CODES.O)
enum class ZELDA_GAMES( val dateOfRelease: LocalDate){


    LEGEND_OF_ZELDA( LocalDate.of(1986,Month.FEBRUARY,21)),
    THE_ADVENTURE_OF_LINK( LocalDate.of(1987,Month.JANUARY,14)),
    A_LINK_TO_THE_PAST( LocalDate.of(1991,Month.NOVEMBER,21)),
    LINKS_AWAKENING( LocalDate.of(1993,Month.JANUARY,6)),
    OCARINA_OF_TIME( LocalDate.of(1998,Month.NOVEMBER,21)),
    LINKS_AWAKENING_DX( LocalDate.of(1998,Month.JANUARY,6)),
    MAJORAS_MASK( LocalDate.of(2000,Month.APRIL,27)),
    ORACLE_OF_SEASONS_AND_ORACLE_OF_AGES( LocalDate.of(2001,Month.FEBRUARY,27)),
    FOUR_SWORDS( LocalDate.of(2002,Month.DECEMBER,2)),
    THE_WIND_WAKER( LocalDate.of(2002,Month.DECEMBER,13)),
    FOUR_SWORDS_ADVENTURES( LocalDate.of(2004,Month.MARCH,18,)),
    THE_MINISH_CAP( LocalDate.of(2004,Month.NOVEMBER,4)),
    TWILLIGHT_PRINCESS( LocalDate.of(2006,Month.NOVEMBER,19)),
    PHANTOM_HOURGLASS( LocalDate.of(2007,Month.JUNE,23)),
    SPIRIT_TRACKS( LocalDate.of(2009,Month.DECEMBER,7)),
    OCARINA_OF_TIME_3D( LocalDate.of(2011,Month.JUNE,16)),
    SKYWARD_SWORD( LocalDate.of(2011,Month.NOVEMBER,18)),
    THE_WIND_WAKER_HD( LocalDate.of(2013,Month.SEPTEMBER,20)),
    A_LINK_BETWEEN_WORLDS( LocalDate.of(2013,Month.NOVEMBER,22)),
    MAJORAS_MASK_3D( LocalDate.of(2015,Month.FEBRUARY,13)),
    TRI_FORCE_HEROES( LocalDate.of(2015,Month.OCTOBER,22)),
    TWILLIGHT_PRINCESS_HD( LocalDate.of(2016,Month.MARCH,4)),
    BREATH_OF_THE_WILD( LocalDate.of(2017,Month.MARCH,3)),
    SKYWARD_SWORD_HD( LocalDate.of(2021,Month.JULY,16)),
    TEARS_OF_THE_KINGDOM( LocalDate.of(2023,Month.MAY,12)),

}

@RequiresApi(Build.VERSION_CODES.O)
fun  timeBetweenZeldaGames(game1: ZELDA_GAMES, game2: ZELDA_GAMES): String {

    var period :Period
    if(game1.dateOfRelease.isAfter(game2.dateOfRelease)){
        period= Period.between(game2.dateOfRelease,game1.dateOfRelease)
    } else {
       period =  Period.between(game1.dateOfRelease,game2.dateOfRelease)
    }
        return "Years:" + period.getYears() +
                " days:"+( period.getMonths()*30+period.getDays())
}