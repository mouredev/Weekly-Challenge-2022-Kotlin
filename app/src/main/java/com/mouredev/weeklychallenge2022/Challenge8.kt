package com.mouredev.weeklychallenge2022

/*
 * Reto #8
 * DECIMAL A BINARIO
 * Fecha publicación enunciado: 18/02/22
 * Fecha publicación resolución: 02/03/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa se encargue de transformar un número decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main(args: Array<String>) {
    println(convertDecimalToBinaryRecursive(19))
}




/*
Version recursiva
 */
fun convertDecimalToBinaryRecursive(number: Int): String {
    val list =  aux(number)
    var str = ""
    for (i in 0 until  list.size){
        str += list[i]
    }
    return str
}

fun aux(number: Int): MutableList<String>{
    if(number == 0)
        return mutableListOf()

    val reminder = (number % 2).toString()
    val quotient = number / 2
    val newList =  aux(quotient)
    newList.add(reminder)
    return newList
}
