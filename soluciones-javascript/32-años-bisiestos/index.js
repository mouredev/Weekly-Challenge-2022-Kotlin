/*
 * Crea una función que imprima los 30 próximos años bisiestos
 * siguientes a uno dado.
 * - Utiliza el menor número de líneas para resolver el ejercicio.
 */

const esBisiesto = (year) => {
    return ((year % 4 === 0  &&  year % 100 !== 0) ||  (year % 400 === 0)); 
}

const calcularBisiesto = (year) => {

    if (!esBisiesto(year)) {
        return "Error: debes ingresar un año bisiesto"
    }

    const proximosBisiestos = [];

    for (let i = 1; i <= 30; i++) {

        year += 4;

        if (esBisiesto(year)) {
            proximosBisiestos.push(year);
        } else {
            i--;
        }
        
    }

    return proximosBisiestos;

}

console.log(calcularBisiesto(2024));
console.log(calcularBisiesto(2000));
console.log(calcularBisiesto(1900));