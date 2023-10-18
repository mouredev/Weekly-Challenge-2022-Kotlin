/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

//? Check if the binary has zeros and ones only
function checkBinary(binary) {
    for (let i = 0; i < binary.length; i++){
        if (binary[i] !== '1' && binary[i] !== '0') {
            return false;
        }
    }
    return true;
}

// Convert binary number to decimal number
function binaryToDecimal(binary) {
    binary = binary.toString();
    if (!checkBinary(binary)) {
        throw new Error("Binary number must contains zeros or ones only");
    }

    let decimal = 0;
    for (let i = 0; i < binary.length ;i++){
        decimal += Number(binary[i]) * Math.pow(2,binary.length-1-i);
    }
    return decimal;
}


let binary = 10000001;
console.log(binaryToDecimal(binary));
