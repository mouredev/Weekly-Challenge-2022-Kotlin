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

/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

fun main() {
    println(Triangle(10.0, 10.0).getArea())
    println(Square(10.0).getArea())
    println(Rectangle(5.0, 10.0).getArea())
}

abstract class Polygon {
    val side: Double
    val height: Double
    constructor(side: Double, height: Double) {
        this.side = side
        this.height = height
    }
    abstract fun getArea() :Double
}

class Triangle(side: Double, height: Double): Polygon(side, height) {
	override fun getArea() :Double {
        return super.side * super.height / 2.0
    }
}

class Square(side: Double): Polygon(side, side) {
    override fun getArea() :Double {
        return super.side * super.height
    }
}

class Rectangle(side: Double, height: Double): Polygon(side, height) {
	override fun getArea() :Double {
        return super.side * super.height
    }
}
