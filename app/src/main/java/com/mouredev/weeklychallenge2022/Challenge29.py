#!/usr/bin/python3
# -*- coding: utf-8 -*-

# Reto #29
# ORDENA LA LISTA
# Fecha publicación enunciado: 18/07/22
# Fecha publicación resolución: 26/07/22
# Dificultad: FÁCIL
# Enunciado: Crea una función que ordene y retorne una matriz de números.
# - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
#   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
# - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
# Información adicional:
# - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
# - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
# - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
# - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.

from random import randint

def bubblesort(vector, reverse=False):
    intercambio = True
    while intercambio:
        intercambio = False
        for i in range(len(vector)-1):
            if reverse:
                if vector[i] < vector[i+1]:
                    vector[i], vector[i+1] = vector[i+1], vector[i]
                    intercambio = True
            else:
                if vector[i] > vector[i+1]:
                    vector[i], vector[i+1] = vector[i+1], vector[i]
                    intercambio = True

if __name__ == '__main__':
    tam_vec = 20
    reverse = False

    vec = [randint(1, 100) for x in range(tam_vec)]
    print(vec)
    bubblesort(vec, reverse)
    print(vec)
