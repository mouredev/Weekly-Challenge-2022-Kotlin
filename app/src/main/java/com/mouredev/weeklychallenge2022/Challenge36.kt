package com.mouredev.weeklychallenge2022

import es.jaimefere.weeklychallenge2022.PokemonType
import es.jaimefere.weeklychallenge2022.getAttackDamage

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

enum class BattleResult {
    DRAW, EVIL, GOOD
}

enum class GoodRace {
    PELOSOS, SUREÑOS_BUENOS, ENANOS, NUMENORANOS, ELFOS
}

enum class EvilRace {
    SUREÑOS_MALOS, ORCOS, GOBLINS, HUARGOS, TROLLS;

    companion object {
        fun strength(obj: EvilRace): Int {
            return when (obj) {
                HUARGOS -> 3
                TROLLS -> 5
                else -> 2
            }
        }
    }
}

fun battle(goodArmy: Map<GoodRace, Int>, evilArmy: Map<EvilRace, Int>): BattleResult {
    val goodStrength = goodArmy.map{ (it.key.ordinal + 1) * it.value }.sum()
    val evilStrength = evilArmy.map{ EvilRace.strength(it.key) * it.value }.sum()
    return if(goodStrength == evilStrength) BattleResult.DRAW else if(goodStrength > evilStrength) BattleResult.GOOD else BattleResult.EVIL
}

fun main() {
    println(battle(mapOf(Pair(GoodRace.PELOSOS,1)), mapOf(Pair(EvilRace.ORCOS,1))))
    println(battle(mapOf(Pair(GoodRace.PELOSOS,2)), mapOf(Pair(EvilRace.ORCOS,1))))
    println(battle(mapOf(Pair(GoodRace.PELOSOS,3)), mapOf(Pair(EvilRace.ORCOS,1))))
}