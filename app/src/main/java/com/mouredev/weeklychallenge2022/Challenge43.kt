package com.mouredev.weeklychallenge2022

import java.util.Scanner
import kotlin.math.truncate
import kotlin.random.Random

/*
 * Reto #43
 * TRUCO O TRATO
 * Fecha publicación enunciado: 24/10/22
 * Fecha publicación resolución: 02/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Este es un reto especial por Halloween.
 * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
 * un listado (array) de personas con las siguientes propiedades:
 * - Nombre de la niña o niño
 * - Edad
 * - Altura en centímetros
 *
 * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
 * siguiendo estos criterios:
 * - Un susto por cada 2 letras del nombre por persona
 * - Dos sustos por cada edad que sea un número par
 * - Tres sustos por cada 100 cm de altura entre todas las personas
 * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
 *
 * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
 * siguiendo estos criterios:
 * - Un dulce por cada letra de nombre
 * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
 * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
 * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

data class Persona(var nombre: String, var edad: Int, var altura: Int)

val scares = listOf(
    Character.toChars(0x1F383), // 🎃
    Character.toChars(0x1F47B), // 👻
    Character.toChars(0x1F480), // 💀
    Character.toChars(0x1F577), // 🕷
    Character.toChars(0x1F578), // 🕸
    Character.toChars(0x1F987), // 🦇
)

val candies = listOf(
    Character.toChars(0x1F370), // 🍰
    Character.toChars(0x1F36C), // 🍬
    Character.toChars(0x1F361), // 🍡
    Character.toChars(0x1F36D), // 🍭
    Character.toChars(0x1F36A), // 🍪
    Character.toChars(0x1F36B), // 🍫
    Character.toChars(0x1F9C1), // 🧁
    Character.toChars(0x1F369), // 🍩
)

enum class Action(val code: Int) {
    TRUCO (1),
    TRATO (2),
    ERROR (0xFF)
}

fun main() {
    val personas = listOf(
        Persona("Manolo", 10, 160),
        Persona("Pepe", 9, 140),
        Persona("Izan", 6, 120),
        Persona("Mario", 11, 150),
        Persona("Juan", 7, 130),
        Persona("Jorge", 13, 165),
        Persona("Álvaro", 12, 145)
    )

    val action = getAction()
    try {
        if (action == Action.TRUCO.code) {
            playTrick(personas)
        } else if (action == Action.TRATO.code) {
            playTreat(personas)
        }
    } catch (e: java.lang.Exception) {
        println(e.javaClass.simpleName + ": " + e.message)
    }
}

fun playTrick(personas: List<Persona>) {
    var nScares: Int = 0
    var totalHeight: Int = 0
    for (persona in personas) {
        nScares += truncate(persona.nombre.length / 2f).toInt() // +1 scare for every 2 letters of the name
        if (persona.edad % 2 == 0) {
            nScares += 2 // +2 scares if age is even
        }
        totalHeight += persona.altura
    }

    nScares += (truncate(totalHeight / 100f).toInt() * 3) // +3 scares of every 100 cm of height

    println("Número de sustos: " + nScares)

    for (i in 0..nScares) {
        val randomIndex = Random.nextInt(scares.size)
        print(scares[randomIndex])
    }
}

fun playTreat(personas: List<Persona>) {
    var nCandies = 0
    for (persona in personas) {
        nCandies += persona.nombre.length // +1 candy for every letter of the name
        var ageForCandies: Int = persona.edad
        if (persona.edad > 10) { // Until 10 years old
            ageForCandies -= persona.edad % 10 // Subtract the number of years from 10 to the current age so the new age will be 10
        }
        nCandies += truncate(ageForCandies / 3f).toInt() // +1 candy for every 3 years of age until 10 years old

        var heightForCandies: Int = persona.altura
        if (persona.altura > 150) { // Until 150 cm height
            heightForCandies -= persona.altura % 150
        }
        nCandies += truncate(heightForCandies / 50f).toInt() * 2 // +2 candies for every 50 cm of height until 150 cm
    }

    println("Número de dulces: " + nCandies)

    for (i in 0..nCandies) {
        val randomIndex = Random.nextInt(candies.size)
        print(candies[randomIndex])
    }
}

fun getAction(): Int {
    var action: Int = Action.ERROR.code
    try {
        val scanner = Scanner(System.`in`)
        do {
            println("Escoge truco o trato")
            println("1. Truco")
            println("2. Trato")
            print("Selección: ")
            action = scanner.nextInt()

            val actionSeleccionada = action == Action.TRUCO.code || action == Action.TRATO.code
            if (!actionSeleccionada) {
                println("Debes poner 1 o 2 (truco o trato).")
            }
        } while (!actionSeleccionada)

    } catch (e: java.lang.Exception) {
        println(e.javaClass.simpleName + ": " + e.message)
    }

    return action
}