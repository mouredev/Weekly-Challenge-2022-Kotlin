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
    repeat(5){
        RPS().playGame()
    }
}

private class RPS{
    private val gameSet = mutableListOf<Pair<PlayerChoices, PlayerChoices>>()

    enum class WinLoseTie(val result: String){
        WIN("Winner"),
        LOSE("Lose"),
        TIE("Tie")
    }

    enum class PlayerChoices(val choice :String){
        R("Rock") {
            override fun versus(opponent: PlayerChoices): WinLoseTie {
                return  when(opponent){
                    P -> WinLoseTie.LOSE
                    S -> WinLoseTie.WIN
                    R -> WinLoseTie.TIE
                }
            } },
        P("Paper"){
            override fun versus(opponent: PlayerChoices): WinLoseTie {
                return  when(opponent){
                    S -> WinLoseTie.LOSE
                    R -> WinLoseTie.WIN
                    P -> WinLoseTie.TIE
                }
            } },
        S("Scissor"){
            override fun versus(opponent: PlayerChoices): WinLoseTie {
                return  when(opponent){
                    R -> WinLoseTie.LOSE
                    P -> WinLoseTie.WIN
                    S -> WinLoseTie.TIE
                }
            } };

        abstract fun versus(opponent : PlayerChoices): WinLoseTie
    }

    private fun  getRandomChoice(): PlayerChoices {
        return PlayerChoices.values()[(0..2).random()]
    }

    private fun getGameSet() : List<Pair<PlayerChoices,PlayerChoices>> {
        repeat((1..10).random()) {
            val turn = getRandomChoice() to getRandomChoice()
            gameSet.add(turn)
        }
        return gameSet
    }

    private fun printGameSet(gameSet :List<Pair<PlayerChoices,PlayerChoices>>){
        print("{ ")
        gameSet.forEach{
            print("[${it.first.choice}|${it.second.choice}] ")
        }
        print("}\n")
    }

    private fun getWinner() : String{
        var player1 = 0
        var player2 = 0
        gameSet.forEach{
            when (it.first.versus(it.second)){
                WinLoseTie.WIN -> player1++
                WinLoseTie.LOSE -> player2++
                WinLoseTie.TIE -> {
                    player1++
                    player2++
                }
            }
        }
        return if (player1 == player2) {
            WinLoseTie.TIE.result
        } else if (player1 > player2) {
            "Player1 Wins"
        } else {
            "Player2 Wins"
        }
    }

    fun playGame(){
        getGameSet()
        printGameSet(gameSet)
        println("${getWinner()}\n")
    }
}