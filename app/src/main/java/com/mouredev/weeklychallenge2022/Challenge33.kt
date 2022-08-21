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


/**
 * Enumerado que representa los elementos del ciclo sexagenario chino.
 */

enum class Element(val element:String) {
    FIRE("Fuego"),
    WOOD("Madera"),
    EARTH("Tierra"),
    METAL("Metal"),
    WATER("Agua"),
}

/**
 * Enumerado que representa los animales del ciclo sexagenario chino.
 */
enum class Animal(val animal: String){
    RAT("Rata"),
    BULL("Buey"),
    TIGER("Tigre"),
    RABBIT("Conejo"),
    DRAGON("Dragón"),
    SNAKE("Serpiente"),
    HORSE("Caballo"),
    SHEEP("Oveja"),
    MONKEY("Mono"),
    ROOSTER("Gallo"),
    PIG("Cerdo"),
    DOG("Perro")
}

/**
 * Funcion principal
 */
fun main(){

    println(sexagenarianYear(1984))
    println(sexagenarianYear(2011))
    println(sexagenarianYear(2018))
}

/**
 * Funcion que devuelve el elemento y animal correspondiente a un año dado ,de un ciclo sexagenario
 * @param year año del ciclo sexagenario
 * @return elemento y animal correspondiente al año dado
 */

fun sexagenarianYear(year: Int): String{

    val elements = mapOf(
        0 to Element.WOOD,
        1 to Element.WOOD,
        2 to Element.FIRE,
        3 to Element.FIRE,
        4 to Element.EARTH,
        5 to Element.EARTH,
        6 to Element.METAL,
        7 to Element.METAL,
        8 to Element.WATER,
        9 to Element.WATER)



    val animals = mapOf(
        0 to Animal.RAT,
        1 to Animal.BULL,
        2 to Animal.TIGER,
        3 to Animal.RABBIT,
        4 to Animal.DRAGON,
        5 to Animal.SNAKE,
        6 to Animal.HORSE,
        7 to Animal.SHEEP,
        8 to Animal.MONKEY,
        9 to Animal.ROOSTER,
        10 to Animal.DOG,
        11 to Animal.PIG)


    val yearElement = elements[(year-1984)% elements.size]
    val animalElement = animals[(year-1984)% animals.size]


    return "$year ${yearElement?.element} ${animalElement?.animal}"







}