""" package com.mouredev.weeklychallenge2022

/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */ """


import operator

from unicodedata import normalize


def vocal_count(text):

    vocals = ["a", "e", "i", "o", "u"]
    count_dict = {}

    text = normalize("NFD", text).lower()

    for vocal in vocals:

        count_dict[vocal] = text.count(vocal)

    order = sorted(count_dict.items(),
                   key=operator.itemgetter(1), reverse=True)

    return print(f"La vocal {order[0][0]} se ha repetido {order[0][1]}") if order[0][1] > 0 else print("No hay vocales")


vocal_count("Al pan pan y al vino vino")
vocal_count("Si no hay al piste eres pasto de los buitres")
vocal_count("Me voy a poner deltoya sin parar")
vocal_count("Aquí tienes más miseria")
vocal_count("")
