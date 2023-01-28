/*
 * Enunciado: Crea una función que retorne el número total de bumeranes de
 * un array de números enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números
 *   seguidos, en el que el primero y el último son iguales, y el segundo
 *   es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2]
 *   y [4, 2, 4]).
 */

const array1 = [1, 0, 1, 0, 3, 5, 7, 4, 7, 4];

const array2 = [5, 7, 5, 7, 5, 7, 5, 7, 5, 7, 5];

let boomerangs = [];

const findBoomerangs = (arr) => {
  let index = 0;
  for (let i = 0; i < arr.length - 2; i++) {
    if (arr[index] != arr[index + 1] && arr[index] === arr[index + 2]) {
      boomerangs.push([arr[index], arr[index + 1], arr[index + 2]]);
      index++;
    } else {
      index++;
    }
  }

  // Muestra la cantidad de boomerangs encontrados
  console.log(
    `El número de boomerangs en el array inicial es de: ${boomerangs.length}`
  );

  // Muestra los boomerangs encontrados.
  console.log(boomerangs);
  boomerangs = [];
};

findBoomerangs(array1);

// Otro array para probar:
// findBoomerangs(array2);
