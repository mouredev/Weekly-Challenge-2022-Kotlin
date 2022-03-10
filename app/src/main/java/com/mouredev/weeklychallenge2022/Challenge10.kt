package com.mouredev.weeklychallenge2022

import java.util.*

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

const val PARENTHESIS_OPEN = '('
const val PARENTHESIS_CLOSE = ')'
const val BRACKET_OPEN = '['
const val BRACKET_CLOSE = ']'
const val CURLY_BRACKET_OPEN = '{'
const val CURLY_BRACKET_CLOSE = '}'


/** Metodo Main
 * Metodo Principal del reto
 * */
fun main() {

    //Ejemplos de expresiones
    val expression_list = arrayListOf("{ [ a * ( c + d ) ] - 5 }",
                                      "{ a * ( c + d ) ] - 5 }")
    //Recorremos el array de expresiones
    expression_list.forEach {
        //Comprobamos si esta balanceada cada una de ellas
        val balanced = isBalanced(it)
        //Imprimimos el resultado
        println(when(balanced) {
            true -> "La expresión $it está bien balanceada"
            false -> "La expresión $it NO está balanceada"
        })

    }


}

/** Metodo isBalanced
 * Metodo que evalua una expresion para saber si esta bien balanceada
 * @param expression: String expresion a evaluar
 * @return Boolean : true si la expresion está bien balanceada, false si no lo está
 * */

fun isBalanced(expression: String): Boolean {
    val stack = Stack<Char>()

    expression.forEach {
        when(it){
            PARENTHESIS_OPEN -> stack.push(it)
            PARENTHESIS_CLOSE -> {
                if(stack.pop()!= PARENTHESIS_OPEN)
                    return false
            }
            BRACKET_OPEN -> stack.push(it)
            BRACKET_CLOSE -> {
                if(stack.pop()!= BRACKET_OPEN)
                    return false
            }
            CURLY_BRACKET_OPEN -> stack.push(it)
            CURLY_BRACKET_CLOSE -> {
                if(stack.pop()!= CURLY_BRACKET_OPEN)
                    return false
            }
        }
    }

    return  stack.isEmpty()
}

