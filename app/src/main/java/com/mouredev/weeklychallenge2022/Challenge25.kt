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
    println(rockScissorsPaper(arrayListOf(Pair(Move.ROCK, Move.ROCK))))
    println(rockScissorsPaper(arrayListOf(Pair(Move.ROCK, Move.SCISSORS))))
    println(rockScissorsPaper(arrayListOf(Pair(Move.PAPER, Move.SCISSORS))))
    println(rockScissorsPaper(arrayListOf(
        Pair(Move.ROCK, Move.ROCK),
        Pair(Move.SCISSORS, Move.SCISSORS),
        Pair(Move.PAPER, Move.PAPER))))
    println(rockScissorsPaper(arrayListOf(
        Pair(Move.ROCK, Move.SCISSORS),
        Pair(Move.SCISSORS, Move.PAPER),
        Pair(Move.SCISSORS, Move.ROCK))))
    println(rockScissorsPaper(arrayListOf(
        Pair(Move.ROCK, Move.PAPER),
        Pair(Move.SCISSORS, Move.ROCK),
        Pair(Move.PAPER, Move.SCISSORS))))
}

enum class Move {
    ROCK, SCISSORS, PAPER
}

private fun rockScissorsPaper(games: List<Pair<Move, Move>>): String {

    var playerOneGames = 0
    var playerTwoGames = 0

    games.forEach { game ->

        val playerOneMove = game.first
        val playerTwoMove = game.second

        if (playerOneMove != playerTwoMove) {

            if (playerOneMove == Move.ROCK && playerTwoMove == Move.SCISSORS
                || playerOneMove == Move.SCISSORS && playerTwoMove == Move.PAPER
                || playerOneMove == Move.PAPER && playerTwoMove == Move.ROCK) {

                playerOneGames += 1
            } else {
                playerTwoGames += 1
            }
        }
    }

    return if (playerOneGames == playerTwoGames) {
        "Tie"
    } else if (playerOneGames > playerTwoGames) {
        "Player 1"
    } else {
        "Player 2"
    }
}