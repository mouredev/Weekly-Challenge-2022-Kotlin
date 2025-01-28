/*
 * Crea un programa que sea capaz de transformar texto natural a código
 * morse y viceversa.
 * - Debe detectar automáticamente de qué tipo se trata y realizar
 *   la conversión.
 * - En morse se soporta raya "—", punto ".", un espacio " " entre letras
 *   o símbolos y dos espacios entre palabras "  ".
 * - El alfabeto morse soportado será el mostrado en
 *   https://es.wikipedia.org/wiki/Código_morse.
 */

console.log({dataMorseCode});

const codigoMorse = (text) => {

    return text.toUpperCase().split('').map( word => {
        
        if(dataMorseCode[word]){
            return dataMorseCode[word]
        } else if (word === " "){
            return "/";
        }else {
            return "";
        }

    }).join(" ");

}

console.log(codigoMorse("Prueba x"));
console.log(codigoMorse("Otra prueba con diferasduhwq signficado, ayuda ´++´{}"));
console.log(codigoMorse("Me gusta la cigueña, la malta y la inmal también jaja esxs xsxsada"));