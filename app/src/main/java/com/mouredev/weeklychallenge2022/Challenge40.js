/*
 * Reto #40
 * TRIÁNGULO DE PASCAL
 * Fecha publicación enunciado: 03/10/22
 * Fecha publicación resolución: 10/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sea capaz de dibujar el "Triángulo de Pascal" indicándole
 * únicamente el tamaño del lado.
 * - Aquí puedes ver rápidamente cómo se calcula el triángulo:
 *   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

function pascalTriangle(size){
	let lastRow = []; // empty list to save the values of the last row
	for(let row=0; row<size; row++){
		let currentRow = []; // empty list to save the values of the current row
		let triangleRow = ""; // empty string to save the values of the current row and print them
		for(let element=0; element<=row; element++){
			if(element>=1 && element<row){ // untill row == 2 won't enter here
				// calculate each value
				let value = lastRow[element-1] + lastRow[element];
				// save the values in the string with a white space after the value
				triangleRow = triangleRow.concat(`${value} `);
				// save the values in the current row list
				currentRow.push(value);
			} else { // enters here at the beginning and ending of each row -> value = 1 always
				triangleRow = triangleRow.concat("1 ");
				currentRow.push(1);
			}
		}
		// prints the result
		console.log(" ".repeat(size-row) + triangleRow);
		lastRow = currentRow; // current row becomes the last row
	}
}

pascalTriangle(5);
/* prints:
     1  
    1 1  
   1 2 1  
  1 3 3 1  
 1 4 6 4 1
*/
pascalTriangle(1); // prints: 1
pascalTriangle(0); // nothing is printed
pascalTriangle(-5); // nothing is printed