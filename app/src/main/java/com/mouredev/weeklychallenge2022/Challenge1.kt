package com.mouredev.weeklychallenge2022

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.HashMap

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

@RequiresApi(Build.VERSION_CODES.N)
fun StringToMap(string:String): Map<Char, Int> {
    val map_String: MutableMap<Char, Int> = HashMap()
    for (char in string)
    {
        map_String.putIfAbsent(char, 0)
        map_String[char] = map_String[char]!! + 1
    }
    return map_String
}

@RequiresApi(Build.VERSION_CODES.N)
fun Is_Anagram(string1: String, string2:String): Boolean{
    val map_String1: Map<Char, Int> = StringToMap(string1)
    val map_String2: Map<Char, Int> = StringToMap(string2)
    return map_String1.equals(map_String2)&&string1!=string2
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val result: Boolean = Is_Anagram("AAAABBBBCDEF","CDEFAAAABBBB")
    print(result)
}
