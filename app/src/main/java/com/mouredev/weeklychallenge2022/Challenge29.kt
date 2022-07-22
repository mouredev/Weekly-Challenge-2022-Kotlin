package com.mouredev.weeklychallenge2022

/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

 /*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {    
    val input: List<Int> = listOf(5, 3, 6, 2, 1, 4)

    val output: MutableList<Int> = arrangeRec(input, "desc", false)

    println(" \nINPUT : $input")
    println("OUTPUT: $output")
}

fun arrangeRec(input: List<Int>, order: String, orderedIn: Boolean): MutableList<Int> {
    if (errorInputData(input, order)) return mutableListOf()  
     
    var numAux = 0
    var orderedOut = true
    val output = input.toMutableList()
        
    if (!orderedIn) {        
        (1..output.lastIndex).forEach {
            when (order.lowercase()) {
                "asc" -> {
                    if (output[it-1] > output[it]) {
                        orderedOut = false
                        
                        numAux = output[it]
                        output[it] = output[it-1]
                        output[it-1] = numAux  
                    }
                }
                
                "desc" -> {
                    if (output[it-1] < output[it]) {
                        orderedOut = false
                        
                        numAux = output[it]
                        output[it] = output[it-1]
                        output[it-1] = numAux                
                    }
                }
            }
        }        
    }
    
    if (!orderedOut) return  arrangeRec(output.toList(), order, orderedOut)
    
    if (order.lowercase() == "asc") println ("Orden Ascendente")
    if (order.lowercase() == "desc") println ("Orden Descendente")
    
    return output
}


fun errorInputData(input: List<Int>, order: String): Boolean{
    var error = false
    
    if (input.isNullOrEmpty()) {
        println ("Lista a ordenar vacia")
        error = true
    }
    
    if (!error && input.size <= 1) {
        println ("La lista debe tener al menos 2 valores a ordenar")
        error = true
    }
    
    if (!error && order.isNullOrEmpty()) {
        println ("Debes indicar un orden")
        error = true
    }
        
    
    if (!error && order.lowercase() != "asc" && order.lowercase() != "desc") {
        println("No se como ordenarlo")
        error = true
    }
    
    return error
}
