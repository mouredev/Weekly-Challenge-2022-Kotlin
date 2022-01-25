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
fun main() {
    area(2) //cuadrado
    area(2,3,4,5) // debe sacar mensaje de error
    area(2,4) // rectangulo
    area(2,3,4) // triangulo
}

private fun area (vararg polygon: Int) {
    // Implementanción rapida. No verifica que se le pase que un lado o la altura sea 0
    when{
        polygon.size == 1 -> {
            print("El área del cuadrado pasado es: ")
            println(polygon[0]*polygon[0])
        }
        polygon.size == 2 -> {
            print("El área del rectangulo pasado es: ")
            println(polygon[0]*polygon[1])
        }
        polygon.size == 3 -> {
            print("El área del triangulo pasado es: ")
            println((polygon[0]*polygon[1])/2)
        }
        else -> println("No has pasado un poligono correcto")
    }
}
