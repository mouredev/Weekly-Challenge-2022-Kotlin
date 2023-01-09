package com.mouredev.weeklychallenge2022

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val nada: Array<Int> = arrayOf()
    val cuadrado: Array<Int> = arrayOf(2)
    val rectangulo: Array<Int> = arrayOf(4, 2)
    val triangulo: Array<Int> = arrayOf(3, 4, 5)
    val pentagono: Array<Int> = arrayOf(3, 4, 5, 6, 7)
    calculateArea(nada)
    calculateArea(cuadrado)
    calculateArea(rectangulo)
    calculateArea(triangulo)
    calculateArea(pentagono)
}

fun calculateArea(sides: Array<Int>) {
    when (sides.size) {
        0 -> println("Error, no hay figura")
        1 -> println("El area del cuadrado es: " + (sides[0] * sides[0]))
        2 -> println("El area del rectangulo es: " + (sides[0] * sides[1]))
        3 -> {
            val s = (sides[0] + sides[1] + sides[2]) / 2
            val area = Math.sqrt((s * (s - sides[0]) * (s - sides[1]) * (s - sides[2])).toDouble())
            println("El area del triangulo es: " + area)
        }
        else -> println("El calculo de ese poligono no esta contemplado")
    }
}

