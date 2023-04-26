"""
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
"""
import re
def count_word_repetitions(text):
    text_splitted = text.split(" ");
    regular_expression = r'[^\w\s]'
    word_repetitions = {};
    for word in text_splitted:
        matches = re.findall(regular_expression, word)
        if len(matches) > 0: word = re.sub(regular_expression, "", word.lower())
        else: word = word.lower()
        if word not in word_repetitions: word_repetitions[word] = 1
        else: word_repetitions[word] += 1
    final_count = sum(word_repetitions.values())
    print(f"{word_repetitions}\nFinal word count: {final_count}")
count_word_repetitions("Hello, HELLO WORLD!,")