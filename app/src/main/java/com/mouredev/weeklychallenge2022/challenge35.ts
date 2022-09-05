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

export enum PokemonType {
    WATER = 'water',
    FIRE = 'fire',
    GRASS = 'grass',
    ELECTRIC = 'electric'
}

enum EffectivenessType {
    SUPER_EFFECTIVE = 2,
    NORMAL = 1,
    NOT_VERY_EFFECTIVE = 0.5
}

const DAMAGEMODIFIER = 50

const EFFECTIVENESS = {
    [PokemonType.WATER]: {
        [PokemonType.WATER]: EffectivenessType.NOT_VERY_EFFECTIVE,
        [PokemonType.FIRE]:  EffectivenessType.SUPER_EFFECTIVE,
        [PokemonType.GRASS]:  EffectivenessType.NOT_VERY_EFFECTIVE,
        [PokemonType.ELECTRIC]: EffectivenessType.NORMAL
    },
    [PokemonType.FIRE]: {
        [PokemonType.WATER]: EffectivenessType.NOT_VERY_EFFECTIVE,
        [PokemonType.FIRE]: EffectivenessType.NOT_VERY_EFFECTIVE,
        [PokemonType.GRASS]: EffectivenessType.SUPER_EFFECTIVE,
        [PokemonType.ELECTRIC]: EffectivenessType.NORMAL
    },
    [PokemonType.GRASS]: {
        [PokemonType.WATER]: EffectivenessType.SUPER_EFFECTIVE,
        [PokemonType.FIRE]: EffectivenessType.NOT_VERY_EFFECTIVE,
        [PokemonType.GRASS]: EffectivenessType.NOT_VERY_EFFECTIVE,
        [PokemonType.ELECTRIC]: EffectivenessType.NORMAL
    },
    [PokemonType.ELECTRIC]: {
        [PokemonType.WATER]: EffectivenessType.SUPER_EFFECTIVE,
        [PokemonType.FIRE]: EffectivenessType.NORMAL,
        [PokemonType.GRASS]: EffectivenessType.NOT_VERY_EFFECTIVE,
        [PokemonType.ELECTRIC]: EffectivenessType.NOT_VERY_EFFECTIVE
    }
}


export function calculatePokeDamage(attackerType: PokemonType, defenderType: PokemonType, attack: number, defense: number): number {

    if(attack < 1 || attack > 100) {
        console.log('Attack must be between 1 and 100')
        return 0
    }

    if(defense < 1 || defense > 100) {
        console.log('Defense must be between 1 and 100')
        return 0
    }

    let effectiveness = EFFECTIVENESS[attackerType][defenderType];
    return  DAMAGEMODIFIER * (attack / defense) * effectiveness;

}



console.log(calculatePokeDamage(PokemonType.WATER, PokemonType.FIRE, 50, 50))