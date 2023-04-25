/*
* Challenge #6
* REVERSING STRINGS
* Difficulty: EASY
*
* Statement: Create a program that reverses the order of a text string without using language-specific functions that do so automatically.
* - If we pass "Hello world" we would return "dlrow olleH"
*
* Reto #6
* INVIRTIENDO CADENAS
* Dificultad: FÁCIL
*
* Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
* - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
*/
void main() {
  print(reverseString('Hello world'));
}

String reverseString(String text) {
  List<String> textSplitted = text.split('');
  String stringReversed = "";
  for (int idx = textSplitted.length - 1; idx >= 0; idx--) {
    stringReversed += textSplitted[idx];
  }
  return stringReversed;
}
