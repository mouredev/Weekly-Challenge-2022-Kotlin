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


/*
FUNCION DE MARTINEZ
 */
fun main() {

    if(isBalanced("{ [ a * ( c + d ) ] - 5 }")){
        println("Balanceada")

    }else{
        println("NO balanceada")
    }
}

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

