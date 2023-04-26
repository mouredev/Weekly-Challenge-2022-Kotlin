/*
* Challenge #7
* COUNTING WORDS
* Difficulty: MEDIUM
*
* Statement: Create a program that counts how many times each word is repeated and displays the final count for all of them.
* - Punctuation marks are not part of the word.
* - A word is the same even if it appears in upper and lower case.
* - It is not possible to use functions of the language that resolve it automatically.
*
* Reto #7
* CONTANDO PALABRAS
* Dificultad: MEDIA
*
* Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
* - Los signos de puntuación no forman parte de la palabra.
* - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
* - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
*/
void main() {
  countWordsRepetitions("Hello, HELLO WORLD!,");
}

void countWordsRepetitions(String text) {
  RegExp regex = RegExp(r'[^\w\s]');
  List<String> textSplitted = text.split(" ");
  Map<String, int> wordRepetitions = Map<String, int>();
  int counter = 0, finalCount = 0;

  for (String word in textSplitted) {
    String wordCleaned = regex.hasMatch(word)
        ? word.toLowerCase().replaceAll(regex, "")
        : word.toLowerCase();
    if (wordRepetitions.containsKey(wordCleaned) == false) {
      counter = 1;
      wordRepetitions.addAll({wordCleaned: counter});
    } else {
      counter++;
      wordRepetitions[wordCleaned] = counter;
    }
  }
  finalCount = wordRepetitions.values.reduce((a, b) => a + b);
  print("$wordRepetitions\nFinal words count: $finalCount");
}
