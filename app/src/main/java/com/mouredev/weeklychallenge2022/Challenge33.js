/*
 * Reto #33
 * CICLO SEXAGENARIO CHINO
 * Fecha publicación enunciado: 15/08/22
 * Fecha publicación resolución: 22/08/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
 * en el ciclo sexagenario del zodíaco chino.
 * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
 *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
 *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

/* Solución:
 * Requerimientos:
 * Node v 16.15.1
 *
 * Ejecución:
 * node Challenge33_test.js
 */

module.exports.func = function chineseYearCycle(year) {
  const cycleYear = 60;
  // const startCycle = 1924;
  const animals = new Array(
    "rat",
    "ox",
    "tiger",
    "rabbit",
    "dragon",
    "snake",
    "horse",
    "sheep",
    "monkey",
    "rooster",
    "dog",
    "pig"
  );
  const elements = new Array(
    "wood",
    "wood",
    "fire",
    "fire",
    "earth",
    "earth",
    "metal",
    "metal",
    "water",
    "water"
  );

  if (verifyYear(year)) {
    // procedure that only works with positive years (AC)
    // years = Math.abs(startCycle - parseInt(year)) % cycleYear;
    // if (parseInt(year) < startCycle) {
    //   years = Math.abs(years - cycleYear);
    // }

    // the following procedure is based in https://en.wikipedia.org/wiki/Sexagenary_cycle#Examples
    let years = 0;
    if (year > 0) years = (year - 4) % cycleYear;
    if (year < 0) years = cycleYear - ((Math.abs(year) + 3) % cycleYear);

    return {
      animal:
        animals[years < 0 ? animals.length + years : years % animals.length],
      element:
        elements[years < 0 ? elements.length + years : years % elements.length],
    };
  } else {
    return { msg: "not valid year" };
  }
};

const verifyYear = (year) => {
  if (parseInt(year) || parseInt(year) != 0) {
    return parseInt(year);
  } else {
    return false;
  }
};
