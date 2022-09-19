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
 * Clase que representa un juego de Zelda y su fecha de lanzamiento
 */
export class Zelda{
    constructor(public name:ZeldaGame, public date:Date){}
}

/**
 * Enumerado con los nombres de los juegos de Zelda
 */
export enum ZeldaGame{
    THE_LEGEND_OF_ZELDA = "The Legend of Zelda",
    THE_ADVENTURE_OF_LINK ="The Adventure of Link",
    A_LINK_TO_THE_PAST = "A Link to the Past",
    LINKS_AWAKENING = "Link's Awakening",
    OCARINA_OF_TIME = "Ocarina of Time",
    MAJORA_S_MASK = "Majora's Mask",
    THE_WIND_WAKER = "The Wind Waker",
    FOUR_SWORDS_ADVENTURES = "Four Swords Adventures",
    THE_MINISH_CAP = "The Minish Cap",
    TWILIGHT_PRINCESS = "Twilight Princess",
    PHANTOM_HOURGLASS = "Phantom Hourglass",
    SPIRIT_TRACKS = "Spirit Tracks",
    SKYWARD_SWORD = "Skyward Sword",
    THE_LEGEND_OF_ZELDA_2 = "The Legend of Zelda 2",
    THE_WIND_WAKER_2 = "The Wind Waker 2",
    TWILIGHT_PRINCESS_2 = "Twilight Princess 2",
    BREATH_OF_THE_WILD = "Breath of the Wild",
    TEARS_OF_THE_KINGDOM = "Tears of the Kingdom"
}


/**
 * Objecto que contienen los juegos de zelda y sus fechas de lanzamiento
 */
export const zeldaGames:Zelda[] =
[

    {name: ZeldaGame.THE_LEGEND_OF_ZELDA, date: new Date(1987, 7, 22)},
    {name: ZeldaGame.THE_ADVENTURE_OF_LINK, date: new Date(1987, 2, 21)},
    {name: ZeldaGame.A_LINK_TO_THE_PAST, date: new Date(1991, 2, 21)},
    {name: ZeldaGame.LINKS_AWAKENING, date: new Date(1993, 9, 21)},
    {name: ZeldaGame.OCARINA_OF_TIME, date: new Date(1998, 11, 21)},
    {name: ZeldaGame.MAJORA_S_MASK, date: new Date(2000, 5, 21)},
    {name: ZeldaGame.THE_WIND_WAKER, date: new Date(2002, 9, 21)},
    {name: ZeldaGame.FOUR_SWORDS_ADVENTURES, date: new Date(2004, 5, 21)},
    {name: ZeldaGame.THE_MINISH_CAP, date: new Date(2004, 11, 21)},
    {name: ZeldaGame.TWILIGHT_PRINCESS, date: new Date(2006, 11, 21)},
    {name: ZeldaGame.PHANTOM_HOURGLASS, date: new Date(2007, 5, 21)},
    {name: ZeldaGame.SPIRIT_TRACKS, date: new Date(2009, 11, 21)},
    {name: ZeldaGame.SKYWARD_SWORD, date: new Date(2011, 11, 21)},
    {name: ZeldaGame.THE_LEGEND_OF_ZELDA_2, date: new Date(2013, 11, 21)},
    {name: ZeldaGame.THE_WIND_WAKER_2, date: new Date(2015, 11, 21)},
    {name: ZeldaGame.TWILIGHT_PRINCESS_2, date: new Date(2017, 11, 21)},
    {name: ZeldaGame.BREATH_OF_THE_WILD, date: new Date(2017, 3, 21)},
    {name: ZeldaGame.TEARS_OF_THE_KINGDOM, date: new Date(2023, 4, 12)}



]

/**
 * Metodo que calcula si una fecha es valida
 * @param date fecha a comprobar
 * @returns true /false si la fecha es valida o no
 */
export function dateIsValid(date?:Date):boolean {
  return date instanceof Date && !isNaN(date.getTime());
}


/**
 * Calcula los años y los dias entre 2 juegos de Zelda
 * @param game1 Juego 1 de Zelda
 * @param game2 Juego 2 de Zelda
 * @returns {years: number, days: number} años y dias entre los 2 juegos
 */
export function calculateDaysBetweenZeldaGames(game1:ZeldaGame, game2:ZeldaGame):{} {



    var zeldaGame1 = zeldaGames.find(x => x.name == game1);
    var zeldaGame2 = zeldaGames.find(x => x.name == game2);

    if(dateIsValid(zeldaGame1?.date) && dateIsValid(zeldaGame2?.date)){

    console.log(`El nombre del zelda 1 es ${zeldaGame1?.name} y la fecha de lanzamiento es ${zeldaGame1?.date}`)
    console.log(`El nombre del zelda 2 es ${zeldaGame2?.name} y la fecha de lanzamiento es ${zeldaGame2?.date}`)
    console.log(`La diferencia de fecha entre los dos juegos es ${diffYears(zeldaGame1?.date,zeldaGame2?.date)} año/s y ${diffDays(zeldaGame1?.date,zeldaGame2?.date)} dias`)
    }
    else{
        console.log("Las fechas no son validas")
    }

    return { years: diffYears(zeldaGame1?.date,zeldaGame2?.date), days: diffDays(zeldaGame1?.date,zeldaGame2?.date) }

}

/**
 * Metodo para cacular los dias entre 2 fechas
 * @param date1 fecha 1
 * @param date2 fecha 2
 * @returns numero de años entre las 2 fechas
 */
export function diffYears(date1?:Date,date2?:Date):number{
    var diff= 0

    if(date1!!<date2!!){
    diff = Math.abs(date1!!.getTime() - date2!!.getTime())
    }
    else{
    diff = Math.abs(date2!!.getTime() - date1!!.getTime())
    }

    var days = Math.floor(diff / (1000 * 60 * 60 * 24));
    var years = Math.floor(days / 365.25);
    return Math.abs(years);
}

/**
 * Metodo que calcula los dias entre 2 fechas
 * @param date1 fecha 1
 * @param date2 fecha 2
 * @returns Numero de dias entre las 2 fechas
 */
export function diffDays(date1?:Date,date2?:Date):number{

        var days = diffYears(date1,date2)% 365;
        return Math.abs(days);

}

calculateDaysBetweenZeldaGames(ZeldaGame.BREATH_OF_THE_WILD,ZeldaGame.A_LINK_TO_THE_PAST)
calculateDaysBetweenZeldaGames(ZeldaGame.BREATH_OF_THE_WILD, ZeldaGame.OCARINA_OF_TIME);
calculateDaysBetweenZeldaGames(ZeldaGame.FOUR_SWORDS_ADVENTURES,ZeldaGame.BREATH_OF_THE_WILD);