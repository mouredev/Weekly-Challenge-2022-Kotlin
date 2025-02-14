/*
 * Crea una función que retorne el número total de bumeranes de
 * un array de números enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números
 *   seguidos, en el que el primero y el último son iguales, y el segundo
 *   es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2]
 *   y [4, 2, 4]).
 */

const countBoomerangs = (arrayBoomerangs) => {
    if (arrayBoomerangs.length < 3) return "El array no tiene suficientes elementos.";

    const boomerangs = [];
    arrayBoomerangs.forEach((element, index, array) => {
        if ( element === array[index + 2] && element !== array[index + 1] ) {
            boomerangs.push([array[index], array[index + 1], array[index + 2]]);
        }
    });
    return `El array tiene ${boomerangs.length} \n **${boomerangs.join('**')}**`;
}

console.log(countBoomerangs([2, 1, 2, 3, 3, 4, 2, 4])); 
console.log(countBoomerangs([3, 1, 2, 1, 3, 4, 3, 4])); 
console.log(countBoomerangs([9, 1, 9, 3, 4, 3, 2, 4]));
console.log(countBoomerangs([2, 2, 2])); // 0 (caso incorrecto corregido)
console.log(countBoomerangs([1, 2])); // 0 (array con menos de 3 elementos)