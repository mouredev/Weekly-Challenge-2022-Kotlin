package com.mouredev.weeklychallenge2022

/*
 * Reto #27
 * VECTORES ORTOGONALES
 * Fecha publicación enunciado: 07/07/22
 * Fecha publicación resolución: 11/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que determine si dos vectores son ortogonales.
 * - Los dos array deben tener la misma longitud.
 * - Cada vector se podría representar como un array. Ejemplo: [1, -2]
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

/**
 * Clase que representa un vector de coordenadas cartesianas.
 * @param coordinates Coordenada x del vector.
 */
data class Vector(val coordinates:Array<Int>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vector

        if (!coordinates.contentEquals(other.coordinates)) return false

        return true
    }

    override fun hashCode(): Int {
        return coordinates.contentHashCode()
    }
    fun size():Int = coordinates.size

}

fun main(){

    println(areOrthogonal(Vector(arrayOf(1,2)), Vector(arrayOf(-2,1))))
}

/**
 * Metodo que determina si dos vectores son ortogonales.
 * Dos vectores U y V son ortongales cuando se encuentra de manera perpendicular  * entre sí y forman un ángulo de 90° (π/2).
 * Para determinar si son ortongales se comprueba si su producto escalar es 0.
 * @param v1 Vector 1.
 * @param v2 Vector 2.
 * @return True si los vectores son ortogonales, false en caso contrario.
 */
private fun areOrthogonal(v1: Vector, v2: Vector): Boolean {

    if(v1.size() != v2.size()) return false

    var sum = 0
    for(i in 0 until v1.size()){
        sum += v1.coordinates[i] * v2.coordinates[i]
    }

    return sum == 0
}

