package com.mouredev.weeklychallenge2022

import kotlin.math.sqrt

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {

    var area: Double
    val a = 2.0
    val b = 3.2
    val c = 5.1

    area = polygonArea(a)
    println("El área de un cuadrado de lado $a es: $area")

    area = polygonArea(a, b)
    println("El área de un rectángulo de lados $a y $b es: $area")

    area = polygonArea(a, b, c)
    println("El área de un triángulo de lados $a, $b y $c es: $area")

}

private fun polygonArea(vararg side: Double): Double {
    val area: Double
    if (side.filter { n -> n <= 0 }.isNotEmpty()) {
        println("El polígono introducido no es válido:")
        return 0.0
    }
    when (side.size) {
        1 -> area = side[0] * side[0]
        2 -> area = side[0] * side[1]
        3 -> {
            val s = (side[0] + side[1] + side[2]) / 2
            area = sqrt(s * (s - side[0]) * (s - side[1]) * (s - side[2]))
        }
        else -> {
            area = 0.0
            println("Polígono no soportado:")
        }
    }
    return area
}