package com.mouredev.weeklychallenge2022

/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 *
 */

fun main() {

    //Test función de Moure
    println(isAnagram("amor", "roma"))

    //Test función de Martinez
    if(esAnagrama("canción         ","noi             cnac")){
        println("SON ANAGRAMAS")

    }else{
        println("NO SON ANAGRAMAS")
    }
}

/*
FUNCIÓN DE MOURE
 */
private fun isAnagram(wordOne: String, wordTwo: String): Boolean {
    if (wordOne.lowercase() == wordTwo.lowercase()) {
        return false
    }
    return wordOne.lowercase().toCharArray().sortedArray().contentEquals(wordTwo.lowercase().toCharArray().sortedArray())
}

/*
FUNCIÓN DE MARTINEZ
 */
fun contadorOcurrencias (palabra: String, letra: Char): Int {
    return palabra.filter { it == letra }.length
}

//Función para dar formato a las distintas palabras
fun formatearPalabra(palabra: String): String {
    return palabra.lowercase().trim()
        .replace(" ", "")
        .replace("á","a")
        .replace("é","e")
        .replace("í","i")
        .replace("ó","o")
        .replace("ú","u")
}

//Función principal del reto
fun esAnagrama (palabraUno : String, palabraDos : String) : Boolean{
    val palabraUnoFormateada = formatearPalabra(palabraUno)
    val palabraDosFormateada = formatearPalabra(palabraDos)

    if((palabraUnoFormateada.length != palabraDosFormateada.length) || palabraUnoFormateada == palabraDosFormateada){
        return false
    }

    for(letra in palabraUnoFormateada) {
        val aparicionesEnPalabraUnoFormateada = contadorOcurrencias(palabraUnoFormateada, letra)
        val aparicionesEnPalabraDosFormateada = contadorOcurrencias(palabraDosFormateada, letra)

        if(aparicionesEnPalabraUnoFormateada != aparicionesEnPalabraDosFormateada){
            return false
        }
    }
    return true
}

