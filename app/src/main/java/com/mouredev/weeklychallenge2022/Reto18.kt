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
 */


fun main() {
    println(play(arrayOf(
        "x", "o", "o",
        "o", "x", "o",
        "x", "o", "x"
    ))) //x
    println(play(arrayOf(
        "o", "x", "x",
        "o", "o", "o",
        "x", "o", "x"
    ))) //o
    println(play(arrayOf(
        "o", "x", "x",
        "x", "o", "o",
        "o", "o", "x"
    ))) //Empate
    println(play(arrayOf(
        "o", "x", "x",
        "x", "o", "o",
        "o", "o"
    ))) //null
    println(play(arrayOf(
        "x", "x", "x",
        "x", "o", "o",
        "o", "o", "o"
    ))) //null
    println(play(arrayOf(
        "x", "x", "x",
        "x", "o", "o",
        "o", "o", ""
    ))) //X
    //Si alguna de las cadenas esta vacía, la variable fullBoard será false
    //Y tomará otros criterios
}

/*
0, 4, 8 = diagonal arriba iz - abajo der
2, 4, 6 = diagonal arriba der - abajo iz
*/

private fun play(board: Array<String>): String?{
    val size = board.size
    if (size != 9) return null
    var (xCount, oCount) = arrayOf(0, 0)
    for(i in board.indices) {
        board[i] = board[i].toLowerCase()
        if(board[i] == "x") xCount++
        else if(board[i] == "o") oCount++
    }
    val fullBoard = (xCount == 5 && oCount == 4) || (xCount == 4 && oCount == 5)
    val xWins = checkPlays(board, "x")
    val oWins = checkPlays(board, "o")
    //println("X: $xWins - $xCount, O: $oWins - $oCount, fullBoard: $fullBoard")
    if(!xWins && !oWins){
        return "Empate"
    } else if(xWins && oWins) {
        return null
    } else {
        if(fullBoard){
            if((xCount == 4 && oCount == 5)
            || (xCount == 5 && oCount == 4)){
                if(xWins) return "X"
                if(oWins) return "O"
            } else return null
        } else {
            if(xWins) return "X"
            if(oWins) return "O" 
        }
    }
    return null
}

//Checa las posibles jugadas con las que se puede ganar
private fun checkPlays(board: Array<String>, symbol: String): Boolean{
    val horizontalStartPos = intArrayOf(0, 3, 6)
    val verticalStartPos = intArrayOf(0, 1, 2)
    //Las primeras 2 condiciones son para checar diagonalmente
    if(board[0] == symbol && board[4] == symbol && board[8] == symbol){
        return true
    } else if(board[2] == symbol && board[4] == symbol && board[6] == symbol){
        return true
    } else {
        for(pos in horizontalStartPos){
            if(board[pos] == symbol && board[pos + 1] == symbol
            && board[pos + 2] == symbol) return true
        }
        for(pos in verticalStartPos){
            if(board[pos] == symbol && board[pos + 3] == symbol
            && board[pos + 6] == symbol) return true
        }
    }
    return false
}
