package com.mouredev.weeklychallenge2022

import kotlin.math.floor

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

/**
 * Enumerado con los tipos de truco o trato
 */
enum class TrickOrTreat {
    TRICK, TREAT
}

/**
 * Clase que representa una pesona
 * @param name Nombre de la persona
 * @param age Edad de la persona
 * @param height Altura de la persona
 */
data class Person(val name: String, val age: Int, val height: Int)
/**
 * Función que devuelve un array de dulces en funcion de los parametros
 *  * - Un susto por cada 2 letras del nombre por persona
 *  * - Dos sustos por cada edad que sea un número par
 *  * - Tres sustos por cada 100 cm de altura entre todas las personas
 *
 * @param people Array de personas
 * @returns Array de sustos
 */
fun trick(persons: List<Person>) : ArrayList<String> {
    val scares: List<String> = listOf("🎃", "👻", "💀", "🕷", "🕸", "🦇")
    val scare = arrayListOf<String>()

    persons.forEach { person ->
        val nameScares = person.name.length / 2
        val ageScares = if (person.age % 2 == 0) 2 else 0
        val heightScares = floor(persons.sumOf { it.height } / 100.0).toInt() * 3

        val totalScares = nameScares + ageScares + heightScares
        scares.apply {
            repeat(totalScares) {
                scare.add(scares.shuffled().random())
            }
        }
    }

    return scare
}
/**
 * Función que devuelve un array de dulces en funcion de los parametros
 *  * - Un dulce por cada letra de nombre
 *  * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
 *  * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
 *
 * @param people Array de personas
 * @returns Array de dulces
 */
fun treat(persons: List<Person>) : ArrayList<String> {
    val sweets: List<String> = listOf("🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩")
    val sweet = arrayListOf<String>()
    persons.forEach { person ->
        val nameSweets = person.name.length
        val ageSweets = floor(person.age/ 3.0).coerceAtMost(10.0).toInt()
        val heightSweets = floor((person.height/50.0).coerceAtMost(3.0)).toInt()*2
        val totalSweets = nameSweets + ageSweets + heightSweets
        sweet.apply {
           repeat(totalSweets) {
               sweet.add(sweets.shuffled().random())
           }
        }
    }


    return sweet
}

/**
 * Función que devuelve un array de sustos o dulces en funcion de los parametros
 * @param trickOrTreat Tipo de truco o trato
 * @param people Array de personas
 * @returns Array de sustos o dulces
 */
fun trickOrTreat(trickOrTreat: TrickOrTreat, persons: Array<Person>) : List<String> {
    return when (trickOrTreat) {
        TrickOrTreat.TRICK -> trick(persons.toList())
        TrickOrTreat.TREAT -> treat(persons.toList())
    }
}

/**
 * Funcion principal
 */
fun main() {
    println(
        trickOrTreat(
            TrickOrTreat.TRICK, arrayOf(
                Person("Carmen", 7, 124),
                Person("Brais", 38, 170)
            )
        )
    )

    println(
        trickOrTreat(
            TrickOrTreat.TREAT, arrayOf(
                Person("Angel", 10, 145),
                Person("Miguel Angel", 42, 178)
            )
        )
    )


}




