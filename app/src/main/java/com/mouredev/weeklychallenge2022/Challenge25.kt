package com.mouredev.weeklychallenge2022

import com.mouredev.weeklychallenge2022.Input.PAPER
import com.mouredev.weeklychallenge2022.Input.SCISSORS
import com.mouredev.weeklychallenge2022.Input.STONE
import com.mouredev.weeklychallenge2022.Player.PLAYER1
import com.mouredev.weeklychallenge2022.Player.PLAYER2
import com.mouredev.weeklychallenge2022.Player.TIE

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
    val inputList = listOf(
        Pair("R", "S"),
        Pair("S", "R"),
        Pair("P", "S")
    )
    println(getWinner(inputList))
}

object Input {
    const val STONE = "R"
    const val SCISSORS = "S"
    const val PAPER = "P"
}

object Player {
    const val PLAYER1 = "Player 1"
    const val PLAYER2 = "Player 2"
    const val TIE = "Tie"
}

fun getWinner(list: List<Pair<String, String>>): String {
    var contPlayer1 = 0
    var contPlayer2 = 0
    list.forEach {  match ->
        when(getWinnerMatch(match)) {
            1 -> contPlayer1++
            2 -> contPlayer2++
        }
    }
    return checkResult(contPlayer1, contPlayer2)

}

fun checkResult(p1: Int, p2: Int): String {
    return if(p1 > p2) {
        PLAYER1
    } else if(p2 > p1) {
        PLAYER2
    } else {
        TIE
    }
}

fun getWinnerMatch(match: Pair<String, String>): Int {
    return when(match.first) {
        STONE -> when(match.second) {
            SCISSORS -> 1
            PAPER -> 2
            else -> 0
        }
        SCISSORS -> when(match.second) {
            PAPER -> 1
            STONE -> 2
            else -> 0
        }
        PAPER -> when(match.second) {
            STONE -> 1
            SCISSORS -> 2
            else -> 0
        }
        else -> -1
    }
}


