/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

void main() {
  print(lostNumbers([11, 9, 7, 6, 5, 4, 2, 2]));
}

lostNumbers(List<int> numbers) {
  List<int> lostNumbers = [];
  List<int> originalNumbers = [];
  int size = numbers.length;
  if (numbers[0] > numbers[size - 1]) {
    numbers = numbers.reversed.toList();
  }
  int greater = numbers[size - 1];
  int smaller = numbers[0];
  List<int> values =
      List.generate(greater + 1 - smaller, (index) => index + smaller);
  int index = 0;
  for (int value in values) {
    if (originalNumbers.contains(numbers[0])) {
      throw 'The array must contain non-repeating values, but ${numbers[index]} is repeated';
    }
    if (numbers[0] == value) {
      originalNumbers.add(value);
      numbers.removeAt(0);
    } else {
      if (numbers[0] < originalNumbers[originalNumbers.length - 1] ||
          numbers[0] > greater) {
        throw 'You must provide an ordered array';
      }
      lostNumbers.add(value);
    }
  }
  print(numbers);
  if (numbers.length > 0)
    throw 'The array must contain non-repeating values, but ${numbers[0]} is repeated';
  return lostNumbers;
}
