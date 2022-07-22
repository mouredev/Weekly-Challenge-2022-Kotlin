package com.mouredev.weeklychallenge2022

/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


/**
 * Funcion Principal
 */
fun main() {

    val list = listOf(28, 11, 96, -5, 21, 18, 12, 22, 30, 97, -1, -40, -500)
    println("Lista: ${list}")

    println("Orden Ascendente: ${mergeSort(list, Order.ASC)}")
    println("Orden Descendente: ${mergeSort(list, Order.DESC)}")
}

/**
 * Enumerado que representa el orden de la lista.
 */
enum class Order {
    ASC,
    DESC
}

/**
 * Función que ordena una lista de números Mediante el método de Merge Sort.
 * @see https://es.wikipedia.org/wiki/Ordenamiento_por_mezcla
 * @see https://www.youtube.com/watch?v=dENca26N6V4
 * @param list Lista de números a ordenar.
 * @param order Orden de la lista.
 * @see Order
 * @return Lista ordenada en orden ascendente o descendente.
 */
fun mergeSort(list: List<Int>, order: Order): List<Int> {

    if (list.size == 1) {
        return list
    }

    val mid = list.size / 2
    val left = list.subList(0, mid)
    val right = list.subList(mid, list.size)

    return merge(mergeSort(left, order), mergeSort(right, order), order)

}

/**
 * Función que combina dos listas de números en una sola lista ordenada
 * @param order Orden de la lista Ascedente o descentente
 * @param left Lista de números de la izquierda.
 * @param right Lista de números a la derecha
 * @return Lista de números ordenados.
 */
fun merge(left: List<Int>, right: List<Int>,order: Order) : List<Int> {
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0
    while (i< left.size && j < right.size) {

        if(order== Order.ASC){
            if (left[i] < right[j]) {
                result.add(left[i])
                i++
            } else {
                result.add(right[j])
                j++
            }
            }
        else{

            if (left[i] > right[j]) {
                result.add(left[i])
                i++
            } else {
                result.add(right[j])
                j++
            }

        }
    }
    while (i < left.size) {
        result.add(left[i])
        i++
    }
    while (j < right.size) {
        result.add(right[j])
        j++
    }

    return result
}