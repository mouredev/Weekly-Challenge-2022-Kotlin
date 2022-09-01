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

void main() {
  print(damage(pokeType.Water, pokeType.Water, 100, 100));
  print(damage(pokeType.Water, pokeType.Fire, 20, 50));
  print(damage(pokeType.Plant, pokeType.Electric, 35, 70));
  print(damage(pokeType.Electric, pokeType.Water, 100, 40));
}

damage(pokeType attaker, pokeType defender, int attack, int defense) {
  double damage = 50 * (attack / defense) * attaker.getEffectiveness(defender);
  return damage;
}

enum pokeType {
  Water,
  Fire,
  Plant,
  Electric,
}

Map<String, double> effectiveness = {
  'Water-Water': 1,
  'Water-Fire': 2,
  'Water-Plant': 0.5,
  'Water-Electric': 0.5,
  'Fire-Water': 0.5,
  'Fire-Fire': 1,
  'Fire-Plant': 2,
  'Fire-Electric': 0.5,
  'Plant-Water': 1,
  'Plant-Fire': 0.5,
  'Plant-Plant': 1,
  'Plant-Electric': 0.5,
  'Electric-Water': 2,
  'Electric-Fire': 1,
  'Electric-Plant': 2,
  'Electric-Electric': 1,
};

extension pokeTypeExtension on pokeType {
  String get string {
    switch (this) {
      case pokeType.Water:
        return 'Water';
      case pokeType.Plant:
        return 'Plant';
      case pokeType.Fire:
        return 'Fire';
      case pokeType.Electric:
        return 'Electric';
    }
  }

  String getString(pokeType poke) {
    switch (poke) {
      case pokeType.Water:
        return 'Water';
      case pokeType.Plant:
        return 'Plant';
      case pokeType.Fire:
        return 'Fire';
      case pokeType.Electric:
        return 'Electric';
    }
  }

  double getEffectiveness(pokeType enemyType) {
    return effectiveness['${this.string}-${this.getString(enemyType)}']!;
  }
}
