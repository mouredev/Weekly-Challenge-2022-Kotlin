/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

const palabra1 = "AmOr";
const palabra2 = "RoMA";

const anagrama = (a, b) => {

  //comprobar si son excatamente iguales:
  if (palabra1 === palabra2) {
    return console.log(false)
  }

  //comprobar que son string
  if (typeof (palabra1) != "string" || typeof (palabra2) != "string") {
    return console.log(false)
  }

  //seteamos todo a min
  a = a.toLowerCase().split(' ').join('').split('').sort().join('');
  b = b.toLowerCase().split(' ').join('').split('').sort().join('');


  if (a === b) {
    return console.log(true);
  } else {
    return console.log(false)
  }

};


anagrama(palabra1, palabra2);