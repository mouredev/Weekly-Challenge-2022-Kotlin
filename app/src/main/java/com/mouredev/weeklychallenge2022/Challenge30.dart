/*
 * Reto #30
 * MARCO DE PALABRAS
 * Fecha publicación enunciado: 26/07/22
 * Fecha publicación resolución: 01/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
 * un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

enum Align { left, center, right }

// ********** ********** **********
// * ¿Qué   * *  ¿Qué  * *   ¿Qué *
// * te     * *   te   * *     te *
// * parece * * parece * * parece *
// * el     * *   el   * *     el *
// * reto?  * * reto?  * *  reto? *
// ********** ********** **********
void main(List<String> args) {
  String wrapText(String input,
      {String char = '*', String space = ' ', Align align = Align.left}) {
    String _char = char.substring(0, 1);
    String _space = space.substring(0, 1);
    String textWrapped = '';
    List<String> lines = input.split(RegExp(r'\s+'));
    if (lines.isNotEmpty) {
      int width = 0;
      for (var line in lines) width = width > line.length ? width : line.length;

      textWrapped = '${_char * (width + 4)}\n'; //lado superior
      for (var line in lines) {
        textWrapped += (_char + _space); //lado izquierdo
        //contenido
        switch (align) {
          case Align.left:
            textWrapped += '$line${_space * (width - line.length)}';
            break;
          case Align.center:
            int spaceLeft = ((width - line.length) ~/ 2);
            int spaceRight = width - line.length - spaceLeft;
            textWrapped += '${_space * spaceLeft}$line${space * spaceRight}';
            break;
          case Align.right:
            textWrapped += '${_space * (width - line.length)}$line';
            break;
        }
        textWrapped += '${(_space + _char)}\n'; //lado derecho
      }
      textWrapped += '${_char * (width + 4)}\n'; //lado inferior
    }
    return textWrapped;
  }

  print(wrapText('¿Qué te parece el reto?', align: Align.left));
  print(wrapText('¿Qué te parece el reto?', align: Align.center));
  print(wrapText('¿Qué te parece el reto?', align: Align.right));
}
