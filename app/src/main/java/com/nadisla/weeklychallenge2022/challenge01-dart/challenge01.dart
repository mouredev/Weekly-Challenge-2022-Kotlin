/*
* Challenge #1
* IS IT AN ANAGRAM?
* Difficulty: MEDIUM
*
* Statement: Write a function that receives two words (String) and returns true or false (Boolean) depending on whether or not they are anagrams.
* An Anagram consists of forming a word by rearranging ALL the letters of another initial word.
* It is NOT necessary to check that both words exist.
* Two exactly the same words are not anagram.

* Reto #1
* ¿ES UN ANAGRAMA?
* Dificultad: MEDIA
*
* Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
* Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
* NO hace falta comprobar que ambas palabras existan.
* Dos palabras exactamente iguales no son anagrama.
*/
import 'dart:io';

void main() {
  stdout.write("Enter the first word: ");
  String word1 = stdin.readLineSync()!;
  stdout.write("Enter the second word: ");
  String word2 = stdin.readLineSync()!;
  print("Is the second word an anagram? ${isAnagram(word1, word2)}");
}

bool isAnagram(String word1, String word2) {
  List<String> word1Splitted = word1.toLowerCase().trim().split(""),
      word2Splitted = word2.toLowerCase().trim().split("");
  word1Splitted.sort();
  word2Splitted.sort();

  if (word1 == word2 ||
      word1Splitted.length != word2Splitted.length ||
      word1Splitted.join() != word2Splitted.join()) {
    return false;
  }
  return true;
}
