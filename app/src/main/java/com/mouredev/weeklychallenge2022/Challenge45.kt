package com.mouredev.weeklychallenge2022

/*
 * Reto #45
 * CONTENEDOR DE AGUA
 * Fecha publicación enunciado: 07/10/22
 * Fecha publicación resolución: 14/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Dado un array de números enteros positivos, donde cada uno representa unidades
 * de bloques apilados, debemos calcular cuantas unidades de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *        ⏹
 *        ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
 *   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
 *
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

private fun getWaterUnits(input: Array<Int>, draw: Boolean = true): Int {
    var result = 0
    val numRows = input.maxOrNull() ?: 0
    (0 until numRows).forEach{ row ->
        var line = ""
        var previousBlockColumn = -1
        input.indices.forEach { column ->
                if(numRows-row <= input[column]) {
                    (previousBlockColumn+1 until column).forEach { _ ->
                            if(previousBlockColumn == -1) {
                                line += "➖"
                            } else {
                                line += "💧"
                                result += 1
                            }
                    }
                    line += ("⏹")
                    previousBlockColumn = column
                }
        }
        (line.replace("\uD83D","").length until input.size).forEach { _ ->
            line += "➖"
        }
        if(draw) {
            println(line)
        }
    }
    return result
}

fun main() {
    println(getWaterUnits(arrayOf()))
    println(getWaterUnits(arrayOf(1, 2, 3, 3, 2, 1)))
    println(getWaterUnits(arrayOf(4, 3, 1, 1, 3, 4)))
    println(getWaterUnits(arrayOf(4, 0, 3, 6, 1, 3)))
}


