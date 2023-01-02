package com.openai.chat

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN en Kotlin (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 * Resuelto: Sí.
 * Iteracciones: 2
 * Explicación: La función calcularAreaPoligono() recibe un objeto cualquiera y, usando el operador when, determina el tipo de polígono que se ha pasado como parámetro. Si el polígono es un triángulo, un cuadrado o un rectángulo,
 * se calcula y se retorna su área. En caso contrario, se retorna 0.0.
 * Conversación:
 * - Vale, ¿cómo sería la definición de las clases de los polígonos?
 *
 */

// Clase base para polígonos
abstract class Poligono {
    abstract fun calcularArea(): Double
}

// Clase para triángulos
class Triangulo(val base: Double, val altura: Double): Poligono() {
    override fun calcularArea(): Double {
        return (base * altura) / 2
    }
}

// Clase para cuadrados
class Cuadrado(val lado: Double): Poligono() {
    override fun calcularArea(): Double {
        return lado * lado
    }
}

// Clase para rectángulos
class Rectangulo(val base: Double, val altura: Double): Poligono() {
    override fun calcularArea(): Double {
        return base * altura
    }
}

fun main() {
    val triangulo = Triangulo(5.0, 7.0)
    val cuadrado = Cuadrado(5.0)
    val rectangulo = Rectangulo(5.0, 7.0)

    println(triangulo.calcularArea())  // Imprime 17.5
    println(cuadrado.calcularArea())   // Imprime 25.0
    println(rectangulo.calcularArea()) // Imprime 35.0
}