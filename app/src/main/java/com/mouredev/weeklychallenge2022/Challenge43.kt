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

    val kids = arrayOf(
        Kid(name = "Enrique", age = 11, height = 151),
        Kid(name = "Maria Jose", age = 10, height = 150),
        Kid(name = "Annabel", age = 5, height = 98),
        Kid(name = "Ana", age = 1, height = 49),
        Kid(name = "Raul de Jesus", age = 15, height = 168),
        Kid(name = "Juan", age = 3, height = 50),
        Kid(name = "Manuel", age = 3, height = 50)
    )

    println(kids.trickOrTread(Halloween.TRICK))
    println(kids.trickOrTread(Halloween.TREAT))
}

data class Kid(val name: String, val age: Int, val height: Int)

enum class Halloween {
    TRICK, TREAT
}

fun Array<Kid>.trickOrTread(halloween: Halloween): String {
    val scares = arrayListOf("🎃", "👻", "💀", "🕷", "🕸", "🦇")
    val sweets = arrayListOf("🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩")

    var presents = 0
    var rewards = ""

    when (halloween) {
        Halloween.TRICK -> {
            var heights = 0
            this.forEach { kid ->
                // One scare for every 2 letters of the name per person
                presents += (kid.name.replace(" ", "").length / 2)
                // Two scares for each age that is an even number
                presents += if (kid.age % 2 == 0) 2 else 0
                // sum of heights
                heights += kid.height
            }
            // Three scares for every 100 cm of height among all people
            presents += (heights / 100) * 3
            for (i in 1..presents) {
                rewards += scares.random()
            }
        }

        Halloween.TREAT -> {
            this.forEach { kid ->
                // One candy for each letter of name
                presents += kid.name.replace(" ", "").length
                // One candy for every 3 years up to a maximum of 10 years per person
                presents += if (kid.age > 10) 3 else kid.age / 3
                // Two candies for every 50 cm of height up to a maximum of 150 cm per person
                presents += if (kid.height > 150) 6 else (kid.height / 50) * 2
            }
            for (i in 1..presents) {
                rewards += sweets.random()
            }
        }
    }
    return rewards
}