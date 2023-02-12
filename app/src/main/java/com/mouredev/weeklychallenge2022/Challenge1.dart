/*
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
 */

void main() {
  print(isAnagram('amor', 'roma'));
}

bool isAnagram(String firstWord, String secondWord) {
  if (firstWord.toLowerCase() == secondWord.toLowerCase()) {
    return false;
  }

  List firstArray = firstWord.toLowerCase().split('')..sort();
  List secondArray = secondWord.toLowerCase().split('')..sort();

  if (firstArray.length == secondArray.length) {
    return firstArray.every((value) => secondArray.contains(value));
  } else {
    return false;
  }
}
