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
 */

enum Type { water, fire, grass, electric }

Map<Type, Map<Type, double>> attackMultiplier = {
  Type.water: {
    Type.water: 0.5,
    Type.fire: 2.0,
    Type.grass: 0.5,
    Type.electric: 1.0
  },
  Type.fire: {
    Type.water: 0.5,
    Type.fire: 0.5,
    Type.grass: 2.0,
    Type.electric: 1.0
  },
  Type.grass: {
    Type.water: 2.0,
    Type.fire: 0.5,
    Type.grass: 0.5,
    Type.electric: 1.0
  },
  Type.electric: {
    Type.water: 2.0,
    Type.fire: 1.0,
    Type.grass: 0.5,
    Type.electric: 0.5
  }
};

void main() {
  print(calculateDamage(
      attackerType: Type.water,
      defenderType: Type.fire,
      attack: 1,
      defense: 1));

  print(calculateDamage(
      attackerType: Type.electric,
      defenderType: Type.electric,
      attack: 80,
      defense: 100));

  print(calculateDamage(
      attackerType: Type.grass,
      defenderType: Type.electric,
      attack: -10,
      defense: 20));
}

double? calculateDamage(
   {required Type attackerType,
    required Type defenderType,
    required double attack,
    required double defense}) {
      
  if (attack < 1 || attack > 100) {
    print('El ataque debe estar entre 1 y 100.');
    return null;
  }

  if (defense < 1 || defense > 100) {
    print('La defensa debe estar entre 1 y 100.');
    return null;
  }

  double multiplier = attackMultiplier[attackerType]![defenderType]!;

  return 50 * attack / defense * multiplier;
}
