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


fun main(){

    println(emulateFight(POKEMON.BULBASAUR,POKEMON.ELECTABUZZ))
    println(emulateFight(POKEMON.RAPIDASH,POKEMON.ELECTABUZZ))
    println(emulateFight(POKEMON.SEEL,POKEMON.ELECTABUZZ))
    println(emulateFight(POKEMON.ELECTABUZZ,POKEMON.ELECTABUZZ))

}

enum class TYPE{
    WATER,
    FIRE,
    PLANT,
    ELECTRIC;


    fun getSuperEffectiveList():List<TYPE>{
    val effectiveList =
        when(this){
            FIRE -> listOf(PLANT)
            WATER ->listOf(FIRE)
            PLANT -> listOf(WATER)
            ELECTRIC -> listOf(WATER)
        }
    return effectiveList
    }

    fun getLessEffectiveList():List<TYPE>{
        val lessEffectiveList =
            when(this){
                FIRE -> listOf(FIRE,WATER)
                WATER ->listOf(WATER,PLANT)
                PLANT -> listOf(FIRE,PLANT)
                ELECTRIC -> listOf(PLANT,ELECTRIC)
            }
        return lessEffectiveList
    }
}

enum class POKEMON( val type:TYPE, val attack:Double, val defense:Double ){

    RAPIDASH(TYPE.FIRE, 56.0,60.0),
    BULBASAUR(TYPE.PLANT,34.0,50.0),
    SEEL(TYPE.WATER,40.0, 60.0),
    ELECTABUZZ(TYPE.ELECTRIC, 80.0, 70.0)
}

fun emulateFight(attackPokemon: POKEMON, defensePokemon: POKEMON): Double {

    val effectivity = getEffectivity(attackPokemon.type, defensePokemon.type)
    // daño = 50 * (ataque / defensa) * efectividad
    return 50 * (attackPokemon.attack / defensePokemon.defense) * effectivity

}

fun getEffectivity(attackType:TYPE, defenseType:TYPE): Double {

            return when {
                attackType.getSuperEffectiveList().contains(defenseType) -> 2.0
                attackType.getLessEffectiveList().contains(defenseType) -> 0.5
                else -> 1.0
            }
}