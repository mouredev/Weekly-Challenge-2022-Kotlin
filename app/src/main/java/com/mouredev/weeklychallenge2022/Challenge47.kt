package com.mouredev.weeklychallenge2022

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

fun main() {
    val vocal =
        maxRepeatVocal("Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.")
    println("La vocal ${vocal.first} se repite ${vocal.second} veces.")
}


private fun maxRepeatVocal(text: String): Pair<String, Int> {
    val repeatVocalMap = mutableMapOf("A" to 0, "E" to 0, "I" to 0, "O" to 0, "U" to 0)

    for (i in text.indices) {
        when (text.uppercase()[i]) {
            'A', 'Á' -> repeatVocalMap["A"]?.let { repeatVocalMap.replace("A", it.plus(1)) }
            'E', 'É' -> repeatVocalMap["E"]?.let { repeatVocalMap.replace("E", it.plus(1)) }
            'I', 'Í' -> repeatVocalMap["I"]?.let { repeatVocalMap.replace("I", it.plus(1)) }
            'O', 'Ó' -> repeatVocalMap["O"]?.let { repeatVocalMap.replace("O", it.plus(1)) }
            'U', 'Ú' -> repeatVocalMap["U"]?.let { repeatVocalMap.replace("U", it.plus(1)) }
        }
    }

    return repeatVocalMap.toList()
        .sortedBy { (key, value) -> value }
        .reversed()[0]
    ;
}