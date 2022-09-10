/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function validacionArray(array) {
    let creciente = true, decreciente = true;
    let validacion = true;
    let ultimo = array[0];
    
    for (let i = 1; i < array.length; i++) {
        if (array[i] < ultimo) { creciente = false };
        if (array[i] > ultimo) { decreciente = false };
        if (array[i] === ultimo) { return !validacion};

        if ( !Number.isInteger(array[i]) ) {
            return !validacion;
        }
        ultimo = array[i];
    }
    
    if ((creciente && decreciente )|| (!creciente && !decreciente)) {
        return !validacion;
    } else {
        return validacion;
    }
}

function numerosPerdidos(array) {
    let arrayRespuesta = [];
    if (!validacionArray(array)) {
        throw console.error('Array de entrada incorrecto');

    }
    
    for (let i = 0; i < array.length-1; i++) {
        if (Math.abs(array[i] - array[i + 1]) > 1) {
            if (array[i] < array[i + 1]) {
                for (let j = array[i]+1; j < array[i+1]; j++) {
                    arrayRespuesta.push(j);
                }
            } else {
                for (let j = array[i]-1; j > array[i+1]; j--) {
                    arrayRespuesta.push(j);
                }
            }
        }
    }
    return arrayRespuesta;
}

let array = [9, 8 , 0, -3];
console.log('Los numeros perdidos son: ',numerosPerdidos(array));



