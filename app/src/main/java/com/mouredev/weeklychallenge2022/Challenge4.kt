package com.mouredev.weeklychallenge2022

import java.util.*

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

fun main() {
    initApp()
}

fun calculatePolygon(polygon : Int) {
    when (polygon){
        1 -> {
            println("Calcularemos el área del triángulo.")
            println("Introduce la base")
            val base = readLine().toString().toDoubleOrNull()
            println("Introduce la altura")
            val height = readLine().toString().toDoubleOrNull()
            if(base != null && height != null){
                println("El área del triángulo es ${(base * height)/2}")
                println("--------------------------------")
                initApp()
            } else calculatePolygon(1)
        }
        2 -> {
            println("Calcularemos el área del cuadrado.")
            println("Introduce el lado")
            val side = readLine().toString().toDoubleOrNull()
            if (side != null){
                println("El área del cuadrado es ${side * side}")
                println("--------------------------------")
                initApp()
            }else calculatePolygon(2)
        }
        3 -> {
            println("Calcularemos el área del rectángulo.")
            println("Introduce la base")
            val base = readLine().toString().toDoubleOrNull()
            println("Introduce la altura")
            val height = readLine().toString().toDoubleOrNull()
            if(base != null && height != null){
                println("El área del rectángulo es ${base*height}")
                println("--------------------------------")
                initApp()
            } else calculatePolygon(3)
        }
    }
}

fun initApp(){
    println("De qué polígono quieres calcular el área?")
    println("Triangulo")
    println("Cuadrado")
    println("Rectangulo")

    when (readLine().toString().lowercase()){
        "triangulo" -> calculatePolygon(1)
        "cuadrado" -> calculatePolygon(2)
        "rectangulo" -> calculatePolygon(3)
        else -> {
            println("Por favor, introduce un polígono válido.")
            initApp()
        }
    }
}


