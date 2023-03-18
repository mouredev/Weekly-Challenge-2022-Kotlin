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
    val firstGroup = arrayOf(
        Visitor("Pepito", 10, 70),
        Visitor("Juana", 8, 79),
        Visitor("Pulgarcito", 20, 29),
        Visitor("Gigante", 5, 180))

    Halloween().trickOrTreat(firstGroup, answer.Trick)
    Halloween().trickOrTreat(firstGroup, answer.Treat)
}

private typealias Visitor = Halloween.Persona
private typealias answer = Halloween.Surprises

private class Halloween{
    data class Persona( val name : String, val age : Int, val height: Int)

    enum class Surprises(val options : List<String>){
        Treat(listOf("🎃", "👻", "💀", "🕷", "🕸", "🦇")),
        Trick(listOf("🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"));

        fun getRandom(): String {
            return this.options[(0 until this.options.size).random()]
        }
    }

    fun trickOrTreat(group : Array<Persona>, selection : Surprises){
        if (selection == Surprises.Treat){
            var totalLetters = 0
            var pairAges = 0
            var totalHeight = 0

            group.forEach {
                totalLetters += it.name.length
                if (it.age%2 == 0) pairAges ++
                totalHeight += it.height
            }

            val numOfSurprises = totalLetters/2 + 2*pairAges + 3*(totalHeight/100)
            println("This group gets $numOfSurprises tricks")
            repeat(numOfSurprises) {
                print(" ${selection.getRandom()}")
            }
        } else {
            var totalLetters = 0
            var everythree = 0
            var totalHeightCount = 0

            group.forEach {
                totalLetters += it.name.length
                everythree +=
                    if (it.age >= 9) 3
                    else it.age/3
                totalHeightCount +=
                    if (it.height >= 150) 3
                    else it.age/50
            }

            val numOfSurprises = totalLetters + everythree + 2*totalHeightCount
            println("This group gets $numOfSurprises treats")
            repeat(numOfSurprises) {
                print(" ${selection.getRandom()}")
            }
        }

        println("\nHappy Halloween :D\n")
    }
}
