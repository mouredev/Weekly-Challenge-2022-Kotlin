package com.mouredev.weeklychallenge2022

import java.util.ArrayDeque

/*
 * Reto #45
 * CONTENEDOR DE AGUA
 * Fecha publicación enunciado: 07/10/22
 * Fecha publicación resolución: 14/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Dado un array de números enteros positivos, donde cada uno representa unidades
 * de bloques apilados, debemos calcular cuantas unidades de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *        ⏹
 *        ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
 *   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
 *
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


fun getTotalWater(blocks: Array<Int>): Long {
    var (result, remaining) = countWaterLR(blocks)
    if (remaining.size > 2) {
        /**
         * El resto de bloques podrian contener agua, ejecutamos countWaterLR sobre el resto de
         * forma inversa para contarlos
         */ 
        result += countWaterLR(remaining.reversed().toTypedArray()).first
    }
    return result
}

/**
 * Cuenta el agua de izquierda a derecha, complejidad O(n):
 * - Si se encuentra bloques apilados que son almenos igual de altos que todas ateriores, entonces
 *   se cuenta toda el agua contenida hasta ese momento
 * - Al final se retorna lo contado y los bloques apilados que no cumplieron la condicion anterior
 */
fun countWaterLR(blocks: Array<Int>): Pair<Long, Array<Int>> {
    var count: Long = 0
    val deque = ArrayDeque<Int>()
    for (currentBlocks in blocks) {
        while(!deque.isEmpty() && deque.first() <= currentBlocks) {
            count += deque.first() - deque.removeLast()
        }
        deque.addLast(currentBlocks)
    }
    return Pair(count, deque.toTypedArray())
}

fun testCase(blocks: Array<Int>, expected: Long) {
    checkValidTestCase(blocks)
    val returned = getTotalWater(blocks)
    if (returned != expected) {
        val blocksString = blocks.joinToString()
        throw Exception(
            "Case with blocks [$blocksString], returns $returned but it should be $expected"
        )
    }
}

fun checkValidTestCase(blocks: Array<Int>) {
    blocks.forEach {
        if (it < 0) {
            val blocksString = blocks.joinToString()
            throw Exception(
                "Case with [$blocksString] is invalid, it should contain only positive values"
            )
        }
    }
}

fun main() {
    /*
           #
           #
        #..#
        #.##.#
        #.##.#
        #.####
     */
    testCase(arrayOf(4, 0, 3, 6, 1, 3), 7)

    /*
          #
          #
          #..#
        #.##.#
        #.##.#
        ####.#
     */
    testCase(arrayOf(3, 1, 6, 3, 0, 4), 7)

    /*
        #...#
        ##..#
        ###.#
     */
    testCase(arrayOf(3, 2, 1, 0, 3), 6)

    /*
            #...#...#
          #.#...#.#.#
          #.#.#.#.#.#
        #.#.#.#.#.#.#.#
        #.#.#.#.#.#.#.#
     */
    testCase(arrayOf(2, 0, 4, 0, 5, 0, 3, 0, 5, 0, 4, 0, 5, 0, 2), 31)

    /*
        #.........#
        ##.......##
        ###.....###
        ####...####
        #####.#####
     */
    testCase(arrayOf(5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5), 25)

    /*
        
              #...#
         #...###.##.#
        ###.#######.##
     */
    testCase(arrayOf(1, 2, 1, 0, 1, 2, 3, 2, 1, 2, 3, 0, 2, 1), 10)

    /*
              #.#
          #...#.#
        #.#.#.#.#
        #########
     */
    testCase(arrayOf(2, 1, 3, 1, 2, 1, 4, 1, 4), 9)

    /*
              #..#
         #....#..#
         ##.#.#.##
        #####.#####
     */
    testCase(arrayOf(1, 3, 2, 1, 2, 0, 4, 1, 2, 4, 1), 12)

    /*
                    #
            #.....#.# 
        #...#..#..#.#.# 
        #.#.#.###.###.#.#.#
        #.###.###########.#
     */
    testCase(arrayOf(3, 0, 2, 1, 4, 0, 2, 3, 2, 1, 4, 2, 5, 1, 3, 1, 2, 0, 2), 25)

    /*
          #   
          ####
         ######
        #########
     */
    testCase(arrayOf(1, 2, 4, 3, 3, 3, 2, 1, 1), 0)

    /*
              
              #...#
            #.#...#.#
          #.#.#...#.#.#
        #.#.#.#.#.#.#.#.#
     */
    testCase(arrayOf(1, 0, 2, 0, 3, 0, 4, 0, 1, 0, 4, 0, 3, 0, 2, 0, 1), 23)

    /*
        #.........#
        #.#.....#.#
        #.#.#.#.#.#
        #.#.#.#.#.#
        #.###.###.#
     */
    testCase(arrayOf(5, 0, 4, 1, 3, 0, 3, 1, 4, 0, 5), 29)

    /*
            #.#
            #.#
          #.###.#
        #.#.###.#.#
        #.#######.#
     */
    testCase(arrayOf(2, 0, 3, 1, 5, 3, 5, 1, 3, 0, 2), 10)

    /*
        #####.#####
        ###########
        ###########
        ###########
        ###########
     */
    testCase(arrayOf(5, 5, 5, 5, 5, 4, 5, 5, 5, 5, 5), 1)

    /*
        #....#....#
        #....#....#
        #...###...#
        #..#####..#
        ###########
     */
    testCase(arrayOf(5, 1, 1, 2, 3, 5, 3, 2, 1, 1, 5), 26)

    // Casos extremos, para comprobar complejidad O(n)
    testCase(Array<Int>(1000000, {i -> i + 1}), 0)
    testCase(Array<Int>(1000001, {i -> i % 2}), 499999)
    testCase(Array<Int>(1000001, {i -> 1 - i % 2}), 500000)
    testCase(Array<Int>(1000000, {i -> i % 100000}), 44999550000)
    testCase(Array<Int>(1000000, {i -> 99999 - i % 100000}), 44999550000)
    testCase(Array<Int>(1000001, {i -> 1000000000 * (i % 2)}), 499999000000000)
    testCase(Array<Int>(1000001, {i -> 1000000000 * (1 - i % 2)}), 500000000000000)

    // Casos extra
    testCase(arrayOf(), 0)
    testCase(arrayOf(1), 0)
    testCase(arrayOf(1, 0), 0)
    testCase(arrayOf(0, 1), 0)
    testCase(arrayOf(1, 0, 1), 1)
    testCase(arrayOf(0, 1, 0), 0)

    println("All cases passed!")
}
