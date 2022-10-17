package com.mouredev.weeklychallenge2022

/*
 * Reto #40
 * TRIÁNGULO DE PASCAL
 * Fecha publicación enunciado: 03/10/22
 * Fecha publicación resolución: 10/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que sea capaz de dibujar el "Triángulo de Pascal" indicándole
 * únicamente el tamaño del lado.
 * - Aquí puedes ver rápidamente cómo se calcula el triángulo:
 *   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    pascalTriangle(5)
    pascalTriangle(1)
    pascalTriangle(0)
    pascalTriangle(-5)
}

private fun pascalTriangle(size: Int) {

    var lastRow = arrayListOf<Int>()

    for (row in 0 until size) {

        val currentRow = arrayListOf<Int>()

        var triangleRow = ""

        for (element in 0..row) {

            if (element in 1 until row) {
                val value = lastRow[element - 1] + lastRow[element]
                triangleRow += "$value "
                currentRow.add(value)
            } else {
                triangleRow += "1 "
                currentRow.add(1)
            }
        }

        println(" ".repeat(size - row) + triangleRow)

        lastRow = currentRow
    }
}
