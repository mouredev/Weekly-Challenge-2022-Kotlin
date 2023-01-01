"""
/*
 * Enunciado: Crea una función que sea capaz de detectar y retornar todos los
 * handles de un texto usando solamente Expresiones Regulares.
 * Debes crear una expresión regular para cada caso:
 * - Handle usuario: Los que comienzan por "@"
 * - Handle hashtag: Los que comienzan por "#"
 * - Handle web: Los que comienzan por "www.", "http://", "https://" 
 *   y finalizan con un dominio (.com, .es...)
 */
 """

import re

def detectar_handle(text):
    exp_usuario = r"([@][a-zA-Z_.\d+]+)"
    exp_hastag = r"([#][a-zA-Z_.\d+]+)"
    exp_web = r"www\.[a-zA-Z0-9]+\.[a-z]+|https://[a-zA-Z0-9]+\.[a-z]+|http://[a-zA-Z0-9]+\.[a-z]+"

    usuarios = re.findall(r"([@][a-zA-Z_.\d+]+)", text) 

    print(f"Usuarios: {usuarios} ")
    print("")

    hastag = re.findall(r"([#][a-zA-Z_.\d+]+)", text)
    print(f"Hastags: {hastag}")
    
    url = re.findall(exp_web, text)
    print("Webs:")
    for web in url:
        print(web)





def main():
    text = "Hola somos los usuarios @apolo$ y @isis_16,  utilizando el hastag #programar y #12quelio, partizipamos en el portal www.web.com, https://ortraweb.es y http://nose.net. Adios"

    detectar_handle(text)

if __name__ == '__main__':
    main()

