package com.mouredev.weeklychallenge2022

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar
 * el área de un polígono.
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

fun main() {
    val area = Poligono()
    area.triangulo(2.0, 3.0)
    area.cuadrado(2.0)
    area.rectangulo(2.0, 3.0)
}

class Poligono(){
    fun triangulo(base: Double, altura: Double){
        println("El área del triangulo es: ${base*altura/2}")
    }
    fun cuadrado(lado: Double){
        println("El área del cuadrado es: ${lado*lado}")
    }
    fun rectangulo(base: Double, altura: Double){
        println("El área del rectangulo es: ${base*altura}")
    }
}