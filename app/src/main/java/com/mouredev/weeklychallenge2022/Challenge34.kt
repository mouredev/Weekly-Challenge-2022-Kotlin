#package com.mouredev.weeklychallenge2022
#
#/*
# * Reto #34
# * LOS NÚMEROS PERDIDOS
# * Fecha publicación enunciado: 22/08/22
# * Fecha publicación resolución: 29/08/22
# * Dificultad: FÁCIL
# *
# * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
# * y retorne todos los que faltan entre el mayor y el menor.
# * - Lanza un error si el array de entrada no es correcto.
# *
# * Información adicional:
# * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
# *   para preguntas, dudas o prestar ayuda a la comunidad.
# * - Tienes toda la información sobre los retos semanales en
# *   https://retosdeprogramacion.com/semanales2022.
# *
# */

#!/usr/bin/python3


def lost_nunmer(enter):
    for i in enter:
        if not isinstance(i, int):
            return "Error, hay valores que no son enteros\n"
        if enter.count(i) > 1:
            return " Error, hay valores repetidos\n"
        if i != enter[0] and i <= i_anterior:
            return "Error, valores desordenados\n"
        i_anterior = i

    j = min(enter)
    salida = []
    while j <= max(enter):
        salida.append(j)
        j += 1
    return salida

# Valor Repetido
#enter = [2,2,3,4,5,6]
# Valor Perdido
enter = [1,6,11]
# Valor Desordenado
#enter = [6,3,1,2,4]
print(lost_nunmer(enter))
