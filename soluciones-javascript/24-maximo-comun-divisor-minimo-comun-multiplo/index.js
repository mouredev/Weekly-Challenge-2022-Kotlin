/*
 * Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra
 * que calcule el mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que
 *   lo resuelvan directamente.
 */

const mcd = (a , b) => {
    return b === 0 ? a : mcd(b, a % b);
}

const mcm = (a , b) => {
    return ( a * b ) / mcd(a,b);
}

console.log(mcd(48, 36));
console.log(mcd(12, 18));
console.log(mcm(12, 18));
console.log(mcm(48, 36));
