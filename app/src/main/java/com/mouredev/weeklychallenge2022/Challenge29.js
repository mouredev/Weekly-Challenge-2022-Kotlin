/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function sort(numbers, asc){
	let aux; // auxiliary variable
	// BUBBLE METHOD
	for(let i=0; i<numbers.length; i++){
		for(let j=0; j<numbers.length; j++){
			/* if asc=true -> if(numbers[j] < numbers[j-1])
			   if asc=false -> if(numbers[j] > numbers[j-1]) */
			if((asc)? numbers[j]<numbers[j-1] : numbers[j]>numbers[j-1]){
				aux = numbers[j]; // save current value
				numbers[j] = numbers[j-1]; // change current value
				numbers[j-1] = aux; // modify the previous number
			}
		}
	}
	return numbers; // return the result
}

console.log(sort([4, 6, 1, 8, 2], true)) // 1, 2, 4, 6, 8
console.log(sort([4, 6, 1, 8, 2], false)) // 8, 6, 4, 2, 1