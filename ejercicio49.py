"""
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
 """

import re

def detecHnadles():

    print("Introduzca el texto en el que quiere buscar")
    text = input()
    handle_usuario = re.findall('@\w+', text)
    handle_hashtag = re.findall('#\w+', text)
    patron = r"(https://www.+[\w.%+-]+/?\w*|http://www.+[\w.%+-]+/?\w*|www.+[\w.%+-]+/?\w*)"
    handle_web = re.findall(patron, text)
    print("HANDLES DE USUARIO: {} \n HANDLES HASHTAG: {} \n HANDLES WEB: {}".format(handle_usuario, handle_hashtag, handle_web))

print(detecHnadles())