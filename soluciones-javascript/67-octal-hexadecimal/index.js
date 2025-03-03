/*
 * Crea una función que reciba un número decimal y lo trasforme a Octal
 * y Hexadecimal.
 * - No está permitido usar funciones propias del lenguaje de programación que
 * realicen esas operaciones directamente.
 */

const octalHexadecimal = ( num ) => {

    const decimalToOctal = ( number ) => {
        let resultOctal = "";
        while (number > 0) {
            resultOctal = (number % 8) + resultOctal;
            number = Math.floor(number / 8);
        }
        return resultOctal;
    }

    const decimalToHex = ( number ) =>{
        let resultHexadecimal = "";
        const caracteresHex = "0123456789ABCDEF";
        while ( number > 0 ) {
            resultHexadecimal = caracteresHex[number % 16] + resultHexadecimal;
            number = Math.floor(number / 16);
        }
        return resultHexadecimal;
    }

    const resultOctal = decimalToOctal( num );
    const resultHexadecimal = decimalToHex(num);

    return `Número Octal: ${ resultOctal }\nNúmero Hexadecimal: ${resultHexadecimal}`;

}

console.log(octalHexadecimal(156));