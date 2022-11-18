/*
 * Reto #41
 * LA LEY DE OHM
 * Fecha publicación enunciado: 10/10/22
 * Fecha publicación resolución: 17/10/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que calcule el valor del parámetro perdido correspondiente a la ley de Ohm.
 * - Enviaremos a la función 2 de los 3 parámetros (V, R, I), y retornará el valor del tercero (redondeado a 2 decimales).
 * - Si los parámetros son incorrectos o insuficientes, la función retornará la cadena de texto "Invalid values".
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

// put parameters inside {} to choose theis names when the function is called
function ohm({v, i, r}){
	try{
		if(v===undefined && i!==undefined && r!==undefined) return `V = ${(i * r).toFixed(2)} V`;
		else if(v!==undefined && i===undefined && r!==undefined){
			// if r = 0 -> I wanna throw an error
			if(r === 0) throw new Error("Number divided by 0!");
			// else -> return the value
			return `I = ${(v / r).toFixed(2)} A`;
		}
		else if(v!==undefined && i!==undefined && r===undefined){
			// if r = 0 -> I wanna throw an error
			if(i === 0) throw new Error("Number divided by 0!");
			// else -> return the value
			return `R = ${(v / i).toFixed(2)} Ohm`;
		}
	} catch(err) {
		return err; // if an error is thown, returns its value
	}
	return "ERROR: Invalid values!"; // if number of parameters given != 2 -> return "ERROR: Invalid values!"
}

// put the patameterns inside {} to choose which parameter's value is defined
console.log(ohm({})); // ERROR: Invalid values!
console.log(ohm({v : 5.0})); // ERROR: Invalid values!
console.log(ohm({v : 5.0, r : 4.01})); // I = 1.25 A
console.log(ohm({v : 5.0, i : 4.01})); // R = 1.25 Ohm
console.log(ohm({r : 5.0, i : 4.01})); // V = 20.05 V
console.log(ohm({v : 5.125, r : 4.01})); // I = 1.28 A
console.log(ohm({v : 5.0, i : 4.1251})); // R = 1.21 Ohm
console.log(ohm({r : 5.0, i : 4.1251})); // V = 20.63 V
console.log(ohm({v : 5.0, r : 0.0})); // [Error: Number divided by 0!]
console.log(ohm({v : 5.0, i : 0.0})); // [Error: Number divided by 0!]
console.log(ohm({r : 5.0, i : 0.0})); // V = 0.00V
console.log(ohm({v : 5.0, r : 4.0, i : 3.0})); // ERROR: Invalid values!