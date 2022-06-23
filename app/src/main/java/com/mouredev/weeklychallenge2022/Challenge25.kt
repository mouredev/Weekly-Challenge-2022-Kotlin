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
 */

fun main (){
    val listOfMoves = arrayOf(arrayOf("R","R"), arrayOf("R","R"), arrayOf("R","P"))
    println(whoWins(listOfMoves))
}

fun whoWins(listOfMoves : Array<Array<String>>) : String{
    var player1wins = 0;
    var player2wins = 0;
    var tie = 0;

    listOfMoves.forEach { move ->

        if(move[0] == move[1]){
            tie++

        }else if ((move[0] == "R" && move[1] == "S") ||
            (move[0] == "S" && move[1] == "P") ||
            (move[0] == "P" && move[1] == "R")){
            player1wins++

        }else{
            player2wins++
        }
    }

    return if (player1wins > player2wins){
        "Player 1"
    }else if(player2wins > player1wins){
        "Player 2"
    }else{
        "Tie"
    }
}