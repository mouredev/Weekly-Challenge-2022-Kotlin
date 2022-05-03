package com.mouredev.weeklychallenge2022

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
    var resultado = ""
    val tablero = arrayOf(
        arrayOf("X", "X", "X"),
        arrayOf("O", "O", "O"),
        arrayOf("X", "O", "X")
    )

    if (checkBoard(tablero) == "Nulo") {
        println("Nulo")
    } else {
        resultado += "${checkWinner(tablero[0])}${checkWinner(tablero[1])}${checkWinner(tablero[2])}" //Horizontal
        resultado += "${checkWinner(arrayOf(tablero[0][0], tablero[1][0], tablero[2][0]))}${checkWinner(arrayOf(tablero[0][1], tablero[1][1], tablero[2][1]))}${checkWinner(arrayOf(tablero[0][2], tablero[1][2], tablero[2][2]))}"
        //vertical
        resultado += "${checkWinner(arrayOf(tablero[0][0], tablero[1][1], tablero[2][2]))}${checkWinner(arrayOf(tablero[0][2], tablero[1][1], tablero[2][0]))}"//diagonal

        val x = resultado.count { it == 'X' }
        val o = resultado.count { it == 'O' }

        if (x > o){
            println("X")
        } else if (o > x){
            println("O")
        } else {
            println("Empate")
        }
    }
}

fun checkBoard(board: Array<Array<String>>): String {
    if (board.size != 3 || board[0].size != 3 || board[1].size != 3 || board[2].size != 3) {
        return "Nulo"
    }
    return ""
}

fun checkWinner(array: Array<String>): String {
    val x = array.filter { it == "X" }.size
    val o = array.filter { it == "O" }.size
    return when {
        x == 3 -> "X"
        o == 3 -> "O"
        else -> "E"
    }
}