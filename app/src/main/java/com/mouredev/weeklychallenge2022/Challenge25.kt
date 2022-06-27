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
    // Values: Rock(R), Scissors(S), Paper(P)
    // Rules -> R wins S ; S wins P; P wins R
    val play1 = mapOf('R' to 'R') // tie
    val play2 = mapOf('R' to 'S') // Player 1
    val play3 = mapOf('R' to 'P') // Player 2
    val play4 = mapOf('S' to 'R') // Player 2
    val play5 = mapOf('S' to 'S') // tie
    val play6 = mapOf('S' to 'P') // Player 1
    val play7 = mapOf('P' to 'R') // Player 1
    val play8 = mapOf('P' to 'S') // Player 2
    val play9 = mapOf('P' to 'P') // tie

    val playsList = listOf(play2, play3, play6)

    println(checkRPSResult(playsList))
}

private fun checkRPSResult(playsList: List<Map<Char, Char>>): String {
    var counter = 0

    playsList.forEach {
        if (it.containsKey('R')) {
            if (it.containsValue('S')) counter--
            else if (it.containsValue('P')) counter++
        }
        if (it.containsKey('S')) {
            if (it.containsValue('P')) counter--
            else if (it.containsValue('R')) counter++
        }
        if (it.containsKey('P')) {
            if (it.containsValue('R')) counter--
            else if (it.containsValue('S')) counter++
        }
    }

    if (counter < 0) return "Winner Player 1"
    if (counter > 0) return "Winner Player 2"

    return "Tie"
}
