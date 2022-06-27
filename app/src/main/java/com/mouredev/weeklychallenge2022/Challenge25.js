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
const jugadas = [
  ["S", "S"],
  ["R", "P"],
  ["P", "R"],
  ["P", "P"],
  ["S", "P"],
  ["R", "S"],
  ["S", "P"],
  ["P", "S"],
];

function calcPiedraPapelTijeras(arrPairs) {
  if (arrPairs.length && typeof arrPairs === "object") {
    let result = {
      1: 0,
      2: 0,
    };

    arrPairs.forEach((par, i) => {
      const [pOne, pTwo] = par;
      if (pOne !== pTwo) {
        if (pOne === "R") pTwo === "S" ? result[1]++ : result[2]++;
        if (pOne === "S") pTwo === "P" ? result[1]++ : result[2]++;
        if (pOne === "P") pTwo === "R" ? result[1]++ : result[2]++;
      }
    });

    console.log(`P1 : ${result[1]}`);
    console.log(`P2 : ${result[2]}`);

    return result[1] === result[2]
      ? "Tie"
      : result[1] > result[2]
      ? "Player 1"
      : "Player 2";
  }
}

console.log(calcPiedraPapelTijeras(jugadas));
