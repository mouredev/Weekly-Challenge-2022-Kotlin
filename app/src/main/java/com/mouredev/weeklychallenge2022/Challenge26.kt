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
    drawShape(width = 10, type = TypeShape.SQUARE)
    drawShape(width = 5, type = TypeShape.TRIANGLE)
}

enum class TypeShape {
    SQUARE, TRIANGLE
}

private fun drawShape(width: Int, type: TypeShape) {
    when(type) {
        TypeShape.SQUARE -> drawSquare(width)
        TypeShape.TRIANGLE -> drawTriangle(width)
    }
    println()
}

private fun drawSquare(width: Int) {
    val widthWithSpace = width * 3 - 2
    repeat(width) {
        when(it) {
            0, width -1 -> fillLine(width, 3)
            else -> {
                println(String(CharArray(widthWithSpace) {
                    if(it == 0 || it == widthWithSpace - 1) '*' else ' '
                }))
            }
        }
    }
}

private fun drawTriangle(width: Int) {
    val widthWithSpace = width * 4 - 3
    var pointerLeft = widthWithSpace / 2
    var pointerRight = widthWithSpace / 2
    repeat(width) { line ->
        if(line == width - 1) {
            fillLine(width, 4)
        } else {
            println(String(CharArray(widthWithSpace) {
                if(it == pointerLeft || it == pointerRight) '*' else ' '
            }))
        }
        pointerLeft -= 2
        pointerRight += 2
    }
}

private fun fillLine(width: Int, space: Int) {
    val widtWithSpace = width * space - (space - 1)
    println(String(CharArray(widtWithSpace) {
        if(it%space == 0) '*' else ' '
    }))
}