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

    print("Sin borrar elementos de la lista")

    for i in range(len(number_list) - 2):
        head = number_list[i]
        tail = number_list[i+2]

        if head == tail:
            boomerang = [head, number_list[i+1], tail]
            print(boomerang)


def get_boomerang2(number_list):

    print("Borrando elementos de la lista")

    while len(number_list) >= 3:
        head = number_list[0]
        tail = number_list[2]

        if head == tail:
            boomerang = [head, number_list[1], tail]
            for i in boomerang:
                number_list.remove(i)
            print(boomerang)
        else:
            number_list.pop(0)


number_list = [2, 1, 2, 3, 3, 4, 2, 4]

get_boomerang(number_list)

get_boomerang2(number_list)
