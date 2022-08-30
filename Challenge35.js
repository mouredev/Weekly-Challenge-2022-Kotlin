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

/* 
Agua: Agua 0.5, Fuego 2, Planta 0.5, Electrivo = 1
Fuego: Agua 0.5, Fuego 0.5, Planta 2, Electrico 1
Planta: Agua 2, Fuego 0.5, Planta 0.5, Electrico 1
Electrico: Agua 2, Fuego 1, Planta .,5, Electrico 0.5
 */

const calcDmg = (
  atacantType = undefined,
  defensorType = undefined,
  dmg = undefined,
  def = undefined
) => {
  //Comprobaciones
  if (
    atacantType === undefined ||
    defensorType === undefined ||
    dmg === undefined ||
    def === undefined
  )
    return console.error("Debes rellenar todos los campos");
  if (
    atacantType != "Agua" &&
    atacantType != "Fuego" &&
    atacantType != "Planta" &&
    atacantType != "Electrico"
  )
    return console.error(
      "Los valores de atacantType solo pueden ser Agua, Fuego, Planta o Electrico"
    );
  if (
    defensorType != "Agua" &&
    defensorType != "Fuego" &&
    defensorType != "Planta" &&
    defensorType != "Electrico"
  )
    return console.error(
      "Los valores de defensorType solo pueden ser Agua, Fuego, Planta o Electrico"
    );
  if (typeof dmg != "number" || typeof def != "number")
    return console.error(
      "Los valores de dmg y def solo se pueden llenar con numeros"
    );
  if (dmg < 1 || dmg > 100 || def < 1 || def > 100)
    return console.error(
      "Los valores de dmg y def solo pueden estar comprendidos entre 1 y 100"
    );

  //Declaracion de constantes y variable
  const veryEffective = 2,
    neutral = 1,
    notVeryEffective = 0.5;

  let efectividad = neutral;

  //Comprobaciones para atacantType === "Agua"
  if (
    (atacantType === "Agua" && defensorType === "Agua") ||
    (atacantType === "Agua" && defensorType === "Planta")
  ) {
    efectividad = notVeryEffective;
  }
  if (atacantType === "Agua" && defensorType === "Fuego") {
    efectividad = veryEffective;
  }

  //Comprobaciones para atacantType === "Fuego"
  if (
    (atacantType === "Fuego" && defensorType === "Agua") ||
    (atacantType === "Fuego" && defensorType === "Fuego")
  ) {
    efectividad = notVeryEffective;
  }
  if (atacantType === "Fuego" && defensorType === "Planta") {
    efectividad = veryEffective;
  }

  //Comprobaciones para atacantType === "Planta"
  if (
    (atacantType === "Planta" && defensorType === "Fuego") ||
    (atacantType === "Planta" && defensorType === "Planta")
  ) {
    efectividad = notVeryEffective;
  }
  if (atacantType === "Planta" && defensorType === "Agua") {
    efectividad = veryEffective;
  }

  //Comprobaciones para atacantType === "Electrico"
  if (
    (atacantType === "Electrico" && defensorType === "Planta") ||
    (atacantType === "Electrico" && defensorType === "Electrico")
  ) {
    efectividad = notVeryEffective;
  }
  if (atacantType === "Electrico" && defensorType === "Agua") {
    efectividad = veryEffective;
  }

  let dmgDealt = 50 * (dmg / def) * efectividad;

  return console.info("El danho inflingido es de ", dmgDealt.toFixed());
};

calcDmg("Planta", "Fuego", 70, 55);
