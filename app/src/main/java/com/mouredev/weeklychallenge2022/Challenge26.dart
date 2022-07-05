/*
 * Reto #26
 * CUADRADO Y TRIÁNGULO 2D
 * Fecha publicación enunciado: 27/06/22
 * Fecha publicación resolución: 07/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

//Unidad de longitud 1 es la distancia entre dos asteriscos **
// Ej: longitud 1
// **
// **
//  Ej: longitud 4
// *****
// *   *
// *   *
// *   *
// *****

abstract class FigureASCII {
  final int side;
  final String char;
  final String voidChar;

  FigureASCII({required this.side, this.char = '*', this.voidChar = ' '});

  void printOutline();
  void printFill();
}

//Cuadrado ---------------------------------------------------------------------
// * * * *    * * * *
// *     *    * * * *
// *     *    * * * *
// * * * *    * * * *

class SquareASCII extends FigureASCII {
  SquareASCII({required super.side, super.char, super.voidChar});

  @override
  void printOutline() {
    String canvas = '';
    int canvasWidth = side;
    int canvasHeight = side;
    for (var i = 0; i <= canvasHeight; i++) {
      for (var j = 0; j <= canvasWidth; j++) {
        if (i == 0 || i == side || j == 0 || j == side) {
          canvas += char + voidChar;
        } else {
          canvas += voidChar * 2;
        }
      }
      canvas += '\n';
    }
    print(canvas);
  }

  @override
  void printFill() {
    String canvas = '';
    int canvasWidth = side;
    int canvasHeight = side;
    for (var i = 0; i <= canvasHeight; i++) {
      for (var j = 0; j <= canvasWidth; j++) {
        canvas += char + voidChar;
      }
      canvas += '\n';
    }
    print(canvas);
  }
}

//Triángulo --------------------------------------------------------------------
//             *                           *
//           *   *                       *   *
//         *       *                   *   *   *
//       *           *               *   *   *   *
//     *               *           *   *   *   *   *
//   *                   *       *   *   *   *   *   *
// *  *  *  *  *  *  *  *  *   *  *  *  *   *   *   *  *

class TriangleASCII extends FigureASCII {
  TriangleASCII({required super.side, super.char, super.voidChar});

  @override
  void printOutline() {
    String canvas = '';
    int canvasWidth = side * 2;
    int canvasHeight = side;
    for (var i = 0; i <= canvasHeight; i++) {
      for (var j = 0; j <= canvasWidth; j++) {
        if (i == side) {
          canvas += (j.isEven ? char : voidChar) + voidChar;
        } else if (j <= side ? (i + j == side) : (j - i == side)) {
          canvas += char + voidChar;
        } else {
          canvas += voidChar * 2;
        }
      }
      canvas += '\n';
    }
    print(canvas);
  }

  @override
  void printFill() {
    String canvas = '';
    int canvasWidth = side * 2;
    int canvasHeight = side;
    for (var i = 0; i <= canvasHeight; i++) {
      for (var j = 0; j <= canvasWidth; j++) {
        if (i == side || (i + j >= side && j - i <= side)) {
          canvas += ((j + i + side).isEven ? char : voidChar) + voidChar;
        } else {
          canvas += voidChar * 2;
        }
      }
      canvas += '\n';
    }
    print(canvas);
  }
}

//Paralelogramo ------------------------------------------------------------------------
//
//          * * * * *               * * * * *
//        *       *              * * * * *
//      *       *             * * * * *
//    *       *             * * * * *
//  * * * * *             * * * * *

class ParallelogramASCII extends FigureASCII {
  ParallelogramASCII({required super.side, super.char, super.voidChar});

  @override
  void printOutline() {
    String canvas = '';
    int canvasWidth = side * 2;
    int canvasHeight = side;
    for (var i = 0; i <= canvasHeight; i++) {
      for (var j = 0; j <= canvasWidth; j++) {
        if ((i == side && j <= side) ||
            (i > 0 && j < canvasWidth && (j + i) % side == 0) ||
            (i == 0 && j >= side)) {
          canvas += char + voidChar;
        } else {
          canvas += voidChar * 2;
        }
      }
      canvas += '\n';
    }
    print(canvas);
  }

  @override
  void printFill() {
    String canvas = '';
    int canvasWidth = side * 2;
    int canvasHeight = side;
    for (var i = 0; i <= canvasHeight; i++) {
      for (var j = 0; j <= canvasWidth; j++) {
        if ((i == side && j <= side) ||
            (j + i) >= side && (j + i) <= canvasWidth ||
            (i == 0 && j >= side)) {
          canvas += char + voidChar;
        } else {
          canvas += voidChar * 2;
        }
      }
      canvas += '\n';
    }
    print(canvas);
  }
}

//Hexágono --------------------------------------------------------------------
//         * * * * *                   * * * * *
//       *           *               * * * * * * *
//     *               *           * * * * * * * * *
//   *                   *       * * * * * * * * * * *
// *                       *   * * * * * * * * * * * * *
//   *                   *       * * * * * * * * * * *
//     *               *           * * * * * * * * *
//       *           *               * * * * * * *
//         * * * * *                   * * * * *

class HexagonASCII extends FigureASCII {
  HexagonASCII({required super.side, super.char, super.voidChar});

  @override
  void printOutline() {
    String canvas = '';
    int canvasWidth = side * 3;
    int canvasHeight = side * 2;
    for (var i = 0; i <= canvasHeight; i++) {
      for (var j = 0; j <= canvasWidth; j++) {
        if (j <= canvasWidth ~/ 3) {
          canvas +=
              ((j + i > 0 && i < side && (j + i) % (side) == 0 || i - j == side)
                      ? char
                      : voidChar) +
                  voidChar;
        } else if (j >= canvasWidth ~/ 3 && j <= (canvasWidth ~/ 3) * 2) {
          canvas +=
              ((i == 0 || i == canvasHeight) ? char : voidChar) + voidChar;
        } else {
          canvas += (j - side * 2 - i == 0 || i + j == side * 4)
              ? char
              : voidChar + voidChar;
        }
      }
      canvas += '\n';
    }
    print(canvas);
  }

  @override
  void printFill() {
    String canvas = '';
    int canvasWidth = side * 3;
    int canvasHeight = side * 2;
    for (var i = 0; i <= canvasHeight; i++) {
      for (var j = 0; j <= canvasWidth; j++) {
        if (j <= canvasWidth ~/ 3) {
          canvas += ((j + i > 0 && (i < side ? (j + i) >= side : i - j <= side))
                  ? char
                  : voidChar) +
              voidChar;
        } else if (j >= canvasWidth ~/ 3 && j <= (canvasWidth ~/ 3) * 2) {
          canvas += char + voidChar;
        } else {
          canvas += ((i < side ? j - side * 2 - i <= 0 : i + j <= side * 4)
                  ? char
                  : voidChar) +
              voidChar;
        }
      }
      canvas += '\n';
    }
    print(canvas);
  }
}

class FigureASCIIFactory {
  void generate({required int side, required String figure}) {
    switch (figure) {
      case 'Square':
        SquareASCII(side: side)
          ..printOutline()
          ..printFill();
        break;
      case 'Triangle':
        TriangleASCII(side: side)
          ..printOutline()
          ..printFill();
        break;
      case 'Parallelogram':
        ParallelogramASCII(side: side)
          ..printOutline()
          ..printFill();
        break;
      case 'Hexagon':
        HexagonASCII(side: side)
          ..printOutline()
          ..printFill();
        break;
      default:
        print('$figure not found');
    }
  }
}

void main(List<String> args) {
  FigureASCIIFactory fprinter = FigureASCIIFactory();

  // fprinter.generate(side: 4, figure: 'Triangle');
  // fprinter.generate(side: 8, figure: 'Square');
  // fprinter.generate(side: 4, figure: 'Parallelogram');
  fprinter.generate(side: 5, figure: 'Hexagon');
}
