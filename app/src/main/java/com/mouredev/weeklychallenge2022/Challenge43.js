/*
 * Reto #43
 * TRUCO O TRATO
 * Fecha publicación enunciado: 24/10/22
 * Fecha publicación resolución: 02/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
 * un listado (array) de personas con las siguientes propiedades:
 * - Nombre de la niña o niño
 * - Edad
 * - Altura en centímetros
 *
 * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
 * siguiendo estos criterios:
 * - Un susto por cada 2 letras del nombre por persona
 * - Dos sustos por cada edad que sea un número par
 * - Tres sustos por cada 100 cm de altura entre todas las personas
 * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
 *
 * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
 * siguiendo estos criterios:
 * - Un dulce por cada letra de nombre
 * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
 * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
 * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function trickOrTreat(action, peopleList){
	// constants for all the scares and candies
	const scares = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"];
	const candies = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"];
	let result = ""; // to save the result as string
	let totalHeight = 0; // to calculate the total height when the action is "TRICK"
	// function to get a random number between to numbers (both includes)
	const getRandom = (min, max) => {
		// in case of giving floats as "min" or "max", we get their values as integers
		min = Math.ceil(min);
		max = Math.floor(max);
		// return the random number between min and max
		return Math.floor(Math.random() * (max - min + 1) + min);
		/* Math.random() returns a random float number between 0 and 1, so we multiply it takin in count our limits
		and convert it into integer using Math.floor(), which takes the lowest value of the float */
	}
	peopleList.forEach(person => {
		if(action === "TRICK"){
			// NAMES -> 1 scare for every two letters of the name per person
			for(let i=1; i<person.name.length; i+=2){
				result += scares[getRandom(0, scares.length - 1)];
			}
			// AGES -> 2 scares for each age that is multiple of 2
			if(person.age % 2 === 0) result += scares[getRandom(0, scares.length - 1)] + scares[getRandom(0, scares.length - 1)];
			// HEIGHT -> 3 scares for every 100 cm of height among all persons
			totalHeight += person.height;
		}
		else if(action === "TREAT"){
			// NAMES -> 1 candy for each letter of name
			for(char of person.name) result += candies[getRandom(0, candies.length - 1)];
			// AGES -> 1 candy for every three years of age up to a maximum of 10 years per person
			for(let i=3; i<=person.age; i+=3){
				if(i > 10) break;
				result += candies[getRandom(0, candies.length - 1)];
			}
			// HEIGHT -> 2 candies for every 50 cm of height up to a maximum of 150 cm per person
			for(let i=50; i<=person.height; i+=50){
				if(i > 150) break;
				result += candies[getRandom(0, candies.length - 1)] + candies[getRandom(0, candies.length - 1)];
			}
		}
	});
	if(action === "TRICK"){
		// 3 scares for every 100 cm of height among all people
		for(let i=100; i<=totalHeight; i+=100){
			result += scares[getRandom(0, scares.length - 1)] + scares[getRandom(0, scares.length - 1)] + scares[getRandom(0, scares.length - 1)];
		}
	}
	return result;
}

// a class named Person to define every atributes of each person
class Person{
	constructor(name, age, height){
		this.name = name;
		this.age = age;
		this.height = height;
	}
}

console.log(trickOrTreat("TRICK", [
	new Person("Naia", 24, 163),
	new Person("Cristina", 28, 153),
	new Person("Irene", 21, 166),
	new Person("June", 24, 172)]));
	// prints: 🦇🕷👻🕸💀🎃🕸🕸👻👻🕸🦇🎃🎃🦇🕷🕸💀🎃🦇🦇🦇👻🕸👻🎃🦇💀🦇🦇💀🎃👻🦇

console.log(trickOrTreat("TREAT", [
	new Person("Naia", 24, 163),
	new Person("Cristina", 28, 153),
	new Person("Irene", 21, 166),
	new Person("June", 24, 172)]));
	// prints: 🍬🍫🍬🧁🍡🍪🍬🍫🍰🍩🍬🍡🍪🍩🧁🍫🧁🍬🍭🍬🧁🍬🍰🍭🧁🍬🍩🍰🍩🍡🍭🍫🍰🍫🍡🧁🍭🍭🍫🍡🍫🍫🍰🍩🍰🍭🍭🧁🍡🍭🍬🍡🍩🍬🧁🧁🍰