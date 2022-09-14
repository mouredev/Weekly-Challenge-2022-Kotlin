package es.jaimefere.weeklychallenge2022

/*
 * Reto #35
 * BATALLA POKÉMON
 * Fecha publicación enunciado: 29/08/22
 * Fecha publicación resolución: 06/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

enum class PokemonType {
    ELECTRIC, FIRE, PLANT, WATER;

    companion object {
        fun getEffectivity(obj: PokemonType, opponent: PokemonType): Double {
            return when(obj) {
                ELECTRIC -> when(opponent) {
                    ELECTRIC -> 0.5
                    FIRE -> 1.0
                    PLANT -> 0.5
                    WATER -> 2.0
                }
                FIRE -> when(opponent) {
                    ELECTRIC -> 1.0
                    FIRE -> 0.5
                    PLANT -> 2.0
                    WATER -> 0.5
                }
                PLANT -> when(opponent) {
                    ELECTRIC -> 1.0
                    FIRE -> 0.5
                    PLANT -> 0.5
                    WATER -> 2.0
                }
                WATER -> when(opponent) {
                    ELECTRIC -> 1.0
                    FIRE -> 2.0
                    PLANT -> 0.5
                    WATER -> 0.5
                }
            }
        }
    }
}

fun getAttackDamage(attacker: PokemonType, defender: PokemonType, attack: Int, defence: Int): String {
    return if(attack < 1 || attack > 100) {
        "El ataque no tiene un valor correcto"
    } else if(defence < 1 || defence > 100) {
        "La defensa no tiene un valor correcto"
    } else {
        "El daño de la pelea es ${50.0 * (attack.toDouble() / defence.toDouble()) * PokemonType.getEffectivity(attacker, defender)}"
    }
}

fun main() {
    println(getAttackDamage(PokemonType.FIRE, PokemonType.PLANT, 30, 60))
}