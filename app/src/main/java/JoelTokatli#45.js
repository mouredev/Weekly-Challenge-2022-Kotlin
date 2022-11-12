/*
 * Enunciado: Dado un array de números enteros positivos, donde cada uno
 * representa unidades de bloques apilados, debemos calcular cuantas unidades
 * de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *         ⏹
 *         ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades
 *   de agua. Suponemos que existe un suelo impermeable en la parte inferior
 *   que retiene el agua.
 */

let arr1 = [4, 0, 3, 6, 1, 3];
let arr2 = [1, 2, 3, 4, 3, 2, 1];

const getWater = (arr) => {
  let waterCount = 0;
  for (let i = 1; i < arr.length - 1; i++) {
    let leftBlock = arr[i];
    for (let j = 0; j < i; j++) {
      leftBlock = Math.max(leftBlock, arr[j]);
    }
    let rightBlock = arr[i];
    for (let j = i + 1; j < arr.length; j++) {
      rightBlock = Math.max(rightBlock, arr[j]);
    }
    waterCount += Math.min(leftBlock, rightBlock) - arr[i];
  }
  return console.log(
    `El cantidad de agua atrapada entre los bloques es de: ${waterCount}`
  );
};

getWater(arr1);
