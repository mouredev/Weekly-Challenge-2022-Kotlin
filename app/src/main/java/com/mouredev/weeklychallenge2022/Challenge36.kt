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
<<<<<<< HEAD
 */
=======
 */

fun main() {

    battleForTheMiddleEarth(
        listOf(Pair(KindArmy.ELF, 1)),
        listOf(Pair(EvilArmy.TROLL, 1)))

    battleForTheMiddleEarth(
        listOf(Pair(KindArmy.ELF, 1), Pair(KindArmy.HARFOOT, 1)),
        listOf(Pair(EvilArmy.TROLL, 1)))

    battleForTheMiddleEarth(
        listOf(Pair(KindArmy.ELF, 1), Pair(KindArmy.HARFOOT, 1)),
        listOf(Pair(EvilArmy.TROLL, 1), Pair(EvilArmy.ORC, 1)))

    battleForTheMiddleEarth(
        listOf(Pair(KindArmy.ELF, 56), Pair(KindArmy.HARFOOT, 80), Pair(KindArmy.DWARF, 5)),
        listOf(Pair(EvilArmy.TROLL, 17), Pair(EvilArmy.ORC, 51), Pair(EvilArmy.WARG, 10), Pair(EvilArmy.SOUTHERNER, 2)))
}

enum class KindArmy() {

    HARFOOT, SOUTHERNER, DWARF, NUMENOREAN, ELF;

    var bravery: Int = 0
        get() {
            return when (this) {
                HARFOOT -> 1
                SOUTHERNER -> 2
                DWARF -> 3
                NUMENOREAN -> 4
                ELF -> 5
            }
        }
}

enum class EvilArmy() {

    SOUTHERNER, ORC, GOBLIN, WARG, TROLL;

    var bravery: Int = 0
        get() {
            return when (this) {
                SOUTHERNER, ORC, GOBLIN -> 2
                WARG -> 3
                TROLL -> 5
            }
        }
}

private fun battleForTheMiddleEarth(kindArmy: List<Pair<KindArmy, Int>>, evilArmy: List<Pair<EvilArmy, Int>>) {

    var kindArmyPoints = 0
    var evilArmyPoints = 0

    kindArmy.forEach { army ->
        kindArmyPoints += army.first.bravery * army.second
    }

    evilArmy.forEach { army ->
        evilArmyPoints += army.first.bravery * army.second
    }

    if (kindArmyPoints > evilArmyPoints) {
        println("Gana el bien")
    } else if (evilArmyPoints > kindArmyPoints) {
        println("Gana el mal")
    } else {
        println("Empate")
    }

}
>>>>>>> 547c1070cb391f3a746dde1323b4b31b020e13e0
