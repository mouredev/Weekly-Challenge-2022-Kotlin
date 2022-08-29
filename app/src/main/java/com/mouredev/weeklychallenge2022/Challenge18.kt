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

private fun main() {
    val matrix1 = getRandomMatrixV1()
    printMatrix(matrix1)
    println("${checkWinner(matrix1)}\n")

    val matrix2 = getRandomMatrixV2()
    printMatrix(matrix2)
    println("${checkWinner(matrix2)}\n")

    val matrix3 = getRandomMatrixV2()
    printMatrix(matrix3)
    println("${checkWinner(matrix3)}\n")

    val matrix4 = getRandomMatrixV2()
    printMatrix(matrix4)
    println("${checkWinner(matrix4)}\n")
}

private val matrix = Array(3) { Array(3) { 'v' } }

private fun getRandomMatrixV1(): Array<Array<Char>> {

    val newMatrix = matrix

    for (x in 0..2) {
        for (y in 0..2) {
            val xo = (1..300).random()
            newMatrix[x][y] = when {
                (xo < 100) -> 'x'
                (xo > 200) -> 'o'
                else -> ' '
            }
        }
    }
    return newMatrix
}

private fun getRandomMatrixV2(): Array<Array<Char>> {

    val newMatrix = matrix

    val squares = Array(9) { col ->
        Array(2) { row ->
            when {
                (col <= 2 && row == 0) -> 0
                (col <= 5 && row == 0) -> 1
                (col <= 8 && row == 0) -> 2
                (col <= 2 && row == 1) -> col
                (col <= 5 && row == 1) -> col - 3
                (col <= 8 && row == 1) -> col - 6
                else -> 0
            }
        }
    }
    squares.shuffle()

    val player1 = if ((0..10).random()<5) 'x' else 'o'
    val player2 = if(player1 == 'x') 'o' else 'x'

    val variety = (7..9).random()

    for (x in 0..8) {
        if (x < variety) {
            newMatrix[squares[x][0]][squares[x][1]] = if (x % 2 == 0) {
                player1
            } else {
                player2
            }
        } else {
            newMatrix[squares[x][0]][squares[x][1]] = ' '
        }
    }

    return newMatrix
}

private fun printMatrix(matrix: Array<Array<Char>>) {
    matrix.forEach {
        print('|')
        it.forEach { xo ->
            print(xo)
        }
        print("|\n")
    }
}

private fun checkValidMatrix(matrix: Array<Array<Char>>): Boolean {
    var xCount = 0
    var oCount = 0
    for (x in matrix.indices) {
        matrix[x].forEach {
            when (it) {
                'x' -> xCount++
                'o' -> oCount++
            }
        }
        if (matrix.size != matrix[x].size) return false
    }
    return when {
        xCount == 0 -> false
        oCount == 0 -> false
        xCount >= (oCount + 2) -> false
        oCount >= (xCount + 2) -> false
        else -> true
    }
}

private fun checkWinner(matrix: Array<Array<Char>>): String {

    if (!checkValidMatrix(matrix)) return "Nulo"

    var xCount: Int
    var oCount: Int

    // Horizontal check
    var xWin = 0
    var oWin = 0
    for (x in matrix.indices) {
        xCount = 0
        oCount = 0
        matrix[x].forEach {
            when (it) {
                'x' -> xCount++
                'o' -> oCount++
            }
        }
        if (xCount == 3) xWin++
        if (oCount == 3) oWin++
    }

    if (xWin > oWin) {
        return "X"
    } else if (xWin < oWin) {
        return "O"
    } else if (xWin == 1 && oWin == 1) {
        return "Nulo"
    }

    // Vertical check
    xWin = 0
    oWin = 0
    for (y in 0..2) {
        xCount = 0
        oCount = 0
        for (x in 0..2) {
            when (matrix[x][y]) {
                'x' -> xCount++
                'o' -> oCount++
            }
        }
        if (xCount == 3) xWin++
        if (oCount == 3) oWin++
    }

    if (xWin > oWin) {
        return "X"
    } else if (xWin < oWin) {
        return "O"
    } else if (xWin == 1 && oWin == 1) {
        return "Nulo"
    }

    // Diagonal \ check
    xCount = 0
    oCount = 0
    for (z in 0..2) {
        when (matrix[z][z]) {
            'x' -> xCount++
            'o' -> oCount++
        }
    }
    if (xCount == 3) return "X"
    if (oCount == 3) return "O"

    // Diagonal / check
    xCount = 0
    oCount = 0
    for (z in 0..2) {
        when (matrix[z][2 - z]) {
            'x' -> xCount++
            'o' -> oCount++
        }
    }
    if (xCount == 3) return "X"
    if (oCount == 3) return "O"

    return "Empate"
}