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

fun main() {
    var expression : String

    print("Introduce la expresión a comprobar: ")
    expression = readLine().toString()

    if(expression.contains("[({\\[\\]})]".toRegex()))
        print("La expresión $expression está balanceada? ${Evaluate(expression)}")
    else
        print("No es necesario evaluar si la expresion esta equilibrada")
}

private fun Evaluate (expr: String): Boolean {

    var listOfElements = mutableListOf<Char>()

    for (c in expr){
        when (c) {
            '{', '(', '[' -> listOfElements.add(c)
            '}', ')', ']' -> RemoveFromList(listOfElements, c)
        }
    }

    if (listOfElements.isNotEmpty())
        return  false

    return true
}

private fun RemoveFromList (itemsList: MutableList<Char>, character: Char ): Boolean {
    var result = true

    if (itemsList.isEmpty())
        return false
    when (character) {
        '}' -> if (itemsList.last() == '{') {
                    itemsList.removeLast()
                } else return false
        ')' -> if (itemsList.last() == '(') {
                    itemsList.removeLast()
                } else return false
        ']' -> if (itemsList.last() == '[') {
                    itemsList.removeLast()
                } else return false
    }
    return result
}
