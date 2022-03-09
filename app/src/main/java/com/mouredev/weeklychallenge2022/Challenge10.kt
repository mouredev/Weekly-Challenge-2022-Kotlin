package com.mouredev.weeklychallenge2022

/*
 * Reto #10
 * EXPRESIONES EQUILIBRADAS
 * Fecha publicación enunciado: 07/03/22
 * Fecha publicación resolución: 14/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que comprueba si los paréntesis, llaves y corchetes de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cierran en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
fun main() {

    val expression = "2x−{5+3x−[4x+(2x−5)−x]}"
    val reducedExpression = expression.replace("[^{}()\\[\\]]".toRegex(), "")

    if (reducedExpression.count() == 0) {
        println("La expresión \"$expression\" no contiene paréntesis, llaves y corchetes")
    } else {
        println("La Expresión \"$expression\" ${if (checkExpression(reducedExpression)) "está" else "no está"} equilibrada -> $reducedExpression")
    }
}

fun checkExpression(reducedExpression: String): Boolean {

    val elements = arrayListOf<Char>()

    if (reducedExpression.count() % 2 != 0) return false

    for (symbol in reducedExpression)
        if (symbol == '{' || symbol == '[' || symbol == '(') {
            elements.add(symbol)
        } else if (elements.isNotEmpty()) {
            when {
                symbol == '}' && elements.last() == '{' -> elements.removeLast()
                symbol == ']' && elements.last() == '[' -> elements.removeLast()
                symbol == ')' && elements.last() == '(' -> elements.removeLast()
                else -> return false
            }
        } else {
            return false
        }
    return true
}


