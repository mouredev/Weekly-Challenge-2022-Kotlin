/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

module.exports.func = function binaryToDecimal(binary) {
  // return parseInt(binary, 2);
  const arr = binary.split("").map((num) => parseInt(num));
  const arr_len = arr.length;
  return arr.reduce(
    (prev, current, index) => prev + current * 2 ** (arr_len - (index + 1)),
    0
  );
};
