package es.jaimefere.weeklychallenge2022

import org.omg.CORBA.Object

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

fun findItems(array1: Array<Any>, array2: Array<Any>, commons: Boolean): Array<Any> {
    return if(commons) {
        array1.filter{ array2.contains(it) }.toTypedArray()
    } else {
        (array1.filter{ !array2.contains(it) } + array2.filter{ !array1.contains(it) }).toTypedArray()
    }
}

fun main() {
    println("Elementos comunes: ${findItems(arrayOf("manzana", "pera", "mango"), arrayOf("manzana", "melón"), true).map { "$it" }}")
    println("Elementos distintos: ${findItems(arrayOf("manzana", "pera", "mango"), arrayOf("manzana", "melón"), false).map { "$it" }}")
    println("Elementos comunes: ${findItems(arrayOf(4L, 2, 3.5), arrayOf("manzana", 4L), true).map { "$it" }}")
    println("Elementos distintos: ${findItems(arrayOf(4L, 2, 3.5), arrayOf("manzana", 4L), false).map { "$it" }}")
}