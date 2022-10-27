const readline = require("node:readline/promises");
const { stdin: input, stdout: output } = require("node:process");
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
const TRICK = "TRUCO";
const TREAT = "TRATO";
const TYPES_ENUM = {
  [TRICK]: TRICK,
  [TREAT]: TREAT,
};
const TREATS = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"];
const TRICKS = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"];

function randomInteger(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

function validateName(name) {
  if (!name) throw new Error("Nombre invalido");
  return name;
}
function validateAge(age) {
  const n = Number(age);
  if (isNaN(n) || n < 1) {
    throw new Error("Edad invalida");
  }
  return n;
}
function validateHeight(height) {
  const n = Number(height);
  if (isNaN(n) || Number(n) < 1) {
    throw new Error("Estatura invalida");
  }
  return n;
}

function parsePerson(data = "") {
  const [name, age, height] = data.split(" ");

  return {
    name: validateName(name),
    age: validateAge(age),
    height: validateHeight(height),
  };
}

async function loadPeopleData() {
  const rl = readline.createInterface({ input, output });
  const heights = [];
  const names = [];
  const ages = [];

  console.log(`Añade personas e.g.'Esteban 12 120': `);
  while (true) {
    const data = await rl.question(`(Escribe # para terminar): `);
    if (data === "#") {
      break;
    }

    try {
      const { age, height, name } = parsePerson(data);
      heights.push(height);
      ages.push(age);
      names.push(name);
    } catch (e) {
      console.log(e.message);
    }
  }

  rl.close();
  return {
    heights,
    names,
    ages,
  };
}

async function loadTrickOrTreat() {
  const rl = readline.createInterface({ input, output });
  let type;

  while (true) {
    type = await rl.question(`Truco o Trato: `);
    if (TYPES_ENUM[type.toUpperCase()]) {
      break;
    }
    console.log("Respuesta invalida");
  }

  rl.close();
  return type;
}

function getTreats(peopleData) {
  let treats = 0;

  peopleData.names.forEach((name) => {
    const letterCount = name.replace(/\s+/g, "").length;
    treats += Math.floor(letterCount / 2);
  });

  peopleData.ages.forEach((age) => {
    if (age % 2 === 0) {
      treats += 2;
    }
  });

  const heightsSum = peopleData.heights.reduce((p, c) => p + c);
  treats += Math.floor(heightsSum / 100) * 3;

  return treats;
}

function getTricks(peopleData) {
  let tricks = 0;

  peopleData.names.forEach((name) => {
    tricks += name.length;
  });

  peopleData.ages.forEach((age) => {
    tricks += Math.min(3, Math.floor(age / 3));
  });

  peopleData.heights.forEach((height) => {
    tricks += Math.min(3, Math.floor(height / 50)) * 2;
  });

  return tricks;
}

function generateEmojis(type, qty) {
  let response = "";
  const emojis = type === TREAT ? TREATS : TRICKS;

  for (let x = 0; x < qty; x++) {
    const index = randomInteger(0, emojis.length - 1);
    response += emojis[index];
  }
  console.log(response);
}

async function app() {
  const type = await loadTrickOrTreat();
  const peopleData = await loadPeopleData();

  const emojis = type === TREAT ? getTreats(peopleData) : getTricks(peopleData);
  generateEmojis(type, emojis);
}
app();
