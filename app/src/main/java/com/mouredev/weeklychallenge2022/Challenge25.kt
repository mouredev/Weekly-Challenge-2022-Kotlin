package com.mouredev.weeklychallenge2022
import java.io.File
import java.text.Normalizer
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
    val input = File("app/src/main/java/com/mouredev/weeklychallenge2022","Challenge25.txt").readLines().map { it.split(",") }
    val normalized = input.map { texto(it[0],it[1]) }
    val games = normalized.filter { it[0]!=it[1] }
    val wins = games.map {rockPaperScissors(it[0],it[1])}
    println(winner(wins))
}
fun rockPaperScissors(player1:String,player2:String): String{

    return if((player1=="r"&& player2=="s")||(player1=="s"&&player2=="p")||(player1=="p"&&player2=="r"))
        "1"
    else if((player2=="r"&& player1=="s")||(player2=="s"&&player1=="p")||(player2=="p"&&player1=="r"))
        "2"
    else
        throw Exception("Error text out of rock paper scissors")
}
fun winner(games:List<String>): String {
    val player1wins = games.count { it == "1" }
    val player2wins = games.count { it == "2" }
    return when {
        player1wins > player2wins -> "Player 1 Wins with $player1wins games won "
        player2wins > player1wins -> "Player 2 Wins with $player2wins games won "
        else -> "Player 1 and Player 2 are tied in games"
    }
}
fun texto(item1:String,item2:String):List<String> {
    val firstItem = Normalizer.normalize(item1.lowercase(), Normalizer.Form.NFD).replace("[^a-z0-9]".toRegex(), "")
    val secondItem = Normalizer.normalize(item2.lowercase(),Normalizer.Form.NFD).replace("[^a-z0-9]".toRegex(),"")
    return listOf(firstItem,secondItem)
}

