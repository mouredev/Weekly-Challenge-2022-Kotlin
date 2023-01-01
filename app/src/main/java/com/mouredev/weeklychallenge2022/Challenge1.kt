package com.mouredev.weeklychallenge2022

/*
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
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */


### SOLUCIÓN CON PYTHON ###

def anagrama(palabra1: str, palabra2: str):
    if palabra1 == palabra2:
        return "iguales"
    elif sorted(palabra1.lower()) == sorted(palabra2.lower()):
        return True
    else:
        return False

palabra1 = "amor"
palabra2 = "roma"

respuesta = anagrama(palabra1, palabra2)

if respuesta == "iguales":
    print(f"Has introducido la misma palabra.")
elif respuesta == True:
    print(f"Las palabras '{palabra1}' y '{palabra2}' sí son anagramas.")
else:
    print(f"Las palabras '{palabra1}' y '{palabra2}' no son anagramas.")
