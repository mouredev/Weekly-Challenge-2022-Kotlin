# /*
#  * Reto #49
#  * EL DETECTOR DE HANDLES
#  * Fecha publicación enunciado: 05/11/22
#  * Fecha publicación resolución: 12/12/22
#  * Dificultad: FÁCIL
#  *
#  * Enunciado: Crea una función que sea capaz de detectar y retornar todos los handles de un texto usando solamente Expresiones Regulares.
#  * Debes crear una expresión regular para cada caso:
#  * - Handle usuario: Los que comienzan por "@"
#  * - Handle hashtag: Los que comienzan por "#"
#  * - Handle web: Los que comienzan por "www.", "http://", "https://" y finalizan con un dominio (.com, .es...)
#  *
#  * Información adicional:
#  * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
#  *   para preguntas, dudas o prestar ayuda a la comunidad.
#  * - Tienes toda la información sobre los retos semanales en
#  *   https://retosdeprogramacion.com/semanales2022.
#  *
#  */
import re

def HanlesDetector(text):
    listaPalabras = text.split()
    container = []
    user = re.compile("^@[a-z0-9_-]{3,20}$", re.IGNORECASE)
    hast = re.compile('^#[^ !@#$%^&*(),.?":{}|<>]*$', re.IGNORECASE)
    web = re.compile("[(http(s)?):\/\/(www\.)?a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}", re.IGNORECASE) 
    for palabra in listaPalabras:
        if user.match(palabra):
            container.append(palabra)
        elif hast.match(palabra):
            container.append(palabra)
        elif web.match(palabra):
            container.append(palabra)
            
           
    for handles in container:  
        print(handles)


text = "hola como estan @maurodev muy agradecido por el movimiento #tech en https://twitter.com o www.twitter.com,  Gracias..!!"

HanlesDetector(text)
