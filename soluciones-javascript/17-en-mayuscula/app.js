/*
 * Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que
 *   lo resuelvan directamente.
 */

/**
 * 
 * @param {String} string 
 * @returns 
 */
const inUpperCase = (string) => {
    return string.split(' ').map(word => {
        const firstLetterCap = word.charAt(0).toUpperCase();
        const remainingLetters = word.slice(1);
        return firstLetterCap + remainingLetters;
    }).join(' ').trim();
}

console.log(inUpperCase('debi tirar mas algo'));
console.log(inUpperCase("  hola   mundo! esto es una prueba   "));
