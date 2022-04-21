package com.mouredev.weeklychallenge2022
/*
 * Reto #10
 * EXPRESIONES EQUILIBRADAS
 * Fecha publicación enunciado: 07/03/22
 * Fecha publicación resolución: 14/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que comprueba si los paréntesis, llaves y corchetes de una expresión están equilibrados.
 * - Equilibrado significa que estos delimitadores se abren y cieran en orden y de forma correcta.
 * - Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más importante que otro.
 * - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
 * - Expresión no balanceada: { a * ( c + d ) ] - 5 }
 *
 *
 */


fun main() {

    println(isBalanced("{a + b [c] * (2x2)}}}}"))
    println(isBalanced("{ [ a * ( c + d ) ] - 5 }"))
    println(isBalanced("{ a * ( c + d ) ] - 5 }"))
    println(isBalanced("{a^4 + (((ax4)}"))
    println(isBalanced("{ ] a * ( c + d ) + ( 2 - 3 )[ - 5 }"))
    println(isBalanced("{{{{{{(}}}}}}"))
    println(isBalanced("(a"))

}

/*
FUNCION DE MARTINEZ
-Esta función tiene en cuenta que haya el mismo número de simbolos de cierre que de apertura
-Esta función NO tiene en cuenta que los simbolos se abran y se cierren como deberían.
 */
fun isBalanced (expression : String) : Boolean{

    val openedParenthesisOccurrences  = expression.count {it == '('}
    val closedParenthesisOccurrences  = expression.count {it == ')'}
    val openedKeysOccurrences  = expression.count {it == '{'}
    val closedKeysOccurrences  = expression.count {it == '}'}
    val openedBracketOccurrences  = expression.count {it == '['}
    val closedBracketOccurrences  = expression.count {it == ']'}

    return openedParenthesisOccurrences == closedParenthesisOccurrences &&
            openedKeysOccurrences == closedKeysOccurrences &&
            openedBracketOccurrences == closedBracketOccurrences
}

/*
FUNCION DE MOURE
-Esta función tiene en cuenta que haya el mismo número de simbolos de cierre que de apertura
-Esta función tiene en cuenta que los simbolos se abran y se cierren como deberían.
 */
private fun isBalancedAux (expression: String): Boolean {

    val symbols = mapOf("{" to "}", "[" to "]", "(" to ")")
    val stack = arrayListOf<String>()

    expression.forEach {

        val symbol = it.toString()
        val containsKey = symbols.containsKey(symbol)

        if (containsKey || symbols.containsValue(symbol)) {
            if (containsKey) {
                stack.add(symbol)
            } else if (stack.isEmpty() || symbol != symbols[stack.removeLast()]) {
                return false
            }
        }
    }

    return stack.isEmpty()
}