package es.jaimefere.weeklychallenge2022

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

fun quickSort(numbers: Array<Int>, first: Int, last: Int): Array<Int> {
    val p = numbers[(first + last) / 2]
    var i = first
    var j = last
    var result = numbers

    do {
        while(result[i] < p) { i += 1 }
        while(p < result[j]) { j -= 1 }
        if(i <= j) {
            val aux = result[i]
            result[i] = result[j]
            result[j] = aux
            i += 1
            j -= 1
        }
    } while(i <= j)
        if(first < j) {
            result = quickSort(result, first, j)
        }
    if(i < last) {
        result = quickSort(result, i, last)
    }
    return result
}

fun bubbleSort(numbers: Array<Int>): Array<Int> {
    var result = numbers

    (1 until result.size).forEach {
        (0 until result.size-1).forEach { i ->
            if(result[i] > result[i+1]) {
                val aux = result[i]
                result[i] = result[i+1]
                result[i+1] = aux
            }
        }
    }

    return result
}

fun insertionSort(numbers: Array<Int>): Array<Int> {
    var result = numbers

    (1 until result.size).forEach { i ->
        val aux = result[i]
        var j = i - 1
        while(j >= 0 && result[j] > aux) {
            result[j+1] = result[j]
            j -= 1
            result[j+1] = aux
        }
    }

    return result
}

fun sortNumbers(numbers: Array<Int>, order: String) {
    if(order == "Asc") {
        println("Quicksort: ${quickSort(numbers, 0, numbers.size - 1).toList()}")
        println("Bubble: ${bubbleSort(numbers).toList()}")
        println("Insertion: ${insertionSort(numbers).toList()}")
        println()
    } else {
        println("Quicksort: ${quickSort(numbers, 0, numbers.size - 1).reversed()}")
        println("Bubble: ${bubbleSort(numbers).reversed()}")
        println("Insertion: ${insertionSort(numbers).reversed()}")
        println()
    }
}


fun main() {
    sortNumbers(arrayOf(8, 4, 2, 9, 1), "Asc")
    sortNumbers(arrayOf(9, 8, 0, 2, 5, 1, 3, 2, 9), "Desc")
    sortNumbers(arrayOf(3, 10, 1, 8, 15, 5, 12, 6, 5, 4), "Asc")
}