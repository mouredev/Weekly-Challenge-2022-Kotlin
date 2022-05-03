package com.mouredev.weeklychallenge2022

import java.util.ArrayList

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


// Cambio! La celda vacía la represento con " "
fun main() {
    val matrix1 = arrayListOf(
        arrayListOf("O", "X", "X"),
        arrayListOf("X", "X", "O"),
        arrayListOf("O", "X", "O")
    )
    val matrix2 = arrayListOf(
        arrayListOf("X", "O", "X"),
        arrayListOf("X", "X", "O"),
        arrayListOf("O", "O", "O")
    )
    val matrix3 = arrayListOf(
        arrayListOf("X", "X", "X"),
        arrayListOf("X", "X", "O"),
        arrayListOf("O", "O", "O")
    )
    val matrix4 = arrayListOf(
        arrayListOf("X", "X", " "),
        arrayListOf("X", "O", "O"),
        arrayListOf("O", "X", "O")
    )
    val matrix5 = arrayListOf(
        arrayListOf("X", "X", " "),
        arrayListOf("X", "O", "O"),
        arrayListOf("O", "O", "O")
    )
    val matrix6 = arrayListOf(
        arrayListOf("X", "X", "X", "X"),
        arrayListOf("X", "X", "O", "O"),
        arrayListOf("O", "O", "O", "X")
    )
    val matrix7 = arrayListOf(
        arrayListOf("X", "X", "X"),
        arrayListOf("X", "X", "O"),
        arrayListOf("O", "O", "O"),
        arrayListOf("O", "O", "O")
    )
    val matrix8 = arrayListOf(
        arrayListOf("X", "X", "T"),
        arrayListOf("X", "X", "O"),
        arrayListOf("O", "O", "O")
    )

    println("Matrix 1: ${analyzeMatrix(matrix1)}")
    println("Matrix 2: ${analyzeMatrix(matrix2)}")
    println("Matrix 3: ${analyzeMatrix(matrix3)}")
    println("Matrix 4: ${analyzeMatrix(matrix4)}")
    println("Matrix 5: ${analyzeMatrix(matrix5)}")
    println("Matrix 6: ${analyzeMatrix(matrix6)}")
    println("Matrix 7: ${analyzeMatrix(matrix7)}")
    println("Matrix 8: ${analyzeMatrix(matrix8)}")
}

fun analyzeMatrix(matrix: ArrayList<ArrayList<String>>): String {
    var xCount = 0
    var oCount = 0
    var items = ""
    val availableOptions = listOf("X", "O", " ")
    /*
    Iterate through each row and check:
    - If matrix has either more than 3 columns or more than 3 rows.
    - If item is either "X", "O" or " ", count them, and save them.
    */
    for ((i, row) in matrix.withIndex()) {
        if (i > 2) return "Null! More than 3 rows!"
        for ((j, item) in row.withIndex()) {
            when {
                j > 2 -> {
                    return "Null! More than 3 columns!"
                }
                availableOptions.contains(item) -> {
                    items += when (item) {
                        availableOptions[0] -> {
                            xCount++
                            item
                        }
                        availableOptions[1] -> {
                            oCount++
                            item
                        }
                        else -> " "
                    }
                }
                else -> {
                    return "Null! Wrong item in matrix!"
                }
            }
        }
    }
    // If the "X" and "O" ratio is correct
    if (xCount == oCount || ((xCount == 5 && oCount == 4) || (xCount == 4 && oCount == 5))
    ) {
        val patterns = listOf("123", "147", "159", "258", "357", "369", "456", "789")
        var winners = ""
        var hasWon = false
        /*
        Loop 2 times (One for "X" and another for "O")
        Then iterate each possible winning pattern
        And check if each pattern position has the desired item in it
         */
        for (i in 0..1) {
            run loop@{
                patterns.forEach pattern@{ pattern ->
                    hasWon = false
                    pattern.forEach { pos ->
                        if (items[pos.digitToInt() - 1] != availableOptions[i].single()) {
                            return@pattern
                        }
                    }
                    hasWon = true
                    return@loop
                }
            }
            if (hasWon) {
                winners += i
            }
        }
        return when (winners.length) {
            0 -> {
                "Tie! No one won!"
            }
            1 -> {
                if (winners == "0") {
                    "X won!"
                } else {
                    "O won!"
                }
            }
            else -> {
                return "Null! Both players won!"
            }
        }
    } else {
        return "Null! The ratio of X and O is not correct!"
    }
}