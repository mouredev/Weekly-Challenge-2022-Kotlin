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

fun main(){

    val game1: List<Pair<String, String>> = listOf(Pair("R", "S"), Pair("S", "R"), Pair("P", "S"), Pair("R", "S"))
    val game2: List<Pair<String, String>> = listOf(Pair("R", "S"), Pair("S", "R"), Pair("P", "S"))
    val game3: List<Pair<String, String>> = listOf(Pair("R", "S"), Pair("S", "R"), Pair("P", "S"), Pair("R", "S"), Pair("S", "P"))

    println(game(game1))
    println(game(game2))
    println(game(game3))
}

private fun game(games: List<Pair<String, String>>): String{
    var playerOne = 0
    var playerTwo = 0

    for(i in games){
        if(i.first == "R" && i.second == "P"){
            playerTwo += 1
        }
        if(i.first == "R" && i.second == "S"){
            playerOne += 1
        }
        if(i.first == "P" && i.second == "S"){
            playerTwo += 1
        }
        if(i.first == "P" && i.second == "R"){
            playerOne += 1
        }
        if(i.first == "S" && i.second == "R"){
            playerTwo += 1
        }
        if(i.first == "S" && i.second == "P"){
            playerOne += 1
        }
    }

    if (playerOne > playerTwo){
        return "Player 1"
    }
    if (playerOne < playerTwo){
        return "Player 2"
    }

    return "Tie"

}
