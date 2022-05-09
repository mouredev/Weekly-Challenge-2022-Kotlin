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


/**
 * Constante con el numero de filas y columnas
 */
const val CELLS= 3

/**
 * Enumerado con los valores del tablero
 * @property X valor para las X
 * @property O valor para los O
 * @property EMPTY valor para el vacio
 */
enum class Cell(val value : String) {
    X("X"),
    O("O"),
    EMPTY("")
}

/**
 * Funcion principal
 */
fun main() {

    val matrix = arrayOf(
        arrayOf(Cell.X, Cell.X, Cell.O),
        arrayOf(Cell.EMPTY, Cell.O, Cell.O),
        arrayOf(Cell.O, Cell.X, Cell.X)
    )

    if (checkMatrix(matrix)) {
        println(winnerTicTacToe(matrix))

    }
    else
        println("Tablero no valido")
}


/**
 * Funcion para comprobar si la matriz es valida
 * @param matrix matriz a comprobar
 * @return true si la matriz es valida, false si no.Comprobaciones:
 * Si la matriz no es de 3 filas, 3 columnas, o 3 filas y 3 columnas, no es valida
 * Si el numero de X es distinto al de O no es valida
 */
fun checkMatrix(matrix: Array<Array<Cell>>): Boolean {
    var x = 0
    var o = 0

    for (i in 0 until CELLS) {
        if (matrix[i].size != CELLS)
            return false
    }


    matrix.forEachIndexed { i, row ->
        row.forEachIndexed { j, cell ->
            if (matrix[i][j] == Cell.X) {
                x++
            } else if (matrix[i][j] == Cell.O) {
                o++
            }


        }
    }

    return  (o == x)


    }

/**
 * Funcion para comprobar si hay un ganador
 * @param board matriz a comprobar
 * @return String con el ganador, o "Empate" si no hay ganador
 * @see Cell
 */
fun winnerTicTacToe(board: Array<Array<Cell>>): String {


    //Filas
    board.forEachIndexed { index, arrayOfCells ->

        if (arrayOfCells[0] == Cell.X && arrayOfCells[1] == Cell.X && arrayOfCells[2] == Cell.X) {
            return "Ganan las X"
        }
        if (arrayOfCells[0] == Cell.O && arrayOfCells[1] == Cell.O && arrayOfCells[2] == Cell.O) {
            return "Ganan las O"
        }
    }

    //Columnas

    for (i in 0 until CELLS) {
        if (board[0][i] == Cell.X && board[1][i] == Cell.X && board[2][i] == Cell.X) {
            return "X"

        }
        if (board[0][i] == Cell.O && board[1][i] == Cell.O && board[2][i] == Cell.O) {
            return "O"
        }
    }

    //Diagonales
    if (board[0][0] == Cell.X && board[1][1] == Cell.X && board[2][2] == Cell.X) {
        return "X"
    }
    if (board[0][0] == Cell.O && board[1][1] == Cell.O && board[2][2] == Cell.O) {
        return "O"
    }

    //Otro caso
    return "Empate"

}









