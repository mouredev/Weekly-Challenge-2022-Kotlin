from typing import List, Tuple, Final

from Alphabet import ALPHABET, SPECIAL_WORDS
from CharEncoded import CharEncoded
from Utils import AlphabetType, CharSpacing


class WordEncoded:
    __word: Final[str]
    __current_alphabet: AlphabetType
    __alphabet: Final[Tuple[CharEncoded, ...]] = ALPHABET
    __special_words: Final[Tuple[CharEncoded]] = SPECIAL_WORDS
    is_special_word: Final[bool]

    @property
    def __word_encoded(self) -> List[CharEncoded]:
        if self.is_special_word:
            return self.__identify_special_word(self.__word)
        return self.__identify_chars(self.__word)

    def __init__(self, word: str, current_alphabet: AlphabetType):
        self.__word = word
        self.__current_alphabet = current_alphabet
        self.is_special_word = self.special_word_check(word)

    def special_word_check(self, word: str) -> bool:
        for special_word in self.__special_words:
            if special_word.is_roman_code(word) or special_word.is_morse_code(word):
                return True
        return False

    def __identify_special_word(self, word: str) -> List[CharEncoded]:
        char_encoded_list: List[CharEncoded] = [special_word
                                                for special_word in self.__special_words
                                                if special_word.is_roman_code(word)
                                                or special_word.is_morse_code(word)
                                                ]

        return char_encoded_list

    def __identify_chars(self, word: str) -> List[CharEncoded]:
        if self.__current_alphabet == AlphabetType.MORSE:
            return self.__identify_morse_chars(word)

        return self.__identify_roman_chars(word)

    def __identify_morse_chars(self, word: str) -> List[CharEncoded]:
        morse_word = word.split(CharSpacing.MORSE.value)
        char_encoded_list: List[CharEncoded] = [char_encoded
                                                for char in morse_word
                                                for char_encoded in self.__alphabet
                                                if char_encoded.is_morse_code(char)
                                                ]

        return char_encoded_list

    def __identify_roman_chars(self, word: str) -> List[CharEncoded]:
        char_encoded_list: List[CharEncoded] = [char_encoded
                                                for char in word
                                                for char_encoded in self.__alphabet
                                                if char_encoded.is_roman_code(char)
                                                ]

        return char_encoded_list

    def decode(self) -> str:
        if self.__current_alphabet == AlphabetType.MORSE:
            return self.__decode_roman()

        return self.__decode_morse()

    def __decode_morse(self) -> str:
        decoded_word_list: List[str] = [char.morse_code for char in self.__word_encoded]
        decoded_word: str = CharSpacing.MORSE.value.join(decoded_word_list)

        return decoded_word

    def __decode_roman(self) -> str:
        decoded_word_list: List[str] = [char.roman_code for char in self.__word_encoded]
        decoded_word: str = CharSpacing.ROMAN.value.join(decoded_word_list)

        return decoded_word
