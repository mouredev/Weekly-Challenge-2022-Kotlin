package com.mouredev.weeklychallenge2022

/*
 * Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/11/22
 * Fecha publicación resolución: 19/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
 * algoritmo de encriptación de Karaca (debes buscar información sobre él).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main(){
    karacaEncrypt("Martha", encrypt = true)
    karacaEncrypt("0htr0M", encrypt = false)
}
private fun karacaEncrypt(text:String,encrypt:Boolean){
    var reversedText=text.reversed()
    val vowelsMap= mapOf("a" to 0,"e" to 1, "i" to 0, "o" to 0, "u" to 3)

    vowelsMap.forEach {
        reversedText = if(encrypt) {
            reversedText.replace(it.key, it.value.toString())
        }else{
            reversedText.replace(it.value.toString(),it.key)
        }
    }

    println(reversedText)
}