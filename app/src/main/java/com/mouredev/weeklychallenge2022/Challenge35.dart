// Reto #35
// BATALLA POKÉMON
// Fecha publicación enunciado: 29/08/22
// Fecha publicación resolución: 06/09/22
// Dificultad: MEDIA
//  *
// Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
// - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
// - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
// - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
// - El programa recibe los siguientes parámetros:
//  - Tipo del Pokémon atacante.
//  - Tipo del Pokémon defensor.
//  - Ataque: Entre 1 y 100.
//  - Defensa: Entre 1 y 100.
//  *
// Información adicional:
// - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
//   para preguntas, dudas o prestar ayuda a la comunidad.
// - Tienes toda la información sobre los retos semanales en
//   https://retosdeprogramacion.com/semanales2022.

enum Type { water, fire, plant, electric }

Map<Type, Map<Type, double>> _effectivenessMultiplier = {
  Type.water: {
    Type.water: 0.5,
    Type.fire: 0.5,
    Type.plant: 2,
  },
  Type.fire: {
    Type.water: 2,
    Type.fire: 0.5,
    Type.plant: 0.5,
  },
  Type.plant: {
    Type.water: 0.5,
    Type.fire: 2,
    Type.plant: 0.5,
  },
  Type.electric: {
    Type.water: 2,
    Type.electric: 0.5,
  },
};

class Pokemon {
  // final int id;
  final Type type;
  final int attack;
  final int defense;
  // final int espAttack;
  // final int espDef;
  // final int speed;
  // final int hp;
  // final int maxHp;
  // final int level;
  // final int exp;
  // final List<Moves> moves;

  const Pokemon({
    // required this.id,
    required this.type,
    required this.attack,
    required this.defense,
    // required this.espAttack,
    // required this.espDef,
    // required this.speed,
    // required this.hp,
    // required this.maxHp,
    // required this.level,
    // required this.exp,
    // required this.moves,
  })  : assert(
            attack >= 1 && attack <= 100, 'Attack must be between 1 and 100'),
        assert(defense >= 1 && defense <= 100,
            'Defense must be between 1 and 100');
}

class Battle {
  final Pokemon pokeOne;
  final Pokemon pokeTwo;

  const Battle({
    required this.pokeOne,
    required this.pokeTwo,
  });

  double damage(Pokemon attacker, Pokemon defender) {
    double effectiveness =
        _effectivenessMultiplier[attacker.type]![defender.type] ?? 1;
    return 50 * (attacker.attack / defender.defense) * effectiveness;
  }
}
