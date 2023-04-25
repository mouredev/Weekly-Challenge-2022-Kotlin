"""
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
"""
def is_anagram(word1, word2):
    word1_cleaned = sorted(word1.lower().strip())
    word2_cleaned = sorted(word2.lower().strip())

    if (word1 == word2 or len(word1_cleaned) != len(word2_cleaned) or word1_cleaned != word2_cleaned):
        return False
    return True

word1 = input("Enter the first word: ")
word2 = input("Enter the second word: ")
print(f"Is the second word an anagram? {is_anagram(word1, word2)}")