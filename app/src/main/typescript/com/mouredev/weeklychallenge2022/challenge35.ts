/**
 * Enunciado: Crea un programa que calcule el daño de un ataque durante
 * una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico 
 *   (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
 */

enum TipoPokemon {
    AGUA = 'Agua',
    FUEGO = 'Fuego',
    PLANTA = 'Planta',
    ELECTRICO = 'Electrico'
}


function calculateDamage(tipoAtaque: TipoPokemon, tipoDefensivo: TipoPokemon, valorAtaque: number, valorDefensa: number): Object {

    if (valorAtaque < 1 && valorAtaque > 100) throw new Error('El valor de ataque debe estar entre 0 y 100')
    if (valorDefensa < 1 && valorDefensa > 100) throw new Error('El valor de defensa debe estar entre 0 y 100')

    let efectividad = 0
    let damage = 0

    // definicion de la efectividad del ataque del tipo agua
    if (tipoAtaque === TipoPokemon.AGUA && tipoDefensivo === TipoPokemon.FUEGO) {
        efectividad = 2
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else if (tipoAtaque === TipoPokemon.AGUA && tipoDefensivo === TipoPokemon.PLANTA) {
        efectividad = 0.5
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else if (tipoAtaque === TipoPokemon.AGUA && tipoDefensivo === TipoPokemon.AGUA) {
        efectividad = 0.5
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else {
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    }

    // definicion de la efectividad del ataque del tipo fuego
    if (tipoAtaque === TipoPokemon.FUEGO && tipoDefensivo === TipoPokemon.PLANTA) {
        efectividad = 2
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else if (tipoAtaque === TipoPokemon.FUEGO && tipoDefensivo === TipoPokemon.FUEGO) {
        efectividad = 0.5
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else if (tipoAtaque === TipoPokemon.FUEGO && tipoDefensivo === TipoPokemon.AGUA) {
        efectividad = 0.5
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else {
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    }

    // definicion de la efectividad del ataque del tipo planta
    if (tipoAtaque === TipoPokemon.PLANTA && tipoDefensivo === TipoPokemon.AGUA) {
        efectividad = 2
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else if (tipoAtaque === TipoPokemon.PLANTA && tipoDefensivo === TipoPokemon.FUEGO) {
        efectividad = 0.5
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else if (tipoAtaque === TipoPokemon.PLANTA && tipoDefensivo === TipoPokemon.PLANTA) {
        efectividad = 0.5
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else {
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    }

    // definicion de la efectividad del ataque del tipo electrico
    if (tipoAtaque === TipoPokemon.ELECTRICO && tipoDefensivo === TipoPokemon.AGUA) {
        efectividad = 2
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else if (tipoAtaque === TipoPokemon.ELECTRICO && tipoDefensivo === TipoPokemon.PLANTA) {
        efectividad = 0.5
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else if (tipoAtaque === TipoPokemon.ELECTRICO && tipoDefensivo === TipoPokemon.ELECTRICO) {
        efectividad = 0.5
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    } else {
        damage = 50 * (valorAtaque / valorDefensa) * efectividad
    }


    console.log({ damage, efectividad })

    return { damage }
}


