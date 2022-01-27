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

fun main(){
    val dataInput = arrayOf<String>("triangulo", "cuadrado", "rectangulo")
    var base = 10
    var height = 2

    dataInput.forEach{
        println("Area de $it con base $base y altura $height es: ${calculateArea(it, base, height)}")
    } 
}

private fun calculateArea(polygon: String, base: Int, height:Int): Int {
    var area = 0
    when(polygon){
        "triangulo"  -> area=(base*height)/2 
        "cuadrado"   -> area=base*base //para el cuadrado solo se tendra en cuenta uno de los lados, en este caso la base
        "rectangulo" -> area=base*height
    }
    return area
}
