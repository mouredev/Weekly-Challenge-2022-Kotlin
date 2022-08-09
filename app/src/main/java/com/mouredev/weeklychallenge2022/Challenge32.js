/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
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
 * node Challenge32_test.js
 */

module.exports.func = function secondBiggest(list) {
  if (list.length < 2) return "Lista inválida";

  new_list = sort(list);
  for (let i = 1; i < new_list.length; i++) {
    if (new_list[i] != new_list[new_list.length - 1]) return new_list[i];
  }
};

const sort = (arr) => {
  for (let i = 0; i < arr.length - 1; i++) {
    for (let j = i; j < arr.length; j++) {
      if (arr[i] < arr[j]) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
  }
  return arr;
};
