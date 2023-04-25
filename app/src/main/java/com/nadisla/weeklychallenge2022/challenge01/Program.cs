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
bool IsAnagram(string word1, string word2)
{
    if (word1.ToLower().Trim() == word2.ToLower().Trim() || word1.Length != word2.Length) return false;
    else return word1.ToLower().Trim().ToCharArray().OrderBy(c => c).SequenceEqual(word2.ToLower().Trim().ToCharArray().OrderBy(c => c));
}
Console.Write("Enter the first word: ");
string word1 = Console.ReadLine()!;
Console.Write("Enter the second word: ");
string word2 = Console.ReadLine()!;
Console.WriteLine($"Is the second word an anagram? {IsAnagram(word1, word2)}");