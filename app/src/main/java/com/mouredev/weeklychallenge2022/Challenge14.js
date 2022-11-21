/*
 * Reto #14
 * ¿ES UN NÚMERO DE ARMSTRONG?
 * Fecha publicación enunciado: 04/04/22
 * Fecha publicación resolución: 11/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Escribe una función que calcule si un número dado es un número de Amstrong (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información al respecto.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function isNarcissist(number){
	if(number < 0) return false; // negative numbers aren't Armstrong's numbers
	let nDigits = number.toString().length; // to calculate the number of digits of each number
	let sum = 0; // initial value for sum
	// equation to check if it is an Armstrong number
	number.toString().split("").forEach(n => sum += parseInt(n) ** nDigits);
	// result
	if(number === sum) return true;
	return false;
}

console.log(isNarcissist(371)); // true
console.log(isNarcissist(-371)); // false
console.log(isNarcissist(372)); // false
console.log(isNarcissist(0)); // true