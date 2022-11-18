/*
 * Reto #18
 * TRES EN RAYA
 * Fecha publicación enunciado: 02/05/22
 * Fecha publicación resolución: 09/05/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que analice una matriz 3x3 compuesta por "X" y "O" y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta. O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta. Se podría representar con un vacío "", por ejemplo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function checkTicTacToe(board){
	let xWins = false;
	let oWins = false;
	if(board.length !== 3) return null; // the board has more than 3 rows
	// check rows and columns
	for(let row=0; row<board.length; row++){
		if(board[row].length !== 3) return null;
		let xRow = 0;
		let oRow = 0;
		let xCol = 0;
		let oCol = 0;
		for(let col=0; col<board[row].length; col++){
			// check rows
			if(board[row][col] === "X") xRow += 1;
			else if(board[row][col] === "O") oRow += 1;
			else xRow, oRow = 0, 0;
			// check columns
			if(board[row][col] === "X") xCol += 1;
			else if(board[row][col] === "O") oCol += 1;
			else xCol, oCol = 0, 0;
			// to see counters
			//console.log(`xRow: ${xRow}\toRow: ${oRow}\n`);
			//console.log(`xCol: ${xCol}\toCol: ${oCol}\n`);
			// who wins
			if(xRow===3 || oRow===3 || xCol===3 || oCol===3){
				if(xRow===3 || xCol===3) xWins = true;
				else if(oRow===3 || oCol===3) oWins = true;
			}
			// check if there is a winner
			if(xWins || oWins) break;
		}
	}
	// if there is no winner yet -> check diagonals
	if((xWins && oWins) === false){
		// check diagonals
		let xd1=0, xd2=0, od1=0, od2=0;
		for(let pos=0; pos<board.length; pos++){
			if(board[pos][pos] === "X") xd1++;
			else if(board[pos][pos] === "O") od1++;
			if(board[pos][3-pos-1] === "X") xd2++;
			else if(board[pos][3-pos-1] === "O") od2++;
			// to see counters
			//console.log(`xd1: ${xd1}\txd2: ${xd2}`)
            //console.log(`od1: ${od1}\tod2: ${od2}`)
			// who wins
			if(xd1===3 || xd2===3) xWins = true;
			else if(od1===3 || od2===3) oWins = true;
		}
	}
	if(xWins && oWins) return "Null, both are winners"; // both wins -> null
	else if(xWins) return "X wins";
	else if(oWins) return "O wins";
	else return "Draw"; // there is no winner
}

console.log(checkTicTacToe([["X","O","X"],["O","X","O"],["O","O","X"]])) // X should win
console.log(checkTicTacToe([["","O","X"],["","X","O"],["","O","X"]])) // there is no winner -> Draw
console.log(checkTicTacToe([["O","O","O"],["O","X","X"],["O","X","X"]])) // O should win
console.log(checkTicTacToe([["X","X","X"],["O","X","X"],["X","O","X"]])) // X should win