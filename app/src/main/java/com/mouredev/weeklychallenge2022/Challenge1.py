# package com.mouredev.weeklychallenge2022

# /*
#  * Reto #1
#  * ¿ES UN ANAGRAMA?
#  * Fecha publicación enunciado: 03/01/22
#  * Fecha publicación resolución: 10/01/22
#  * Dificultad: MEDIA
#  *
#  * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
#  * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
#  * NO hace falta comprobar que ambas palabras existan.
#  * Dos palabras exactamente iguales no son anagrama.
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
#  * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#  *
#  */


word1, word2 = input('Ingresa dos palabras y te diré si son anagramas \n Palabra 1: ').lower().strip(), input(' Palabra 2: ').lower().strip()

word1_set = set(word1)
word2_set = set(word2)

def anagrame(word1: str, word2: str)-> bool:
    if word1 == word2:
        return True
    else:
        return False

print(anagrame(word1_set,word2_set))
