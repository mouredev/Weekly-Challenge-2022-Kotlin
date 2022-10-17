package com.mouredev.weeklychallenge2022

import java.lang.Math.round
import kotlin.math.roundToInt

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

private fun printLine(line: MutableList<Int>, tab: Int) {
    (0 until tab * 2 + (line.size / 2.0).roundToInt()).forEach { _ -> print(" ") }
    line.forEachIndexed { index, i ->
        if(index == line.size - 1) {
            println(i)
        } else {
            print("$i${if(i<10 && line[index+1]<10) "  " else " "}")
        }
    }
}

private fun drawPascalTriangle(side: Int) {
    var previousLine = mutableListOf(1)
    (1 until side).forEach { row ->
        var currentLine = mutableListOf(1)
        printLine(previousLine, side - row)
        (1 until row).forEach { column ->
            currentLine.add(previousLine[column-1] + previousLine[column])
        }
        currentLine.add(1)
        previousLine = currentLine
    }
    printLine(previousLine, 0)
}

fun main() {
    drawPascalTriangle(9)
}



