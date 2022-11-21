package com.mouredev.weeklychallenge2022

import kotlin.math.abs

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



/**
 * Función principal
 */
fun main(){
    val robot = Robot()
    robot.move(arrayOf(10, 5, -2))
    robot.printPosition()
    robot.printRoute()
    robot.reset()
}


/**
 * Clase que representa un robot
 * Cada robot tiene las coordenadas (x, y) en las que se encuentra
 * y un array de pasos que debe dar.
 * Tambien tiene un atributo que indica la direccion en la que mira
 */
class Robot {

    enum class Direction {
        UP,
        LEFT,
        DOWN,
        RIGHT
    }

    private var x = 0
    private var y = 0
    private var direction = Direction.UP
    private var route:String = ""

    /**
     * Metodo que mueve al robot segun los pasos indicados en el array
     * @param steps Array de pasos a dar
     * en cada coordenadada de pasos el robot gira 90 grados hacia la izquierda
     */
    fun move(steps: Array<Int>) {
        steps.forEach { step ->
            when (direction) {
                Direction.UP ->{
                    route += if(step>0){
                        "🡹".repeat(abs(step))
                    } else{
                        "🡻".repeat(abs(step))
                    }
                    y += step
                }

                Direction.RIGHT -> {
                    route += if(step>0){
                        "🡺".repeat(abs(step))
                    } else{
                        "🡸".repeat(abs(step))
                    }
                    x += step
                }
                Direction.DOWN -> {
                    route += if(step>0){
                        "🡻".repeat(abs(step))
                    } else{
                        "🡹".repeat(abs(step))
                    }
                    y -= step
                }
                Direction.LEFT ->{
                    route += if(step>0){
                        "🡸".repeat(abs(step))
                    } else{
                        "🡺".repeat(abs(step))
                    }
                    x -= step

                }
            }
            turn()
        }

    }

    /**
     * Funcion que realiza el giro del robot
     * cada vez que se mueve el robot gira 90 grados hacia la izquierda
     */
    private fun turn() {
        direction = when (direction) {
            Direction.UP -> Direction.LEFT
            Direction.LEFT -> Direction.DOWN
            Direction.DOWN -> Direction.RIGHT
            Direction.RIGHT -> Direction.UP
        }
    }
    /**
     * Funcion que resetea al robot y lo devuelve a las coordenadas iniciales
     */
    fun reset(){
        x = 0
        y = 0
        direction = Direction.UP
        route = ""
    }
    /**
     * Pinta la ruta seguida actual por el robot.
     */

    fun printRoute(){
        println(route)
    }
    /**
     * Devuelve las coordenadas actuales del robot
     */
    fun printPosition(){
        println("x: $x, y: $y")
    }

    fun coordenates(): Pair<Int, Int> {
        return Pair(x, y)
    }
}
