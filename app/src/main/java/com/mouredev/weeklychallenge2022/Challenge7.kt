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

private fun countWords (inputText: String) {
   var counter = ArrayList<Pair<String, Int>> ()
   var stringAux = "" //Para no usar substring
   // var index = 0
    var maxIndex = inputText.length - 1
    val puntuationSigns = arrayOf(" ", ",", ".", ":", ";")
   
   for (index in 0..maxIndex) {
      if (index==maxIndex&&inputText[index].toString() !in puntuationSigns) stringAux += inputText[index]
       
      if (index==maxIndex||inputText[index].toString() in puntuationSigns){
            var sile = chekWord(stringAux, counter)
            if (!sile.first){
                val pair = Pair(stringAux, 1)
                counter.add(pair)            
            } else {                
                counter[sile.second].second++
            }
            
            stringAux=""
        } else {
            stringAux += inputText[index] 
        }
   }
   
   if (chekWord("Kotlin", counter).first) println("si le")

   println(counter)
   
}

private fun isPuntuation (inputChar: String): Boolean {
   var check = false
   
   if (inputChar in arrayOf(" ", ",", ".", ":", ";")) check = true
   
   return check
}

private fun chekWord(inputWord:String, wordCounter:ArrayList<Pair<String, Int>>): Pair<Boolean, Int> {
   var exists = Pair(false, 0)

   for (i in 0..wordCounter.size - 1) {
      if (inputWord in wordCounter[i].first) exists = Pair(true, i)
   }
   return exists
}