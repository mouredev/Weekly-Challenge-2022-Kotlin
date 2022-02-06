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
 * - Retos obtenidos de https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
 *
 */

fun main() {
    println("Area del triangulo: " + area(Triangulo(4.0, 2.0)))
    println("Area del cuadrado: " + area(Cuadrado(4.0)))
    println("Area del rectangulo: " + area(Rectangulo(4.0, 2.0)))
}

interface poligono{

}

data class Triangulo(val base : Double, val altura : Double) : poligono{

}

data class Cuadrado(val base : Double) : poligono{

}

data class Rectangulo(val ancho : Double, val largo : Double) : poligono{

}

fun area(poligono: poligono) : Double{
    when (poligono) {
        is Triangulo -> {
            return (poligono.base*poligono.altura) / 2
        }
        is Cuadrado -> {
            return poligono.base*poligono.base
        }
        is Rectangulo -> {
            return poligono.ancho*poligono.largo
        }
        else -> return 0.0
    }
}