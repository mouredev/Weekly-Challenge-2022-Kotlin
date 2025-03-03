/*
 * Crea un programa se encargue de transformar un número binario
 * a decimal sin utilizar funciones propias del lenguaje que
 * lo hagan directamente.
 */

/**
 * 
 * @param {Number} numeroBinario 
 */
const binaryToDecimal = (numeroBinario) => {

    const stringNumeroBinario = numeroBinario.toString();
    let resultado = 0;
    let exponente = 0;

    for (let i = 1; i <= stringNumeroBinario.length; i++) {
        
        const number = Number(stringNumeroBinario[ stringNumeroBinario.length - i]);

        resultado += (number * Math.pow(2, exponente));
        exponente++;
    }

    return resultado; 

}

console.log(binaryToDecimal(1011));
console.log(binaryToDecimal(1010));
console.log(binaryToDecimal(11111111));