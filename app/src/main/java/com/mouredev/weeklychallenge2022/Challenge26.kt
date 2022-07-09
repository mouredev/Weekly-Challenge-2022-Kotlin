package com.mouredev.weeklychallenge2022

/*
 * Reto #26
 * CUADRADO Y TRIÁNGULO 2D
 * Fecha publicación enunciado: 27/06/22
 * Fecha publicación resolución: 07/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    drawPolygon(10,PolygonType.SQUARE)
    drawPolygon(15,PolygonType.TRIANGLE)
    drawPolygon(12,PolygonType.DIAMOND)
}

private enum class PolygonType {
    SQUARE, TRIANGLE, DIAMOND
}

private fun drawPolygon(size: Int, type: PolygonType) {

    if (size < 2) {
        println("El tamaño debe ser mayor a 1")
    }

    var totalSize = size
    if (type == PolygonType.DIAMOND) {
        totalSize *= 2
    }

    for (value in 1..totalSize) {
        when (type) {
            PolygonType.SQUARE -> {
                println("* ".repeat(totalSize))
            }
            PolygonType.TRIANGLE -> {
                println("* ".repeat(value))
            }
            PolygonType.DIAMOND -> {
                if (value <= size) {
                    println("* ".repeat(value))
                } else {
                    println("${"  ".repeat(value - size)}${"* ".repeat(totalSize - value)}")
                }
            }
        }
    }

    println("")
}