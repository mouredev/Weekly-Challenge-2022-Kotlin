/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function calculateSet(arr1, arr2, bool){
	let result = new Set(); // empty set -> to not repeat the values
	for(item1 of arr1){
		// if bool=false and item1 is not in arr2 -> add item1 to result set
		if(!(bool) && !(arr2.includes(item1))) result.add(item1);
		for(item2 of arr2){
			// if bool=true and both items are equals -> add any of those (item1 for example) to the result
			if(bool && item1===item2) result.add(item1);
			// if bool=false and arr1 doesn't include item2 -> add item2 to the result
			else if(!(bool) && !(arr1.includes(item2))) result.add(item2);
		}
	}
	return Array.from(result); // returns an array with the results
}

console.log(calculateSet([1,2,3,3,4], [2,2,3,3,3,4,6], true)); // [2, 3, 4]
console.log(calculateSet([1,2,3,3,4], [2,2,3,3,3,4,6], false)); // [1, 6]