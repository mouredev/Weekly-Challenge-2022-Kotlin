package com.mouredev.weeklychallenge2022

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
    FIRE, WATER, GRASS, ELECTRIC
}

fun main(){
    CalculateDamage(PokemonType.FIRE, PokemonType.WATER, 50, 50)
    CalculateDamage(PokemonType.WATER, PokemonType.ELECTRIC, 10, 39)
    CalculateDamage(PokemonType.GRASS, PokemonType.GRASS, 47, 20)
    CalculateDamage(PokemonType.ELECTRIC, PokemonType.WATER, 99, 2)
    CalculateDamage(PokemonType.FIRE, PokemonType.ELECTRIC, 100, 50)
    CalculateDamage(PokemonType.WATER, PokemonType.GRASS, 20, 10)
    CalculateDamage(PokemonType.FIRE, PokemonType.FIRE, 30, 75)


}

private fun CalculateDamage(attackerType: PokemonType, defenderType: PokemonType, attack: Int, defense: Int) {

    if (attack < 0 || attack > 100 || defense < 0 || defense> 100) {
        throw WrongValues()
    }
    val efectivity = getEfectivity(attackerType, defenderType)
    val damage = 50 * (attack / defense) * efectivity

    println("ATACANTE: $attackerType vs DEFENSOR: $defenderType")
    println("Efectividad del ataque: ${EvaluateEffectiveness(efectivity)}")
    println("Para los valores indicados, el daño producido seria de: $damage")
    println ("--------------------------------")
}

fun getEfectivity(attackerType: PokemonType, defenderType: PokemonType): Double {
    return when (attackerType) {
        PokemonType.FIRE -> when (defenderType) {
            PokemonType.FIRE -> 0.5
            PokemonType.WATER -> 0.5
            PokemonType.GRASS -> 2.0
            PokemonType.ELECTRIC -> 1.0
        }
        PokemonType.WATER -> when (defenderType) {
            PokemonType.FIRE -> 2.0
            PokemonType.WATER -> 0.5
            PokemonType.GRASS -> 0.5
            PokemonType.ELECTRIC -> 1.0
        }
        PokemonType.GRASS -> when (defenderType) {
            PokemonType.FIRE -> 0.5
            PokemonType.WATER -> 2.0
            PokemonType.GRASS -> 0.5
            PokemonType.ELECTRIC -> 1.0
        }
        PokemonType.ELECTRIC -> when (defenderType) {
            PokemonType.FIRE -> 1.0
            PokemonType.WATER -> 2.0
            PokemonType.GRASS -> 0.5
            PokemonType.ELECTRIC -> 0.5
        }
    }
}

private fun EvaluateEffectiveness (efectivity: Double): String
{
    when (efectivity){
        2.0 -> return "Super efectivo"
        1.0 -> return "Neutral"
        0.5 -> return "No muy efectivo"
        else -> return "Error"
    }
}

class WrongValues : Exception()
{
    override val message: String?
        get() = "Los valores deben estar entre 0 y 100"
}