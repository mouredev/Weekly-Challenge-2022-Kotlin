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


/**
 * Función que transforma un número binario a decimal
 * @param binary Número binario a transformar
 * @returns Número decimal
 */
export function binaryToDecimal(binary: string): number {
    var decimal = 0;
    if(checkBinary(binary)){
        binary.split('').reverse().forEach((value, index) => {
            if(value =='1'){
                decimal += Number.parseInt(value) * Math.pow(2, index);
            }
        })

    }
    else{
        console.log("El número binario no tiene el formato correcto");
    }

    return decimal;
}

/**
 * Función que comprueba si el número binario tiene el formato correcto
 * @param binary Número binario a comprobar
 * @returns Booleano que indica si el número binario tiene el formato correcto
 */
function checkBinary(binary: string): boolean {
     return /^[0-1]{1,}$/g.test(binary);
}

console.log(binaryToDecimal("100100001")) //289
console.log(binaryToDecimal("10121011")) // 0 (El número binario no tiene el formato correcto)
