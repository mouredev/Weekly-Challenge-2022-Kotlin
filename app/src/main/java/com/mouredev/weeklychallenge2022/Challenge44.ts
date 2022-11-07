/*
 * Reto #44
 * BUMERANES
 * Fecha publicación enunciado: 02/10/22
 * Fecha publicación resolución: 07/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que retorne el número total de bumeranes de un array de números
 * enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números seguidos, en el que el
 *   primero y el último son iguales, y el segundo es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/**
 * Funcion que busca el número total de bumeranes de un array de tipo T
 * @param numbers Array de tipo T
 * @returns Array de Arrays de tipo con los boommeranes encontrados
 * @example
 * // returns [[2, 1, 2], [4, 2, 4]]
 */
export function findBoomerangs<T>(numbers: T[]):T[][]{
    let boomerang: T[];
    const boomerangs = [];

    for (let i = 0; i < numbers.length - 2; i++) {
        boomerang = []
        if (numbers[i] === numbers[i + 2]) {
           boomerang.push(numbers[i], numbers[i + 1], numbers[i + 2])
           boomerangs.push(boomerang);
        }

    }

    return boomerangs;



}

const boomerangs_number = findBoomerangs([2, 1, 2, 3, 3, 4, 2, 4]);
const boomerangs_char = findBoomerangs(['a', 'b', 'a', 'c', 'c', 'd', 'a', 'd', 'b', 'd']);
console.log(boomerangs_number);
console.log(boomerangs_char);