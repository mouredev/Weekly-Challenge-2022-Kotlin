package com.mouredev.weeklychallenge2022

import java.util.*

/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


fun main(){
    println(countVowels("Martha is a graphic designer"))
    println(countVowels("aa eeee iiiii uuuuuu"))
    println(countVowels(""))
}
private fun countVowels(text:String):String{
    val vowels= mutableMapOf<String,Int>()

    if(text.isEmpty())return ""

    text.lowercase(Locale.getDefault()).replace("[^aeiou]".toRegex(),"").forEach { char->
        if(vowels[char.toString()] !=null){
            vowels[char.toString()] = vowels.getValue(char.toString()) + 1
        }
        else{
            vowels[char.toString()]=1
        }
    }
    var maxValue = 0
    var vowelKey = ""
    vowels.forEach{vowel->
        maxValue=vowel.value
        for(v in vowels){
            if(v.value>maxValue){
                maxValue=v.value
                vowelKey=v.key

            }
        }
    }
    return "'${vowelKey}' se repite $maxValue veces"
}