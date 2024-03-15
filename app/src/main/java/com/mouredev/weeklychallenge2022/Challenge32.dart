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

import 'dart:math'; //Para listas aleatoreas

num secondMax(List<num> list) {
  if (list.isEmpty) throw Exception("lista vacia");
  List<num> maxs = List<num>.filled(2, list.first);
  for (var n in list) {
    if (maxs.last < n) {
      maxs.first = maxs.last;
      maxs.last = n;
    } else if (maxs.first < n || maxs.first == maxs.last) maxs.first = n;
  }
  return maxs.first;
}

void main(List<String> args) {
  Random rand = Random();
  List<num> list =
      List<num>.generate(rand.nextInt(25), (index) => rand.nextInt(100));

  print(list);
  try {
    print(secondMax(list));
  } catch (e) {
    print(e);
  }
}
