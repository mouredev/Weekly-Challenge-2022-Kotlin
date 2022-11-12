/*
 * Reto #45
 * CONTENEDOR DE AGUA
 * Fecha publicación enunciado: 07/10/22
 * Fecha publicación resolución: 14/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Dado un array de números enteros positivos, donde cada uno representa unidades
 * de bloques apilados, debemos calcular cuantas unidades de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *        ⏹
 *        ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
 *   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
 *
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

module.exports.func = function waterContainers(input) {
  let savedWater = 0;
  for (let column = 1; column < input.length; column++) {
    let leftWallHeight = findLeftWall(input, column);
    let rightWallHeight = findRightWall(input, column);
    if (input[column] < leftWallHeight && input[column] < rightWallHeight) {
      savedWater +=
        leftWallHeight < rightWallHeight
          ? leftWallHeight - input[column]
          : rightWallHeight - input[column];
    }
  }
  return savedWater;
};

const findLeftWall = (arr, rightLimit) => {
  let leftWall = 0;
  for (let i = 0; i < rightLimit; i++) {
    if (arr[i] > leftWall) leftWall = arr[i];
  }
  return leftWall;
};

const findRightWall = (arr, leftLimit) => {
  let rightWall = 0;
  for (let i = arr.length - 1; i > leftLimit; i--) {
    if (arr[i] > rightWall) rightWall = arr[i];
  }
  return rightWall;
};
