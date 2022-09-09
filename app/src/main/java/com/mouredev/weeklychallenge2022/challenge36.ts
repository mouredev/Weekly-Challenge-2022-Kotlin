/*
 * Reto #36
 * LOS ANILLOS DE PODER
 * Fecha publicación enunciado: 06/09/22
 * Fecha publicación resolución: 14/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: ¡La Tierra Media está en guerra! En ella lucharán razas leales a Sauron
 * contra otras bondadosas que no quieren que el mal reine sobre sus tierras.
 * Cada raza tiene asociado un "valor" entre 1 y 5:
 * - Razas bondadosas: Pelosos (1), Sureños buenos (2), Enanos (3), Númenóreanos (4), Elfos (5)
 * - Razas malvadas: Sureños malos (2), Orcos (2), Goblins (2), Huargos (3), Trolls (5)
 * Crea un programa que calcule el resultado de la batalla entre los 2 tipos de ejércitos:
 * - El resultado puede ser que gane el bien, el mal, o exista un empate. Dependiendo de la
 *   suma del valor del ejército y el número de integrantes.
 * - Cada ejército puede estar compuesto por un número de integrantes variable de cada raza.
 * - Tienes total libertad para modelar los datos del ejercicio.
 * Ej: 1 Peloso pierde contra 1 Orco, 2 Pelosos empatan contra 1 Orco, 3 Pelosos ganan a 1 Orco.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

/**
 * Enumerado que representa las razas libres de la Tierra Media.
 */
export enum FreeLegion {
  harfoots = 1,
  freevariags = 2,
  dwarves = 3,
  númenóreans = 4,
  elves = 5,
}


/**
 * Enumerado que representa las razas oscuras de la Tierra Media leales a Sauron.
 */
export enum DarkLegion {
  darkvariags = 2,
  orcs = 2,
  goblins = 2,
  wargs = 3,
  trolls = 5,
}

/**
 * Enumerado que representa el resultado de la batalla.
 */
export enum BattleResult {
  Tie = 0,
  FreeLegion = 1,
  DarkLegion = 2,
}


/**
 * Función que calcula el resultado de la batalla entre los 2 ejércitos.
 * @param freeLegion Ejército de razas libres.Array con el número de integrantes de cada raza.
 * @param darkLegion Ejército de razas oscuras.Array con el número de integrantes de cada raza.
 * @returns Resultado de la batalla.BattleResult enum
 */
export function middleEarthBattle(
  freeLegion: FreeLegion[],
  darkLegion: DarkLegion[]
): BattleResult {
  let freeArmyValue = 0;
  let darkArmyValue = 0;

  freeLegion.forEach((legion) => {
    freeArmyValue += legion;
  });

  darkLegion.forEach((legion) => {
    darkArmyValue += legion;
  });
  darkArmyValue = darkArmyValue + darkLegion.length;
  freeArmyValue = freeArmyValue + freeLegion.length;

  if (freeArmyValue > darkArmyValue) {
    console.log("Free Legion Win");
    return BattleResult.FreeLegion;
  } else if (freeArmyValue < darkArmyValue) {
    console.log("Dark Legion Win");
    return BattleResult.DarkLegion;
  } else {
    console.log("it's a Tie");
    return BattleResult.Tie;
  }
}


let result = middleEarthBattle([FreeLegion.harfoots,FreeLegion.dwarves], [DarkLegion.orcs,DarkLegion.trolls]);
console.log(result);