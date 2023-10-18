/*
 * Reto #38
 * BINARIO A DECIMAL
 * Fecha publicación enunciado: 19/09/22
 * Fecha publicación resolución: 27/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar
 * funciones propias del lenguaje que lo hagan directamente.
 */

void main() {
  // 110010110101 -> 3253
  print(binaryToDecimal(110010110101));

  // 1111111111 -> 1023
  print(binaryToDecimal(1111111111));

  // 001110 -> 14
  print(binaryToDecimal(001110));

  // 0 -> 0
  print(binaryToDecimal(0));

  // 1234 -> null
  print(binaryToDecimal(1234));
}

int? binaryToDecimal(int binaryNumber) {
  final String stringNumber = binaryNumber.toString();
  final Iterable<String> characterList = stringNumber.split('').reversed;

  if (characterList.any((char) => char != '0' && char != '1')) {
    print('El número introducido no es binario');
    return null;
  }
  
  int decimalNumber = 0;
  int digitMultiplier = 1;

  for (String char in characterList) {
    decimalNumber += char == '1' ? digitMultiplier : 0;
    digitMultiplier *= 2;
  }

  return decimalNumber;
}