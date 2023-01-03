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
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    println(isAnagram("amor", "roma"))
}

private fun isAnagram(wordOne: String, wordTwo: String): Boolean {
    if (wordOne.lowercase() == wordTwo.lowercase()) {
        return false
    }
    return wordOne.lowercase().toCharArray().sortedArray().contentEquals(wordTwo.lowercase().toCharArray().sortedArray())
}

// javascript
anagrama('amor', 'roma')
anagrama('pepe', 'pepi')
anagrama('Amor', 'amores')
anagrama('Amor', 'amor')

function anagrama( palabraUno, palabraDos ) {
    if ( palabraUno.toLowerCase() === palabraDos.toLowerCase()){
            return console.log(false , 'las palabras son iguales')
    }   
    let arrUno = palabraUno.toLowerCase().split('').sort()
    let arrDos = palabraDos.toLowerCase().split('').sort()

    if ( arrUno.length === arrDos.length) {
       for ( let i = 0; i < arrUno.length; ++i ){
            if (arrUno[i] !== arrDos[i]) {
                return console.log(false , 'las palabras NO son anagramas')
            }
       } 
        return console.log(true , 'las palabras son anagramas');
    } else {
            console.log(false , 'las palabras son de diff longitud')
    }
}
