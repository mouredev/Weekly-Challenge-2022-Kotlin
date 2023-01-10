/*
 * Reto #44
 * BUMERANES
 * Fecha publicación enunciado: 02/10/22
 * Fecha publicación resolución: 07/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que retorne el número total de bumeranes de un array de números
 * enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números seguidos, en el que el
 *   primero y el último son iguales, y el segundo es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function numberOfBoomerangs(list){
	// if the length of the list is less than 3, it can't have any boomerangs
	if(list.length < 3) return `There are no bommerangs in [${list}], there should be at least 3 numbers!`;
	let counter = 0; // counts the total number of boomerangs
	// loop to go through the list
	for(let i=0; i<list.length-2; i++){
		let rNum = list[i]; // updates the rNum's value
		if(list[i+2] === rNum) counter++; // if rNum is equal to the number 2 positions ahead of it -> counter++
	}
	return `There ${counter == 1 ? 'is' : 'are'} ${counter} ${counter == 1 ? 'boomerang' : 'boomerangs'} in [${list}]`;
}

console.log(numberOfBoomerangs([2, 1, 2, 3, 3, 4, 2, 4])); // There are 2 boomerangs in [2,1,2,3,3,4,2,4]
console.log(numberOfBoomerangs([2, 1, 2, 1, 2])); // There are 3 boomerangs in [2,1,2,1,2]
console.log(numberOfBoomerangs([1, 2, 3, 4, 5])); // There are 0 boomerangs in [1,2,3,4,5]
console.log(numberOfBoomerangs([2, 2, 2, 2, 2])); // There are 3 boomerangs in [2,2,2,2,2]
console.log(numberOfBoomerangs([2, -2, 2, -2, 2])); // There are 3 boomerangs in [2,-2,2,-2,2]
console.log(numberOfBoomerangs([1, 2, 1])) // There is 1 boomerang in [1,2,1]
console.log(numberOfBoomerangs([2, -2])); // There are no bommerangs in [2,-2], there should be at least 3 numbers!
console.log(numberOfBoomerangs([2])); // There are no bommerangs in [2], there should be at least 3 numbers!
console.log(numberOfBoomerangs([])); // There are no bommerangs in [], there should be at least 3 numbers!