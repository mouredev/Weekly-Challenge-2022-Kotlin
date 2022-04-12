package com.example.weeklychallenge2022
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

/*
* Lo he hecho implementado una pila con un array y la funcion devuelve un boolean, la pila se va llenando con los carateres de apertura
*  y en el momento que encuentra uno de cierre comprueba se es el que esta en lo alto de la pila. Si lo es lo borra
*  y si no pone al boolean a false y se sale del bucle.
*  También compruebo que si lo primero que encuentra es un caracter de cierre y la pila esta vacia el boolean es falso
 */

fun main() {
    var expression = "{ [ a * ( c + d ) ] - 5 }"
    println(expression +": "+ verification(expression))
    expression = "{ a * ( c + d ) ] - 5 }"
    println(expression +": "+ verification(expression))
    expression = "{ [ a * ( c + d ) ] - 5"
    println(expression +": "+ verification(expression))
    expression = "} a * ( c + d ) ] - 5 }"
    println(expression +": "+ verification(expression))
    expression = "{a + b [c]* (2x2)}}}}"
    println(expression +": "+ verification(expression))
}


private fun verification (input: String): Boolean {
    val symbols = mapOf("{" to "}" , "(" to ")", "[" to "]")
    val stack = arrayListOf<String>()

    input.forEach {
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
/*
    var balanced = true

    val pile = arrayListOf<String>()

    for (character in input){
        when (character.toString()) {
            "{","(","[" ->{
                pile.add(character.toString())
            }
            "]" ->{
                if (pile.size !=0){
                    if (pile[pile.lastIndex] == "["){
                        pile.removeLast()
                    } else {
                        balanced=false
                        break
                    }
                }else{
                    balanced=false
                    break
                }
            }
            "}" ->{
                if (pile.size !=0){
                    if (pile[pile.lastIndex] == "{"){
                        pile.removeLast()
                    } else {
                        balanced=false
                        break
                    }
                }else{
                    balanced=false
                    break
                }
            }
            ")" ->{
                if (pile.size !=0){
                    if ( pile[pile.lastIndex] == "("){
                        pile.removeLast()
                    } else {
                        balanced=false
                        break
                    }
                }else{
                    balanced=false
                    break
                }
            }
        }
    }
    if (pile.size != 0){
        balanced = false
    }
    return balanced*/
