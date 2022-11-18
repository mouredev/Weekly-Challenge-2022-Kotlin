/*
 * Reto #16
 * EN MAYÚSCULA
 * Fecha publicación enunciado: 18/04/22
 * Fecha publicación resolución: 25/04/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function capitalize(str){
	let result = ""; // empty string to save the result
	// to know when we have to capitalize a char. It starts being true because the first char must be capitalized
	let nextIsUpper = true;
	for(c of str){
		if(nextIsUpper) result += c.toUpperCase();
		else result += c;
		// if the char match one of these, next char must be capitalized
		nextIsUpper = /[^A-z0-9ñÑ]/g.test(c);
	}
	console.log(result);
}

capitalize("Hi, how are you?");
capitalize("Hi           how are you?");
capitalize("el niño ñoño")