/*
 * Crea un programa que calcule quien gana más partidas al piedra,
 * papel, tijera.
 * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
 * - La función recibe un listado que contiene pares, representando cada jugada.
 * - El par puede contener combinaciones de "R" (piedra), "P" (papel)
 *   o "S" (tijera).
 * - Ejemplo. Entrada: [("R","S"), ("S","R"), ("P","S")]. Resultado: "Player 2".
 */

/**
 * Juego de piedra papel o tijera
 * @param {Array<Array<String>>} jugadas - Lista de pares de jugadas, donde cada par es ["R", "P", "S"]
 * @return {string} - "Player 1", "Player 2" o "Tie"
 */
const piedraPapelTijera = (jugadas) => {

    const puntaje = {
        player1: 0,
        player2: 0,
    }

    const reglas = {
        R: "S",
        P: "R",
        S: "P"
    };

    jugadas.forEach(([p1, p2]) => {
        
        if ( reglas[p1] === p2 ){
            puntaje.player1++;
        }  else if ( reglas[p2] === p1 ) {
            puntaje.player2++;
        }
        
    });
    
    const { player1, player2 } = puntaje;
    
    return (player1 > player2) ? "Player 1" : 
           (player2 > player1) ? "Player 2" : "Tie";

}

// 1
console.log(piedraPapelTijera([
    ["R", "S"],
    ["S", "R"],
    ["P", "S"],
]));

// 2
console.log(piedraPapelTijera([
    ["S", "P"],
    ["S", "R"],
    ["P", "R"],
]));

// Tie
console.log(piedraPapelTijera([
    ["R", "S"],
    ["S", "R"],
    ["P", "S"],
    ["S", "P"],
]));