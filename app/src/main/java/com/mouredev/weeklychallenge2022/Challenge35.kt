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

/**
 * Clase que representa un Pokémon.
 * @param type Tipo del Pokémon.
 */

data class Pokemon(val type:PokemonType){

    /**
     * Funcion que devuelve la efectividad de el pokemon actual contra otro pokemon
     * @param pokemon Pokemon contra el que se quiere calcular la efectividad
     * @return Efectividad del pokemon actual contra el pokemon pasado como parámetro
     */
    fun effectiveness(defender:PokemonType):EffectivenessType{
        return when(type){
            PokemonType.WATER -> when(defender){
                PokemonType.WATER -> EffectivenessType.NOT_VERY_EFFECTIVE
                PokemonType.FIRE -> EffectivenessType.SUPER_EFFECTIVE
                PokemonType.GRASS -> EffectivenessType.NOT_VERY_EFFECTIVE
                PokemonType.ELECTRIC -> EffectivenessType.NORMAL
            }
            PokemonType.FIRE -> when(defender){
                PokemonType.WATER -> EffectivenessType.NOT_VERY_EFFECTIVE
                PokemonType.FIRE -> EffectivenessType.NOT_VERY_EFFECTIVE
                PokemonType.GRASS -> EffectivenessType.SUPER_EFFECTIVE
                PokemonType.ELECTRIC -> EffectivenessType.NORMAL
            }
            PokemonType.GRASS -> when(defender){
                PokemonType.WATER -> EffectivenessType.SUPER_EFFECTIVE
                PokemonType.FIRE -> EffectivenessType.NOT_VERY_EFFECTIVE
                PokemonType.GRASS -> EffectivenessType.NOT_VERY_EFFECTIVE
                PokemonType.ELECTRIC -> EffectivenessType.NORMAL
            }
            PokemonType.ELECTRIC -> when(defender){
                PokemonType.WATER -> EffectivenessType.SUPER_EFFECTIVE
                PokemonType.FIRE -> EffectivenessType.NORMAL
                PokemonType.GRASS -> EffectivenessType.NOT_VERY_EFFECTIVE
                PokemonType.ELECTRIC -> EffectivenessType.NOT_VERY_EFFECTIVE
            }
        }

    }
}

/**
 * Enumerado que representa los tipos de Pokémon
 */

enum class PokemonType(val type:String){
    WATER("water"),
    FIRE("fire"),
    GRASS("grass"),
    ELECTRIC("electric")
}

/**
 * Enumerado que representa la efectividad de un ataque
 */

enum class EffectivenessType(val effectiveness:Double){
    SUPER_EFFECTIVE(2.0),
    NORMAL(1.0),
    NOT_VERY_EFFECTIVE(0.5)
}

const val DAMAGE_MODIFIER:Double = 50.0

/**
 * Funcion principal del programa
 */
fun main() {

    println("Attack - Water(50) vs  Defend - Fire(50) :  ${calculateDamage(Pokemon(PokemonType.WATER), Pokemon(PokemonType.FIRE), 50.0, 50.0)}")
    println("Attack - Grass(20) vs  Defend - Electric(80) :  ${calculateDamage(Pokemon(PokemonType.GRASS), Pokemon(PokemonType.ELECTRIC), 20.0, 80.0)}")

}


/**
 * Funcion que calcula el daño de un ataque
 * @param attacker Pokemon que ataca
 * @param defender Pokemon que defiende
 * @param attack Ataque del pokemon que ataca(1-100)
 * @param defense Defensa del pokemon que defiende(1-100)
 * @return Daño calculado del ataque ( 0 en caso de error)
 */
fun calculateDamage(attacker:Pokemon, defender:Pokemon, attack:Double, defense:Double):Double {
    if(attack < 1 || attack > 100 || defense < 1 || defense > 100){
        println("Attack and defense must be between 1 and 100")
        return 0.0
    }

    return (DAMAGE_MODIFIER * (attack / defense) * attacker.effectiveness(defender.type).effectiveness)
}