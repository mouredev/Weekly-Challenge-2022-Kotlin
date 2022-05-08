package com.mouredev.weeklychallenge2022

import com.mouredev.weeklychallenge2022.ThreeInStripes.*
import java.util.*

/*
 * Reto #18
 * TRES EN RAYA three in stripes
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
private enum class ThreeInStripes(val player: String) {
    X("X"),
    O("O"),
    EMPTY(" ")
}

fun main() {
    println("Check Three In Stripes Winner")
    checkThreeInStripesWinner(
        arrayOf(
            arrayOf(X, O, X),
            arrayOf(X, X, O),
            arrayOf(O, X, O)
        )
    )
    checkThreeInStripesWinner(
        arrayOf(
            arrayOf(X, X, O),
            arrayOf(O, X, EMPTY),
            arrayOf(EMPTY, O, X)
        )
    )
    checkThreeInStripesWinner(
        arrayOf(
            arrayOf(X, X, X),
            arrayOf(O, O, O),
            arrayOf(EMPTY, EMPTY, EMPTY)
        )
    )
    checkThreeInStripesWinner(
        arrayOf(
            arrayOf(O, O, O),
            arrayOf(EMPTY, X, EMPTY),
            arrayOf(X, EMPTY, EMPTY)
        )
    )
    checkThreeInStripesWinner(
        arrayOf(
            arrayOf(O, X, X),
            arrayOf(O, X, EMPTY),
            arrayOf(O, EMPTY, EMPTY)
        )
    )
    checkThreeInStripesWinner(
        arrayOf(
            arrayOf(O, X, X),
            arrayOf(O, X, EMPTY),
            arrayOf(X, O, EMPTY)
        )
    )
}

private fun checkThreeInStripesWinner(board: Array<Array<ThreeInStripes>>) {
    val playerXMovements = board.getPlayerMovements(X)
    val playerOMovements = board.getPlayerMovements(O)
    board.printBoard()
    println("The result of the game is ->")
    if (playerXMovements.size == playerOMovements.size ||
        playerXMovements.size == playerOMovements.size - 1 ||
        playerXMovements.size == playerOMovements.size + 1
    ) {
        val winner: MutableList<ThreeInStripes> = mutableListOf()
        for (i in board.indices) {
            when(board.size){
                playerXMovements.filter { it.first == i }.count(),
                playerXMovements.filter { it.second == i }.count() ->
                    winner.add(X)
                playerOMovements.filter { it.first == i }.count(),
                playerOMovements.filter { it.second == i }.count() ->
                    winner.add(O)
            }
        }
        when(board.size){
            playerXMovements.filter { it.first == it.second }.count() -> winner.add(X)
            playerOMovements.filter { it.first == it.second }.count() -> winner.add(O)
        }
        val invertCross = getInvertCross(board.size)
        when{
            Collections.disjoint(playerXMovements, invertCross) -> winner.add(X)
            Collections.disjoint(playerOMovements, invertCross) -> winner.add(O)
        }
        winner.printResult()
    } else {
        println("Null")
    }

}

private fun Array<Array<ThreeInStripes>>.getPlayerMovements(player: ThreeInStripes): MutableList<Pair<Int, Int>> {
    val movements = mutableListOf<Pair<Int, Int>>()
    this.forEachIndexed { index, line ->
        line.forEachIndexed { elementIndex, element ->
            if (element == player) {
                movements.add(index to elementIndex)
            }
        }
    }
    return movements
}

private fun Array<Array<ThreeInStripes>>.printBoard() {
    forEach { line ->
        line.forEach {
            print("${it.player} | ")
        }
        println()
    }
}

private fun MutableList<ThreeInStripes>.printResult() {
    when {
        isEmpty() -> println("Tie")
        size == 1 -> println("${this.first().player} win")
        else -> println("Null")
    }
}

private fun getInvertCross(size: Int): MutableList<Pair<Int, Int>> {
    val result: MutableList<Pair<Int, Int>> = mutableListOf()
    for (i in 0 until size) {
        result.add(i + 1 to size - i)
    }
    return result
}