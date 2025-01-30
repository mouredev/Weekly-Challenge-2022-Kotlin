/*
 * Escribe una función que calcule si un número dado es un número de Armstrong
 * (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información
 * al respecto.
 */

/**
 * Función para calcular si un número es un número de Armstrong o no.
 * @param {Number} n : number
 */
const esNumeroArmstrong = (n) => {
    if (n < 0) return false;

    const formattedNumber = n.toString().split("").map(Number);
    const sumNumber = formattedNumber.reduce(
        (prev, current) => prev + Math.pow(current, formattedNumber.length),
        0
    );

    return sumNumber === n;
};

console.log(esNumeroArmstrong(153)); // true
console.log(esNumeroArmstrong(9474)); // true
console.log(esNumeroArmstrong(9475)); // false
console.log(esNumeroArmstrong(370)); // true

