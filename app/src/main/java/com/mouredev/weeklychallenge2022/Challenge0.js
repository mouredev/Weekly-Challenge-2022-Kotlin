/*
 * Reto #0
 * EL FAMOSO "FIZZ BUZZ"
 * Fecha publicación enunciado: 27/12/21
 * Fecha publicación resolución: 03/01/22
 * Dificultad: FÁCIL
 * Enunciado: Escribe un programa que muestre por consola (con un print) los números de 1 a 100 (ambos incluidos y con un salto de línea entre cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

// @author Javier Guerra
// +info: https://javguerra.github.io/2022-04-22-fizzbuzz/

const START = 1;
const END = 100; // START > END
let result = '0';
let x3, x5;

for (let i = START; i <= END; i++)
{
  result += ', ';
  x3 = i % 3 == 0;
  x5 = i % 5 == 0;

  if (!x3 && !x5)
    result += i;
  else {
    if (x3) result += 'fizz';
    if (x5) result += 'buzz';
  }
} // end for()

console.log (result);
