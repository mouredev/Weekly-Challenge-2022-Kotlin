/*
 * Reto #25
 * PIEDRA, PAPEL, TIJERA
 * Fecha publicación enunciado: 20/06/22
 * Fecha publicación resolución: 27/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule quien gana más partidas al piedra, papel, tijera.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "R" (piedra), "P" (papel) o "S" (tijera).
 * - Ejemplo. Entrada: [("R","S"), ("S","R"), ("P","S")]. Resultado: "Player 2".
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

function rockScissorsPaper(game){
	let p1=0, p2=0; // counters starting at 0
	for(moves of game){
		// if there's only one move
		if(moves.length === 1){
			if(game[0] === game[1]) return "Tie"; // if both movements are equal -> tie
			else if((game[0]==='R' && game[1]==='S')||(game[0]==='S' && game[1]==='P')||(game[0]==='P' && game[1]==='R')) return "Player 1 wins";
			else return "Player 2 wins";
		}
		// if there're more than one movements -> counters will be used here
		else{
			if(moves[0] === moves[1]) continue; // if both are equals, continue
			else if((moves[0]==='R' && moves[1]==='S')||(moves[0]==='S' && moves[1]==='P')||(moves[0]==='P' && moves[1]==='R')) p1++;
			else p2++;
		}
	}
	// results
	if(p1 === p2) return "Tie";
	else if(p1 > p2) return "Player 1 wins";
	else return "Player 2 wins";
}

console.log(rockScissorsPaper(["R","R"])); // Tie
console.log(rockScissorsPaper(["R","S"])); // Player 1 wins
console.log(rockScissorsPaper(["P","S"])); // Player 2 wins
console.log(rockScissorsPaper([["R", "R"],["S", "S"],["P", "P"]])); // Tie
console.log(rockScissorsPaper([["R", "S"],["S", "P"],["S", "R"]])); // Player 1 wins
console.log(rockScissorsPaper([["R", "P"],["S", "R"],["P", "S"]])); // Player 2 wins