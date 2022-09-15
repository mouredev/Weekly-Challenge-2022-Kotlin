/*

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

const zeldaGames = [
    {
        name: 'Tears of the Kingdom',
        releaseDate: new Date(2023, 4, 12)
    },
    {
        name: 'The Legend of Zelda',
        releaseDate: new Date(1986, 2, 21)
    },
    {
        name: 'The Legend of Zelda: A Link to the Past',
        releaseDate: new Date(1991, 11, 21)
    },
    {
        name: 'The Legend of Zelda: Ocarina of Time',
        releaseDate: new Date(1998, 9, 27)
    },
    {
        name: "The Legend of Zelda: Majora's Mask",
        releaseDate: new Date(2000, 1, 27)
    },
    {
        name: 'The Legend of Zelda: The Wind Waker',
        releaseDate: new Date(2002, 9, 14)
    },
    {
        name: 'The Legend of Zelda: Twilight Princess',
        releaseDate: new Date(2006, 11, 24)
    },
    {
        name: 'The Legend of Zelda: Skyward Sword',
        releaseDate: new Date(2011, 11, 20)
    },
    {
        name: 'The Legend of Zelda: Breath of the Wild',
        releaseDate: new Date(2017, 2, 3)
    }
];

const getDaysBetweenDates = (date1, date2) => {
    const oneDay = 24 * 60 * 60 * 1000;
    const oneYear = 365 * 24 * 60 * 60 * 1000;
    return {
        days: Math.round(Math.abs((date1 - date2) / oneDay)),
        years: Math.round(Math.abs((date1 - date2) / oneYear))
    };
};

console.log(
    getDaysBetweenDates(zeldaGames[0].releaseDate, zeldaGames[1].releaseDate)
);
