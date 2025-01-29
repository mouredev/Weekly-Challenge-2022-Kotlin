/*
 * Crea un programa se encargue de transformar un número
 * decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 */

const decimalToBinary = (number) => {
    let numberBinary = [];
    let numberNew = number; 

    while (numberNew > 0) {
        numberBinary.unshift(Math.floor(numberNew % 2));
        numberNew = Math.floor(numberNew / 2);
    }

    return numberBinary.join("");
    

};

console.log(decimalToBinary(10));
