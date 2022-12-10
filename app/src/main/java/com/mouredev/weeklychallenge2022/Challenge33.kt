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
 */

fun main(){
    toChineseYear(1924)
    toChineseYear(1982)
    toChineseYear(1936)
    toChineseYear(1963)
    toChineseYear(1959)
}

fun toChineseYear(year : Int) {

    val elements = arrayOf("madera", "fuego", "tierra", "metal", "agua")

    val animals = arrayOf("rata", "buey", "tigre", "conejo", "dragón", "serpiente", "caballo", "oveja",
                          "mono", "gallo", "perro", "cerdo")

    //Material
    //Los materiales se repiten cada 10 años
    when (year.toString().last()) {
        '0', '1' -> print("metal")
        '2', '3' -> print("agua")
        '4', '5' -> print("madera")
        '6', '7' -> print("fuego")
        else -> {
            print("tierra")
        }
    }

    //Animal
    //Los animales se repiten en ciclos de 12 años desde 1924
    var cycleCounter = 0
    for (i in 1924 .. year){
        cycleCounter++

        if (cycleCounter == 13){
            cycleCounter = 1
        }
    }
    println(" " + animals[cycleCounter-1])
}



