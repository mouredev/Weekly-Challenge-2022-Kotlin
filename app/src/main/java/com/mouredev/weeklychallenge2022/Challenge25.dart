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
import 'dart:math'; //Para el Random

void main(List<String> args) {
  //Determina el ganador de una Ronda
  String checkRound(String p1, String p2) {
    String result = "Tie";
    String p1Up = p1.toUpperCase();
    String p2Up = p2.toUpperCase();
    if (p1Up != p2Up) {
      switch (p1Up) {
        case "R":
          result = p2Up == "P" ? "Player 2" : "Player 1";
          break;
        case "P":
          result = p2Up == "S" ? "Player 2" : "Player 1";
          break;
        case "S":
          result = p2Up == "R" ? "Player 2" : "Player 1";
          break;
      }
    }
    return result;
  }

  //Cuenta los puntajes totales
  Map<String, int> scoreMatch(List<List<String>> match) {
    Map<String, int> scoreboard = {"Player 1": 0, "Player 2": 0, "Tie": 0};
    match.forEach((element) {
      String resultRound = checkRound(element[0], element[1]);
      if (scoreboard.containsKey(resultRound)) {
        scoreboard[resultRound] = scoreboard[resultRound]! + 1;
      }
    });
    return scoreboard;
  }

  //Genera una ronda de Piedra, Papel, Tijera al azar
  List<String> randomRound() => List<String>.generate(2, (index) {
        const List<String> options = ["R", "P", "S"];
        Random random = Random();
        return options[random.nextInt(3)];
      });

  //MAIN
  late List<List<String>> currentMatch = [];

  //Fijo
  currentMatch = [
    ["R", "R"],
    ["R", "S"],
    ["S", "R"],
    ["P", "R"],
    ["r", "R"],
    ["R", "R"],
    ["P", "R"],
    ["S", "P"],
    ["R", "S"],
    ["S", "S"],
    ["R", "p"],
    ["R", "R"],
    ["P", "R"],
    ["S", "R"],
    ["R", "P"],
    ["R", "R"],
    ["P", "P"],
    ["r", "p"],
    ["R", "R"],
    ["R", "s"],
  ];

  //Random
  // currentMatch.clear();
  // for (var i = 0; i < 1000; i++) {
  //   currentMatch.add(randomRound());
  // }

  Map<String, int> finalScore = scoreMatch(currentMatch);
  // currentMatch.forEach((pair) => print(pair));
  finalScore.forEach((key, value) => print("$key : $value"));

  if (finalScore["Player 1"]! > finalScore["Player 2"]!) {
    print("Resultado: Player 1");
  } else if (finalScore["Player 1"]! < finalScore["Player 2"]!) {
    print("Resultado: Player 2");
  } else {
    print("Resultado: Tie");
  }
}
