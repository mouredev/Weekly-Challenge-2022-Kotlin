/*
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function degreeConverter(temperature) {
  const isValid = /[0-9]+[ºC|F]{2}/.test(temperature);

  if (!isValid) {
    return `Enter a correct degree format, ex: '24ºC' or '24ºF'`;
  }

  const [number, type] = temperature.split('º');
  const result = type === 'C' ?
    `${(number * 9 / 5) + 32}ºF` :
    `${(number - 32) * 5 / 9}ºC`;

  return result;
}

degreeConverter('10ºC'); //'50ºF'
degreeConverter('10ºF'); //'-12.222222222222221ºC'
