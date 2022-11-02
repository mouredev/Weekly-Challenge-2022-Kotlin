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

const sustos = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"];
const dulces = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"];

type Choice = "truco" | "trato";

type Person = {
  name: string;
  age: number;
  height: number;
};

function getRandom(choice: Choice, times: number): string {
  let output = "";
  const list = choice === "truco" ? sustos : dulces;
  for (let i = 0; i < times; i++) {
    output += list[Math.floor(Math.random() * list.length)];
  }
  return output;
}

export default function trucoOTrato(choice: Choice, people: Person[]): string {
  let quantity = 0;

  if (choice === "truco") {
    // Un susto por cada 2 letras del nombre por persona
    quantity += people.reduce(
      (accumulated, current) =>
        (accumulated += Math.floor(current.name.length / 2)),
      0
    );
    // Dos sustos por cada edad que sea un número par
    quantity += people.reduce(
      (accumulated, current) => (accumulated += current.age % 2 ? 0 : 2),
      0
    );
    // Tres sustos por cada 100 cm de altura entre todas las personas
    const heightsSum = people.reduce(
      (accumulated, current) => (accumulated += current.height),
      0
    );
    quantity += 3 * Math.floor(heightsSum / 100);
  }

  if (choice === "trato") {
    // Un dulce por cada letra de nombre
    quantity += people.reduce(
      (accumulated, current) => (accumulated += current.name.length),
      0
    );

    // Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
    quantity += people.reduce(
      (accumulated, current) =>
        (accumulated += current.age < 10 ? Math.floor(current.age / 3) : 3),
      0
    );

    // Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
    quantity +=
      2 *
      people.reduce(
        (accumulated, current) =>
          (accumulated +=
            current.height <= 150 ? Math.floor(current.height / 50) : 3),
        0
      );
  }

  return getRandom(choice, quantity);
}
