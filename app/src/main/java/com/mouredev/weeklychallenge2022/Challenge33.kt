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
    println(chineseZodiac(4))
    println(chineseZodiac(0))
    println(chineseZodiac(1))
    println(chineseZodiac(2022))
    println(chineseZodiac(1987))
    println(chineseZodiac(1986))
}

private fun chineseZodiac(year: Int): String {
    if(year <= 0) {
        return "Introduce un año mayor que 0"
    }
    val pos = if (year >= 4) {
        if ((year - 3) % 60 > 0) ((year - 3) % 60) - 1 else 46
    } else {
        (56 + year)
    }
    return "$year: " + getSignElement(pos)
}

private fun getSignElement(pos: Int) : String {
    val sodiacSigns = arrayOf("Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente", "Caballo", "Oveja", "Mono", "Gallo", "Perro", "Cerdo")
    val elements = arrayOf("Madera", "Fuego", "Tierra", "Metal", "Agua")
    val sodiacSign = sodiacSigns[pos % 12]
    val elementPos = (pos % 10) / 2
    val element = elements[elementPos]
    return "$element $sodiacSign"
}
