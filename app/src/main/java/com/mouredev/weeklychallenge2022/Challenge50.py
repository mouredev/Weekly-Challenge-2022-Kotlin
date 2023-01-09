""" package com.mouredev.weeklychallenge2022

/*
 * Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/11/22
 * Fecha publicación resolución: 19/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
 * algoritmo de encriptación de Karaca (debes buscar información sobre él).
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */ """


def karaca(text: str, encript: bool) -> str:

    split_text: list = text.lower().split()

    text_output: str = ""

    if encript:
        for word in split_text:
            if word.isalpha():
                text_output += word[::-1].translate(
                    word[::-1].maketrans("aeiouáéíóúü", "01234012344")) + "aca "
            else:
                text_output += word + " "

        return text_output

    else:
        for word in split_text:
            if not word.isdigit():
                word: str = word[0:-3]
                text_output += word[::-1].translate(
                    word[::-1].maketrans("01234", "aeiou")) + " "

            else:
                text_output += word + " "

        return text_output


print(karaca("Cagó en los 1000 moños", True))
print(karaca("3g0caca n1aca s3laca 1000 s3ñ3maca", False))
