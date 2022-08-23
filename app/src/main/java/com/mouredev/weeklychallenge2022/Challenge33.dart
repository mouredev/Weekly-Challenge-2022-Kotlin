/*
 * Reto #33
 * CICLO SEXAGENARIO CHINO
 * Fecha publicación enunciado: 15/08/22
 * Fecha publicación resolución: 22/08/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
 * en el ciclo sexagenario del zodíaco chino.
 * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
 *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
 *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

void main() {
  printCycleDetails(1983);
}

printCycleDetails(int year) {
  Map<int, String> animals = {
    1: 'Rat',
    2: 'Ox',
    3: 'Tiger',
    4: 'Rabbit',
    5: 'Dragon',
    6: 'Snake',
    7: 'Horse',
    8: 'Sheep',
    9: 'Monkey',
    10: 'Rooster',
    11: 'Dog',
    0: 'Pig',
  };

  Map<int, String> elements = {
    1: 'Wood',
    2: 'Fire',
    3: 'Earth',
    4: 'Metal',
    0: 'Water',
  };
  int elementIndex = ((year - 1983) / 2).ceil() % 5;
  int animalIndex = (year - 1983) % 12;
  String element = elements[elementIndex]!;
  String animal = animals[animalIndex]!;

  print('$animal - $element');
}
