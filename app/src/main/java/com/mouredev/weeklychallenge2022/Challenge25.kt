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


/**
 * Data class que representa una jugada.
 */
data class Game(val list:List<Pair<Option,Option>>,val namePlayer1: String,val namePlayer2: String)

/**
 * Enum que representa una opción de juego.
 */
enum class Option(val value: String) {
    ROCK("R"),
    PAPER("P"),
    SCISSORS("S")
}

/**
 * Clase que representa un resultado de una jugada.
 */
sealed class Result {
    object Tie : Result()
    object Player1 : Result()
    object Player2 : Result()
}


/**
 * Funcion Principal
 */
fun main(){

    val game1 = Game(listOf(
        Pair(Option.ROCK,Option.PAPER),
        Pair(Option.SCISSORS,Option.PAPER),
        Pair(Option.ROCK,Option.SCISSORS)),
        "Player 1",
        "Player 2")

        println("El resultado del juego es :${evaluateGame(game1)}")

    val game2 = Game(listOf(
        Pair(Option.ROCK,Option.PAPER),
        Pair(Option.SCISSORS,Option.PAPER),
        Pair(Option.ROCK,Option.SCISSORS),
        Pair(Option.SCISSORS,Option.SCISSORS),
        Pair(Option.ROCK,Option.PAPER)),
        "Player 1",
        "Player 2")

    println("El resultado del juego es :${evaluateGame(game2)}")


}


/**
 * Funcion que busca el ganador si lo hay de una lista de jugadas
 * @param results Listado de jugadas
 * @return Resultado de la jugada
 * @see Result
 */
fun foundWinner(results:List<Result>):Result{

    val player1 = results.count { it == Result.Player1 }
    val player2 = results.count { it == Result.Player2 }

    return when{
        player1 > player2 -> Result.Player1
        player2 > player1 -> Result.Player2
        else -> Result.Tie
    }
}

/**
 * Funcion que evalua una partida de piedra, papel, tijera
 * @param game objeto que representa un juego con los jugadores y las jugadas de cada uno
 * @return String con el nombre del jugador o empate en el que no hay ningun ganador
 */
fun evaluateGame(game: Game):String{

    return when (foundWinner(game.list.map {
        when (it) {
            Pair(Option.ROCK, Option.SCISSORS) -> Result.Player1
            Pair(Option.SCISSORS, Option.ROCK) -> Result.Player2
            Pair(Option.ROCK, Option.PAPER) -> Result.Player2
            Pair(Option.PAPER, Option.ROCK) -> Result.Player1
            Pair(Option.SCISSORS, Option.PAPER) -> Result.Player1
            Pair(Option.PAPER, Option.SCISSORS) -> Result.Player2
            else -> Result.Tie
        }
    })){
        is Result.Player1 -> "gana el jugador ${game.namePlayer1}"
        is Result.Player2 -> "gana el jugaodr ${game.namePlayer2}"
        is Result.Tie -> "Empate"
    }




}

