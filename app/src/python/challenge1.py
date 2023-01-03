# Reto  # 1
# ¿ES UN ANAGRAMA?
# Fecha publicación enunciado: 03/01/22
# Fecha publicación resolución: 10/01/22
# Dificultad: MEDIA

# Enunciado: Escribe una función que reciba dos palabras(String) y retorne verdadero o falso(Boolean) según sean o no anagramas.
# Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
# NO hace falta comprobar que ambas palabras existan.
# Dos palabras exactamente iguales no son anagrama.


def is_an_anagram(wordOne: str, wordTwo: str) -> bool:
    wordOne = wordOne.lower()
    wordTwo = wordTwo.lower()

    if wordOne == wordTwo:
        return False
    return sorted(wordOne) == sorted(wordTwo)


if __name__ == '__main__':
    print(is_an_anagram('amor', 'roma'))  # True
    print(is_an_anagram('amor', 'amor'))  # False
    print(is_an_anagram('delira', 'lidera'))  # True
    print(is_an_anagram('ballena', 'llenaba'))  # True
    print(is_an_anagram('perro', 'ropero'))  # False
