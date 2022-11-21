/*
 * Reto #30
 * MARCO DE PALABRAS
 * Fecha publicación enunciado: 26/07/22
 * Fecha publicación resolución: 01/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
 * un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function drawFrame(str){
	let largestWidth = 0; // to save the maximum number of characteres for the frame
	let newStr = []; // empty array to save the words
	str.split(" ").forEach(word => {
		if((word.length + 4) > largestWidth) largestWidth = word.length + 4; // calculate the largest width
		if(word !== "") newStr.push(word); // save the words if they're not empty
	});
	let wordCounter = newStr.length; // count how many words there are
	for(let row=0; row<(wordCounter+2); row++){
		// code for the first and last rows
		if(row === 0 || row === (wordCounter+1)) console.log("*".repeat(largestWidth));
		// code for the rest of the rows
		else{
			for(let col=0; col<=largestWidth; col++){
				// code for the first and last columns
				if(col === 0 || col === largestWidth) process.stdout.write("*"); // process.stdout.write() -> prints without \n at the end
				// code for the rest of the columns
				else if(col === 2){
					// in the 2nd column the word is printed and the col index is updated
					process.stdout.write(newStr[row-1]);
					col += newStr[row-1].length;
				}
				// if it's not the 1st, the 2nd or the last column, print " "
				else process.stdout.write(" ");
			}
			console.log(""); // used to jump to the next row
		}
	}
}

drawFrame("What do you think of the challenge?");
drawFrame("What do            you think of the challenge?");
drawFrame("How many community code challenges have you solved?");
drawFrame("This is gonna be smaller");