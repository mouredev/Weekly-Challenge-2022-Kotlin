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

// list of objects with the information of every game
const games = [
	{id: "THE_LEGEND_OF_ZELDA", name: "The Legend of Zelda", date: new Date("02/21/1986")},
    {id: "THE_ADVENTURE_OF_LINK", name: "Zelda II: The Adventure of Link", date: new Date("01/14/1987")},
    {id: "A_LINK_TO_THE_PAST", name: "The Legend of Zelda: A Link to the Past", date: new Date("11/21/1991")},
    {id: "LINKS_AWAKENING", name: "The Legend of Zelda: Link's Awakening", date: new Date("06/06/1993")},
    {id: "OCARINA_OF_TIME", name: "The Legend of Zelda: Ocarina of Time", date: new Date("11/21/1998")},
    {id: "MAJORAS_MASK", name: "Zelda: Majora's Mask", date: new Date("04/27/2000")},
    {id: "ORACLE_OF_SEASONS", name: "The Legend of Zelda: Oracle of Seasons", date: new Date("02/27.2011")},
    {id: "ORACLE_OF_AGES", name: "The Legend of Zelda: Oracle of Ages", date: new Date("02/27.2011")},
    {id: "FOUR_SWORDS", name: "The Legend of Zelda: Four Swords", date: new Date("12/03/2002")},
    {id: "THE_WIND_WAKER", name: "The Legend of Zelda: The Wind Waker", date: new Date("12/13/2002")},
    {id: "FOUR_SWORDS_ADVENTURES", name: "The Legend of Zelda: Four Swords Adventures", date: new Date("03/18/2004")},
    {id: "THE_MINISH_CUP", name: "The Legend of Zelda: The Minish Cap", date: new Date("11/04/2004")},
    {id: "TWILIGHT_PRINCES", name: "The Legend of Zelda: Twilight Princess", date: new Date("11/19/2006")},
    {id: "PHANTOM_HOURGLASS", name: "The Legend of Zelda: Phantom Hourglass", date: new Date("06/23/2007")},
    {id: "SPIRIT_TRACKS", name: "The Legend of Zelda: Spirit Tracks", date: new Date("12/07/2009")},
    {id: "SKYWARD_SWORD", name: "The Legend of Zelda: Skyward Sword", date: new Date("11/18/2011")},
    {id: "A_LINK_BETWEEN_WORLDS", name: "The Legend of Zelda: A Link Between Worlds", date: new Date("11/23/2013")},
    {id: "TRI_FORCE_HEROES", name: "The Legend of Zelda: Tri Force Heroes", date: new Date("10/11/2015")},
    {id: "BREATH_OF_THE_WILD", name: "The Legend of Zelda:  Breath of the Wild", date: new Date("03/03/2017")},
    {id: "TEARS_OF_THE_KINGDOM", name: "The Legend of Zelda: Tears of the Kingdom", date: new Date("05/12/2023")}
];

function timeBetweenRelease(g1, g2){
	// variables
	let date1, date2, errorMessage = "";
	// find games if they match with one
	(games.find(game => game.id === g1)) !== undefined? date1 = games.find(game => game.id === g1).date : errorMessage = "Couldn't calculate the time...";
	(games.find(game => game.id === g2)) !== undefined? date2 = games.find(game => game.id === g2).date : errorMessage = "Couldn't calculate the time...";
	if(errorMessage !== "") return errorMessage; // if there is an error, returns it
	// variable to calculate the time
	let resultMillis;
	// substract the oldest time from the most current
	(date1.getTime() >= date2.getTime())? resultMillis = date1.getTime() - date2.getTime() : resultMillis = date2.getTime() - date1.getTime();
	let resultYears = parseInt(resultMillis / 1000 / 3600 / 24 / 365); // convert milliseconds to years
	// calculate how many days the remaining time is
	let resultDays = parseInt(((resultMillis / 1000 / 3600 / 24 / 365) - resultYears) * 365); // remaining days
	// find the name of both games
	let name1 = games.find(game => game.id === g1).name;
	let name2 = games.find(game => game.id === g2).name;
	// returns the result
	return `Between '${name1}' and '${name2}' are ${resultYears} years and ${resultDays} days!`;
}

console.log(timeBetweenRelease("THE_LEGEND_OF_ZELDA", "TEARS_OF_THE_KINGDOM"));
console.log(timeBetweenRelease("TEARS_OF_THE_KINGDOM", "THE_LEGEND_OF_ZELDA"));
console.log(timeBetweenRelease("THE_LEGEND_OF_ZELDA", "THE_ADVENTURE_OF_LINK"));
console.log(timeBetweenRelease("THE_ADVENTURE_OF_LINK", "THE_LEGEND_OF_ZELDA"));
console.log(timeBetweenRelease("THE_LEGEND_OF_ZELDA", "THE_LEGEND_OF_ZELDA"));
console.log(timeBetweenRelease("ORACLE_OF_SEASONS", "ORACLE_OF_AGES"));