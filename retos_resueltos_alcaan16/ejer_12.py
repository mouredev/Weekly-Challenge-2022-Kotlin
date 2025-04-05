"""
#12-¿ES UN PALÍNDROMO?
/*
 * Escribe una función que reciba un texto y retorne verdadero o
 * falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee
  * de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 */
"""

#creamos un diccionario simbolos, sonde se buscara los simbolos
simbolos = [",", ";", ":", ".", "·", "¿", "?", "¡", "!", "(", ")", "-", "_", "<", ">", "*", "'", "{", "}",
            "[", "]", "^", "%", "/", "|", "\\"]

#creamos un diccionario acentos, sonde se buscara los acentos
acentos = {
    "á": "a",
    "à": "a",
    "ä": "a",
    "â": "a",
    "é": "e",
    "è": "e",
    "ë": "e",
    "ê": "e",
    "í": "i",
    "ì": "i",
    "ï": "i",
    "î": "i",
    "ó": "o",
    "ò": "o",
    "ö": "o",
    "ô": "o",
    "ú": "u",
    "ù": "u",
    "ü": "u",
    "û": "u"
}

def palindromo(texto):

    texto_sin_acento = ""
    texto_sin_simbolos = ""

    print (texto)

    #recorremos el texto, eliminando los acentos de las palabras.
    #los acentos se encuentran en el diccionario acentos
    for i in texto:
        if i in acentos:
            texto_sin_acento += acentos[i]
        else:
            texto_sin_acento += i

    texto = texto_sin_acento

    #recorremos el texto, para eliminar los simbolos de la frase
    #los simbolos se encuentran en el diccionario simbolos
    for i in texto:
        if i not in simbolos:
            texto_sin_simbolos += i
    
    texto = texto_sin_simbolos

    texto_nuevo = ""
    texto_reves = ""

    #ponemos el texto del reves, eliminando los espacios
    for i in texto[::-1]:
        if i != " ":
            texto_reves += i

    #eliminamos los espacios del texto
    for i in texto:
        if i != " ":
            texto_nuevo += i

    #pasamos a minuscula
    texto_reves = texto_reves.lower()
    texto_nuevo = texto_nuevo.lower()

    print (texto_nuevo)
    palin = True

    #comparamos los textos para cer si se lee de igual manera
    if len(texto_reves) == len(texto_nuevo):
        z = 0
        for x in texto_nuevo:
            if x != texto_reves[z]:
                palin = False
                break
            z += 1
    else:
        palin = False
    
    return palin


print ( palindromo ("Ana lleva al oso (/(/(la avellaná?¿"))
print ( palindromo ("Anita lava la tina"))
print ( palindromo ("MôureDév by {Brais Môüre}"))
print ( palindromo ("¿Qué tal Hackermen?"))
