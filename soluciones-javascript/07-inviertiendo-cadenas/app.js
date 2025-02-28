/*
 * Crea un programa que invierta el orden de una cadena de texto
 * sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 */

const reverseTextString = (string) => {

    const stringFormatter = string.trim();
    let reverseText = "";

    for (let i = 1; i <= stringFormatter.length; i++) {
        
        reverseText += stringFormatter[ stringFormatter.length - i];

    }
    
    return reverseText;
    
}

console.log(reverseTextString(" Hola Mundo "));