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

fun main() {
    println(orderList(mutableListOf(1, 3, 4, 6, 2, 10, 9, 8), "Asc"))
    println(orderList(mutableListOf(1, 3, 4, 6, 2, 10, 9, 8), "Desc"))
    println(orderList(mutableListOf(100, 531, 69, 420, 3, 862, 591), "Asc"))
    println(orderList(mutableListOf(100, 531, 69, 420, 3, 862, 591), "Desc"))
}

private fun orderList(list: MutableList<Int>, sortType: String): List<Int> {
    val newList = mutableListOf<Int>()
    list.forEachIndexed givenList@{ index, num ->
        val clonedNewList = newList.toMutableList()
        if (index == 0) {
            // First index, adding to first and skipping
            newList.add(num)
            return@givenList
        }
        run breaking@{
            if (sortType == "Asc") {
                // Is ascending
                clonedNewList.forEachIndexed newList@{ indexNew, numNew ->
                    if (num > numNew) {
                        if (indexNew == clonedNewList.lastIndex) {
                            // Is last index, adding num to indexNew + 1
                            newList.add(indexNew + 1, num)
                        } else {
                            // Not last index, going to next indexNew
                            return@newList
                        }
                    } else {
                        // num < numNew, adding $num to index $indexNew
                        newList.add(indexNew, num)
                        return@breaking
                    }
                }
            } else if (sortType == "Desc") {
                // Is descending
                clonedNewList.forEachIndexed newList@{ indexNew, numNew ->
                    if (num < numNew) {
                        if (indexNew == clonedNewList.lastIndex) {
                            // Is last index, adding num to indexNew + 1
                            newList.add(indexNew + 1, num)
                        } else {
                            // Not last index, going to next indexNew
                            return@newList
                        }
                    } else {
                        // num < numNew, adding $num to index $indexNew
                        newList.add(indexNew, num)
                        return@breaking
                    }
                }
            }
        }
    }
    return newList
}