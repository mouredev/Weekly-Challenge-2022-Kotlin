package com.mouredev.weeklychallenge2022

import java.lang.Math.abs

/*
 * Reto #18
 * TRES EN RAYA
 * Fecha publicación enunciado: 02/05/22
 * Fecha publicación resolución: 09/05/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que analice una matriz 3x3 compuesta por "X" y "O" y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta. O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta. Se podría representar con un vacío "", por ejemplo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println(playVeryRayy(arrayOf(arrayOf("","",""),arrayOf("","",""),arrayOf("","",""))))
    println(playVeryRayy(arrayOf(arrayOf("","",""),arrayOf("","",""),arrayOf("",""))))
    println(playVeryRayy(arrayOf(arrayOf("X","O",""),arrayOf("","",""),arrayOf("","",""))))
    println(playVeryRayy(arrayOf(arrayOf("X","X","X"),arrayOf("O","",""),arrayOf("","",""))))
    println(playVeryRayy(arrayOf(arrayOf("X","X","X"),arrayOf("O","O","O"),arrayOf("","",""))))
    println(playVeryRayy(arrayOf(arrayOf("X","X","X"),arrayOf("O","O",""),arrayOf("","",""))))
    println(playVeryRayy(arrayOf(arrayOf("X","O",""),arrayOf("X","O",""),arrayOf("X","",""))))
    println(playVeryRayy(arrayOf(arrayOf("X","O",""),arrayOf("O","X",""),arrayOf("","","X"))))
    println(playVeryRayy(arrayOf(arrayOf("","O","X"),arrayOf("","X","O"),arrayOf("X","",""))))
    println(playVeryRayy(arrayOf(arrayOf("O","O","X"),arrayOf("X","X","0"),arrayOf("0","X","O"))))
}

private enum class Player {
    X, O;

    companion object {
        fun getTries(obj: Player, board: Array<Array<String>>): Int {
            return board.flatMap{ it.filter{ it == obj.name } }.size
        }
    }
}

private fun playVeryRayy(board: Array<Array<String>>): String {
    var result = "Nulo"
    if((board.flatMap { it.asIterable() }.size == 9) && (abs(Player.getTries(Player.X, board) - Player.getTries(Player.O, board)) == 1)) {
        result = "Empate"
        Player.values().forEach { player ->
            if((board[0].filter{ it == player.name }.size == 3) || (board[1].filter{ it == player.name }.size == 3) || (board[2].filter{ it == player.name }.size == 3) ||
                (board.filter{ it[0] == player.name }.size == 3) || (board.filter{ it[1] == player.name }.size == 3) || (board.filter{ it[2] == player.name }.size == 3) ||
                (board[0][0] == player.name && board[1][1] == player.name && board[2][2] == player.name) || (board[0][2] == player.name && board[1][1] == player.name && board[2][0] == player.name)) {
                result = player.name
            }
        }
    }
    return result
}
