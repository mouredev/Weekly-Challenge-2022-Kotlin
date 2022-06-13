package com.mouredev.weeklychallenge2022

import kotlin.math.pow

/*
 * Reto #23
 * MÁXIMO COMÚN DIVISOR Y MÍNIMO COMÚN MÚLTIPLO
 * Fecha publicación enunciado: 07/06/22
 * Fecha publicación resolución: 13/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea dos funciones, una que calcule el máximo común divisor (MCD) y otra que calcule el mínimo común múltiplo (mcm) de dos números enteros.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    try {
        println("MCD: ${mcd(3, 21)} - MCM: ${mcm(3, 26)}")
        println("MCD: ${mcd(2, 16)} - MCM: ${mcm(12, 8)}")
    } catch (e: WrongParameterException) {
        println(e.message)
    }
}

private fun mcd(num1: Int, num2: Int): Int {
    // If any of both numbers is 0, the MCD is 0
    if (num1 == 0 || num2 == 0) {
        return 0
    }

    // Get prime factorization of each number
    val alMaps = primeFactorization(arrayListOf(num1, num2))

    // Get the matching prime numbers of each number
    val matchingKeys = hashMapOf<Int, Int>()
    for ((k, v) in alMaps[0]) {
        // If the prime number does match, get the one with the lowest exponential
        if (alMaps[1].contains(k)) {
            matchingKeys[k] = if (alMaps[0][k]!! < alMaps[1][k]!!) {
                v
            } else {
                alMaps[1][k]!!
            }
        }
    }

    // Finally return the bigger matching prime (key) to the power exponent (value)
    return matchingKeys.keys.maxOrNull()!!.toDouble()
        .pow(matchingKeys[matchingKeys.keys.maxOrNull()]!!).toInt()
}

private fun mcm(num1: Int, num2: Int): Int {
    // If any of both numbers is 0, the MCD is 0
    if (num1 == 0 || num2 == 0) {
        return 0
    }

    // Get prime factorization of each number
    val alMaps = primeFactorization(arrayListOf(num1, num2))

    // Get the matching prime numbers of each number
    val matchingKeys = hashMapOf<Int, Int>()
    for ((k, v) in alMaps[0]) {
        // If the prime number does match, get the one with the biggest exponential
        if (alMaps[1].contains(k)) {
            matchingKeys[k] = if (alMaps[0][k]!! > alMaps[1][k]!!) {
                v
            } else {
                alMaps[1][k]!!
            }
        }
    }

    // Remove those matching prime numbers from both previous hashMaps
    for ((k, _) in matchingKeys) {
        alMaps[0].remove(k)
        alMaps[1].remove(k)
    }
    // And add the non matching prime numbers to the matching prime numbers hashMap
    matchingKeys.putAll(alMaps[0])
    matchingKeys.putAll(alMaps[1])

    // Finally calculate the MCD by multiplying each prime number (key) to the power exponent (value)
    var mcd = 1
    for (hashMap in matchingKeys) {
        mcd *= hashMap.key.toDouble().pow(hashMap.value).toInt()
    }
    return mcd
}

private fun primeFactorization(alNumbers: ArrayList<Int>): ArrayList<HashMap<Int, Int>> {
    val mapNum1 = hashMapOf<Int, Int>()
    val mapNum2 = hashMapOf<Int, Int>()
    // Loop through each number
    alNumbers.forEachIndexed { index, num ->
        // If number is lower than 0 throw an exception
        if (num < 0) {
            throw WrongParameterException()
        // If not...
        } else {
            var newNum = num
            // Loop through each number (or the new calculated number) until the number is 1
            while (newNum != 1) {
                var divisible = 2
                // Then try to divide the number by $divisible
                while (newNum != 1) {
                    // If the division remainder is 0 divide and exit loop
                    if (newNum % divisible == 0) {
                        newNum /= divisible
                        break
                        // If not, add 1 to $divisible
                    } else {
                        divisible++
                    }
                }
                // If the loop is in the first number
                if (index == 0) {
                    // If the hashMap of the first number has the $divisible add 1 to the value
                    if (mapNum1.keys.contains(divisible)) {
                        mapNum1[divisible] = mapNum1.getValue(divisible) + 1
                    // If not, create a new key with value of 1
                    } else {
                        mapNum1[divisible] = 1
                    }

                // If the loop is in the second number
                } else {
                    // If the hashMap of the first number has the $divisible add 1 to the value
                    if (mapNum2.keys.contains(divisible)) {
                        mapNum2[divisible] = mapNum2.getValue(divisible) + 1
                    // If not, create a new key with value of 1
                    } else {
                        mapNum2[divisible] = 1
                    }
                }
            }
            // Finally, add the prime number 1 to the hashMap of the current number
            if (index == 0) {
                mapNum1[newNum] = 1
            } else {
                mapNum2[newNum] = 1
            }
        }
    }

    return arrayListOf(mapNum1, mapNum2)
}

class WrongParameterException(message: String = "ERROR: Number should be bigger or equal 0!") :
    Exception(message)