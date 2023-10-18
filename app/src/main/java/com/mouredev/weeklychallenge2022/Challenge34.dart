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
  print(lostNumbers([2, 5, 6, 7, 10]));
  print(lostNumbers([-2, 0, 2, 5]));

  try {
    print(lostNumbers([0, 2, 5, 5]));
  } catch (e) {
    print(e);
  }
}

List<int> lostNumbers(List<int> inputList) {
  List<int> lostNumbersList = [];

  for (int index = 0; index < inputList.length - 1; index++) {
    int inputNumber = inputList[index];
    int nextInputNumber = inputList[index + 1];

    // check order and repetitions
    if (inputNumber >= nextInputNumber) {
      throw FormatException(
          "El array de entrada debe estar ordenado de forma ascendente y "
          "no puede tener repeticiones");
    }

    for (int lostNumber = inputNumber + 1; lostNumber < nextInputNumber; lostNumber++) {
      lostNumbersList.add(lostNumber);
    }
  }

  return lostNumbersList;
}
