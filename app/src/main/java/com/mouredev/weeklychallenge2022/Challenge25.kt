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

enum class PlayResult{
    Win,
    Lose,
    Tie
}

enum class Movement{
    Stone,
    Paper,
    Scissors;
    fun asWin(movement: Movement): PlayResult = when(this){
        Stone -> when(movement){
            Scissors -> PlayResult.Win
            Paper -> PlayResult.Lose
            else -> PlayResult.Tie
        }
        Paper -> when(movement){
            Scissors -> PlayResult.Lose
            Stone -> PlayResult.Win
            else -> PlayResult.Tie
        }
        Scissors -> when(movement){
            Paper -> PlayResult.Win
            Stone -> PlayResult.Lose
            else -> PlayResult.Tie
        }
    }
}

fun main(){
    val games = arrayOf(
        arrayOf(
            Pair(Movement.Stone, Movement.Scissors),
            Pair(Movement.Stone, Movement.Paper),
            Pair(Movement.Scissors, Movement.Scissors),
            Pair(Movement.Paper, Movement.Stone),
            Pair(Movement.Scissors, Movement.Paper),
            Pair(Movement.Paper, Movement.Scissors)
        ),
        arrayOf(
            Pair(Movement.Stone, Movement.Paper),
            Pair(Movement.Stone, Movement.Scissors),
            Pair(Movement.Scissors, Movement.Scissors),
            Pair(Movement.Stone, Movement.Stone)
        )
    )

    println(games.mapIndexed { index, pairs ->
        "Partida ${index + 1}:\r\nGanadas Jugador 1: ${pairs.count { p -> p.first.asWin(p.second) == PlayResult.Win }}" +
                "\r\nGanadas Jugador2: ${pairs.count { p -> p.second.asWin(p.first) == PlayResult.Win }}" +
                "\r\nEmpates: ${pairs.count { p -> p.second.asWin(p.first) == PlayResult.Tie }}"
    }.joinToString("\r\n-----\r\n"))
}
