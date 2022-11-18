/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function isSorted(array){
	// need to know if the array is sorted
	const compareArrays = (arr1, arr2) => {
		if(arr1.length !== arr2.length) return false; // both arrays are not equals
		return arr1.every((value, i) => value === arr2[i]); // both arrays are equals
	}
	// create a sorted array from the given array
	let arrToCompare = array.slice().sort((a, b) => a - b);
	// check if it is not sorted from smallest to largest -> if not, check otherwise
	if(!compareArrays(array, arrToCompare)){
		arrToCompare = array.slice().sort((a, b) => b - a);
		if(compareArrays(array, arrToCompare)) return true; // if sorted from largest to smallest, return true
		return false;
	}
	return true; // if sorted from smallest to largest, return true
}

function lostNumbers(array){
	// check if the array has a repeated number
	for(let i=0; i<array.length; i++){
		for(let j=i+1; j<array.length; j++){
			if(array[j] === array[i]) throw new Error("This array has repeated numbers!");
		}
	}
	// check if the array is sorted
	const sorted = isSorted(array);
	if(!sorted) throw new Error("This array is not sorted!");
	else{
		var newArr = [];
		if(array[0]<array[array.length-1]){
			for(let i=array[0]; i<=array[array.length-1]; i++){
				newArr.push(i);
			}
		} else {
			for(let i=array[0]; i>=array[array.length-1]; i--){
				newArr.push(i);
			}
		}
	}
	return newArr;
}

try{
	console.log(lostNumbers([1, 3, 5])); // [ 1, 2, 3, 4, 5 ]
	console.log(lostNumbers([5, 3, 1])); // [ 5, 4, 3, 2, 1 ]
	console.log(lostNumbers([5, 1])); // [ 5, 4, 3, 2, 1 ]
	console.log(lostNumbers([-5, 1])); // [ -5, -4, -3, -2, -1, 0, 1 ]
	//console.log(lostNumbers([1, 3, 3, 5])); // Error: This array has repeated numbers!
	//console.log(lostNumbers([5, 7, 1])); // Error: This array is not sorted!
	//console.log(lostNumbers([10, 7, 7, 1])); // Error: This array has repeated numbers!
} catch(err) {
	console.error(err);
}