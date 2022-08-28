package es.jaimefere.weeklychallenge2022

import kotlin.math.abs

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

private enum class Animal {
    RAT, OX, TIGER, RABBIT, DRAGON, SNAKE, HORSE, SHEEP, MONKEY, ROASTER, DOG, PIG
}

private enum class Element {
    WOOD, FIRE, EARTH, METAL, WATER
}

private fun getAnimalBy(sexagenarianCycleIndex: Int): Animal {
    return Animal.values().first{ it.ordinal == (sexagenarianCycleIndex % Animal.values().size) }!!
}

private fun getElementBy(sexagenarianCycleIndex: Int): Element {
    return Element.values().first{ (it.ordinal * 2) == (sexagenarianCycleIndex % (Element.values().size * 2)) || (it.ordinal * 2 + 1) == (sexagenarianCycleIndex % (Element.values().size * 2))}!!
}

private fun getChineseZodiacSymbolsBy(year: Int): String {
    if(year < 604) {
        return "El zodiaco chino comenzó más tarde, en el año 604 d.c."
    }
    val sexagenarianCycleIndex = year - 604
    return "Para el año $year el animal es ${getAnimalBy(sexagenarianCycleIndex)} y el elemento es ${getElementBy(sexagenarianCycleIndex)}"
}

fun main() {
    println(getChineseZodiacSymbolsBy(603))
    println(getChineseZodiacSymbolsBy(1924))
    println(getChineseZodiacSymbolsBy(1940))
    println(getChineseZodiacSymbolsBy(1969))
    println(getChineseZodiacSymbolsBy(1983))
}