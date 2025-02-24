/*
 * #13 ¿Es un Palindromo?
 * Escribe una función que reciba un texto y retorne verdadero o
 * falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee
 * de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 */

/**
 * Función para verificar si una cadena de texto es palindromo o no
 * @param {String} texto 
 */
const esPalindromo = ( texto ) => {

    const textoFormateado = texto
        .replace(/\s+/g, "")
        .split('')
        .map( (char, index, array) => array[ index === 0 ? array.length - 1 : array.length - (index + 1)] )
        .join('')
        .toLowerCase();

    return textoFormateado === texto.replace(/\s+/g, "").toLocaleLowerCase();


}

console.log(esPalindromo('Ana lleva al oso la avellana'));
console.log(esPalindromo('Sé verlas al revés'));
console.log(esPalindromo('Somos o no somos'));
console.log(esPalindromo('Ana lava lana'));