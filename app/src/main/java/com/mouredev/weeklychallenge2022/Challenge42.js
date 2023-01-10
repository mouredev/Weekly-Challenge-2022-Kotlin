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

function temperatureConverter(degrees){
	let myRegex = /(\d)(°)(C|F)/g; // regex pattern to check the format: NUMBER°C or NUMBER°F
	try{
		if(!myRegex.test(degrees.replace(/ /g, ""))) throw new Error("Invalid values!");
		let dNum = degrees.trim().replace(/[ °C]/, ""); // gets the number of the degrees
		if(dNum.endsWith("C")){
			// if the string ends with "C" -> it's in Celsius and must be converted to Fahrenheit
			return `${((parseFloat(dNum) * 9/5) + 32).toFixed(2)}°F`;
		} else {
			// if the string doesn't end with "C" -> it's in Fahrenheit and must be converted to Celsius
			return `${((parseFloat(dNum) - 32) * 5/9).toFixed(2)}°C`;
		}
	} catch(err){
		return err; // error message
	}
}

console.log(temperatureConverter("100°C")); // 212.00°F
console.log(temperatureConverter("100°F")); // 37.78°C
console.log(temperatureConverter("100C")); // [Error: Invalid values!]
console.log(temperatureConverter("100F")); // [Error: Invalid values!]
console.log(temperatureConverter("100")); // [Error: Invalid values!]
console.log(temperatureConverter("100")); // [Error: Invalid values!]
console.log(temperatureConverter("- 100 °C ")); // -148.00°F
console.log(temperatureConverter("- 100 °F ")); // -73.33°C
console.log(temperatureConverter("100A°C")); // [Error: Invalid values!]
console.log(temperatureConverter("100A°F")); // [Error: Invalid values!]
console.log(temperatureConverter("°C")); // [Error: Invalid values!]
console.log(temperatureConverter("°F")); // [Error: Invalid values!]