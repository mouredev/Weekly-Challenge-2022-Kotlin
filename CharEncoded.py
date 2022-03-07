from typing import Final


def clean_whitespaces(char: str) -> str:
    return char.replace(" ", "")


class CharEncoded:
    __morse_code: Final[str]
    __roman_code: Final[str]

    def __init__(self, roman: str, morse: str):
        self.__roman_code = roman
        self.__morse_code = morse

    @property
    def morse_code(self) -> str:
        return self.__morse_code

    @property
    def roman_code(self) -> str:
        return self.__roman_code

    def is_roman_code(self, possible_roman_char: str) -> bool:
        return self.__roman_code.lower() == clean_whitespaces(possible_roman_char).lower()

    def is_morse_code(self, possible_morse_char: str) -> bool:
        return self.__morse_code == clean_whitespaces(possible_morse_char)
