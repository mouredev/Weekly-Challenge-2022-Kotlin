/*
 * Crea una función que reciba un texto y muestre cada palabra en una línea,
 * formando un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 */

/**
 * 
 * @param {String} sentence 
 */
const marcoDePalabras = (sentence) => {

    const sentenceLengthMajor = Math.max(...sentence.split(/[^A-Za-zÁ-Úá-úÜüÑñ]+/).map( element => element.length));

    const inicioFinMarco = "*".repeat(sentenceLengthMajor + 4);
    

    const palabrasSeparadas = inicioFinMarco +  "\n"  + sentence.trim().split(' ').map( word  => {
        
        const espacios = word.length === sentenceLengthMajor ? 0 : sentenceLengthMajor - word.length;
        
        return "* " + word + " ".repeat(espacios + 1) + "*"; 
    }).join('\n').concat("\n" + inicioFinMarco);
    
    console.log(palabrasSeparadas);
    
}

marcoDePalabras("¿Qué te parece el reto?");
marcoDePalabras("Esto es otro ejemplo más");
marcoDePalabras("Esto es una declaración de amor");