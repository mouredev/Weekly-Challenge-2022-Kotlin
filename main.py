from typing import List, Final

from Utils import AlphabetType, TextSpacing
from WordEncoded import WordEncoded


# Reto #9
# CÓDIGO MORSE
# Fecha publicación enunciado: 02/03/22
# Fecha publicación resolución: 07/03/22
# Dificultad: MEDIA
#
# Enunciado: Crea un programa que sea capaz de transformar texto natural a código morse y viceversa.
# - Debe detectar automáticamente de qué tipo se trata y realizar la conversión.
# - En morse se soporta raya "—", punto ".", un espacio " " entre letras o símbolos y dos espacios entre palabras "  ".
# - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.
#
# Información adicional:
# - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
# - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
# - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
# - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.


class MorseTranslator:
    __alphabet_type: AlphabetType
    __TEXT: Final[str]

    @property
    def __space_between_input_text(self) -> str:
        if self.__alphabet_type == AlphabetType.ROMAN:
            return TextSpacing.ROMAN.value

        return TextSpacing.MORSE.value

    @property
    def __space_between_output_text(self) -> str:
        if self.__alphabet_type == AlphabetType.ROMAN:
            return TextSpacing.MORSE.value

        return TextSpacing.ROMAN.value

    def __init__(self, text: str):
        text_striped: Final[str] = text.strip()
        self.__TEXT = text_striped
        self.__alphabet_type = AlphabetType.recognize_alphabet(text_striped)

    def __identify_words(self, text: str) -> List[WordEncoded]:
        word_list: List[str] = text.split(self.__space_between_input_text)

        return [WordEncoded(word, self.__alphabet_type) for word in word_list]

    def translate(self) -> str:
        encoded_text: List[WordEncoded] = self.__identify_words(self.__TEXT)
        text__decoded: List[str] = [word.decode() for word in encoded_text]
        return self.__space_between_output_text.join(text__decoded)


while __name__ == '__main__':
    texto = input("Ingrese un texto: ")
    morseTranslator = MorseTranslator(texto)
    print(morseTranslator.translate())
