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
    println(
        calculateBattle(
            mapOf(KindBreeds.HARFOOTS to 3, KindBreeds.DWARVES to 1, KindBreeds.NUMENOREANS to 2),
            mapOf(EvilRaces.ORCS to 2, EvilRaces.TROLLS to 1)
        )
    )
    println(
        calculateBattle(
            mapOf(KindBreeds.HARFOOTS to 2, KindBreeds.DWARVES to 3, KindBreeds.ELVES to 1),
            mapOf(EvilRaces.GOBLINS to 2, EvilRaces.TROLLS to 3)
        )
    )
    println(
        calculateBattle(
            mapOf(KindBreeds.KIND_SOUTHERNERS to 2, KindBreeds.DWARVES to 2),
            mapOf(EvilRaces.EVIL_SOUTHERNERS to 2, EvilRaces.DIRE_WOLVES to 2)
        )
    )
}

enum class KindBreeds(val values: Int) {
    HARFOOTS(1),
    KIND_SOUTHERNERS(2),
    DWARVES(3),
    NUMENOREANS(4),
    ELVES(5)
}

enum class EvilRaces(val values: Int) {
    EVIL_SOUTHERNERS(2),
    ORCS(2),
    GOBLINS(2),
    DIRE_WOLVES(3),
    TROLLS(5),
}

private fun calculateBattle(kindOnes: Map<KindBreeds, Int>, evilOnes: Map<EvilRaces, Int>): String {
    var totalBattlePoints = 0
    (0 until kindOnes.size).forEach { index ->
        totalBattlePoints +=
            (kindOnes.entries.elementAt(index).key.values * kindOnes.values.elementAt(index))
    }
    (0 until evilOnes.size).forEach { index ->
        totalBattlePoints -=
            (evilOnes.entries.elementAt(index).key.values * evilOnes.values.elementAt(index))
    }
    return when {
        totalBattlePoints < 0 -> "The evil race won"
        totalBattlePoints > 0 -> "The kind breeds won"
        else -> "The battle has been tied"
    }
}