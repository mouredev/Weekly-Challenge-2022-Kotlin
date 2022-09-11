// solucion reto #7
// Dificultad media

import { StringDecoder } from "string_decoder";

// CONTANDO PALABRAS

// Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
// Los signos de puntuación no forman parte de la palabra.
// Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
// No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.

const phrase:string = 'Hola, mi nombre es brais. Mi nombre completo es Brais Moure (MoureDev).';

const justLetters:string =  phrase.toLowerCase().replace(/([,().' '])/g, ''); 

const howManyWords = ():any => {
    let result: { [key: string]: number, } = {};
    let index = 0;

    for (index; index< justLetters.length ; index++) {
        if (result[justLetters[index]]=== undefined) {
            result[justLetters[index]] = 1
        } else {
            result[justLetters[index]] = result[justLetters[index]]+1
        }
    }

    for (let key in result) {
        console.log(`"${key}" se ha repetido ${result[key]} ${result[key] === 1 ? "vez" : "veces"}`)
        };

};

howManyWords()

// Big(0) time complexity = 0(2n)
// big(0) space complexity = 0(2n)