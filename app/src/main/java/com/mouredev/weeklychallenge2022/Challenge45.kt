package com.mouredev.weeklychallenge2022

import java.util.ArrayDeque
import kotlin.math.max

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



 fun getTotalWater(blocks: Array<Int>): Int {
    var result = 0
    val deque = ArrayDeque<Int>()
    for (currentBlocks in blocks) {
        while(!deque.isEmpty() && deque.first() <= currentBlocks) {
            result += deque.first() - deque.removeLast()
        }
        deque.addLast(currentBlocks)
    }
    if (deque.size > 1) {
        // don't panic! this recursion should happen at most one time
        result += getTotalWater(deque.reversed().toTypedArray())
    }
    return result
 }

 fun testCase(blocksCase: Array<Int>, expectedValue: Int) {
    val valueReturned = getTotalWater(blocksCase)

    if (valueReturned != expectedValue) {
        val blockString = blocksCase.joinToString()
        throw Exception("Case with blocks [$blockString], returns $valueReturned but it should be $expectedValue")
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

    // stress tests

    testCase(Array<Int>(1000000, {i -> i + 1}), 0)
    testCase(Array<Int>(1000001, {i -> 1 - i % 2}), 500000)
    testCase(Array<Int>(1000000, {i -> i % 10}), 4499955)

    println("All cases passed!")
 }
