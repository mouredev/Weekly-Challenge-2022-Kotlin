package es.jaimefere.weeklychallenge2022

/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */
fun getTheBigestTwo(numbers: Array<Int>): Int? {
    return if(numbers.size < 2) {
        print("¡El listado debe contener al menos 2 números!")
        null
    } else {
        var biggest = numbers[0]
        var result = numbers[0]
        numbers.forEach {
            if(it > biggest) {
                result = biggest
                biggest = it
            }
        }
        result
    }
}

fun main() {
    println(getTheBigestTwo(arrayOf()) ?: "")
    println(getTheBigestTwo(arrayOf(4)) ?: "")
    println(getTheBigestTwo(arrayOf(4, 4)) ?: "")
    println(getTheBigestTwo(arrayOf(4, 6, 1, 8, 2)) ?: "")
}