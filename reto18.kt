import java.time.Duration

val ROW_MAX = 3
val COL_MAX = 3

/*
 * Twitter @Webserveis
 * Mis apps en Gplay: https://t.co/B3YLO5iUSS
 */
fun main() {
    
    //llenar con x, o, ""
    val gameBoard = arrayOf(
        arrayOf("o", "o", "o"),
        arrayOf("o", "x", "x"),
        arrayOf("o", "x", "x"),
    )
    println(validateGameBoard(gameBoard))
    
    //empate
    val gameBoard2 = arrayOf(
        arrayOf("o", "x", "o"),
        arrayOf("o", "x", "o"),
        arrayOf("x", "o", "x"),
    )   
    println(validateGameBoard(gameBoard2))

    // Gana X
    val gameBoard3 = arrayOf(
        arrayOf("x", "o", "o"),
        arrayOf("o", "x", "o"),
        arrayOf("x", "o", "x"),
    )   
    println(validateGameBoard(gameBoard3))

    // dos ganadores, nulo
    val gameBoard4 = arrayOf(
        arrayOf("x", "x", "o"),
        arrayOf("x", "o", "o"),
        arrayOf("x", "o", "o"),
    )   
    println(validateGameBoard(gameBoard4))   

    
    // tablero incorrecto, nulo
    val gameBoard5 = arrayOf(
        arrayOf("x", "x", ""),
        arrayOf("o", "", ""),
        arrayOf("x", "", ""),
    )   
    
    println(validateGameBoard(gameBoard5))   
    
}

fun getCellsCount(gameBoard: Array<Array<String>>) : Pair<Int,Int> {
    
    var p1 : Int = 0
    var p2 : Int = 0
    for (i in 0 until ROW_MAX) {
        for (j in 0 until COL_MAX) {
            if (gameBoard[i][j] == "x") p1++
            if (gameBoard[i][j] == "o") p2++
        }
    }
	return Pair(p1,p2)

}

fun isValidRatioPattern(gameBoard: Array<Array<String>>) : Boolean {
    
	val (p1,p2) = getCellsCount(gameBoard)
    
    return if (p1 == p2 || (p1 == p2 + 1) || (p1 == p2 -1 )) {
        true
    } else {
        false 
    }
}

/*
 *  Solución original de @Andres Mariscal
 *  https://medium.com/@andresmariscal/unbeatable-tic-tac-toe-an-android-app-using-kotlin-4f4d2576e6fd
 * 
 */
fun hasWon(gameBoard: Array<Array<String>>, thePlayer: String): Boolean {
    
    val winningPatterns: Array<Int> = arrayOf(
        0b111000000, 0b000111000, 0b000000111, // rows
        0b100100100, 0b010010010, 0b001001001, // columns
        0b100010001, 0b001010100)              // diagonals
    
    
    var pattern = 0b000000000
    for (row in 0 until ROW_MAX) {
        (0 until COL_MAX)
                .asSequence()
                .filter { gameBoard[row][it] == thePlayer }
                .forEach { pattern = pattern or (1 shl (row * COL_MAX + it)) }
    }
        
   winningPatterns
            .asSequence()
            .filter { (pattern and it) == it }
            .forEach { return true }

    return false
}


fun validateGameBoard(gameBoard: Array<Array<String>>) : String? {
    if (!isValidRatioPattern(gameBoard)) return null
    
    //detectar empate
   	val (p1,p2) = getCellsCount(gameBoard)
    
    //detectar ganadores
    val isWinX = hasWon(gameBoard, "x")
    val isWinO = hasWon(gameBoard, "o")

    return if (isWinX && isWinO) {
        null
    } else if (isWinX) {
        "x"
    } else if (isWinO) {
        "o"
    } else if ((p1 + p2) == ROW_MAX * COL_MAX) {
        "empate"
    } else null
    
}
