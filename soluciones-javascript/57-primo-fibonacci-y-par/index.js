/*
 * Escribe un programa que, dado un número, compruebe y muestre si es primo,
 * fibonacci y par.
 * Ejemplos:
 * - Con el número 2, nos dirá: "2 es primo, fibonacci y es par"
 * - Con el número 7, nos dirá: "7 es primo, no es fibonacci y es impar"
 */

function esPrimo(num) {
    if (num < 2) return false;
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) return false;
    }
    return true;
}

function esFibonacci(num) {
    let a = 0, b = 1, temp;
    while (b < num) {
        temp = a + b;
        a = b;
        b = temp;
    }
    return b === num || num === 0;
}

function esPar(num) {
    return num % 2 === 0;
}

function analizarNumero(num) {
    let resultado = `${num} `;
    resultado += esPrimo(num) ? "es primo, " : "no es primo, ";
    resultado += esFibonacci(num) ? "fibonacci y " : "no es fibonacci y ";
    resultado += esPar(num) ? "es par." : "es impar.";
    return resultado;
}

console.log(analizarNumero(2));
console.log(analizarNumero(7));
console.log(analizarNumero(8));
console.log(analizarNumero(13));
console.log(analizarNumero(21));