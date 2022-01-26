package com.mouredev.weeklychallenge2022

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
    println(Polygon(4.0).getArea())
    println(Polygon(7.0, 4.0).getArea())
    println(Polygon(3.0, 4.0, 5.0).getArea())
}

class Polygon {
    val possibleDistinctSideLengths: Int
    var width: Double
    var height: Double = 0.0
    var length: Double = 0.0

    constructor(sideWidth: Double) {
        possibleDistinctSideLengths = 1
        width = sideWidth
    }

    constructor(base: Double, height: Double) {
        possibleDistinctSideLengths = 2
        width = base
        this.height = height
    }

    constructor(sideLengthA: Double, sideLengthB: Double, sideLengthC: Double) {
        possibleDistinctSideLengths = 3
        width = sideLengthA
        height = sideLengthB
        length = sideLengthC
    }

    fun getArea(): Double {
        return when(possibleDistinctSideLengths) {
            1 -> width * width
            2 -> width * height
            else -> {
                val semiperimeter = (width + height + length) / 2.0
                Math.sqrt(semiperimeter * (semiperimeter - width) * (semiperimeter - height) * (semiperimeter - length))
            }
        }
    }
}

