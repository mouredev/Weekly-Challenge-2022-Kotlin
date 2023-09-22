/**
 * Enunciado: Crea una función que calcule el valor del parámetro perdido
 * correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I),
 *   y retornará el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función 
 *   retornará la cadena de texto "Invalid values".
 */

function ohm(V, R, I) {
    if (V === undefined || R === undefined || I === undefined) {
        return "Invalid values";
    }

    if (V === 0) {
        return (I * R).toFixed(2);
    }
    if (R === 0) {
        return (V / I).toFixed(2);
    }
    if (I === 0) {
        return (V / R).toFixed(2);
    }

}

console.log(ohm(230, 10, 0)); // 23.00
console.log(ohm(0, 10, 0.230)); // 2.30
console.log(ohm(230, 0, 0.230)); // 1000.00
console.log(ohm(0, 0, 0.230)); // Invalid values
console.log(ohm(230, 10, 0.230)); // Invalid values