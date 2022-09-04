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


/*
    Pokemon effectiveness from: 
    https://pokemon.fandom.com/es/wiki/Tipos_elementales#cite_note-6
*/

function validateInputs(attacker_pokemon, defender_pokemon, attack, defense) {
    const pokemon_types = ["water", "fire", "plant", "electric"];
    if (!pokemon_types.includes(attacker_pokemon) ) {
        throw new Error("Incorrect pokemon attacker");
    }

    if (!pokemon_types.includes(defender_pokemon)) {
        throw new Error("Incorrect pokemon defender");
    } 

    if (attack < 1 || attack > 100) {
        throw new Error("Incorrect attack value");
    } 

    if (defense < 1 || defense > 100) {
        throw new Error("Incorrect defense value");
    } 

  
}
function getPokemonDamage(attacker_pokemon, defender_pokemon, attack, defense) {
    validateInputs(attacker_pokemon, defender_pokemon, attack, defense);
    const effectiveness = {
        water: {
            fire: 2,
            water: 0.5,
            plant: 0.5,
            electric: 1
        },

        fire: {
            fire: 0.5,
            water: 0.5,
            plant: 2,
            electric: 1
        },

        plant: {
            fire: 0.5,
            water: 2,
            plant: 0.5,
            electric: 1
        },

        electric: {
            fire: 1,
            water: 2,
            plant: 0.5,
            electric: 0.5
        }
    };

    const attacker_type = effectiveness[attacker_pokemon];
    const attacker_effectiveness = attacker_type[defender_pokemon];

    const damage = 50 * (attack / defense) * attacker_effectiveness;

    return damage;
}

// Values for function
let attacker_pokemon = "electric";
let defender_pokemon = "fire";
let attack = 10;
let defense = 50;

// Result from function
let damage = getPokemonDamage(attacker_pokemon, defender_pokemon, attack, defense);

// Show damage
console.log(damage);
