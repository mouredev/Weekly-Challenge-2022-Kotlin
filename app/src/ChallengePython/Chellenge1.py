"""
* Reto #1
* ¿ES UN ANAGRAMA?
* Fecha publicación enunciado: 03/01/22
* Fecha publicación resolución: 10/01/22
* Dificultad: MEDIA
*
* Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
* Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
* NO hace falta comprobar que ambas palabras existan.
* Dos palabras exactamente iguales no son anagrama.
"""

#Author: Jose Angel Silva
#Date: 12/10/2022
#Challenge 1

def anagrama(w1 : str, w2 : str):
    if w1.lower() == w2.lower():
        return False
    a = sorted(w1.lower())
    b = sorted(w2.lower())
    if a == b:
        return True
    else:
        return False


palabra1 = "Lidera"
palabra2 = "Delira"
print(anagrama(palabra1, palabra2))