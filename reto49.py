#
# Reto #49
# EL DETECTOR DE HANDLES
# Fecha publicación enunciado: 05/12/22
# Fecha publicación resolución: 12/12/22
# Dificultad: FACIL
# Enunciado: Crea una función que sea capaz de detectar y retornar todos los
# handles de un texto usando solamente Expresiones Regulares.
# Debes crear una expresión regular para cada caso:
# - Handle usuario: Los que comienzan por "@"
# - Handle hashtag: Los que comienzan por "#"
# - Handle web: Los que comienzan por "www.", "http://", "https://"
#   y finalizan con un dominio (.com, .es...)
# /

import re


def detecta_handles(texto):

    usuario = r"@[a-zA-Z0-9_]+"
    hashtag = r"#[a-zA-Z0-9_]+"
    web = r"http*\w://\w+\.[a-z]+/?\w*|www\.\w+\.\w+/?\w*"

    handles_usuario = re.findall(usuario, texto)
    handles_hashtag = re.findall(hashtag, texto)
    handles_web = re.findall(web, texto)

    return {"usuario": handles_usuario, "hashtag": handles_hashtag, "web": handles_web}


if __name__ == '__main__':

    texto = "Twitter @prueba1 y @prueBA, hashtags #python; sitios web http://prueba.es, https://prueba.com"
    handles = detecta_handles(texto)

    print("Handles de Usuario:", handles["usuario"])
    print("Handles de Hashtag:", handles["hashtag"])
    print("Handles de Web:", handles["web"])
 