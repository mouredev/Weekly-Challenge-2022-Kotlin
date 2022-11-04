""" package com.mouredev.weeklychallenge2022

/*
 * Reto #44
 * BUMERANES
 * Fecha publicación enunciado: 02/10/22
 * Fecha publicación resolución: 07/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que retorne el número total de bumeranes de un array de números
 * enteros e imprima cada uno de ellos.
 * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números seguidos, en el que el
 *   primero y el último son iguales, y el segundo es diferente. Por ejemplo [2, 1, 2].
 * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] y [4, 2, 4]).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */ """


def get_boomerang(number_list):

    print("Sin evitar la superposición")

    for i in range(len(number_list) - 2):

        if number_list[i] == number_list[i+2]:
            boomerang = [number_list[i], number_list[i+1], number_list[i+2]]
            print(boomerang)


def get_boomerang2(number_list):

    print("Evitando la superposición")

    number_list_temp = number_list.copy()

    while len(number_list_temp) >= 3:

        if number_list_temp[0] == number_list_temp[2]:
            boomerang = [number_list_temp[0], number_list_temp[1], number_list_temp[2]]
            for i in boomerang:
                number_list_temp.remove(i)
            print(boomerang)
        else:
            number_list_temp.pop(0)


number_list = [2, 1, 2, 3, 3, 4, 2, 4]

get_boomerang(number_list)

get_boomerang2(number_list)
