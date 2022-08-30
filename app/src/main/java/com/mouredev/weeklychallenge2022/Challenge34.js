/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/* Solución:
 * Requerimientos:
 * Node v 16.15.1
 *
 * Ejecución:
 * node Challenge34_test.js
 */

module.exports.func = function lostNumbers(arr) {
  if (checkInput(arr)) {
    return passLostNumbers(arr);
  } else return "Not correct input";
};

const checkInput = (arr) => {
  if (Array.isArray(arr)) {
    if (notEmpty(arr) && integers(arr) && ordered(arr)) return true;
  }
  return false;
};

const passLostNumbers = (arr) => {
  let nextNum = arr[0] + 1;
  let index = 1;
  let resp = [];
  while (nextNum < arr[arr.length - 1]) {
    if (arr[index] != nextNum) resp.push(nextNum);
    else index++;
    nextNum++;
  }
  return resp;
};

const notEmpty = (arr) => arr.length != 0;

const integers = (arr) => arr.every((element) => Number.isInteger(element));

const ordered = (arr) => {
  const cleanArray = arr.filter(
    (value, index, self) => self.indexOf(value) === index
  );
  return (
    JSON.stringify(cleanArray.sort((a, b) => a - b)) === JSON.stringify(arr)
  );
};
