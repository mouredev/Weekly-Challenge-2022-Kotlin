package com.mouredev.weeklychallenge2022

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

fun main() {
    println(trickOrTreat(Halloween.TRICK, arrayOf(
        Person("Brais", 35, 177),
        Person("Sara", 9, 122),
        Person("Pedro", 5, 80),
        Person("Roswell", 3, 54))))

    println(trickOrTreat(Halloween.TREAT, arrayOf(
        Person("Brais", 35, 177),
        Person("Sara", 9, 122),
        Person("Pedro", 5, 80),
        Person("Roswell", 3, 54))))
}

enum class Halloween {
    TRICK, TREAT
}

data class Person(val name: String, val age: Int, val height: Int)

private fun trickOrTreat(halloween: Halloween, people: Array<Person>): String {

    val scares = arrayOf("🎃", "👻", "💀", "🕷", "🕸", "🦇")
    val candies = arrayOf("🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩")

    var result = ""
    var height = 0

    people.forEach { person ->

        when (halloween) {
            Halloween.TRICK -> {

                // Name
                (1 .. (person.name.replace(" ", "").length / 2)).forEach { _ ->
                    result += scares.random()
                }

                // Age
                if (person.age % 2 == 0) {
                    result += scares.random()
                    result += scares.random()
                }

                // Height
                height += person.height
                while (height >= 100) {
                    result += scares.random()
                    result += scares.random()
                    result += scares.random()
                    height -= 100
                }

            }
            Halloween.TREAT -> {

                // Name
                (1 .. (person.name.replace(" ", "").length)).forEach { _ ->
                    result += candies.random()
                }

                // Age
                if (person.age <= 10) {
                    (1 .. (person.age / 3)).forEach { _ ->
                        result += candies.random()
                    }
                }

                // Height
                if (person.height <= 150) {
                    (1 .. (person.height / 50)).forEach { _ ->
                        result += candies.random()
                        result += candies.random()
                    }
                }
            }
        }

    }

    return result
}
