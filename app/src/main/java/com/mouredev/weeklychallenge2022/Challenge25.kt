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
    var ganador = 0 // 0: empate, -1 gana Player 2, 1 gana Player 1


    val entrada = listOf(Pair("R", "R"), Pair("S", "S"), Pair("R", "S"))

    for (i in entrada) {
        var j1 = i.first
        var j2 = i.second

        ganador += enfrentamiento(j1, j2)

    }
    if (ganador == 0) {
        print("Tie")
    } else if (ganador < 0) {
        print("Player 2")
    } else {
        print("Player 1")
    }

}


fun enfrentamiento(jugador1: String, jugador2: String): Int {
    var winner = 0
    if (jugador1 == "R") {
        if (jugador2 == "P") {
            winner --
        } else if (jugador2 == "S") {
            winner ++
        }
    } else if (jugador1 == "S") {
        if (jugador2 == "P") {
            winner ++
        } else if (jugador2 == "R") {
            winner --
        }

    } else if (jugador1 == "P") {
        if (jugador2 == "R") {
            winner ++
        } else if (jugador2 == "S") {
            winner --
        }
    }
    return winner
}