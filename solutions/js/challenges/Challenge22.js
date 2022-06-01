/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

/**
 * Returns the related elements of two arrays. Depending on the common flag, it will return the common
 * elements or the different elements. This function treats duplicates as different elements.
 *
 * @param {*[]} arr1 First of the two arrays to compare
 * @param {*[]} arr2 Second of the two arrays to compare
 * @param {boolean} common Boolean flag to indicate if the function should return common elements or different elements
 * @returns {*[]} A list of common or different elements
 */
const getRelatedElements = (arr1, arr2, common) => {
  const getIntersectionElements = (arr1, arr2) => {
    let shortList;
    let longList;
    if (arr1.length < arr2.length) {
      shortList = arr1;
      longList = arr2;
    } else {
      shortList = arr2;
      longList = arr1;
    }
    const newList = [];
    const cache = {};
    longList.forEach((e) => {
      if (cache[e] || shortList.includes(e)) {
        if (cache[e]) {
          cache[e][0]++;
        } else {
          cache[e] = [1, 0];
        }
      }
    });
    shortList.forEach((e) => {
      if (cache[e]) {
        if (cache[e][0] > cache[e][1]++) {
          newList.push(e);
        }
      }
    });
    return newList;
  };

  const getDifferenceElements = (arr1, arr2) => {
    const newList = [];
    const cache = {};
    arr1.forEach((e) => {
      if (cache[e] || arr2.includes(e)) cache[e] = 1;
      else newList.push(e);
    });
    arr2.forEach((e) => {
      if (!cache[e]) newList.push(e);
    });
    return newList;
  };

  return common
    ? getIntersectionElements(arr1, arr2)
    : getDifferenceElements(arr1, arr2);
};

module.exports = { getRelatedElements };