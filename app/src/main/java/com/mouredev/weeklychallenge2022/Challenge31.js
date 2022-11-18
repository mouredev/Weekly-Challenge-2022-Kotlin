/*
 * Reto #31
 * AÑOS BISIESTOS
 * Fecha publicación enunciado: 01/08/22
 * Fecha publicación resolución: 08/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que imprima los 30 próximos años bisiestos siguientes a uno dado.
 * - Utiliza el menor número de líneas para resolver el ejercicio.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function print30LeapYears(year){
	let printed = 0; // to count how many years are printed
	for(let i=0; printed<30; i++){
		// if it is a leap year -> prints the year and updates the counter
		if((year+i)%4===0 && ((year+i)%400===0 || (year+i)%100!==0)){ // => condition to be a leap year
			console.log(`${printed+1}: ${year+i}`);
			printed++;
		}
	}
}

print30LeapYears(1999);