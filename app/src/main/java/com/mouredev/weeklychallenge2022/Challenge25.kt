package com.mouredev.weeklychallenge2022

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
fun main() {
    println("El ganador del juego es : ${RockPaperScissors(listOf(Pair("R", "S"), Pair("S", "R"), Pair("P", "S")))}")
    println("El ganador del juego es : ${RockPaperScissors(listOf(Pair("R", "R"), Pair("S", "S"), Pair("S", "S"), Pair("S", "P")))}")
    println("El ganador del juego es : ${RockPaperScissors(listOf(Pair("P", "R"), Pair("S", "S"), Pair("S", "S"), Pair("R", "P")))}")
}

private fun RockPaperScissors(games: List<Pair<String, String>>): String {
    var player1Wins = 0
    var player2Wins = 0

    for (game in games) {
        if (game.first == game.second) {
            continue
        }

        when (game.first) {
            "R" -> when (game.second) {
                "S" -> player1Wins++
                "P" -> player2Wins++
            }
            "S" -> when (game.second) {
                "R" -> player2Wins++
                "P" -> player1Wins++
            }
            "P" -> when (game.second) {
                "R" -> player1Wins++
                "S" -> player2Wins++
            }
        }
    }

    return ResultGame(player1Wins, player2Wins)
}

private fun ResultGame(player1Wins: Int, player2Wins: Int): String {
    return when {
        player1Wins > player2Wins -> "Player 1"
        player1Wins < player2Wins -> "Player 2"
        else -> "Tie"
    }
}