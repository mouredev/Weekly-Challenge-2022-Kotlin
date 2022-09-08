/*
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales
 * a Sauron contra otras bondadosas que no quieren que el mal reine
 * sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3),
 *   Númenóreanos (4), Elfos (5)
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2),
 *   Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre
 * los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate.
 *   Dependiendo de la suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable
 *   de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco
 *     2 Pelosos empatan contra 1 Orco
 *     3 Pelosos ganan a 1 Orco
 */

export enum RazasBuenas {
    'Pelosos' = 1,
    'Sureños buenos',
    'Enanos',
    'Númenóreanos',
    'Elfos'
}


export enum RazasMalas {
    'Sureños malos' = 2,
    'Orcos' = 2,
    'Goblins' = 2,
    'Huargos' = 3,
    'Trolls' = 5
}

export const MESSAGES: Record<number, string> = {
    '-1': 'Vence el mal',
    0: 'No quedaron vencedores',
    1: 'Vence el bien'
}


export type EjercitoDelBien = RazasBuenas[];
export type EjercitoDelMal = RazasMalas[];
   
export const Batalla = (bien: EjercitoDelBien, mal: EjercitoDelMal): string => {
    
    const totales = {
        bien: bien.reduce((prev, curr) => prev = prev + curr) + bien.length,
        mal: mal.reduce((prev, curr) => prev = prev + curr) + mal.length
    }

    console.info(totales);
    
    return MESSAGES[
        Number(totales.bien >  totales.mal
            ? true 
            : (totales.bien <  totales.mal ? -1 : false))];
}

console.log(
    Batalla(
        [
            RazasBuenas.Elfos,
            RazasBuenas.Pelosos,
            RazasBuenas.Pelosos
        ],
        [
            RazasMalas.Goblins,
            RazasMalas["Sureños malos"],
            RazasMalas.Orcos,
            RazasMalas.Huargos
        ]
    )
);
