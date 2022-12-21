'''
 * Escribe una función que reciba dos palabras (String) y retorne
 * verdadero o falso (Bool) según sean o no anagramas.
 * - Un Anagrama consiste en formar una palabra reordenando TODAS
 *   las letras de otra palabra inicial.
 * - NO hace falta comprobar que ambas palabras existan.
 * - Dos palabras exactamente iguales no son anagrama.
'''
first_word = input('Escribe aqui una palabra: ')
second_word = input('Escribe aqui otra palabra: ')

def es_anagrama(first_word, second_word):

    if first_word == second_word:
        print('No es un anagrama')
    elif sorted(first_word) == sorted(second_word):
        print('Es un anagrama')
    else:
        print('No es un anagrama')


es_anagrama(first_word, second_word)

