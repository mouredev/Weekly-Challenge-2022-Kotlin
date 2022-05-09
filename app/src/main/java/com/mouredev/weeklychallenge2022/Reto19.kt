/*
 * Reto #19
 * CONVERSOR TIEMPO
 * Fecha publicación enunciado: 09/05/22
 * Fecha publicación resolución: 16/05/22
 * Dificultad: FACIL
 *
 * Enunciado: Crea una función que reciba días, horas, minutos y segundos (como enteros) y retorne su resultado en milisegundos.
 */

fun main() {
    println(convertTimeToMs(2, 4, 16, 41)) // 188201000
    println(convertTimeToMs(3, 26, 124, 87)) //360327000
    println(convertTimeToMs(26, 15, 41, 10)) //2302870000
}

fun convertTimeToMs(days: Int, hours: Int, minutes: Int, seconds: Int): Long =
((days.toLong() * 24 * 60 * 60 * 1000) + (hours.toLong() * 60 * 60 * 1000) + (minutes.toLong() * 60 * 1000) + (seconds.toLong() * 1000)).toLong()