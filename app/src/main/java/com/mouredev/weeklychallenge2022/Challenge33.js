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

const animal = [
    "Rat",
    "Ox",
    "Tiger",
    "Rabbit",
    "Dragon",
    "Snake",
    "Horse",
    "Sheep",
    "Monkey",
    "Rooster",
    "Dog",
    "Pig",
  ],
  element = [
    "Wood",
    "Wood",
    "Fire",
    "Fire",
    "Earth",
    "Earth",
    "Metal",
    "Metal",
    "Water",
    "Water",
  ],
  cycle = 60;

let baseYear = 1924,
  animalNumber = 0,
  elementNumber = 0;

const chineseZodiac = (year = undefined) => {
  if (year === undefined) return console.warn("Year is empty");
  if (typeof year != "number")
    return console.error(`"${year}" is not a number`);
  if (year < 0) return console.warn("Only positive years are accepted");

  year = Math.floor(year);

  if (year === baseYear)
    return console.info(
      `Your animal is ${animal[0]} and your element is ${element[0]}`
    );

  if (year < baseYear) {
    while (year < baseYear) {
      baseYear -= cycle;
    }

    baseYear -= 60;

    if (year === baseYear)
      return console.info(
        `Your animal is ${animal[0]} and your element is ${element[0]}`
      );

    while (year != baseYear) {
      baseYear++;
      animalNumber++;
      elementNumber++;
      if (animalNumber > 11) animalNumber = 0;
      if (elementNumber > 9) elementNumber = 0;
    }
    return console.info(
      `Your animal is ${animal[animalNumber]} and your element is ${element[elementNumber]}`
    );
  }

  if (year > baseYear) {
    while (year > baseYear) {
      baseYear += cycle;
    }
    baseYear -= 60;
  }

  if (year === baseYear)
    return console.info(
      `Your animal is ${animal[0]} and your element is ${element[0]}`
    );

  while (year != baseYear) {
    baseYear++;
    animalNumber++;
    elementNumber++;
    if (animalNumber > 11) animalNumber = 0;
    if (elementNumber > 9) elementNumber = 0;
  }
  return console.info(
    `Your animal is ${animal[animalNumber]} and your element is ${element[elementNumber]}`
  );
};

chineseZodiac(1984);
