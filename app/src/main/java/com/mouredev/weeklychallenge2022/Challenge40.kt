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
    print("Ingrese el tamaño del lado: ")
    val side = readln().toInt()
    PascalTriangle(side)
}

private fun PascalTriangle(rows: Int){
    var coef = 1
    for (i in 0..rows - 1) {

        for (space in 1..rows - i - 1) {
            print("  ")
        }

        for (j in 0..i) {
            if (j == 0 || i == 0)
                coef = 1
            else
                coef = coef * (i - j + 1) / j

            System.out.printf("%4d", coef)
        }

        println()
    }
}

