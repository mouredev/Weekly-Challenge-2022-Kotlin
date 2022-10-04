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


/**
 *  Funcion Principal
 *
 */
fun main(){

    val array = arrayOf(5, 3, 8, 4, 2, 7, 1, 10, 6, 9)

    println("Array original: ${array.contentToString()}")
    println("Array ordenado: ${array.quickSort().contentToString()}")

}

/**
 * Funcion que ordena un array de enteros mediante el algoritmo Quick Sort
 * @return Array<Int> ordenado
 * @param array Array<Int> a ordenar
 * @param left Int indice izquierdo del array
 * @param right Int indice derecho del array
 */
fun quickSort(array: Array<Int>,left:Int,right:Int): Array<Int> {

    if(left < right) {
        val pivot = partition(array, left, right)
        quickSort(array, left, pivot - 1)
        quickSort(array, pivot + 1, right)
    }
    return array
}

/**
 * Funcion que particiona un array de enteros , usando la metodologia divide y venceras
 * @return Int indice del pivote
 * @param array Array<Int> a partir
 * @param left Int indice izquierdo del array
 * @param right Int indice derecho del array
 * @param pivot Int indice del pivote
 */

fun partition(array: Array<Int>,left:Int,right:Int): Int {
    val pivot = array[right]

    var i = left
    for(j in left until right) {
        if(array[j] <= pivot) {
            swap(array,i,j)
            i++
        }
    }
    swap(array,i,right)
    return i

}

/**
 * Funcion que intercambia dos elementos de un array
 * @param array Array<Int> que contiene los elementos a intercambiar
 * @param i Int indice del elemento que se intercambiará con el elemento de indice j
 * @param j Int indice del elemento que se intercambiará con el elemento de indice i
 */
fun swap(array: Array<Int>,i:Int,j:Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}


/**
 * Funcion de extension de Array que devuelve el array ordenado mediante el algoritmo Quick Sort
 */
fun Array<Int>.quickSort():Array<Int>{
    return quickSort(this, 0, this.size - 1)
}


