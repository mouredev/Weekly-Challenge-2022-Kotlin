
/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function countVowels(str){
  	let regex = /[aeiou]/gi;
	let text = str.match(regex) // only vowels
	let result = {} //counter by vowel
	text.forEach(function(i){
		if (typeof result[i] == 'undefined'){
  			result[i]=0
    	}
    	result[i]++ 
	})
	let max = Math.max(...Object.values(result)) // get the max value
	return Object.keys(result).find(key => result[key] === max) //return the index with the max value
}
let str = 'Please count this text and count vowels'
console.log(countVowels(str))
