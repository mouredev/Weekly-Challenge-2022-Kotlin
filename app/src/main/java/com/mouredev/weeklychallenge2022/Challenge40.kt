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

fun main(){
    drawPascalTriangle(0)
    drawPascalTriangle(1)
    drawPascalTriangle(3)
    drawPascalTriangle(9)
}

private fun drawPascalTriangle(size: Int) {
    if (size >= 1) {
        print("With size: $size => \n")

        val baseLine = mutableListOf(1)
        val newLine = mutableListOf<Int>()

        repeat(size) {

            newLine.clear()
            newLine.add(1)
            if (baseLine.size >= 2) {
                for (i in 0 until baseLine.size - 1) {
                    newLine.add((baseLine[i] + baseLine[i + 1]))
                }
            }
            newLine.add(1)

            println(baseLine)
            baseLine.clear()
            baseLine.addAll(newLine)
        }
    } else println("Wrong size, must be more than 0")
}



