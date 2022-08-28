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

class EmptyArrayError: Exception()
class UnsortedArrayError: Exception()
class NonUniqueValuesArrayError: Exception()

fun getMissedValues(numbers: Array<Int>): Array<Int> {
    val missedValues: MutableList<Int> = mutableListOf()
    if(numbers.isEmpty()) {
        throw EmptyArrayError()
    }
    numbers.sortedArray().forEachIndexed { index, i ->
        if(i != numbers[index]) {
            throw UnsortedArrayError()
        }
    }
    if(numbers.distinct().size != numbers.size) {
        throw NonUniqueValuesArrayError()
    }
    (0..(numbers.last() - numbers.first())).forEach { index ->
        if(!numbers.contains(index + numbers.first())) {
            missedValues.add(index + numbers.first())
        }
    }
    return missedValues.toTypedArray()
}

fun printMissedValues(numbers: Array<Int>) {
    try {
        println(getMissedValues(numbers).asList())
    } catch (e: EmptyArrayError) {
        println("El array no es válido porque está vacío")
    } catch (e: UnsortedArrayError) {
        println("El array no es válido porque los elementos no están correctamente ordenados")
    } catch (e: NonUniqueValuesArrayError) {
        println("El array no es válido porque tiene elementos repetidos")
    }
}

fun main() {
    printMissedValues(arrayOf(5,5,6,7,8))
    printMissedValues(arrayOf(8,7,6,5))
    printMissedValues(arrayOf())
    printMissedValues(arrayOf(5))
    printMissedValues(arrayOf(5,6,7,8))
    printMissedValues(arrayOf(5,8))
}
