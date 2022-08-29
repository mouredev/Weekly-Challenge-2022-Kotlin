package com.mouredev.weeklychallenge2022

/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    val example1 = arrayOf(1,3,6,8)
    val example2 = arrayOf(10,1)
    val example3 = arrayOf(5,7,2,1)
    val example4 = arrayOf(5)

    lookupForMissingOnes(example1)?.asList()?: println("Wrong input \n")
    lookupForMissingOnes(example2)?.asList()?: println("Wrong input \n")
    lookupForMissingOnes(example3)?.asList()?: println("Wrong input \n")
    lookupForMissingOnes(example4)?.asList()?: println("Wrong input \n")
}

private fun lookupForMissingOnes(numberList: Array<Int>): Array<Int>? {

    val missingOnes = mutableListOf<Int>()
    var completeListItemCounter = 0

    // First validation filter
    if (numberList.size < 2 || numberList.first() == numberList.last())
        return null

    if (numberList.first() > numberList.last()) {
        // Down count
        var nMissing = numberList.first() - numberList.size
        while (nMissing > 0) {
            val first = numberList[completeListItemCounter++]
            val second = numberList[completeListItemCounter]
            if (first - second > 1 ) {
                var x = 1
                repeat(first-second-1){
                    missingOnes.add(first-x++)
                    nMissing--
                }
            } else if (first - second != 1){
                // Second validation filter
                return null
            }
        }
    } else {
        // Up count
        var nMissing = numberList.last() - numberList.size
        while (nMissing > 0) {
            val first = numberList[completeListItemCounter++]
            val second = numberList[completeListItemCounter]

            if (first - second < -1) {
                var x = 1
                repeat(second-first-1) {
                    missingOnes.add(first + x++)
                    nMissing--
                }
            } else if (first - second != -1){
                // Second validation filter
                return null
            }
        }
    }

    if (missingOnes.isNotEmpty())
        println("In the number array: ${numberList.asList()} \n The missing ones are: $missingOnes \n")

    return missingOnes.toTypedArray()
}
