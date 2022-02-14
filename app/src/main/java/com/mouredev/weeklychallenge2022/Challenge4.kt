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
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

abstract class Polygon {
    open fun calculateArea() : Double {
        return 0.0
    }
}

class Triangle: Polygon() {
    private var base = 5.0
    private var height = 10.0

    override fun calculateArea() : Double {
        return base * height / 2
    }
}

class Square: Polygon() {
    private var side = 3.8

    override fun calculateArea(): Double {
        return side * side
    }
}

class Rectangle: Polygon() {
    private var width = 8.5
    private var height = 3

    override fun calculateArea(): Double {
        return width * height
    }
}

fun main() {
    println("Triangle area: ${Triangle().calculateArea()}")
    println("Square area: ${Square().calculateArea()}")
    println("Rectangle area: ${Rectangle().calculateArea()}")
}