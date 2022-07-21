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

fun sortList(lista:List<Int>,orden:String):List<Int>{
    when(orden){
        "Asc" -> return asc(lista)
        "Desc" -> return desc(lista)
        else ->{
            return lista
        }
    }
}

fun asc(items:List<Int>):List<Int>{                 //quicksort
    // Return if the input list is empty or only has 1 entry, since it's already sorted
    if (items.size <= 1) {
        return items
    }

    // Pick a pivot
    val chosenItem: Int = items[items.size / 2]

    // Partition items in three sets: smaller, equal and greater than chosen item
    val smallerList: MutableList<Int> = mutableListOf()
    val equalList: MutableList<Int> = mutableListOf()
    val greaterList: MutableList<Int> = mutableListOf()
    items.forEach {
        when {
            it < chosenItem -> smallerList.add(it)
            it > chosenItem -> greaterList.add(it)
            else -> equalList.add(it)
        }
    }

    // Combine results and return
    val sortedList: MutableList<Int> = mutableListOf()
    sortedList.addAll(asc(smallerList)) // Recursive call
    sortedList.addAll(equalList)
    sortedList.addAll(asc(greaterList)) // Recursive call
    return sortedList
}
fun desc(items:List<Int>):List<Int>{

    // Return if the input list is empty or only has 1 entry, since it's already sorted
    if (items.size <= 1) {
        return items
    }

    // Pick a pivot
    val chosenItem: Int = items[items.size / 2]

    // Partition items in three sets: smaller, equal and greater than chosen item
    val smallerList: MutableList<Int> = mutableListOf()
    val equalList: MutableList<Int> = mutableListOf()
    val greaterList: MutableList<Int> = mutableListOf()
    items.forEach {
        when {
            it < chosenItem -> smallerList.add(it)
            it > chosenItem -> greaterList.add(it)
            else -> equalList.add(it)
        }
    }

    // Combine results and return
    val sortedList: MutableList<Int> = mutableListOf()
    sortedList.addAll(desc(greaterList))
    sortedList.addAll(equalList)
    sortedList.addAll(desc(smallerList))
    return sortedList
}
fun main(){
   val numbers = listOf<Int>(2,4,7,3,6,9,1,0)
    println(sortList(numbers,"Asc"))
    println(sortList(numbers,"Desc"))
    println(sortList(numbers,"Ascc"))

}
