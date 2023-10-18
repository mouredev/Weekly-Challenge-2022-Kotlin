/*
 * Reto #39
 * TOP ALGORITMOS: QUICK SORT
 * Fecha publicación enunciado: 27/09/22
 * Fecha publicación resolución: 03/10/22
 * Dificultad: MEDIA
 *
 * Enunciado: Implementa uno de los algoritmos de ordenación más famosos: el "Quick Sort",
 * creado por C.A.R. Hoare.
 * - Entender el funcionamiento de los algoritmos más utilizados de la historia nos ayuda a
 *   mejorar nuestro conocimiento sobre ingeniería de software. Dedícale tiempo a entenderlo,
 *   no únicamente a copiar su implementación.
 * - Esta es una nueva serie de retos llamada "TOP ALGORITMOS", donde trabajaremos y entenderemos
 *   los más famosos de la historia.
 */

import 'dart:math';

void main() {
  List<int> list = List.generate(10, (index) => index);
  list.shuffle();  
  print('- Lista desordenada: $list');
  print('- Lista ordenada:    ${quickSort(list)}');
  print('');

  Random random = new Random();
  list = new List.generate(10, (_) => random.nextInt(10));
  print('- Lista desordenada: $list');
  print('- Lista ordenada:    ${quickSort(list)}');
}

List<int> quickSort(List<int> unsortedList) {
  final int listLength = unsortedList.length;

  if (listLength < 2) {
     return unsortedList;

  } else {
    final int pivot = unsortedList[0];
    
    List<int> smallerList = [];
    List<int> greaterList = [];

    for (int index = 1; index < listLength; index++) {
      int value = unsortedList[index];

      if (value > pivot) {
        greaterList.add(value);
      } else {
        smallerList.add(value);
      }
    }

    smallerList = quickSort(smallerList);
    greaterList = quickSort(greaterList);

    return smallerList + [pivot] + greaterList;
  }  
}