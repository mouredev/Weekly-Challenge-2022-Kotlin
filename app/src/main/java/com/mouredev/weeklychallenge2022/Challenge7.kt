package com.mouredev.weeklychallenge2022

/*
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
   val inputText = "Hola mundo en Kotlin en"
   
   countWords(inputText)
}

private fun countWords(input: String){    
    var counter = ArrayList<Pair<String, Int>> ()
    var stringAux = ""
    var maxIndex = input.length - 1
    val puntuationSigns = arrayOf(" ", ",", ".", ":", ";")
    
    for (index in 0..maxIndex) {        
       val eval = input[index].toString()
       
       if (eval !in puntuationSigns) stringAux += eval
       
       if (eval in puntuationSigns||index==maxIndex) {
           counter=updateCounter(counter, stringAux)           
           stringAux=""
       }
   } 
   
   println(counter)
}

private fun updateCounter(counter: ArrayList<Pair<String, Int>>, input: String): ArrayList<Pair<String, Int>> {
    val maxIndex = counter.size - 1
    var exists = false
    
    for (index in 0..maxIndex) {
        if (input == counter[index].first) {
            exists = true
            counter[index] = Pair(counter[index].first, counter[index].second + 1)
        }        
    }
    
    if (!exists) counter.add(Pair(input, 1))
    
    return counter    
}