package com.mouredev.weeklychallenge2022

/*
 * Reto #39
 * TOP ALGORITMOS: QUICK SORT
 * Fecha publicación enunciado: 27/09/22
 * Fecha publicación resolución: 03/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Implementa uno de los algoritmos de ordenación más famosos: el "Quick Sort",
 * creado por C.A.R. Hoare.
 * - Entender el funcionamiento de los algoritmos más utilizados de la historia nos ayuda a
 *   mejorar nuestro conocimiento sobre ingeniería de software. Dedícale tiempo a entenderlo,
 *   no únicamente a copiar su implementación.
 * - Esta es una nueva serie de retos llamada "TOP ALGORITMOS", donde trabajaremos y entenderemos
 *   los más famosos de la historia.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    val numArray = Array(40){it+1}
    numArray.shuffle()

    println("\n Final Result ${quickSort(numArray)}")
}

private fun quickSort(unsortedArray: Array<Int>, step : Int = 0): MutableList<Int> {

    val pivot = unsortedArray[unsortedArray.size-1]
    var smallerThanPivot = mutableListOf<Int>()
    var biggerThanPivot = mutableListOf<Int>()

    unsortedArray.forEach {
        when {
            it > pivot -> biggerThanPivot.add(it)
            it < pivot -> smallerThanPivot.add(it)
            else -> Unit
        }
    }
    println("Step#$step ${unsortedArray.toMutableList()}=> $smallerThanPivot $biggerThanPivot, pivot: $pivot")

    if (biggerThanPivot.size > 1) {
        biggerThanPivot = quickSort(biggerThanPivot.toTypedArray(), step+1)
    }
    if (smallerThanPivot.size > 1) {
        smallerThanPivot = quickSort(smallerThanPivot.toTypedArray(), step +1)
    }

    val resultArray = mutableListOf<Int>()
    resultArray.addAll(smallerThanPivot)
    resultArray.add(pivot)
    resultArray.addAll(biggerThanPivot)

    return resultArray
}
