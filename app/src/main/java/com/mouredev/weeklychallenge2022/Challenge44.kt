package com.mouredev.weeklychallenge2022

/*
 * Reto #44
 * BUMERANES
 * Fecha publicación enunciado: 02/10/22
 * Fecha publicación resolución: 07/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que retorne el número total de bumeranes de un array de números
 * enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números seguidos, en el que el
 *   primero y el último son iguales, y el segundo es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

const array = [2, 1, 2, 3, 3, 4, 2, 4, 2 ,2, 2];
const BOOMERANG_LENGTH = 3;
console.log(array);

const arrayBumerangs = [];

for(let index = 0; index < array.length - 2; index++) {
 const testBoomeranElement = [ array[index], array[index +1], array[index + 2] ];
if(isBoomerang(testBoomeranElement))
  arrayBumerangs.push(testBoomeranElement);
}


const isBoomerang = (aux) => aux.length === BOOMERANG_LENGTH  && aux[0] === aux[2] && aux[0] !== aux[1];
const arrayBumerangsToString = (array) =>  {
  const boomerangToString = array.map((boomerang) => '[' + boomerang + ']')
  const joinBoomerang = boomerangToString.join(' , ');
  return joinBoomerang.substring( 0 , joinBoomerang.lastIndexOf(' , ')) + ' y '
    + joinBoomerang.substring(joinBoomerang.lastIndexOf(' , ') + 3, joinBoomerang.length)
}

console.log("En el array ["+ array +"] hay "+ arrayBumerangs.length +" bumeranes (" + arrayBumerangsToString(arrayBumerangs) + ")");
