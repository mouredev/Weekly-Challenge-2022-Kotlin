/*
 * Crea un programa que calcule quien gana más partidas al piedra,
 * papel, tijera, lagarto, spock.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "🗿" (piedra), "📄" (papel),
 *   "✂️" (tijera), "🦎" (lagarto) o "🖖" (spock).
 * - Ejemplo. Entrada: [("🗿","✂️"), ("✂️","🗿"), ("📄","✂️")]. Resultado: "Player 2".
 * - Debes buscar información sobre cómo se juega con estas 5 posibilidades.
 */

/**
 * Función que calcula quien gana en un juego de piedra papel o tijera
 * @param {Array} jugadas
 */
const piedraPapelTijeraLagartoSpock = ( jugadas ) => {

    let conteoPlayer1 = 0;
    let conteoPlayer2 = 0;

    jugadas.forEach((jugada) => {
        const [ player1, player2 ] = jugada;

        if(player1 === player2){
            return; 
        }

        if( (player1 === "🗿" && player2 === "✂️") || (player1 === "🗿" && player2 === "🦎") ){
            conteoPlayer1++;
        } else if((player1 === "📄" && player2 === "🗿") || (player1 === "📄" && player2 === "🖖")){
            conteoPlayer1++;
        } else if((player1 === "✂️" && player2 === "📄") || (player1 === "✂️" && player2 === "🦎")){
            conteoPlayer1++;
        } else if((player1 === "🦎" && player2 === "📄") || (player1 === "🦎" && player2 === "🖖")){
            conteoPlayer1++;
        } else if((player1 === "🖖" && player2 === "✂️") || (player1 === "🖖" && player2 === "🗿")){
            conteoPlayer1++;
        } else {
            conteoPlayer2++;
        }

    });


    return conteoPlayer1 > conteoPlayer2 ? "Player 1" : conteoPlayer1 < conteoPlayer2 ? "Player 2" : "Tie";

}

console.log(piedraPapelTijeraLagartoSpock([["🗿","✂️"], ["✂️","🗿"], ["📄","✂️"]])); // "Player 2"
console.log(piedraPapelTijeraLagartoSpock([["🦎","✂️"], ["✂️","📄"], ["🖖","✂️"]])); // "Player 1"
console.log(piedraPapelTijeraLagartoSpock([["🗿","✂️"], ["✂️","📄"], ["✂️","🖖"], ["🗿","📄"]])); // "Tie"