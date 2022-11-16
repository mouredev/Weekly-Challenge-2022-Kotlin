/*
package com.mouredev.weeklychallenge2022

 * Reto #46
 * ¿DÓNDE ESTÁ EL ROBOT?
 * Fecha publicación enunciado: 14/10/22
 * Fecha publicación resolución: 21/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Calcula dónde estará un robot (sus coordenadas finales) que se encuentra en una cudrícula
 * representada por los ejes "x" e "y".
 * - El robot comienza en la coordenada (0, 0).
 * - Para idicarle que se mueva, le enviamos un array formado por enteros (positivos o negativos)
 *   que indican la secuencia de pasos a dar.
 *  - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene, luego 5, se detiene,
 *    y finalmente 2. El resultado en este caso sería (x: -5, y: 12)
 * - Si el número de pasos es negativo, se desplazaría en sentido contrario al que está mirando.
 * - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando hacia la parte
 *   positiva del eje "y".
 * - El robot tiene un fallo en su programación: cada vez que finaliza una secuencia de pasos gira
 *   90 grados en el sentido contrario a las agujas del reloj.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

enum Direction {
  NORTH(0),
  WEST(1),
  SOUTH(2),
  EAST(3);

  const Direction(this.value);
  final num value;
}

Direction nextDirection(Direction direction) {
  return direction == Direction.EAST
      ? Direction.NORTH
      : Direction.values[direction.index + 1];
}

Map<String, int> calculateCoordinates(Iterable<int> movements) {
  var x = 0;
  var y = 0;

  var direction = Direction.NORTH;

  movements.forEach((movement) {
    switch (direction) {
      case Direction.NORTH:
        y += movement;
        break;
      case Direction.WEST:
        x -= movement;
        break;
      case Direction.SOUTH:
        y -= movement;
        break;
      case Direction.EAST:
        x += movement;
        break;
    }

    direction = nextDirection(direction);
  });

  return {'x': x, 'y': y};
}

void testCase(Iterable<int> movements, int expectedX, int expectedY) {
  var coordinate = calculateCoordinates(movements);
  var movementsInList = movements.toList();

  if (coordinate['x'] != expectedX) {
    throw Exception(
        "Case with coordinate '${movementsInList}', returns ${coordinate["x"]} but it should be $expectedX");
  } else if (coordinate['y'] != expectedY) {
    throw Exception(
        "Case with coordinate '${movementsInList}', returns ${coordinate["y"]} but it should be $expectedY");
  }

  print("Coodinates '${coordinate}' with moovements '${movementsInList}'");
}

void main() {
  testCase(<int>[10, 5, -2], -5, 12);
  testCase(<int>[0, 5, -2, 6, 5, -4], 5, 7);
  testCase(<int>[], 0, 0);
  testCase(<int>[10], 0, 10);
  testCase(<int>[10, 10], -10, 10);
  testCase(<int>[3, -2, 4, 6, 9, 2, 1, 2, 3, 4], 4, 10);
}
