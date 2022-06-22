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


def translate_to_morse(natural_phrase: str):
    # String a imprimir
    translated_phrase = ""

    for letter in natural_phrase.lower():

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
    print(f"The phrase '{natural_phrase}' in morse is: '{translated_phrase}'.")


def translate_to_natural_text(morse_phrase: str):
    # String a imprimir
    translated_phrase = ""

    # Del diccionario de Texto Natural a Código Morse, se crea un nuevo diccionario,
    # que es de Código Morse a Texto Natural
    latin_dict = {value: key for key, value in MORSE_DICT.items()}

    # Separa lo transmitido en morse, en palabras únicas.
    for word in morse_phrase.split("   "):
        # Cada palabra es separado
        for letter_morse in word.split():

            # Intenta obtener la letra del diccionario creado
            latin_letter = latin_dict.get(letter_morse)

            # Si se tiene un error transmitido o no existe la letra, lo marca con un *
            if letter_morse == "....--.....---..-...-.." or latin_letter is None:
                translated_phrase += "*"

            # En caso contrario, añade la letra traducida desde
            else:
                translated_phrase += latin_letter

        # Añade un espacio al final de la palabra
        translated_phrase += " "

    # Imprime la frase en Código Morse
    print(f"The Morse Code '{morse_phrase}' in natural text is: '{translated_phrase}'.")


def morse_translator(phrase: str):

    is_morse = False

    # Si alguna de las letras de la frase, está en los Valores del diccionario, lo traducirá a Texto Natural
    # En caso contrario, lo traduce a Morse.
    for letter in phrase.lower().split():

        # Si la letra se encuentra en los valores del diccionario de morse, deja la traducción a Morse
        if letter in MORSE_DICT.values():
            is_morse = True

    if is_morse:
        translate_to_natural_text(phrase)

    else:
        translate_to_morse(phrase.lower())


# Test
morse_translator("Hola Mundo 1/3")
morse_translator("Olé")
morse_translator("··· --- ···")
morse_translator("-- --- ··- ·-· · -·· · ···-")

# Result Test
# The phrase 'hola mundo 1/3' in morse is: '···· --- ·-·· ·-   -- ··- -· -·· ---   ·---- -··-· ···-- '.
# The phrase 'olé' in morse is: '--- ·-·· ....--.....---..-...-.. '.
# The Morse Code '··· --- ···' in natural text is: 'sos '.
# The Morse Code '-- --- ··- ·-· · -·· · ···-' in natural text is: 'mouredev '.
