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
  print(sexagenaryCycle(1922));
  print(sexagenaryCycle(1923));
  print(sexagenaryCycle(1924));
  print(sexagenaryCycle(1925));
  print(sexagenaryCycle(1926));
}

List<String> sexagenaryCycle(int year) {
  List<String> elements = ['madera', 'fuego', 'tierra', 'metal', 'agua'];
  List<String> animals = [
    'rata',
    'buey',
    'tigre',
    'conejo',
    'dragón',
    'serpiente',
    'caballo',
    'oveja',
    'mono',
    'gallo',
    'perro',
    'cerdo'
  ];

  int originYear = 1924;

  int animalIndex = (year - originYear) % animals.length;
  int elementIndex = ((year - originYear) / 2).floor() % elements.length;

  return [animals[animalIndex], elements[elementIndex]];
}
