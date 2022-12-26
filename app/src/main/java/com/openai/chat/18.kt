package com.openai.chat

/*
 * Reto #18
 * TRES EN RAYA
 * Fecha publicación enunciado: 02/05/22
 * Fecha publicación resolución: 09/05/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función en Kotlin que analice una matriz 3x3 compuesta por "X" y "O" y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta. O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta. Se podría representar con un vacío "", por ejemplo.
 *
 * Resuelto: No
 *
 */

fun analyzeMatrix(matrix: Array<Array<String>>): String {
    // Comprobamos si la matriz tiene el tamaño correcto
    if (matrix.size != 3 || matrix[0].size != 3) return "Nulo"

    // Contamos el número de "X" y de "O"
    var numX = 0
    var numO = 0
    for (row in matrix) {
        for (cell in row) {
            when (cell) {
                "X" -> numX++
                "O" -> numO++
            }
        }
    }

    // Comprobamos si hay una diferencia mayor a 1 entre el número de "X" y "O"
    if (Math.abs(numX - numO) > 1) return "Nulo"

    // Comprobamos si hay una línea completa de "X" o de "O"
    for (row in matrix) {
        if (row.all { it == "X" }) return "X"
        if (row.all { it == "O" }) return "O"
    }
    for (col in 0..2) {
        if (matrix.all { it[col] == "X" }) return "X"
        if (matrix.all { it[col] == "O" }) return "O"
    }
    if (matrix[0][0] == "X" && matrix[1][1] == "X" && matrix[2][2] == "X") return "X"
    if (matrix[0][0] == "O" && matrix[1][1] == "O" && matrix[2][2] == "O") return "O"
    if (matrix[0][2] == "X" && matrix[1][1] == "X" && matrix[2][0] == "X") return "X"
    if (matrix[0][2] == "O" && matrix[1][1] == "O" && matrix[2][0] == "O") return "O"

    // Si no hay ninguna línea completa y el número de "X" y "O" es igual, es un empate
    if (numX == numO) return "Empate"

    // Si no se cumple ninguna de las condiciones anteriores, es "Nulo"
    return "Nulo"
}

fun main() {
    val matrix2 = arrayOf(
        arrayOf("X", "O", "X"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "", "X")
    )
    println(analyzeMatrix(matrix2))  // imprime "Nulo"
    val matrix3 = arrayOf(
        arrayOf("X", "O", "X"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "O", "")
    )
    println(analyzeMatrix(matrix3))  // imprime "Nulo"
    val matrix4 = arrayOf(
        arrayOf("X", "O", "X"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "O", "O")
    )
    println(analyzeMatrix(matrix4))  // imprime "O"
    val matrix5 = arrayOf(
        arrayOf("X", "X", "X"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "O", "O")
    )
    println(analyzeMatrix(matrix5))  // imprime "X"
    val matrix6 = arrayOf(
        arrayOf("O", "O", "O"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "O", "O")
    )
    println(analyzeMatrix(matrix6))  // imprime "O"
    val matrix7 = arrayOf(
        arrayOf("O", "O", "O"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "X", "O")
    )
    println(analyzeMatrix(matrix7))  // imprime "Nulo"
    val matrix8 = arrayOf(
        arrayOf("O", "O", "O"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "X", "X")
    )
    println(analyzeMatrix(matrix8))  // imprime "X"
    val matrix9 = arrayOf(
        arrayOf("O", "O", "X"),
        arrayOf("O", "X", "O"),
        arrayOf("X", "X", "X")
    )
    println(analyzeMatrix(matrix9))  // imprime "Nulo"

    println("\nBrais cases:")
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X", "O", "X"),
        arrayOf("O", "X", "O"),
        arrayOf("O", "O", "X")))
    )    // X
    println(
        analyzeMatrix(arrayOf(
        arrayOf("", "O", "X"),
        arrayOf("", "X", "O"),
        arrayOf("", "O", "X")))
    )    // DRAW
    println(
        analyzeMatrix(arrayOf(
        arrayOf("O", "O", "O"),
        arrayOf("O", "X", "X"),
        arrayOf("O", "X", "X")))
    )    // O
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X", "O", "X"),
        arrayOf("X", "X", "O"),
        arrayOf("X", "X", "X")))
    )    // NULL

    println("\nJaime cases:")
    // Nulo
    println(
        analyzeMatrix(arrayOf(
        arrayOf("","",""),
        arrayOf("","",""),
        arrayOf("","")))
    )
    // Nulo
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X","X","X"),
        arrayOf("O",""),
        arrayOf("","O","","")))
    )
    // Nulo
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X","X","X"),
        arrayOf("O","",""),
        arrayOf("","","")))
    )
    // Nulo
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X","O","X"),
        arrayOf("X","X","O"),
        arrayOf("X","X","X")))
    )
    // Empate
    println(
        analyzeMatrix(arrayOf(
        arrayOf("","",""),
        arrayOf("","",""),
        arrayOf("","","")))
    )
    // Empate
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X","O",""),
        arrayOf("","",""),
        arrayOf("","","")))
    )
    // Empate
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X","X","X"),
        arrayOf("O","O","O"),
        arrayOf("","","")))
    )
    // Empate
    println(
        analyzeMatrix(arrayOf(
        arrayOf("O","O","X"),
        arrayOf("X","X","O"),
        arrayOf("O","X","O")))
    )
    // Empate
    println(
        analyzeMatrix(arrayOf(
        arrayOf("","O","X"),
        arrayOf("","X","O"),
        arrayOf("","O","X")))
    )
    // X
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X","X","X"),
        arrayOf("O","O",""),
        arrayOf("","","")))
    )
    // X
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X","O",""),
        arrayOf("X","O",""),
        arrayOf("X","","")))
    )
    // X
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X","O",""),
        arrayOf("O","X",""),
        arrayOf("","","X")))
    )
    // X
    println(
        analyzeMatrix(arrayOf(
        arrayOf("","O","X"),
        arrayOf("","X","O"),
        arrayOf("X","","")))
    )
    // X
    println(
        analyzeMatrix(arrayOf(
        arrayOf("X","O","X"),
        arrayOf("O","X","O"),
        arrayOf("O","O","X")))
    )
    // O
    println(
        analyzeMatrix(arrayOf(
        arrayOf("O","O","O"),
        arrayOf("O","X","X"),
        arrayOf("O","X","X")))
    )
}

