package com.mouredev.weeklychallenge2022

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

import re


def getting_handles (frase):


    handle_arroba = re.findall('@\w+',frase)  #imprimo una palabra con @ y caracteres Alfanumericos presentes

    for arrobas in handle_arroba :

        print(arrobas)

    handle_numeral = re.findall('#\w+',frase)  #imprimo una palabra con @ y caracteres Alfanumericos presentes

    for numerales in handle_numeral :

        print(numerales)


    handle_web = re.findall(r'http*\w*://[a-z]*[.\w+]+',frase)  # imprimo sitios web presentes comenzando por http://

    for webs_http in handle_web :

        print(webs_http)

    # LLAMADO DE LA FUNCION GETTING_HANDLES :

frase1 = "Hola, mis redes son @mytwitter, @myinstagram, my pagina web : www.myweb.es y"
frase2 = "http://myotherweb.com, visita https://mouredev.dev/ #retosemanal "
frase3 = "Participa en el evento #aDEViento, visita https://adeviento.dev"
frase4 = "#thisiscool #lovedev @hameyoga en instagram https://otrositio.dev"

frase = frase1 + frase2 + frase3 + frase4

getting_handles(frase)


