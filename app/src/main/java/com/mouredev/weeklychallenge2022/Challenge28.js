/*
 * Reto #28
 * MÁQUINA EXPENDEDORA
 * Fecha publicación enunciado: 11/07/22
 * Fecha publicación resolución: 18/07/22
 * Dificultad: MEDIA
 *
 * Enunciado: Simula el funcionamiento de una máquina expendedora creando una operación
 * que reciba dinero (array de monedas) y un número que indique la selección del producto.
 * - El programa retornará el nombre del producto y un array con el dinero de vuelta (con el menor
 *   número de monedas).
 * - Si el dinero es insuficiente o el número de producto no existe, deberá indicarse con un mensaje
 *   y retornar todas las monedas.
 * - Si no hay dinero de vuelta, el array se retornará vacío.
 * - Para que resulte más simple, trabajaremos en céntimos con monedas de 5, 10, 50, 100 y 200.
 * - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function vendingMachine(money, selection){
	// create a constant with the products of the vending machine
	const products = {
        "1": ["Water", 50],
        "2": ["Coca-Cola", 100],
        "4": ["Beer", 155],
        "5": ["Pizza", 200],
        "10": ["Donut", 75]
	}
	// sum the entered money
	let enteredMoney = 0;
	for(var coin in money){
		enteredMoney += money[coin];
	}
	for(var key in products){
		// check if the selected product exists
		if(selection.toString() === key){
			// check if there is enough money -> if not: return message + money
			if(enteredMoney < products[key][1]){
				return [`The product with code '${selection}' costs ${products[key][1]}. You entered ${enteredMoney}.`, money];
			}
			// if there's enough money -> calculate how much must be returned
			let pendingMoney = enteredMoney - products[key][1];
			return [products[key][0], returnMoney(pendingMoney)]; // return the name of the product and the pending money
		}
	}
	// if the product doesn't exist -> return message + money
	return [`The product with code '${selection}' doesn't exist.`, money];
}

function returnMoney(pendingMoney){
	if(pendingMoney === 0) return [0]; // no money to return
	let newMoney = []; // empty list -> is gonna be the result
	// save Money values in an array so it can be sorted
	const moneyValues = [];
	for(var coin in Money){moneyValues.push(Money[coin]);}
	// get moneyValues sorted from the biggest to the smallest value
	moneyValues.sort((a, b) => b - a);
	// loops
	let j=0;
	while(j<moneyValues.length){ // loop starting using the biggest value of Money
		while(pendingMoney>=moneyValues[j]){ // while pending is bigger or equal to the Money value
			pendingMoney -= moneyValues[j]; // substract Money value to the pending
			newMoney.push(moneyValues[j]); // add that Money value to the result
		}
		j++;
	}
	return newMoney; // return the result
}

// object with the money
const Money = {
	FIVE: 5,
	TEN: 10,
	FIFTY: 50,
	ONEHUNDRED: 100,
	TWOHUNDRED: 200
}

console.log(vendingMachine([Money.FIVE, Money.FIVE, Money.TEN, Money.TEN, Money.TEN, Money.FIVE], 1)); // [ "The product with code '1' costs 50. You entered 45.", [5, 5, 10, 10, 10, 5] ]
console.log(vendingMachine([Money.FIVE, Money.FIVE, Money.TEN, Money.TEN, Money.TEN, Money.FIVE], 3)); // [ "The preduct with the code 3 doesn't exist.", [5, 5, 10, 10, 10, 5] ]
console.log(vendingMachine([Money.FIVE, Money.FIVE, Money.TEN, Money.TEN, Money.TEN, Money.FIVE, Money.FIFTY], 1)); // [ 'Water', [10, 10, 10, 10, 5] ]
console.log(vendingMachine([Money.TWOHUNDRED], Money.FIVE)); // [ 'Pizza', [ 0 ] ]