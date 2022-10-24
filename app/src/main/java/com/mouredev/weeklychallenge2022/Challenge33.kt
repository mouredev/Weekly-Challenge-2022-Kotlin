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

fun main() {
    println(chineseZodiac(1924))
    println(chineseZodiac(1946))
    println(chineseZodiac(1984))
    println(chineseZodiac(604))
    println(chineseZodiac(603))
    println(chineseZodiac(1987))
    println(chineseZodiac(2022))
}

private fun chineseZodiac(year: Int) : String {

    val elements = arrayListOf("madera", "fuego", "tierra", "metal", "agua")
    val animals = arrayListOf("rata", "buey", "tigre", "conejo", "dragón", "serpiente", "caballo", "oveja", "mono", "gallo", "perro", "cerdo")

    if (year < 604) {
        return "El ciclo sexagenario comenzó en el año 604."
    }

    val sexagenaryYear = (year - 4) % 60
    val element = elements[(sexagenaryYear % 10) / 2]
    val animal = animals[sexagenaryYear % 12]

    return "$year: $element $animal"
}