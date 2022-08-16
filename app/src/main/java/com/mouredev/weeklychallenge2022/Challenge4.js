/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que
 * sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord)
 *   "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para
 *   que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de
 *   su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de
 *   su publicación.
 *
 * Solución:
 * Requerimientos:
 * Nodejs
 *
 * Ejecución:
 * node Challenge4_test.js
 */

module.exports.func = function calculateArea(polygon, size1, size2) {
  switch (polygon) {
    case "triangle":
      return triangle(size1, size2);
      break;
    case "rectangle":
      return rectangle(size1, size2);
      break;
    case "square":
      return rectangle(size1, size1);
      break;
  }
};

const triangle = (size1, size2) => {
  return (size1 * size2) / 2;
};

const rectangle = (size1, size2) => {
  return size1 * size2;
};
