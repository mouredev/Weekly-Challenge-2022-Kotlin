/*
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
 * gane cada punto del juego.
 *
 * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - Love
 *   30 - Love
 *   30 - 15
 *   30 - 30
 *   40 - 30
 *   Deuce
 *   Ventaja P1
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.
 */

const elPartidoDeTenis = (array) => {
    const puntajes = ["Love", 15, 30, 40];
    let p1 = 0;
    let p2 = 0;
    let terminado = false;

    for (let i = 0; i < array.length && !terminado; i++) {
        // Sumar el punto al jugador correspondiente
        if (array[i] === "P1") p1++;
        else if (array[i] === "P2") p2++;
        else {
            console.log("Entrada inválida");
            return;
        }

        // Imprimir estado actual antes de sumar el siguiente punto
        if (p1 >= 3 && p2 >= 3) {
            if (p1 === p2) {
                console.log("Deuce");
            } else if (p1 === p2 + 1) {
                console.log("Ventaja P1");
            } else if (p2 === p1 + 1) {
                console.log("Ventaja P2");
            } else if (p1 >= p2 + 2) {
                console.log("Ha ganado el P1");
                terminado = true;
            } else if (p2 >= p1 + 2) {
                console.log("Ha ganado el P2");
                terminado = true;
            }
        } else {
            console.log(`${puntajes[p1]} - ${puntajes[p2]}`);
        }
    }
};

elPartidoDeTenis(["P1", "P1", "P2", "P2", "P1", "P2", "P1", "P1"]);
