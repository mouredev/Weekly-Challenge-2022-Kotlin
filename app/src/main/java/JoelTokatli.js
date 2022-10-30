/*
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco
 * o Trato" y un listado (array) de personas con las siguientes propiedades:
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
 */

const treat = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"];
const trick = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"];

const people = [
  { name: "Juan", age: 12, height: 134 },
  { name: "Manola", age: 11, height: 112 },
  { name: "Fernando", age: 13, height: 139 },
  { name: "Josefina", age: 8, height: 124 },
  { name: "Roberto", age: 14, height: 144 },
];

// Función para generar emojis aleatorios dependiendo del array seleccionado.
const randomEmoji = (arr) => {
  return arr[Math.floor(Math.random() * `${arr.length}`)];
};

// Función que se usa si se elige trick como parametro en la funcion principal
const tricks = () => {
  let totalTricks = 0;
  people.map((person) => {
    let nameTricks = person.name.length;
    // si la condición se cumple (person.age > 10 retorna 3, de lo contrario, retorna (Math.floor(person.age / 3)) )
    let ageTricks = person.age > 10 ? 3 : Math.floor(person.age / 3);
    //
    let heightTricks =
      person.height >= 150 ? 3 : Math.floor(person.height / 50) * 2;
    totalTricks += nameTricks + ageTricks + heightTricks;
  });
  return totalTricks;
};

// Función que se usa cuando se elige treat como parametro en la función principal
const treats = () => {
  let initialTreats = 0;
  let totalHeight = 0;
  people.map((person) => {
    let nameTreats = Math.floor(person.name.length / 2);
    let ageTreats = person.age % 2 ? 0 : 2;
    totalHeight += person.height;
    initialTreats += nameTreats += ageTreats;
  });
  let heightTreats = Math.floor(totalHeight / 100);
  let totalTreats = initialTreats + heightTreats;
  return totalTreats;
};

// función principal.
const trickOrTreat = (choice) => {
  if (choice == "treat") {
    let result = [];
    for (i = 1; i <= treats(); i++) {
      result.push(randomEmoji(treat));
      i == treats() ? console.log(result) : false;
    }
  } else if (choice == "trick") {
    let result = [];
    for (i = 1; i <= tricks(); i++) {
      result.push(randomEmoji(trick));
      i == tricks() ? console.log(result) : false;
    }
  }
};

//Descomenta la siguiente linea para usar trick
/* trickOrTreat("trick"); */

//Descomenta la siguiente linea para usar treat
trickOrTreat("treat");
