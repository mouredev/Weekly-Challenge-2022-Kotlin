"""
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
"""

import re
text = '''Hola que tal!, este es el ejercicio 7 de los retos semanales. Este es un 
ejercicio se (resolvio) usando tablas de {hash}. Esta solucion la vi en un video de <youtube> 
hace ya un tiempo en el canal de @bettatech.'''


def normalize(text: str) -> str:
    return re.sub(r"""[!?'".,<>(){}@%&/\n[/]""", "", text)


def word_repetitions(text: str):
    repetitions = {}
    separated_words = text.split(" ")

    for word in separated_words:

        if normalize(word) in repetitions:
            repetitions[normalize(word)] += 1

        else:
            repetitions[normalize(word)] = 1

    print(repetitions)


word_repetitions(text)
