/*
 * Reto #21
 * CALCULADORA .TXT
 * Fecha publicación enunciado: 23/05/22
 * Fecha publicación resolución: 01/06/22
 * Dificultad: MEDIA
 *
 * Enunciado: Lee el fichero "Challenge21.txt" incluido en el proyecto, calcula su resultado e imprímelo.
 * - El .txt se corresponde con las entradas de una calculadora.
 * - Cada línea tendrá un número o una operación representada por un símbolo (alternando ambos).
 * - Soporta números enteros y decimales.
 * - Soporta las operaciones suma "+", resta "-", multiplicación "*" y división "/".
 * - El resultado se muestra al finalizar la lectura de la última línea (si el .txt es correcto).
 * - Si el formato del .txt no es correcto, se indicará que no se han podido resolver las operaciones.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

import 'dart:io';

class CalculatorTXT {
  final List<String> _content;
  final List<String> _operators = <String>["+", "-", "*", "/"];

  CalculatorTXT(this._content);

  bool isNumber(String line) {
    return double.tryParse(line) != null;
  }

  bool isOperator(String line) {
    return _operators.contains(line);
  }

  bool isValid() {
    if (_content.length.isEven) {
      return false;
    }
    bool isContentValid = true;
    for (var i = 0; i < _content.length; i++) {
      if (i.isEven) {
        if (!isNumber(_content[i])) {
          isContentValid = false;
          break;
        }
      } else {
        if (!isOperator(_content[i])) {
          isContentValid = false;
          break;
        }
      }
    }
    return isContentValid;
  }

  Future<String> calculate() async {
    late String output;
    try {
      double result = double.parse(_content[0]);
      for (var i = 1; i < _content.length - 1; i++) {
        if (i.isOdd) {
          double number = double.parse(_content[i + 1]);
          switch (_content[i]) {
            case "+":
              result = result + number;
              break;
            case "-":
              result = result - number;
              break;
            case "*":
              result = result * number;
              break;
            case "/":
              if (number == 0.0) {
                throw Exception("Division por 0");
              } else {
                result = result / number;
              }
              break;
            default:
              throw Exception("Operacion no soportada");
          }
        }
      }
      output = "El resultado es: $result";
    } catch (e) {
      output = e.toString();
    }
    return output;
  }
}

void main(List<String> args) async {
  String path = args.isNotEmpty ? args.first : "Challenge21.txt";
  File file = File(path);
  RandomAccessFile? accessFile;
  late String output;

  try {
    accessFile = file.openSync();
    List<String> lines = file.readAsLinesSync();
    accessFile.closeSync();
    CalculatorTXT calculatorTXT = CalculatorTXT(lines);
    if (calculatorTXT.isValid()) {
      print("calculando...");
      output = await calculatorTXT.calculate();
    } else {
      output = "El formato no es correcto";
    }
  } catch (e) {
    output = e.toString();
  }
  print(output);
}
