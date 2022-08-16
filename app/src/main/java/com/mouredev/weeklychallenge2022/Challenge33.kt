package com.mouredev.weeklychallenge2022

import androidx.core.graphics.rotationMatrix


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


fun main(){


    val year  = 2016

    print(getChineseZodiacSign(year))
}




enum class Elements{

    WOOD,
    FIRE,
    EARTH,
    METAL,
    WATER
}

enum class ZodiacSign{

    RAT,
    OX,
    TIGER,
    RABBIT,
    DRAGON,
    SNAKE,
    HORSE,
    SHEEP,
    MONKEY,
    ROOSTER,
    DOG,
    PIG
}


fun getChineseZodiacSign(year:Int):Pair<ZodiacSign,Elements>{


    val lastYearStartOn = 1984

    var calculateYearFrom = kotlin.math.abs(  year-lastYearStartOn)

    if(calculateYearFrom==60 || calculateYearFrom==0){
        return Pair(ZodiacSign.RAT,Elements.WOOD)
    }
    if(year<lastYearStartOn){
        calculateYearFrom=  kotlin.math.abs(calculateYearFrom-60)
    }

    if(calculateYearFrom>60){
        calculateYearFrom %= 60
    }

    var calculateZodiacSign = calculateYearFrom%12
    val zodiacSign = ZodiacSign.values()[calculateZodiacSign]
    val calculateElemet = (calculateYearFrom%10)/2
    val element =if(calculateElemet>=0) Elements.values()[calculateElemet] else Elements.values()[4]

    return Pair(zodiacSign,element)
}