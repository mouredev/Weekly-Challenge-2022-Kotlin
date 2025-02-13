/*
 * Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes
 *   de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes
 *   de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que
 *   lo resuelvan directamente.
 */

/**
 * Función que determina los iguales o no iguales de dos arrays dependiendo del valor del booleano
 * @param {Array} arr1 Array de valores
 * @param {Array} arr2 Array de valores
 * @param {Boolean} boolean Variable que determina el flujo de la función
 */
const conjuntos = (arr1, arr2, boolean) => {
    const resultado = [];

    if (boolean) {
        for (let i = 0; i < arr1.length; i++) {
            for (let j = 0; j < arr2.length; j++) {
                if (arr1[i] === arr2[j]) {
                    if (!resultado.includes(arr1[i]) || !resultado.includes(arr2[j])) {
                        resultado.push(arr1[i]);
                    }
                }
            }
        }
    } else {
        for (let i = 0; i < arr1.length; i++) {
            for (let j = 0; j < arr2.length; j++) {
                if (arr1[i] !== arr2[j]) {
                    if (!resultado.includes(arr1[i]) || !resultado.includes(arr2[j])) {
                        if (!arr1.includes(arr2[j]) && !resultado.includes(arr2[j])) {
                            resultado.push(arr2[j]);
                        } else if (!arr2.includes(arr1[i]) && !resultado.includes(arr1[i])) {
                            resultado.push(arr1[i]);
                        }
                    }
                }
            }
        }
    }

    return resultado;
};

console.log(conjuntos([1, 23, 4, 56, 7, 89, 10], [1, 23, 4, 5, 6, 67, 8, 1, 210, 10], true));
console.log(conjuntos([1, 23, 4, 56, 7, 89, 10], [1, 23, 4, 5, 6, 67, 8, 1, 210, 10], false));
