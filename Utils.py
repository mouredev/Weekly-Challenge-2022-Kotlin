from enum import Enum, unique
from typing import Tuple


@unique
class AlphabetType(Enum):
    MORSE = 1
    ROMAN = 2

    @classmethod
    def recognize_alphabet(cls, text: str) -> "AlphabetType":
        vowel_tuple: Tuple[str, ...] = ('a', 'e', 'i', 'o', 'u')
        numbers_tuple: Tuple[str, ...] = ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

        for vowel_or_number in vowel_tuple + numbers_tuple:
            if vowel_or_number in text.lower():
                return cls.ROMAN

        return cls.MORSE


@unique
class TextSpacing(Enum):
    MORSE = "  "
    ROMAN = " "


@unique
class CharSpacing(Enum):
    MORSE = " "
    ROMAN = ""
