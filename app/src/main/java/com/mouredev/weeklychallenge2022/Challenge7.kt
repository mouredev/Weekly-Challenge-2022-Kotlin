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
    //contadorDePalabrasModerno("La casa de Brais no es una casa cualquiera es una casa muy especial")
    contadorDePalabrasClasico("La casa de")
}

fun contadorDePalabrasModerno(frase : String){

     val arrayDePalabras= frase.split(" ", ignoreCase = true)

    for (palabra in arrayDePalabras){
        var currentCounter = arrayDePalabras.filter { it == palabra }.size
        println("La palabra $palabra aparece: $currentCounter veces")
    }
}

fun contadorDePalabrasClasico(frase : String){
    val arrayOfWords = stringToArrayOfWords(frase)
    var contadorDepalabras = 0
}

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

        }else if (fraseAux[index].toString() == " "){
            indiceFinDePalabra = index
            arrayOfWords.add(fraseAux.substring(indiceInicioDePalabra, indiceFinDePalabra))
            posiblePalabra = false
        }
    }
    return arrayOfWords
}