package com.mouredev.weeklychallenge2022

import kotlin.math.sqrt;

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
    println(PolygonType.Triangle.loadSides(4.0, 5.0, 7.0).getArea())
    println(PolygonType.Square.loadSides(10.0).getArea())
    println(PolygonType.Rectangle.loadSides(5.0, 10.0).getArea())
    println(Triangle(4.0, 5.0, 7.0).getArea())
    println(Square(10.0).getArea())
    println(Rectangle(5.0, 10.0).getArea())
}

enum class PolygonType {
    Triangle,
    Square,
    Rectangle;
    private var sides: DoubleArray = doubleArrayOf()
    fun loadSides(vararg sides: Double) : PolygonType {
        this.sides = sides
        return this
    }
    fun getArea() :Double {
        when(this){
            Triangle -> {
                assert(this.sides.size == 3);
                val semiperimetro = ( this.sides[0] + this.sides[1] + this.sides[2] ) / 2.0
               	return sqrt(semiperimetro * (semiperimetro - this.sides[0]) * (semiperimetro - this.sides[1]) * (semiperimetro - this.sides[2]))
            }
            Square -> {
                assert(this.sides.size == 1);
                return this.sides[0] * this.sides[0];
            }
            Rectangle -> {
                assert(this.sides.size == 2);
                return this.sides[0] * this.sides[1]
            }
        }
    }
}

abstract class Polygon {
    var sides: DoubleArray = doubleArrayOf()
    constructor(vararg sides: Double) {
        this.sides = sides
    }
    abstract fun getArea() :Double
}

class Triangle(side1: Double, side2: Double, side3: Double): Polygon(side1, side2, side3) {
	override fun getArea() :Double {
        val semiperimetro = ( this.sides[0] + this.sides[1] + this.sides[2] ) / 2.0
        return sqrt(semiperimetro * (semiperimetro - this.sides[0]) * (semiperimetro - this.sides[1]) * (semiperimetro - this.sides[2]))
    }
}

class Square(side: Double): Polygon(side) {
    override fun getArea() :Double {
        return this.sides[0] * this.sides[0];
    }
}

class Rectangle(side1: Double, side2: Double): Polygon(side1, side2) {
	override fun getArea() :Double {
        return this.sides[0] * this.sides[1]
    }
}
