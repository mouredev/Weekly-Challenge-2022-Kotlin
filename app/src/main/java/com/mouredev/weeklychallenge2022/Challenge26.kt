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
    paintFigure("cuadrado", 4)
}

fun paintFigure(figure: String, sideOneLength: Int, sideTwoLength: Int = 0) {
    val figures = listOf("cuadrado", "triangulo", "rectangulo")

    if (figure !in figures) {
        println("Aún no se pintar la figura $figure")
        return
    }

    if ((sideOneLength < 2) || (figure == "rectangulo" && sideTwoLength < 2)) {
        println("Para pintar correctamente la figura los lados deben ser al menos de 2")
        return
    }

    if (figure == "rectangulo" && sideOneLength == sideTwoLength)
        println("Para hacer eso, mejor pinta un cuadrado")

    var sideAux = 0

    (1..sideOneLength).forEach {
        when (figure.lowercase()) {
            "cuadrado" -> sideAux = sideOneLength
            "triangulo" -> sideAux = it
            "rectangulo" -> sideAux = sideTwoLength
        }

        (1..sideAux).forEach {
            print("* ")
        }
        println()
    }
}