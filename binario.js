/*
 * Enunciado: Crea un programa se encargue de transformar un número binario
 * a decimal sin utilizar funciones propias del lenguaje que 
 * lo hagan directamente.
 */


let getRandom = (min, max) => { return Math.floor(Math.random() * (max - min + 1) + min) };

let getBinario = () => {
    let binario = "";
    for ( let i = 0; i < 8; i++ ) {
        binario += getRandom(0,1);
    }
    return binario;
}

let fromBinToDec = num => {
    let decimal = 0;
    for ( let i = 0; i < num.length; i++ ) {
        decimal += num[i] * 2 ** (num.length - 1 - i);
    }
    return `En binario: ${num} \nen decimal: ${decimal}`
};

console.log(fromBinToDec(getBinario()));