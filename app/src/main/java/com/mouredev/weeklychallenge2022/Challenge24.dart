/*
 * Reto #24
 * ITERATION MASTER
 * Fecha publicación enunciado: 13/06/22
 * Fecha publicación resolución: 20/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Quiero contar del 1 al 100 de uno en uno (imprimiendo cada uno). ¿De cuántas maneras eres capaz de hacerlo? Crea el código para cada una de ellas.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

void main(List<String> args) {
  //Contar con enteros y bucle for
  void countFor(int from, int to) {
    for (; from <= to; print(from++));
  }

  //Contar con enteros y bucle while
  void countWhile(int from, int to) {
    while (from <= to) print(from++);
  }

  //Contar con enteros y recursion
  void countRecursion(int from, int to) {
    if (to > from) countRecursion(from, to - 1);
    print(to);
  }

  //Contar usando operaciones de bit
  void countBitOp(int from, int to) {
    while (from <= to) {
      print(from);
      int temp = 1;
      // mientras el OR sea menor o igual al actual
      //Ej1: 00101 (5) | 00001 (1) -> 00101 (5) <= 00101 (5)
      //Ej2: 00101 (5) | 00011 (3) -> 00111 (7) <= 00101 (5)
      while (from | temp <= from) {
        temp <<= 1; // Ej: 00001 (1) -> 00010 (2)
        temp |= 1; // Ej: 00010 (2) -> 00011 (3)
      }
      from ^= temp; // Ej: 00101 (5) ^ 00011 (3) -> 00110 (6)
    }
  }

//Contar usando una lista for-in
  void countForIn(int from, int to) {
    final List unnecessary = List.generate(to, (index) => from + index);
    for (var element in unnecessary) {
      print(element);
    }
  }

  //MAIN
  int from = 1;
  int to = 100;
  if (from > to) {
    int temp = from;
    from = to;
    to = temp;
  }

  // countFor(from, to);
  // countWhile(from, to);
  // countRecursion(from, to);
  // countBitOp(from, to);
  // countForIn(from, to);
}
