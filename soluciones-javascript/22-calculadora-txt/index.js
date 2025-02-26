/*
 * Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su
 * resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un
 *   símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*"
 *   y división "/".
 * - El resultado se muestra al finalizar la lectura de la última
 *   línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han
 *   podido resolver las operaciones.
 */

const fs = require("fs");

try {
    const data = fs.readFileSync("./Challenge21.txt", "utf-8");
    const lines = data.split("\r\n").filter((line) => line.trim() !== "");

    console.log({ lines });

    let resultado = Number(lines[0]);

    for (let i = 1; i < lines.length; i += 2) {
        let operacion = lines[i];
        let numero = Number(lines[i + 1]);

        if (isNaN(numero)) {
            return "Error al Leer el dato";
        }

        switch (operacion) {
            case "+":
                resultado += numero;
                break;
            case "-":
                resultado -= numero;
                break;
            case "*":
                resultado *= numero;
                break;
            case "/":
                resultado /= numero;
                break;
            default:
                return resultado;
        }
    }

    console.log({ resultado });
} catch (err) {
    console.error("Error al leer el archivo:", err);
}
