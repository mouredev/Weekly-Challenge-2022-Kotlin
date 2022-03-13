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
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */
private const val OPEN_PARENTHESES = '('
private const val CLOSE_PARENTHESES = ')'
private const val OPEN_BRACES = '{'
private const val CLOSE_BRACES = '}'
private const val OPEN_BRACKETS = '['
private const val CLOSE_BRACKETS = ']'

fun main() {
    println("Welcome to is balanced expression.")
    println("Enter text to check if is balanced expression: ")
    val text = readLine()
    text?.let {
        println(it.isBalancedExpression())
    }
}

private fun String.isBalancedExpression(): Boolean {
    val regex = "[^(){}\\[\\]]".toRegex()
    val expressions = this.replace(regex, "")
    val appearedExpressions: MutableList<Char> = mutableListOf()
    var isBalancedExpression = true
    expressions.forEach { expression ->
        if (isBalancedExpression){
            if (expression == OPEN_PARENTHESES || expression == OPEN_BRACES || expression == OPEN_BRACKETS) {
                appearedExpressions.add(expression)
            } else {
                val index = appearedExpressions.indexOfLast { it == expression.reverse() }
                isBalancedExpression = index != -1
                if (isBalancedExpression)
                    appearedExpressions.removeAt(index)
            }
        }
    }
    return appearedExpressions.isEmpty() && isBalancedExpression
}

private fun Char.reverse(): Char =
    when {
        this == CLOSE_PARENTHESES -> OPEN_PARENTHESES
        this == CLOSE_BRACES -> OPEN_BRACES
        this == CLOSE_BRACKETS -> OPEN_BRACKETS
        else -> throw IllegalArgumentException()
    }


