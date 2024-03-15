/*
 * Reto #22
 * CONJUNTOS
 * Fecha publicación enunciado: 01/06/22
 * Fecha publicación resolución: 07/06/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba dos array, un booleano y retorne un array.
 * - Si el booleano es verdadero buscará y retornará los elementos comunes de los dos array.
 * - Si el booleano es falso buscará y retornará los elementos no comunes de los dos array.
 * - No se pueden utilizar operaciones del lenguaje que lo resuelvan directamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

void main(List<String> args) {
  List join(List listA, List listB, [bool union = true]) {
    List result = [];
    for (var element in listA) {
      if (listB.contains(element)) {
        if (!union) continue;
      } else {
        if (union) continue;
      }
      result.add(element);
    }
    if (!union) {
      for (var element in listB) {
        if (!listA.contains(element)) result.add(element);
      }
    }
    return result;
  }

  List list1 = [5.5, 'hola', true, 99];
  List list2 = [5.7, 'hola', false, true, 99];

  print(list1);
  print(list2);
  print(join(list1, list2, true));
  print(join(list1, list2, false));
}
