/*
 * Crea un programa que calcule el daño de un ataque durante
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

const tiposDeEfectividad = {
    agua: { fuego: 2, planta: 0.5, electrico: 0.5, agua: 1 },
    fuego: { planta: 2, agua: 0.5, electrico: 1, fuego: 1 },
    planta: { agua: 2, fuego: 0.5,  electrico: 0.5, planta: 1 },
    electrico: { agua: 2, planta: 0.5, fuego: 1, electrico: 1 },
}

const calcularDamageInBattle = (tipoAtacante, tipoDefensor, ataque, defensa) => {

    if (!tiposDeEfectividad[tipoAtacante] || !tiposDeEfectividad[tipoAtacante][tipoDefensor]) {
        throw new Error("Tipo de Pokémon inválido");
    }

    const tipoEfectividad = tiposDeEfectividad[tipoAtacante][tipoDefensor];

    return 50 * ( ataque / defensa ) * tipoEfectividad;
    

}

console.log(calcularDamageInBattle("agua", "electrico", 40, 70));
console.log(calcularDamageInBattle("agua", "fuego", 80, 50)); // Daño esperado alto (súper efectivo)
console.log(calcularDamageInBattle("fuego", "agua", 60, 70)); // Daño esperado bajo (no muy efectivo)
console.log(calcularDamageInBattle("planta", "planta", 90, 90)); // Daño esperado neutro (x1)