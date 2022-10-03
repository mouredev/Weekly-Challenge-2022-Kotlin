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
    var array = arrayOf<Int>(1,5,9,0,6,2)
    ordenar(array, 0, array.size - 1)

    for (i in array) print("${i} ")
}

fun ordenar(array: Array<Int>, p: Int, r: Int) {
    if (p < r) {
        var q: Int = particionar(array, p, r)
        ordenar(array, p, q - 1)
        ordenar(array, q + 1, r)
    }
}

fun particionar(array: Array<Int>, p: Int, r: Int): Int {

    fun pivotar(array: Array<Int>, i: Int, j: Int) {
        var temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    var x = array[r]
    var i = p - 1
    for (j in p until r) {
        if (array[j] <= x) {
            i++
            pivotar(array, i, j)
        }
    }
    pivotar(array, i + 1, r)
    return i + 1
}
