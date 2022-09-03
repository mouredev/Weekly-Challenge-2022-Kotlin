/*
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

const lstPokemon = [ "agua", "fuego", "planta", "electrico" ];

function atakePokemon(pk1, pk2, at, df) {
    let daño = efectividad = "";
    
    if (pk1 === "agua") {
        switch (pk2) {
            case "agua":
                efectividad = 0.5;
                break;
            case "fuego":
                efectividad = 0.5;
                break;
            case "planta":
                efectividad = 2;
                break;
            case "electrico":
                efectividad = 2;
                break;
            default:
                break;
        }
    } else if (pk1 === "fuego") {
        switch (pk2) {
            case "agua":
                efectividad = 2;
                break;
            case "fuego":
                efectividad = 0.5;
                break;
            case "planta":
                efectividad = 0.5;
                break;
            case "electrico":
                efectividad = 1;
                break;
            default:
                break;
        }
    } else if (pk1 === "planta") {
        switch (pk2) {
            case "agua":
                efectividad = 0.5;
                break;
            case "fuego":
                efectividad = 2;
                break;
            case "planta":
                efectividad = 0.5;
                break;
            case "electrico":
                efectividad = 0.5;
                break;
            default:
                break;
        }
    } else {
        switch (pk2) {
            case "agua":
                efectividad = 1;
                break;
            case "fuego":
                efectividad = 1;
                break;
            case "planta":
                efectividad = 1;
                break;
            case "electrico":
                efectividad = 0.5;
                break;
            default:
                break;
        }
    }
    daño = 50 * (at / df) * efectividad;
    console.log(`El pokemon ${pk1} ataca con ${at} a ${pk2} que se defiende ${df}, y le genera un daño de ${daño}. `)
    return daño; 
}

//Obtenemos el Ataque y la Defensa de forma aleatoria.
let getAt = () => { return Math.floor(Math.random() * (100) + 1) }
let getDf = () => { return Math.floor(Math.random() * (100) + 1) }

//Elegimos los pokemons aleatoriamente
//Math.floor(Math.random() * (max - min + 1) + min);
let getPokemonAt = () => {
    let temp = Math.floor(Math.random() * (3 - 0 + 1) + 0);
    return lstPokemon[temp];
}
let getPokemonDf = () => {
    let temp = Math.floor(Math.random() * (3 - 0 + 1) + 0);
    return lstPokemon[temp];
}

atakePokemon(getPokemonAt(), getPokemonDf(), getAt(), getDf());