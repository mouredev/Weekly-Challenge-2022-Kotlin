/*
 * Crea una función que sume 2 números y retorne su resultado pasados
 * unos segundos.
 * - Recibirá por parámetros los 2 números a sumar y los segundos que
 *   debe tardar en finalizar su ejecución.
 * - Si el lenguaje lo soporta, deberá retornar el resultado de forma
 *   asíncrona, es decir, sin detener la ejecución del programa principal.
 *   Se podría ejecutar varias veces al mismo tiempo.
 */

/**
 * Función que suma dos números y que los devuelve en cierto intervalo de tiempo
 * @param {Number} num1 Numero 1 que recibe la función
 * @param {Number} num2 Numero 2 que recibe la función
 * @param {Number} segundosFinalizar Numero de tiempo en segundos
 * @returns Resultado De numeros
 */
const parandoElTiempo = async (num1, num2, segundosFinalizar) => {
    const suma = new Promise((resolve) => {
        setTimeout(() => {
            return resolve(num1 + num2); 
        }, segundosFinalizar * 1000);
    });
    return await suma;
}

parandoElTiempo(2, 3, 3).then((resultado) =>
    console.log(`Resultado de 2 + 3 después de 3 segundos: ${resultado}`)
);

parandoElTiempo(5, 7, 2).then((resultado) =>
    console.log(`Resultado de 5 + 7 después de 2 segundos: ${resultado}`)
);