/*
 * Enunciado: Crea una función que retorne el número total de bumeranes de
 * un array de números enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números
 *   seguidos, en el que el primero y el último son iguales, y el segundo
 *   es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2]
 *   y [4, 2, 4]).
 */

let rawArray = [2, 1, 2, 3, 3, 4, 2, 4, 3, 3, 2, 4, 2, 6, 7, 5, 7];
let countArray = [];

const countingBoomerangs = () => {
    for (let index = 0; index < rawArray.length; index++) {
        let auxArray = [];
        if (rawArray[index] == rawArray[index + 2] && rawArray[index] != rawArray[index + 1]) {
            auxArray.push(rawArray[index], rawArray[index + 1], rawArray[index + 2]);
            countArray.push(auxArray);
        }
    }
    console.log("Este arreglo tiene: " + countArray.length + " Boomerangs");
    console.log("Los boomerangs son: ");
    for (let index = 0; index < countArray.length; index++) {
        console.log(countArray[index]);
    }
};

countingBoomerangs();
