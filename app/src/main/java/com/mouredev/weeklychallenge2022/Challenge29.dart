/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

import 'dart:math'; // para randomizar listas

void main(List<String> args) {
//Imprimir barras para un vistazo rápido
  printBars(List<int> list, {String char = '*', bool showValue = false}) {
    print('----begin------');
    for (var bar in list)
      print('${(bar >= 0 ? char : '#') * bar.abs()} ${showValue ? bar : ''}');
    print('----end--------');
  }

//Bubble Sort-------------------------------------------------------------------
  List<int> bubbleSort(List<int> input, {bool asc = true}) {
    List<int> ordered = List<int>.from(input);
    bool change = true;
    int end = input.length - 1;
    while (end > 0 && change) {
      change = false;
      for (int i = 0; i < end; i++) {
        if (asc ? ordered[i] <= ordered[i + 1] : ordered[i] >= ordered[i + 1])
          continue;
        int temp = ordered[i + 1];
        ordered[i + 1] = ordered[i];
        ordered[i] = temp;
        change = true;
      }
      end--;
    }

    return ordered;
  }

//Cocktail Sort-----------------------------------------------------------------
  List<int> cocktailSort(List<int> input, {bool asc = true}) {
    List<int> ordered = List<int>.from(input);
    bool change = true;
    int end = input.length - 1;
    int start = 0;
    while (end != start && change) {
      change = false;
      //Igual que BubbleSort (llevando el ultimo al final)
      for (int i = start; i < end; i++) {
        if (asc ? ordered[i] <= ordered[i + 1] : ordered[i] >= ordered[i + 1])
          continue;
        int temp = ordered[i + 1];
        ordered[i + 1] = ordered[i];
        ordered[i] = temp;
        change = true;
      }
      //Reccorrido hacia atras con ordenamiento invesrso (llevando el primero al inicio)
      for (int i = end; i > start; i--) {
        if (asc ? ordered[i - 1] <= ordered[i] : ordered[i - 1] >= ordered[i])
          continue;
        int temp = ordered[i - 1];
        ordered[i - 1] = ordered[i];
        ordered[i] = temp;
        change = true;
      }
      //centro los extremos
      start++;
      end--;
    }

    return ordered;
  }

  //Insertion Sort--------------------------------------------------------------
  List<int> insertionSort(List<int> input, {bool asc = true}) {
    List<int> ordered = List<int>.from(input);
    for (var i = 0; i < ordered.length; i++) {
      int current = ordered[i];
      for (var j = i - 1; j >= 0; j--) {
        if (asc ? ordered[j] <= current : ordered[j] >= current) {
          ordered[j + 1] = current;
          break;
        }
        ordered[j + 1] = ordered[j];
        ordered[j] = current;
      }
    }
    return ordered;
  }

//Counting Sort--------------------------------------------------------------
  List<int> countingSort(List<int> input, {bool asc = true}) {
    List<int> ordered = [];
    //Determinar maximo y minimo
    int max = input.first;
    int min = input.first;
    for (var i = 0; i < input.length; i++) {
      if (max < input[i]) {
        max = input[i];
      } else if (min > input[i]) {
        min = input[i];
      }
    }
    //crear vector de rango entre maximo (inclusive) y minimo
    List<int> count = List<int>.filled(max + 1 - min, 0, growable: false);
    //contar apariciones
    for (int value in input) count[value - min]++;
    //Crear lista ordenada
    if (asc) {
      for (var i = 0; i < count.length; i++) {
        if (count[i] == 0) continue;
        ordered.addAll(List<int>.generate(count[i], (_) => i + min));
      }
    } else {
      for (var i = count.length - 1; i >= 0; i--) {
        if (count[i] == 0) continue;
        ordered.addAll(List<int>.generate(count[i], (_) => i + min));
      }
    }

    return ordered;
  }

//Merge Sort--------------------------------------------------------------
  List<int> mergeSort(List<int> input, {bool asc = true}) {
    List<int> ordered = List<int>.from(input);
    //Dividir en listas a la mitad hasta que sean de logitud 1
    if (ordered.length <= 1) return ordered;
    int trunk = ordered.length ~/ 2;
    List<int> left = mergeSort(ordered.sublist(0, trunk));
    List<int> right = mergeSort(ordered.sublist(trunk, ordered.length));

    //Mezclar las listas odenando los elementos
    List<int> merged = [];
    while (left.isNotEmpty || right.isNotEmpty) {
      int take;
      //Ordeno al reves e invierto al final por rendimiento para ascendente
      if (left.isEmpty) {
        take = right.removeLast();
      } else if (right.isEmpty) {
        take = left.removeLast();
      } else {
        take =
            (left.last > right.last) ? left.removeLast() : right.removeLast();
      }
      merged.add(take);
    }
    //Usado el reversed para no eliminar primeros elementos de la lista y evitar que recalcule el tamaño
    return asc ? merged.reversed.toList() : merged;
  }

  //MAIN-----------------------------------------------------------------------
  Random rng = Random();
  List<int> disordered = List<int>.generate(
    50,
    (index) => rng.nextInt(100),
  );

  print('Input: $disordered');

  print('Bubble Sort:');
  printBars(bubbleSort(disordered, asc: true));
  print(bubbleSort(disordered, asc: true));

  print('Cocktail Sort:');
  printBars(cocktailSort(disordered, asc: false));
  print(cocktailSort(disordered, asc: false));

  print('Insertion Sort:');
  printBars(insertionSort(disordered, asc: false));
  print(insertionSort(disordered, asc: false));

  print('Counting Sort:');
  printBars(countingSort(disordered, asc: true));
  print(countingSort(disordered, asc: true));

  print('Merged Sort:');
  printBars(mergeSort(disordered, asc: false));
  print(mergeSort(disordered, asc: false));
}
