package com.mouredev.weeklychallenge2022

/*
 * Reto #46
 * ¿DÓNDE ESTÁ EL ROBOT?
 * Fecha publicación enunciado: 14/10/22
 * Fecha publicación resolución: 21/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Calcula dónde estará un robot (sus coordenadas finales) que se encuentra en una cudrícula
 * representada por los ejes "x" e "y".
 * - El robot comienza en la coordenada (0, 0).
 * - Para idicarle que se mueva, le enviamos un array formado por enteros (positivos o negativos)
 *   que indican la secuencia de pasos a dar.
 *  - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene, luego 5, se detiene,
 *    y finalmente 2. El resultado en este caso sería (x: -5, y: 12)
 * - Si el número de pasos es negativo, se desplazaría en sentido contrario al que está mirando.
 * - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando hacia la parte
 *   positiva del eje "y".
 * - El robot tiene un fallo en su programación: cada vez que finaliza una secuencia de pasos gira
 *   90 grados en el sentido contrario a las agujas del reloj.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


fun main() {
    println(wheresMyRobot(arrayOf(10, 5, -2)))
    println(wheresMyRobot(arrayOf(1, 1, 1, 1)))
    println(wheresMyRobot(arrayOf(-5, 5, -5, 5)))
    println(wheresMyRobot(arrayOf(0, 0, 0, 0, 1, -1)))
    println(wheresMyRobot(arrayOf(1, 1)))
    println(wheresMyRobot(arrayOf()))
}

enum class RobotDirection {
    Y_POSITIVE,
    X_NEGATIVE,
    Y_NEGATIVE,
    X_POSITIVE;
}

private fun wheresMyRobot(moves: Array<Int>): String {
    // robotPosition[0] --> X axis
    // robotPosition[1] --> Y axis
    val robotPosition = arrayOf(0, 0)
    var direction = RobotDirection.Y_POSITIVE

    moves.forEach { move ->
        when (direction) {
            RobotDirection.Y_POSITIVE -> {
                robotPosition[1] += move
                direction = RobotDirection.X_NEGATIVE
            }
            RobotDirection.X_NEGATIVE -> {
                robotPosition[0] -= move
                direction = RobotDirection.Y_NEGATIVE
            }
            RobotDirection.Y_NEGATIVE -> {
                robotPosition[1] -= move
                direction = RobotDirection.X_POSITIVE
            }
            RobotDirection.X_POSITIVE -> {
                robotPosition[0] += move
                direction = RobotDirection.Y_POSITIVE
            }
        }
    }
    return robotPosition.formatResult()
}

private fun Array<Int>.formatResult(): String = "(x: ${this[0]}, y: ${this[1]})"