""" package com.mouredev.weeklychallenge2022

/*
 * Reto #49
 * EL DETECTOR DE HANDLES
 * Fecha publicación enunciado: 05/11/22
 * Fecha publicación resolución: 12/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de detectar y retornar todos los handles de un texto usando solamente Expresiones Regulares.
 * Debes crear una expresión regular para cada caso:
 * - Handle usuario: Los que comienzan por "@"
 * - Handle hashtag: Los que comienzan por "#"
 * - Handle web: Los que comienzan por "www.", "http://", "https://" y finalizan con un dominio (.com, .es...)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

 """

import re


text: str = "Hola mi usuario es @User, y mi web http://user.com/items, https://user.io, www.user.io y también www.user.io/items #Mis3webs #user pa todos"


def find_handler(text: str) -> None:

    pattern1: str = r'@\w+'
    pattern2: str = r'#\w+'
    pattern3: str = r'http*\w://\w+\.[a-z]+/?\w*|www\.\w+\.\w+/?\w*'

    handler_user: list[str] = re.findall(pattern1, text)
    handler_hashtag: list[str] = re.findall(pattern2, text)
    handler_web: list[str] = re.findall(pattern3, text)

    print("Users:")
    [print(f"\t{i}") for i in handler_user]
    print("Hashtag:")
    [print(f"\t{i}") for i in handler_hashtag]
    print("Web:")
    [print(f"\t{i}") for i in handler_web]


find_handler(text)
