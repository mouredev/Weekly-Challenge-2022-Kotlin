/*
 * Reto #32
 * EL SEGUNDO
 * Fecha publicación enunciado: 08/08/22
 * Fecha publicación resolución: 15/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un listado de números, encuentra el SEGUNDO más grande.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en https://retosdeprogramacion.com/semanales2022.
 *
 */

void main() {
  List<double> numberList1 = [-5, -2.1, 0, -10, -0.1];
  List<double> numberList2 = [0, 1.5, 8, 8, 12, 12, 4.5, -1.1];

  secondLargest(numberList1);
  secondLargest(numberList2);

  secondLargestWithoutSort(numberList1);
  secondLargestWithoutSort(numberList2);
}

// solution
void secondLargest(List<double> numberList) {
  // delete duplicates
  numberList = numberList.toSet().toList();

  numberList.sort((n1, n2) => n2.compareTo(n1));
  print(numberList[1]);
}

// other solution
void secondLargestWithoutSort(List<double> numberList) {
  double largestNumber = -double.infinity;
  double secondNumber = -double.infinity;

  numberList.forEach((nextNumber) {
    if (nextNumber > largestNumber) {
      secondNumber = largestNumber;
      largestNumber = nextNumber;
    } else if (nextNumber < largestNumber && nextNumber > secondNumber) {
      secondNumber = nextNumber;
    }
  });

  print(secondNumber);
}
