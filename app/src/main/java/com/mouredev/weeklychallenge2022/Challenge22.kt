package com.mouredev.weeklychallenge2022

/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {

    // Prueba para listas de enteros
    val listOfIntegerOne = arrayOf(2, 4, 6, 8, 10)
    val listOfIntegerTwo = arrayOf(1, 3, 6, 9, 12)

    println("Los elementos comunes de las listas ${listOfIntegerOne.toList()} y ${listOfIntegerTwo.toList()} son: ${compareLists(listOfIntegerOne, listOfIntegerTwo, true)}")
    println("Los elementos no comunes de las listas ${listOfIntegerOne.toList()} y ${listOfIntegerTwo.toList()} son: ${compareLists(listOfIntegerOne, listOfIntegerTwo, false)}")

    // Prueba para listas strings
    val listOfStringOne = arrayOf("a", "b", "c", "d", "e")
    val listOfStringTwo = arrayOf("c", "e", "g", "h", "i")

    println("Los elementos comunes de las listas ${listOfStringOne.toList()} y ${listOfStringTwo.toList()} son: ${compareLists(listOfStringOne, listOfStringTwo, true)}")
    println("Los elementos no comunes de las listas ${listOfStringOne.toList()} y ${listOfStringTwo.toList()} son: ${compareLists(listOfStringOne, listOfStringTwo, false)}")
}

private fun <T>compareLists(listOne: Array<T>, listTwo: Array<T>, equals: Boolean): ArrayList<T>{
    val listResult = arrayListOf<T>()

    if (equals){
        listOne.forEach{
            if (listTwo.contains(it)){
                listResult.add(it)
            }
        }
    }
    else {
        listOne.forEach{
            if (!listTwo.contains(it)){
                listResult.add(it)
            }
        }
        listTwo.forEach{
            if (!listOne.contains(it)){
                listResult.add(it)
            }
        }
    }
    return listResult
}