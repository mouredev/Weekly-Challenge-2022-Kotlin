// package com.mouredev.weeklychallenge2022

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

const personas = [
  {
    Nombre: 'niñita', // 3  -- 6
    Edad: 8, // 4   -- 2
    Altura: 110  // 0  --4
  }, // TOTAL 7 sustos   TOTAL 12 dulces
  {
    Nombre: 'adolecente', // 5  --  10
    Edad: 17, // 8  -- 3
    Altura: 170  // 0  --6
  }, // TOTAL 13 sustos   TOTAL 19 dulces
  {
    Nombre: 'adulto', // 3  --  6
    Edad: 33, // 16  -- 3
    Altura: 160  //   --6
  } // TOTAL 19 sustos  TOTAL 15 dulces
  // sustos 23
  // dulces 46
];

const Sustos = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"]

const Dulces = ["🍰 ", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"]

const pedido = 'Trato'; // Indica el pedido Truco o Trato

let resultado = [];

// Función de Truco
const truco = (persona) => {
  let sustosTotales = []
  let alturaTotal = 0

  persona.forEach(e => {
    alturaTotal += e.Altura
    sustosTotales.push((e.Nombre.length / 2) + Math.floor(e.Edad / 2));

  });

  alturaTotal = Math.floor(alturaTotal / 100)

  sustosTotales.forEach(e => {
    for (let i = 1; i <= e; i++) {
      resultado.push(Sustos[(Math.floor(Math.random() * 6))])

    }
  });
  for (let i = 1; i <= alturaTotal; i++) {
    resultado.push(Sustos[(Math.floor(Math.random() * 6))])

  }
  console.log(resultado)
  console.log("Total de sustos: " + resultado.length)
}

// Función de Trato
const trato = (persona) => {

  let dulcesTotales = [];

  persona.forEach(e => {


    if (e.Edad > 10) {
      e.Edad = 10
    }

    if (e.Altura > 150) {
      e.Altura = 150
    }

    dulcesTotales.push((e.Nombre.length) + Math.floor(e.Edad / 3) + Math.floor((e.Altura / 50) * 2));

  });

  dulcesTotales.forEach(e => {
    for (let i = 1; i <= e; i++) {
      resultado.push(Dulces[(Math.floor(Math.random() * 8))])

    }
  });

  console.log(resultado)
  console.log("Total de dulces: " + resultado.length)
}



const programa = (personas, pedido) => {
  if (pedido === 'Truco') {
    return truco(personas)
  }

  if (pedido === 'Trato') {
    return trato(personas)
  }

  return console.log("No se encontrol el pedido")
}

programa(personas, pedido)

