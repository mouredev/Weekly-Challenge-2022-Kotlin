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

const scares = ['🎃', '👻', '💀', '🕷', '🕸', '🦇'];
const sweets = ['🍰', '🍬', '🍡', '🍭', '🍪', '🍫', '🧁', '🍩'];

function getRandomIcons(number, icons) {
  let result = [];

  for (let i = 0; i < number; i++) {
    const icon = icons[Math.floor(Math.random() * icons.length)];
    result.push(icon);
  }

  return result;
}

function getScares(people) {
  let numberScares = 0;
  let totalHeight = 0;

  people.forEach(person => {
    numberScares += Math.floor(person.nombre.length / 2);

    if (person.edad % 2 === 0) {
      numberScares += 2;
    }

    totalHeight += person.altura;
  });

  numberScares += (totalHeight / 100) * 3;

  return getRandomIcons(numberScares, scares);
}

function getSweets(people) {
  const totalSweets = people.reduce((acc, person) => {
    acc += person.nombre.length;
    acc += person.edad > 10 ? 3 : Math.floor(person.edad / 3);
    acc += person.altura > 150 ? 6 : Math.floor(person.altura / 50) * 2;

    return acc;
  }, 0);

  return getRandomIcons(totalSweets, sweets);
}

function trickOrTreating(option, people = []) {
  const options = {
    truco: getScares,
    trato: getSweets,
    default: () => 'Error, opción incorrecta. Elija truco o trato'
  };

  return (options[option] || options['default'])(people);
}








//Ejemplos

const personas = [
  { nombre: 'Ramón', edad: 20, altura: 180 },
  { nombre: 'Sara', edad: 18, altura: 165 }
];

console.log(trickOrTreating('truco', personas));
// [
//   '💀', '🕸',  '👻', '🕷',
//   '💀', '🕸',  '🎃', '💀',
//   '🎃', '💀', '🕷',  '👻',
//   '👻', '👻', '🕸',  '🎃',
//   '🎃', '🎃', '👻'
// ]
console.log(trickOrTreating('trato', personas));
// [
//   '🍩', '🍫', '🍪', '🍰', '🍭',
//   '🧁', '🍪', '🍪', '🍫', '🍰',
//   '🧁', '🍪', '🍩', '🍩', '🍩',
//   '🧁', '🍭', '🍬', '🍬', '🍬',
//   '🍬', '🍫', '🍪', '🍬', '🧁',
//   '🍬', '🍪'
// ]
console.log(trickOrTreating('', personas)); //Error, opción incorrecta. Elija truco o trato
