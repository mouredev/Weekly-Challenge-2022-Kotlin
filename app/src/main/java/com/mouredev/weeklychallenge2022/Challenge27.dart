/*
 * Reto #27
 * VECTORES ORTOGONALES
 * Fecha publicación enunciado: 07/07/22
 * Fecha publicación resolución: 11/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que determine si dos vectores son ortogonales.
 * - Los dos array deben tener la misma longitud.
 * - Cada vector se podría representar como un array. Ejemplo: [1, -2]
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

void main(List<String> args) {
  List<double> vec1 = [2, 3, 1];
  List<double> vec2 = [3, -2, 2];

  bool areOrthogonal(List<double> v1, List<double> v2) {
    if (v1.length != v2.length) return false;
    double result = 0.0;
    for (var i = 0; i < v1.length; i++) result += v1[i] * v2[i];
    return result == 0.0;
  }

  bool areOrt = areOrthogonal(vec1, vec2);
  print("Los vectoreses $vec1 y $vec2 ${areOrt ? "" : "NO"} son ortogonales");
}
