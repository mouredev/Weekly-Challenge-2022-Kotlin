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

let list = [1, 4, 23, 98, 56, 43, 76, 12, 7]; // a list of numbers

// way 1
list.sort((a, b) => a - b); // sort from smallest to largest number
console.log(list[list.length-2]); // 76

// way 2
list.sort((a, b) => b - a); // sort from largest to smallest
console.log(list[1]); // 76