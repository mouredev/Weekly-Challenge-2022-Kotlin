package com.mouredev.weeklychallenge2022

/*
 * Reto #33
 * CICLO SEXAGENARIO CHINO
 * Fecha publicación enunciado: 15/08/22
 * Fecha publicación resolución: 22/08/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
 * en el ciclo sexagenario del zodíaco chino.
 * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
 *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
 *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

private var ARRAY_ANIMAL = arrayOf("rata", "buey", "tigre", "conejo", "dragón", "serpiente",
    "caballo", "oveja", "mono", "gallo", "perro", "cerdo")

private var ARRAY_ELEMENT = arrayOf("madera", "fuego", "tierra", "metal", "agua")

fun main() {
    val year = 1984
    println("${calculateElement(year)} ${calculateAnimal(year)}")
}

private fun calculateAnimal(year: Int): String {
    val num = year - 1804
    var aux: Int
    if (num >= 0) {
        aux = num
        if(num >= 12) {
            aux = num % 12
        }
    } else {
        aux = 0
    }
    return ARRAY_ANIMAL[aux]
}

private fun calculateElement(year: Int): String {
    val num = year - 1804
    var aux = 0
    if(num >= 0) {
        if(num >= 5){
            aux = num % 10
        }
    } else {
        aux = 0
    }
    when(aux) {
        0,1 -> aux = 0
        2,3 -> aux = 1
        4,5 -> aux = 2
        6,7 -> aux = 3
        8,9 -> aux = 4
    }

    return ARRAY_ELEMENT[aux]
}