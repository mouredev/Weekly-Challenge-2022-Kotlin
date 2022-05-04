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
    val matrix1 = arrayListOf(
        arrayListOf("O", "X"),
        arrayListOf("X", "X"),
        arrayListOf("O", "X")
    )
    val matrix2 = arrayListOf(
        arrayListOf("O", "X", "X"),
        arrayListOf("X", "X", "O")
    )
    val matrix3 = arrayListOf(
        arrayListOf("X", "O", "X"),
        arrayListOf("X", "O", "O"),
        arrayListOf("X", "X", "O")
    )
    val matrix4 = arrayListOf(
        arrayListOf("X", "O", "X"),
        arrayListOf("O", "O", "O"),
        arrayListOf("X", "X", "O")
    )
    val matrix5 = arrayListOf(
        arrayListOf("O", "O", "X"),
        arrayListOf("X", "O", "O"),
        arrayListOf("O", "X", "O")
    )
    val matrix6 = arrayListOf(
        arrayListOf("X", "O", "X"),
        arrayListOf("X", "", "O"),
        arrayListOf("X", "X", "O")
    )
    val matrix7 = arrayListOf(
        arrayListOf("X", "O", "X"),
        arrayListOf("X", "O", "O"),
        arrayListOf("O", "X", "O")
    )
    val matrix8 = arrayListOf(
        arrayListOf("X", "O", "O"),
        arrayListOf("X", "O", "O"),
        arrayListOf("X", "X", "O")
    )
    Evaluate(matrix1); // Nulo por dimensiones incorrectas (matriz 2x3)
    Evaluate(matrix2); //Nulo por dimensiones incorrectas (matriz 3x2)
    Evaluate(matrix3); // Ganan las X
    Evaluate(matrix4); // Ganan las O
    Evaluate(matrix5); // Nulo por deproporcion entre X y O
    Evaluate(matrix6); // Nulo por casilla vacia
    Evaluate(matrix7); // Empate
    Evaluate(matrix8); // Nulo porque ambos ganan
}

private fun Evaluate(matrix: ArrayList<ArrayList<String>>){

    var result = "";

    // Primero vamos a comprobar que la matrix tiene dimension 3x3
    if(CheckDimensions(matrix)){
        // Vamos a pasar la matriz a un array de una dimension para facilitar la busqueda de ganador

        var oneDimension = MatrixToArray(matrix);

        // A continuación vamos a comprobar las condiciones que provocarian una partida nula
        if(NotNullConditions(oneDimension)){
            result = CheckWinner(oneDimension)
        }
        else {
            result ="Nulo. Se produce alguna condición de las que provocan nulo"
        }
    }
    else {
        // La dimension no es 3x3. Resultado Nulo
        result ="Nulo. Dimensiones incorrectas"
    }

    println("El resultado del juego es: $result");
}

private fun CheckDimensions (matrix: ArrayList<ArrayList<String>>):Boolean {

    var rows = matrix.size;
    var result = true;

    if (rows == 3){
        for ( i in 0..rows - 1 ) {
            if (matrix[i].size != 3) {
                result = false
            }
        }
    }
    else
        result = false;

    return result;
}

private fun MatrixToArray (matrix: ArrayList<ArrayList<String>>): ArrayList<String>{

    var array : ArrayList<String> = ArrayList();

    for (i in 0..matrix.size-1) {
        for (j in 0..matrix[i].size - 1) {
            array.add(matrix[i][j]);
        }
    }
    return array;
}

private fun NotNullConditions(array: ArrayList<String>): Boolean {

    var xNumber = 0;
    var oNumber = 0;
    var quotationNumber = 0;

    for (i in 0..array.size-1){
        when (array[i]){
            "X" -> xNumber++;
            "O" -> oNumber++;
            "" -> quotationNumber++;
            else ->  return false;
        }
    }
    return (quotationNumber == 0 && (xNumber == oNumber || (xNumber == 4 && oNumber ==5) || (xNumber == 5 && oNumber ==4)))
}

private fun CheckWinner(array: ArrayList<String>): String {

    var winner = "";
    var xWin = false;
    var oWin = false;

    for (i in 0..array.size-1){
        when(i) {
            0 -> if ((array[i] == array[1] && array[i] == array[2]) ||
                (array[i] == array[3] && array[i] == array[6])||
                (array[i] == array[4] && array[i] == array[8])){
                    if (array[i] == "X"){
                        xWin = true
                    }
                    else {
                        oWin = true
                    }
                }
            1 -> if (array[i] == array[4] && array[i] == array[7]){
                    if (array[i] == "X"){
                        xWin = true
                    }
                    else {
                        oWin = true
                    }
            }
            2 -> if ((array[i] == array[5] && array[i] == array[8]) ||
                (array[i] == array[4] && array[i] == array[6])){
                    if (array[i] == "X"){
                        xWin = true
                    }
                    else {
                        oWin = true
                    }
            }
            3 -> if (array[i] == array[4] && array[i] == array[5]){
                    if (array[i] == "X"){
                        xWin = true
                    }
                    else {
                        oWin = true
                    }
            }
            6 -> if (array[i] == array[7] && array[i] == array[8]){
                if (array[i] == "X"){
                    xWin = true
                }
                else {
                    oWin = true
                }
            }
        }
    }

    // Resultados

    if (xWin == false && oWin == false){
        winner = "Empate"
    } else if (xWin == true && oWin == true){
        winner = "Nulo"
    } else if (xWin == true && oWin == false){
        winner = "Gana X"
    } else {
        winner = "Gana O"
    }

    return winner;
}