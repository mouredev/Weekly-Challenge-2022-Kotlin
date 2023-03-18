package com.mouredev.weeklychallenge2022


/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * - Ten cuidado con algunos casos especiales.
 * - Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main(){
    mostRepeatedVocalIn("Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita." +
            " * Si no hay vocales podrá devolver vacío.")
    mostRepeatedVocalIn("")
}

private fun mostRepeatedVocalIn(textForAnalysis : String) : Char?{
    val totalLettersCharMap = mutableMapOf<Char, Int>()

    fun addOrCount(letter : Char){
        if (totalLettersCharMap.containsKey(letter)){
            totalLettersCharMap[letter] = totalLettersCharMap[letter]!!.plus(1)
        } else {
            totalLettersCharMap[letter] = 1
        }
    }

    textForAnalysis.split(" ").forEach {
        it.toCharArray().forEach { singleLetter ->
            addOrCount(singleLetter)
        }
    }

    var mostRepeated : Char? = null
    var totalCount = 0

    fun computeMostRepeatedVocal(){
        val vocals = listOf('a', 'e', 'i', 'o', 'u')
        vocals.forEach{ vocal ->
            if (totalLettersCharMap.containsKey(vocal)){
                if (totalLettersCharMap[vocal]!! > totalCount){
                    mostRepeated = vocal
                    totalCount = totalLettersCharMap[vocal]!!

                    println("$vocal , $totalCount")
                }
            }
        }
    }

    fun computeMostRepeatedLetter(){
        totalLettersCharMap.forEach{
            if (it.value > totalCount){
                totalCount = it.value
                mostRepeated = it.key
            }
        }
    }

    computeMostRepeatedVocal()
    if (mostRepeated != null)
        println("Int the text : \"$textForAnalysis\", " +
            "the most repeated vocal is $mostRepeated $totalCount times")
    else
        println("Null")

    return mostRepeated
}