/*
 * Crea una función que calcule el valor del parámetro perdido
 * correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará
 *   el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función retornará
 *   la cadena de texto "Invalid values".
 */

/**
 * 
 * @param {{ v: Number, r: Number, i: Number }} param0 
 */
const leyDeOhm = ({ v, r, i }) => {
   
    const valores = [ v, r, i ]; 
    const faltantes = valores.filter( value => value === undefined ).length;

    if ( faltantes !== 1 || valores.some( value => value !== undefined && (typeof value !== "number") || value < 0))
        return "Invalid Values";

    return v === undefined 
            ? (i * r).toFixed(2) 
            : r === undefined 
            ? (v / i).toFixed(2)
            : i === undefined
            ? (v / r).toFixed(2)
            : 'Invalid values';
}

console.log(leyDeOhm({ v: 0, r: 2, i: 3 })); // "Invalid values"
console.log(leyDeOhm({ v: undefined, r: 4, i: 5 })); // 20.00
console.log(leyDeOhm({ v: 12, r: undefined, i: 3 })); // 4.00
console.log(leyDeOhm({ v: 12, r: 4, i: undefined })); // 3.00
console.log(leyDeOhm({ v: 12, r: 4, i: 3 })); // "Invalid values"
console.log(leyDeOhm({ v: -12, r: 4, i: undefined })); // "Invalid values"
console.log(leyDeOhm({ v: 12, r: "4", i: undefined })); // "Invalid values"