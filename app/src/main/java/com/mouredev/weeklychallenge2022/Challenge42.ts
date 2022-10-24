/*
 * Reto #42
 * CONVERSOR DE TEMPERATURA
 * Fecha publicación enunciado: 17/10/22
 * Fecha publicación resolución: 24/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que transforme grados Celsius en Fahrenheit y viceversa.
 * - Para que un dato de entrada sea correcto debe poseer un símbolo "°" y su unidad ("C" o "F").
 * - En caso contrario retornará un error.
 * - ¿Quieres emplear lo aprendido en este reto?
 *   Revisa el reto mensual y crea una App: https://retosdeprogramacion.com/mensuales2022
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


/**
 * Enumerado con las unidades de temperatura
 */
enum TemperatureUnit {
  Celsius = "°C",
  Fahrenheit = "°F",
}

/**
 * Funcion que convierte la temperatura de una unidad de grados Centigrados a Fahrenheit
 * @param temperature Expresion que contiene la temperatura a convertir con su unidad
 * @returns Temperatura convertida a Fahrenheit o a Centigrados
 */
export function convertTemperature(temperature: string): string {

  const regExptemperature = /^(-?\d+(.\d+)?)(°)([CF])/g;
  const regExpNumber = /\-?\d+(.\d+)?/g;
  const regExpUnit = /\°[CF]/g;

    if (regExptemperature.test(temperature)) {

        let value = temperature.match(regExpNumber);
        let unit = temperature.match(regExpUnit);

        const temperatureValue = Number(value);

        if (unit?.[0]=== TemperatureUnit.Celsius) {
            return `${((temperatureValue * 9) / 5 + 32)}${TemperatureUnit.Fahrenheit}`;
        } else if (unit?.[0] === TemperatureUnit.Fahrenheit) {
            return `${(((temperatureValue - 32) * 5) / 9)}${TemperatureUnit.Celsius}`;
        }
        return `The unit ${unit} is not valid`;
    }
    else{
        return `The temperature ${temperature} is not valid`;
    }
}

console.log(convertTemperature("-12°C"));
console.log(convertTemperature("-4.2°F"));



