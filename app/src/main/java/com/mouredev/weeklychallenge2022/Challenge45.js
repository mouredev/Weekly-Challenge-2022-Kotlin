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

module.exports.func = function warterContainers(input) {
  let saved_water = 0;
  let column = 1;
  while (column < input.length - 1) {
    const leftWall = findLeftWallPosition(input, column);
    const rightWall = findRightWallPosition(input, column);

    if (input[column] >= input[leftWall] || input[column] >= input[rightWall]) {
      column += 1;
      continue;
    }
    saved_water += waterStored(input, leftWall, rightWall);
    column = rightWall;
  }
  return saved_water;
};

const findLeftWallPosition = (blockList, rightLimit) => {
  let leftWall = { val: 0, position: 0 };
  for (let position = 0; position < rightLimit; position++) {
    if (blockList[position] > leftWall.val) {
      leftWall = { val: blockList[position], position: position };
    }
  }
  return leftWall.position;
};

const findRightWallPosition = (blockList, leftLimit) => {
  let rightWall = { val: 0, position: 0 };
  for (let position = blockList.length - 1; position > leftLimit; position--) {
    if (blockList[position] > rightWall.val) {
      rightWall = { val: blockList[position], position: position };
    }
  }
  return rightWall.position;
};

const waterStored = (blockList, leftWall, rightWall) => {
  let usedSpace = 0;
  const height =
    blockList[leftWall] < blockList[rightWall]
      ? blockList[leftWall]
      : blockList[rightWall];
  const length = rightWall - (leftWall + 1);

  for (let position = leftWall + 1; position < rightWall; position++) {
    usedSpace += blockList[position];
  }
  return height * length - usedSpace;
};

// Code copied and adapted from Java Solution: https://github.com/mouredev/Weekly-Challenge-2022-Kotlin/pull/1036/files
// module.exports.func = function waterContainers(input) {
//   let savedWater = 0;
//   for (let column = 1; column < input.length; column++) {
//     let leftWallHeight = findLeftWall(input, column);
//     let rightWallHeight = findRightWall(input, column);
//     if (input[column] < leftWallHeight && input[column] < rightWallHeight) {
//       savedWater +=
//         leftWallHeight < rightWallHeight
//           ? leftWallHeight - input[column]
//           : rightWallHeight - input[column];
//     }
//   }
//   return savedWater;
// };

// const findLeftWall = (arr, rightLimit) => {
//   let leftWall = 0;
//   for (let i = 0; i < rightLimit; i++) {
//     if (arr[i] > leftWall) leftWall = arr[i];
//   }
//   return leftWall;
// };

// const findRightWall = (arr, leftLimit) => {
//   let rightWall = 0;
//   for (let i = arr.length - 1; i > leftLimit; i--) {
//     if (arr[i] > rightWall) rightWall = arr[i];
//   }
//   return rightWall;
// };
