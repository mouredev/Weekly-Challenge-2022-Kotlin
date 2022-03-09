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
    val input = "([uno]))"
    
    if (isBalanced(input)) { 
        println("Expresion balanceada")
    } else {
        println("Cagada")
    }
    
}

private fun isBalanced(input: String): Boolean {
    val delimiters = mutableMapOf(")" to "(", "]" to "[", "}" to "{")
    var controlList: MutableList<String> = mutableListOf()   
    var output = true
    
    input.forEach() {
        val item = it.toString()
        
        when {            
            delimiters.containsValue(item) -> controlList.add(item)
            
            delimiters.containsKey(item) -> {                
                if (controlList.isEmpty()) return false
                
                if (delimiters.get(item) == controlList.last()) {
                    controlList.removeAt(controlList.size - 1)
                } else {                    
                    return false
                }          
            }
        }
    }    
    
    return output
}

