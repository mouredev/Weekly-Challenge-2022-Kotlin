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
 */

/*
En esta solución falta por comprobar que el tablero es un tablero válido
*/

fun main (){
    val board = arrayOf(arrayOf("X", "O", "X"),
                        arrayOf("O", "X", "O"),
                        arrayOf("O", "O", "X"))

    val board1 = arrayOf(arrayOf("", "O", "X"),
                         arrayOf("", "X", "O"),
                         arrayOf("", "O", "X"))

    val board2 = arrayOf(arrayOf("O", "O", "O"),
                         arrayOf("O", "X", "X"),
                         arrayOf("O", "X", "X"))

    val board3 = arrayOf(arrayOf("X", "O", "X"),
                         arrayOf("X", "X", "O"),
                         arrayOf("X", "X", "X"))

    println(analyzeGame(board))
    println(analyzeGame(board1))
    println(analyzeGame(board2))
    println(analyzeGame(board3))
}

fun analyzeGame(board : Array<Array<String>>) : String {
    val numFilas = board.size
    val numColumnas = board[0].size
    var ganador = "empate"

    //Analisis de las filas
    for (i in 0 until numFilas){
        val move = board[i]

        if (analyzeMove(move) == "Xwin"){
            ganador =  "Xwin"
            break
        }else if(analyzeMove(move) == "Owin"){
            ganador =  "Owin"
            break
        }
    }

   //Analisis de las columnas
   var columna = arrayOf("","","")

    for (i in 0 until numFilas){
        for (j in 0 until numColumnas){
            columna[j] = board[j][i]
        }
        val move = columna

        if (analyzeMove(move) == "Xwin"){
            ganador =  "Xwin"
            break
        }else if(analyzeMove(move) == "Owin"){
            ganador =  "Owin"
            break
        }
        columna = arrayOf("","","")
    }
    return ganador
}

//Analisis de las dos diagonales (Sin implementar)
//
//
//
//

fun analyzeMove (move : Array<String>) : String{
    var numX = 0
    var numO = 0
    var ganador = "empate"

    numX = move.count { it == "X" }
    numO = move.count { it == "O" }

    if (numX == 3){
        ganador = "Xwin"
    }
    if(numO == 3){
        ganador = "Owin"
    }
    return ganador
}

