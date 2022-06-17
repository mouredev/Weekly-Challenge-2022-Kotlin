package com.mouredev.weeklychallenge2022

import java.util.ArrayList

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
 *
 */

fun main() {
    //contadorDePalabras("La casa de Brais no es una casa cualquiera es una casa muy especial")
    println(stringToArrayOfWords("      La casa        de Brais no es una casa   "))
}

/*
FUNCION DE MARTINEZ
 */
fun contadorDePalabras(frase : String){

     val arrayDePalabras= frase.split(" ")

    for (palabra in arrayDePalabras){
        var currentCounter = arrayDePalabras.filter { it == palabra }.size
        println("La palabra $palabra aparece: $currentCounter veces")
    }
}

/*
FUNCION DE MOURE
 */
fun countWords(text: String) {

    val words = mutableMapOf<String, Int>()

    text.lowercase().replace("[^a-z0-9]".toRegex(), " ").split(" ").forEach { key ->
        if (key.isEmpty()) {
            return@forEach
        }
        if (words[key] != null) {
            words[key] = words.getValue(key) + 1
        } else {
            words[key] = 1
        }
    }

    words.forEach { word ->
        println("${word.key} se ha repetido ${word.value} ${if(word.value == 1) "vez" else "veces"}")
    }
}


/*Método tradicioanl para dividir una string en un array de
palabras sin tener que usar ningún método del lenguaje que
lo haga automaticamente. Se están tentiendo en cuenta los
espacios múltiples entre palabras al igual que los espacios
al principio y al final*/

fun stringToArrayOfWords (frase : String) : ArrayList<String>{
    var fraseAux = "$frase "
    val arrayOfWords = arrayListOf<String>()
    var indiceInicioDePalabra = 0;
    var indiceFinDePalabra = 0;
    var posiblePalabra = false;

    for (index in fraseAux.indices){

        if (fraseAux[index].toString() != " " && !posiblePalabra){
            indiceInicioDePalabra = index
            posiblePalabra = true

        }else if (fraseAux[index].toString() == " " && posiblePalabra){
            indiceFinDePalabra = index
            arrayOfWords.add(fraseAux.substring(indiceInicioDePalabra, indiceFinDePalabra))
            posiblePalabra = false
        }
    }
    return arrayOfWords
}