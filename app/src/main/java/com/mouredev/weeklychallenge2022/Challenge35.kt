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
    val odish = Pokemon(name = "Odish", elementType = Pokemon.Element.Grass,
        attackPower = 100, defencePower = 30, movePower = 50)

    val lechonk = Pokemon(name = "Lechonk", elementType = Pokemon.Element.Fire,
        attackPower = 50, defencePower = 80, movePower = 90)

    attack(odish, lechonk)
    attack(lechonk, odish)
}

class Pokemon(val name : String, val elementType : Element,
               val attackPower : Int, val defencePower : Int, val movePower : Int){

    sealed class Element(
        val weak : List<Element>,
        val effective : List<Element>,
        val resist : List<Element>,
        val immune : List<Element>? = null){
        object Electric : Element(
            weak = listOf(Ground),
            effective = listOf(Water, Flying),
            resist = listOf(Electric, Flying, Steel))

        object Water : Element(
            weak = listOf(Grass, Electric),
            effective = listOf(Ground, Rock, Fire),
            resist = listOf(Fire, Ice, Steel, Water))

        object Fire : Element(
            weak = listOf(Water, Ground, Rock),
            effective = listOf(Grass, Steel, Ice, Bug),
            resist = listOf(Steel, Fire, Grass, Ice, Bug))

        object Grass : Element(
            weak = listOf(Fire, Ice, Flying, Poison, Bug),
            effective = listOf(Water, Ground, Rock),
            resist = listOf(Water, Grass, Electric, Ground))

        object Ground : Element(
            weak = listOf(Water, Ice, Grass),
            effective = listOf(Fire, Electric, Poison, Rock, Steel),
            resist = listOf(Rock, Poison),
            immune = listOf(Electric))

        object Ice : Element(
            weak = listOf(Fire, Fighting, Steel, Rock),
            effective = listOf(Grass, Flying, Dragon, Ground),
            resist = listOf(Ice))

        object Steel : Element(
            weak = listOf(Ground, Fire, Fighting),
            effective = listOf(Ice, Rock),
            resist = listOf(Psychic, Dragon, Steel, Bug,
                Ice, Normal, Grass, Flying, Rock))

        object Rock : Element(
            weak = listOf(Ground, Water, Grass, Steel, Fighting),
            effective = listOf(Ice, Fire, Bug, Flying),
            resist = listOf())

        object Poison : Element(
            weak = listOf(Ground, Psychic),
            effective = listOf(Grass),
            resist = listOf(Poison, Bug, Fighting, Grass))

        object Flying : Element(
            weak = listOf(Rock, Ice, Electric),
            effective = listOf(Grass, Fighting, Bug),
            resist = listOf(Grass, Fighting, Bug),
            immune = listOf(Ground))

        object Dark : Element(
            weak = listOf(Fighting, Bug),
            effective = listOf(Psychic, Ghost),
            resist = listOf(Psychic, Dark, Ghost))

        object Normal : Element(
            weak = listOf(Fighting),
            effective = listOf(),
            resist = listOf(),
            immune = listOf(Ghost))

        object Ghost : Element(
            weak = listOf(Ghost, Dark),
            effective = listOf(Psychic, Ghost),
            resist = listOf(Poison, Bug),
            immune = listOf(Normal, Fighting))

        object Fighting : Element(
            weak = listOf(Flying, Psychic),
            effective = listOf(Ice, Rock, Steel, Normal, Dark),
            resist = listOf(Dark, Rock, Bug))

        object Dragon : Element(
            weak = listOf(Dragon, Ice),
            effective = listOf(Dragon),
            resist = listOf(Fire, Water, Electric, Grass))

        object Bug : Element(
            weak = listOf(Rock, Fire, Flying),
            effective = listOf(Psychic, Grass, Dark),
            resist = listOf(Fighting, Grass, Ground))

        object Psychic : Element(
            weak = listOf(Bug, Dark, Ghost),
            effective = listOf(Fighting, Poison),
            resist = listOf(Psychic, Fighting))

        fun getEffectiveMultiplier(attackElement : Element) : Float {
            return if (immune != null && immune.contains(attackElement))
                0.0f
            else if (resist.contains(attackElement))
                0.5f
            else if (weak.contains(attackElement))
                2.0f
            else
                1.0f
        }
    }
}

fun attack(pokemonA : Pokemon, pokemonD : Pokemon){

    val damage = pokemonA.movePower*(pokemonA.attackPower/pokemonD.defencePower.toFloat())
    val effectiveMultiplier = pokemonD.elementType.getEffectiveMultiplier(pokemonA.elementType)

    println("\n ${pokemonA.name} attacks ${pokemonD.name}.")
    println("It did ${damage*effectiveMultiplier} points of damage.")
    println(when(effectiveMultiplier){
        0.0f -> "${pokemonD.name} is immune."
        0.5f -> "It was not effective"
        2.0f -> "It was super effective"
        else -> ""
    })
}