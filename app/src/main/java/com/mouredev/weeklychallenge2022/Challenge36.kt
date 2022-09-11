package com.mouredev.weeklychallenge2022

/*
 * Reto #36
 * LOS ANILLOS DE PODER
 * Fecha publicación enunciado: 06/09/22
 * Fecha publicación resolución: 14/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
 * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
 *   suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {

    val firstGoodSquad = Squadron(band = Good.SouthGoodOnes, 3)
    val secondGoodSquad = Squadron(band = Good.Pelosos, 5)

    val firstEvilSquad = Squadron(band = Evil.Huargos, 1)
    val secondEvilSquad = Squadron(band = Evil.Trolls, 3)

    firstEvilSquad.fightWith(firstGoodSquad)
    firstGoodSquad.fightWith(secondEvilSquad)
    secondGoodSquad.fightWith(secondEvilSquad)
    secondEvilSquad.fightWith(firstGoodSquad)
}

private class Squadron(private val band: Race, private val quantity: Int) {

    private val totalPower = band.racePower * quantity

    fun fightWith(enemy: Squadron): Int {
        println("$quantity ${band.raceName} fight(s) with ${enemy.quantity} ${enemy.band.raceName}")
        return when {
            totalPower > enemy.totalPower -> {
                println("And Win!!")
                1
            }
            totalPower < enemy.totalPower -> {
                println("And Lose")
                -1
            }
            else -> {
                println("It was a draw")
                0
            }
        }
    }
}

private enum class Good(override val raceName: String, override val racePower: Int) : Race {
    Pelosos("Pelosos",1),
    SouthGoodOnes("Sureños buenos",2),
    Enanos("Enanos",3),
    Numenoreanos("Númenóreanos",4),
    Elfos("Elfos",5)
}

private enum class Evil(override val raceName: String, override val racePower: Int) : Race {
    SouthBadOnes("Sureños malos",2),
    Orcos("Orcos",2),
    Goblins("Goblins",2),
    Huargos("Huargos",3),
    Trolls("Trolls",5)
}

private interface Race {
    val raceName : String
    val racePower: Int
}

