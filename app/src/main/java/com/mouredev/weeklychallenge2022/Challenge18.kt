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
 *
 */
fun main() {

    println("${Enraya(23, 67)}")
}

private fun Enraya(x: Int, O: Int): String? {

    val playGround = arrayListOf<String>(
        "O", "x", "O",
        "x", "O", "x",
        "O", "x", "O"
    )
    var S1: Int = x
    var S2: Int = O
    var index: Int = 0
    var index2: Int = 0

    for (S1 in playGround) {
        index++
    }
    for (S2 in playGround) {
        index2++
    }

    if (index > index2 && index2 + index <= 9) {
        return "Han ganado las X"
    } else if (index2 > index && index2 + index <= 9) {
        return "Han ganado las O"
    } else if (index == index2 && index2 + index <= 9) {
        return "Han empatado"
    } else if (index + index2 < 9) {
        return ""
    } else {
        return null
    }


}
