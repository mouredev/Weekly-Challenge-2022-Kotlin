# solucion reto #1
# Dificultad media 

# ¿ES UN ANAGRAMA?

# Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
# Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
# NO hace falta comprobar que ambas palabras existan.
# Dos palabras exactamente iguales no son anagrama.

# ejemplos Cornisa – Narciso Japonés – Esponja Valora – Álvaro Nepal – Panel amor - roma  Frase – Fresa  Acuerdo – Ecuador

def main(word, wordTwo):

    if len(word) != len(wordTwo) : return False
    sortedWord = ''.join(sorted(word.lower(), key=str.lower))
    sortedTwoWord = ''.join(sorted(wordTwo.lower(), key=str.lower))

    return sortedTwoWord == sortedWord

print(main('Amor', 'romsa'))

# big(0) time complexity = 0(2n)
# big(0) space complexity = 0(2n)
