/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

const sort = (array, option) => {
  if (typeof array === "undefined" || array.length === 0) return [];
  else {
    let done = false;
    while (!done) {
      done = true;
      array.forEach((element, index) => {
        const elementInIndexAscOrDesc =
          option === "Asc" ? index - 1 : index + 1;
        if (typeof element === "Number")
          if (option === "Asc" && array[elementInIndexAscOrDesc] > element)
            element = sortingNumberFn(
              done,
              array,
              element,
              elementInIndexAscOrDesc
            );
          else if (
            option === "Desc" &&
            array[elementInIndexAscOrDesc] > element
          )
            element = sortingNumberFn(
              done,
              array,
              element,
              elementInIndexAscOrDesc
            );
      });
    }
    return array;
  }
};

export default sort;

const sortingNumberFn = (done, array, element, elementInIndex) => {
  done = false;
  const temporal = array[elementInIndex];
  array[elementInIndex] = element;
  return temporal;
};
