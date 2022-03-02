#
#   Reto #9
#   CÓDIGO MORSE
#   Fecha publicación enunciado: 02/03/22
#   Fecha publicación resolución: 07/03/22
#   Dificultad: MEDIA
#  
#   Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
#   - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
#   - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre
#     palabras "  ".
#   - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
#  
#   Información adicional:
#   - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#     ayuda a la comunidad.
#   - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#   - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#   - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#  

# Diccionario de las letras permitidas en Código Morse
MORSE_DICT = {
    "a": "·-",
    "b": "-···",
    "c": "-·-·",
    "d": "-··",
    "e": "·",
    "f": "··-·",
    "g": "--·",
    "h": "····",
    "i": "··",
    "j": "·---",
    "k": "-·-",
    "l": "·-··",
    "m": "--",
    "n": "-·",
    "ñ": "--·--",
    "o": "---",
    "p": "·--·",
    "q": "--·-",
    "r": "·-·",
    "s": "···",
    "t": "-",
    "u": "··-",
    "v": "···-",
    "w": "·--",
    "x": "-··-",
    "y": "-·--",
    "z": "--··",
    "0": "-----",
    "1": "·----",
    "2": "··---",
    "3": "···--",
    "4": "····-",
    "5": "·····",
    "6": "-····",
    "7": "--···",
    "8": "---··",
    "9": "----·",
    ".": "·-·-·-",
    ",": "--··--",
    "?": "··--··",
    '"': "·-··-·",
    "/": "-··-·"
}


def translate_to_morse(phrase: str):
    # String a imprimir
    translated_phrase = ""

    for letter in phrase.lower():

        # Obtiene la traducción de la letra a través del diccionario Morse, si no existe o no se encuentra retorna None
        letter_morse = MORSE_DICT.get(letter)

        # Si se encuentra un espacio, lo reemplaza con un doble espacio para separar una palabra de otra
        if letter == " ":
            translated_phrase += "  "

        # Si la letra no existe en el diccionario, se toma como un error de transmisión y se transmite como tal.
        elif letter_morse is None:
            translated_phrase += "....--.....---..-...-.. "

        # De encontrarse en el diccionario, realiza la traducción directamente
        else:
            translated_phrase += f"{letter_morse} "

    # Imprime la frase en Código Morse
    print(f"The phrase '{phrase}' in morse is: {translated_phrase}")


# Test
translate_to_morse("SOS")

# Result Test
# The phrase 'Hola Mundo 1/3' in morse is: ···· --- ·-·· ·-   -- ··- -· -·· ---   ·---- -··-· ···--
# The phrase 'Olé' in morse is: --- ·-·· ....--.....---..-...-..
# The phrase 'SOS' in morse is: ··· --- ···
