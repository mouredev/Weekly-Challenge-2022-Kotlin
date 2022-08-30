package com.mouredev.weeklychallenge2022

import kotlin.math.roundToInt

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

fun main() {
    try {
        println(calculateDamage(PokemonType.WATER, PokemonType.FIRE, 25.0, 69.0))
        println(calculateDamage(PokemonType.FIRE, PokemonType.ELECTRIC, 67.0, 13.0))
        println(calculateDamage(PokemonType.ELECTRIC, PokemonType.GRASS, 100.0, 1.0))
        println(calculateDamage(PokemonType.GRASS, PokemonType.GRASS, 154.0, 69.0))
    } catch (e: WrongAmountException) {
        println(e.message)
    }
}

enum class PokemonType {
    FIRE, WATER, GRASS, ELECTRIC
}

class WrongAmountException : Exception() {
    override val message: String
        get() = "Attack and Defence amount should be a value between 1 and 100."
}

fun calculateDamage(
    attackerType: PokemonType,
    defenderType: PokemonType,
    attackAmount: Double,
    defenceAmount: Double
): String {
    if (attackAmount !in 1.0..100.0 || defenceAmount !in 1.0..100.0) {
        throw WrongAmountException()
    }
    val effectiveness: Double
    when (attackerType) {
        PokemonType.WATER -> {
            effectiveness = when (defenderType) {
                PokemonType.FIRE -> 2.0
                PokemonType.ELECTRIC -> 1.0
                PokemonType.WATER, PokemonType.GRASS -> 0.5
            }
        }
        PokemonType.FIRE -> {
            effectiveness = when (defenderType) {
                PokemonType.GRASS -> 2.0
                PokemonType.ELECTRIC -> 1.0
                PokemonType.FIRE, PokemonType.WATER -> 0.5
            }
        }
        PokemonType.GRASS -> {
            effectiveness = when (defenderType) {
                PokemonType.WATER -> 2.0
                PokemonType.ELECTRIC -> 1.0
                PokemonType.GRASS, PokemonType.FIRE -> 0.5
            }
        }
        PokemonType.ELECTRIC -> {
            effectiveness = when (defenderType) {
                PokemonType.WATER -> 2.0
                PokemonType.FIRE -> 1.0
                PokemonType.ELECTRIC, PokemonType.GRASS -> 0.5
            }
        }
    }
    val damage = ((50 * (attackAmount / defenceAmount) * effectiveness) * 100).roundToInt() / 100.0

    return "Attack damage: $damage. ${
        when (effectiveness) {
            2.0 -> "Attack is super-effective!"
            1.0 -> "Attack is normal"
            else -> "Attack is not very effective"
        }
    }"
}
