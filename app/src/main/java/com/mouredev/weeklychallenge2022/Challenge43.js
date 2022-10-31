/*
 * Reto #43
 * TRUCO O TRATO
 * Fecha publicación enunciado: 24/10/22
 * Fecha publicación resolución: 02/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
 * un listado (array) de personas con las siguientes propiedades:
 * - Nombre de la niña o niño
 * - Edad
 * - Altura en centímetros
 *
 * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
 * siguiendo estos criterios:
 * - Un susto por cada 2 letras del nombre por persona
 * - Dos sustos por cada edad que sea un número par
 * - Tres sustos por cada 100 cm de altura entre todas las personas
 * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
 *
 * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
 * siguiendo estos criterios:
 * - Un dulce por cada letra de nombre
 * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
 * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
 * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

module.exports.func = function treatOrTreat(input) {
  const prizes = {
    treat: ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"],
    trick: ["🎃", "👻", "💀", "🕷", "🕸", "🦇"],
  };

  switch (input.option) {
    case "treat":
      return input.children.map((child) =>
        halloweenPrizes(calcTreats(child), prizes.treat)
      );

    case "trick":
      return input.children.map((child) =>
        halloweenPrizes(calcTricks(child), prizes.trick)
      );
  }
};

const calcTricks = (personData) => {
  return (
    tricksByName(personData.name.length) +
    tricksByAge(personData.age) +
    tricksByHeight(personData.height)
  );
};

const calcTreats = (personData) => {
  return (
    treatsByName(personData.name.length) +
    treatsByAge(personData.age) +
    treatsByHeight(personData.height)
  );
};

const tricksByName = (name_size) => parseInt(name_size / 2);
const tricksByAge = (age) => (age % 2 == 0 ? 2 : 0);
const tricksByHeight = (height) => parseInt(height / 100) * 3;

const treatsByName = (name_size) => name_size;
const treatsByAge = (age) => (age < 10 ? parseInt(age / 3) : 3);
const treatsByHeight = (height) =>
  height <= 150 ? parseInt(height / 50) * 2 : 6;

const halloweenPrizes = (prizesAmount, prizesSource) => {
  let prize = "";
  for (let i = 0; i < prizesAmount; i++) {
    prize += prizesSource[Math.floor(Math.random() * prizesSource.length)];
  }
  return prize;
};
