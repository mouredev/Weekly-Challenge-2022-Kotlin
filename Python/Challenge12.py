# 
#  Reto #12
#  ¿ES UN PALÍNDROMO?
#  Fecha publicación enunciado: 21/03/22
#  Fecha publicación resolución: 28/03/22
#  Dificultad: MEDIA
#  
#  Enunciado: Escribe una función que reciba un texto y retorne verdadero o falso (Boolean) según sean o no palíndromos.
#  Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de derecha a izquierda.
#  NO se tienen en cuenta los espacios, signos de puntuación y tildes.
#  Ejemplo: Ana lleva al oso la avellana.
#  
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar 
#    ayuda a la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#  
#  

PUNCTUATION_SYMBOLS = [",", ";", ":", ".", "·", "¿", "?", "¡", "!", "(", ")", "-", "_", "<", ">", "*", "'", "{", "}",
                       "[", "]", "^", "%", "/", "|", "\\"]

ACCENT_MARKS = {
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


def remove_special_chars(phrase: str) -> str:
    """
    Remove Punctuation Characters and Accent Marks from a phrase.

    Return an string with only characters, without spaces.
    """

    # Phrase in lowercase
    output_string = phrase.lower()

    # Checks all the chars in the phrase, and replace it if it is not allowed
    for char in phrase.lower():

        if char in PUNCTUATION_SYMBOLS:
            output_string = output_string.replace(char, "")

        if char in ACCENT_MARKS.keys():
            output_string = output_string.replace(char, ACCENT_MARKS[char])

    # Return a String without spaces
    return output_string.replace(" ", "")


def its_palindrome(first_string: str) -> bool:
    """
    Check if a String is a Palindrome
    """
    # Remove Characters not allowed
    clean_phrase = remove_special_chars(first_string)
    reverse_phrase = ""

    # Reverse the clean phrase
    for char in clean_phrase[::-1]:
        reverse_phrase += char

    # Check the phrase if it is equal to the reverse phrase
    if clean_phrase == reverse_phrase:
        return True
    else:
        return False


# Tests
print(its_palindrome("Ana lleva al oso la avellana."))
print(its_palindrome("Anita lava la tina"))
print(its_palindrome("MôureDév by {Brais Môüre}."))
print(its_palindrome("\\¿Qué tal Hackermen?"))

# Result Test
# "Ana lleva al oso la avellana."    -> True
# "Anita lava la tina"               -> True
# "MôureDév by {Brais Môüre}."       -> False
# "¿Qué tal Hackermen?"              -> False
