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
enum class Direction(val value: Int) {
    NORTH(0), WEST(1), SOUTH(2), EAST(3)
}

fun nextDirection(direction: Direction): Direction {
    return if (direction == Direction.EAST) Direction.NORTH else Direction.values()[direction.value + 1]
}

fun calculateCoordinates(movements: Array<Int>): Pair<Int, Int> {
    var x = 0
    var y = 0

    var direction = Direction.NORTH

    movements.forEach { movement ->
        when (direction) {
            Direction.NORTH -> y += movement
            Direction.WEST -> x -= movement
            Direction.SOUTH -> y -= movement
            Direction.EAST -> x += movement
        }

        direction = nextDirection(direction)
    }

    return Pair(x, y)
}


fun testCase(movements: Array<Int>, expectedX: Int, expectedY: Int) {
    val coordinate = calculateCoordinates(movements)
    val movementsInList = movements.toList()

    if (coordinate.first != expectedX) {
        throw Exception(
            "Case with coordinate '${movementsInList}', returns ${coordinate.first} but it should be $expectedX"
        )
    } else if (coordinate.second != expectedY) {
        throw Exception(
            "Case with blocks '${movementsInList}', returns ${coordinate.second} but it should be $expectedY"
        )
    }
    println("Moovements '${movementsInList}', coodinates '${coordinate}'")
}

fun main() {
    testCase(arrayOf(10, 5, -2), expectedX = -5, expectedY = 12)
    testCase(arrayOf(0, 5, -2, 6, 5, -4), expectedX = 5, expectedY = 7)
    testCase(arrayOf(), expectedX = 0, expectedY = 0)
    testCase(arrayOf(10), expectedX = 0, expectedY = 10)
    testCase(arrayOf(10, 10), expectedX = -10, expectedY = 10)
    testCase(arrayOf(3, -2, 4, 6, 9, 2, 1, 2, 3, 4), expectedX = 4, expectedY = 10)
}