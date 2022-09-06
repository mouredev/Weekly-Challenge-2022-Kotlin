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

const batalla = (bondadosas = undefined, malvadas = undefined) => {
  //Comprobaciones
  if (bondadosas === undefined || malvadas === undefined)
    return console.warn("Debes rellenar los ejercitos");
  if (!(bondadosas instanceof Array))
    return console.warn(`${bondadosas} debe introducirse como array`);
  if (!(malvadas instanceof Array))
    return console.warn(`${malvadas} debe introducirse como array`);
  if (bondadosas.length === 0)
    return console.warn(`No hay unidades bondadosas`);
  if (malvadas.length === 0) return console.warn(`No hay unidades malvadas`);
  for (let value of bondadosas) {
    if (
      value !== "Peloso" &&
      value !== "Surenho bueno" &&
      value !== "Enano" &&
      value !== "Numeroneano" &&
      value !== "Elfo"
    )
      return console.error(`${value} no es un guerrero valido`);
  }
  for (let value of malvadas) {
    if (
      value !== "Sureno malo" &&
      value !== "Orco" &&
      value !== "Goblin" &&
      value !== "Huargo" &&
      value !== "Troll"
    )
      return console.error(`${value} no es un guerrero valido`);
  }

  //Resolucion
  let recuentoBondadosas = 0,
    recuentoMalvadas = 0;

  bondadosas.forEach((element) => {
    switch (element) {
      case "Peloso":
        recuentoBondadosas++;
        break;
      case "Surenho bueno":
        recuentoBondadosas += 2;
        break;
      case "Enano":
        recuentoBondadosas += 3;
        break;
      case "Numeroneano":
        recuentoBondadosas += 4;
        break;
      case "Elfo":
        recuentoBondadosas += 5;
        break;
    }
  });

  malvadas.forEach((element) => {
    switch (element) {
      case "Sureno malo":
        recuentoMalvadas += 2;
        break;
      case "Orco":
        recuentoMalvadas += 2;
        break;
      case "Goblin":
        recuentoMalvadas += 2;
        break;
      case "Huargo":
        recuentoMalvadas += 3;
        break;
      case "Troll":
        recuentoMalvadas += 5;
        break;
    }
  });

  return recuentoBondadosas > recuentoMalvadas
    ? console.log(`${bondadosas} ganan contra ${malvadas}`)
    : console.log(`${malvadas} ganan contra ${bondadosas}`);
};

batalla(
  ["Peloso", "Elfo", "Surenho bueno", "Enano", "Numeroneano"],
  ["Sureno malo", "Orco", "Goblin", "Huargo", "Troll"]
);

batalla(["Peloso"], ["Orco"]);
