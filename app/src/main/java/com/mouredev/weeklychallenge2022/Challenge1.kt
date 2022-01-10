package com.mouredev.weeklychallenge2022

import java.util.*
import kotlin.jvm.JvmStatic

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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🗓reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val anagrama = esAnagrama("Holaa", "hLoaa")
    //val anagrama = esAnagrama2("Holaa", "hLoaa")
    if (anagrama) {
        println("Las dos palabras son anagramas")
    } else {
        println("Las dos palabras NO son anagramas")
    }
}

// Forma 1
private fun esAnagrama(palabra1: String, palabra2: String): Boolean {
    // Convertir String palabra1 en array
    val StrPalabra1 = palabra1.lowercase().toCharArray()

    // Convertir String palabra2 en array
    val StrPalabra2 = palabra2.lowercase().toCharArray()

    var resp = false
    if (palabra1.equals(palabra2, ignoreCase = true)) {
        resp = false
    } else {
        if (StrPalabra1.size == StrPalabra2.size) { // Las dos palabras tienen el mismo numero de letras
            var i = 0
            var letrasExistentes = 0
            do { // Mientras la posicion exista 0
                var j = 0
                while (j < StrPalabra2.size && StrPalabra1[i] != StrPalabra2[j]) {
                    j++
                }
                if (j < StrPalabra2.size) {
                    println("Existe la letra " + StrPalabra1[i] + " en la posicion " + j)
                    letrasExistentes++
                    StrPalabra2[j] = '0'
                } else {
                    println("No existe la letra " + StrPalabra1[i])
                    resp = false
                }
                i++
            } while (i < StrPalabra1.size)
            if (letrasExistentes == StrPalabra2.size) {
                resp = true
            }
        } else {
            resp = false
        }
    }
    return resp
}

// Forma 2
private fun esAnagrama2(palabra1: String, palabra2: String): Boolean {
    val palabra1Char = palabra1.lowercase(Locale.getDefault())
    val palabra2Char = palabra2.lowercase(Locale.getDefault())

    val palabra1 = palabra1Char.replace("[^\\\\dA-Za-z]".toRegex(), "").toCharArray()
    val palabra2 = palabra2Char.replace("[^\\\\dA-Za-z]".toRegex(), "").toCharArray()

    Arrays.sort(palabra1)
    Arrays.sort(palabra2)
    return Arrays.equals(palabra1, palabra2)
}