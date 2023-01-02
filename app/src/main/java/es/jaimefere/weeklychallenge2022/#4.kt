package es.jaimefere.weeklychallenge2022

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
    println(Polygon(true,4.0).getArea())
    println(Polygon(true, 7.0, 4.0).getArea())
    println(Polygon(false, 3.0, 4.0, 5.0).getArea())
    println(Polygon(false, 3.0, 4.0).getArea())     // isosceles
    println(Polygon(false, 3.0).getArea())      // equilateral
}

class Polygon(
    private val hasFourVertices: Boolean,
    private val sideA: Double,
    private var sideB: Double = 0.0,
    private var sideC: Double = 0.0
) {
    fun getArea(): Double {
        return if(hasFourVertices) {
            if(sideB == 0.0) {  // square
                sideB = sideA
            }
            sideA * sideB
        } else {
            if(sideB == 0.0) {  // equilateral
                sideB = sideA
            }
            if(sideC == 0.0) {  // isosceles
                sideC = sideB
            }
            val semiperimeter = (sideA + sideB + sideC) / 2.0
            Math.sqrt(semiperimeter * (semiperimeter - sideA) * (semiperimeter - sideB) * (semiperimeter - sideC))
        }
    }
}


