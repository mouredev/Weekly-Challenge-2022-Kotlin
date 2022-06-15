"""
  Reto #10
  EXPRESIONES EQUILIBRADAS
  Fecha publicación enunciado: 07/03/22
  Fecha publicación resolución: 14/03/22
  Dificultad: MEDIA

  Enunciado: Crea un programa que comprueba si los paréntesis, llaves y corchetes de una expresión están equilibrados.
  - Equilibrado significa que estos delimitadores se abren y cieran en orden y de forma correcta.
  - Paréntesis, llaves y corchetes son igual de prioritarios. No hay uno más importante que otro.
  - Expresión balanceada: { [ a * ( c + d ) ] - 5 }
  - Expresión no balanceada: { a * ( c + d ) ] - 5 }

  Información adicional:
  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
"""
from typing import List, Tuple


class Delimiter:
    __start: str
    __end: str
    __name: str

    @property
    def name(self) -> str:
        return self.__name

    @property
    def start(self) -> str:
        return self.__start

    @property
    def end(self) -> str:
        return self.__end

    def __init__(self, name, start, end):
        self.__start = start
        self.__end = end
        self.__name = name

    def is_equilibrated(self, start: str, end: str) -> bool:
        return self.__start == start and self.__end == end

    def are_delimiters(self, delimiters: Tuple[str, str]) -> bool:
        first, second = delimiters

        first_is_delimiter: bool = first == self.__start or first == self.__end
        second_is_delimiter: bool = second == self.__start or second == self.__end

        return first_is_delimiter and second_is_delimiter


def is_equilibrated(expression: str) -> bool:
    delimiters: List[Delimiter] = [
        Delimiter(start="{", end="}", name="llave"),
        Delimiter(start="[", end="]", name="corchete"),
        Delimiter(start="(", end=")", name="parentesis")
    ]

    char_delimiter_list: List[str] = [char
                                      for char in expression
                                      for delimiter in delimiters
                                      if char == delimiter.start or char == delimiter.end
                                      ]

    is_even: bool = len(char_delimiter_list) % 2 == 0

    if not is_even:
        return False

    char_delimiter_list_middle_index: int = len(char_delimiter_list) // 2

    char_delimiter_list_first_half: List[str] = char_delimiter_list[:char_delimiter_list_middle_index]
    char_delimiter_list_second_half_reversed: list[str] = char_delimiter_list[char_delimiter_list_middle_index:][::-1]

    delimiter_pair_list: Tuple[Tuple[str, str]] = tuple(zip(char_delimiter_list_first_half,
                                                            char_delimiter_list_second_half_reversed))

    for start, end in delimiter_pair_list:

        delimiter = [delimiter for delimiter in delimiters if delimiter.are_delimiters((start, end))]

        if not delimiter or not delimiter[0].is_equilibrated(start, end):
            return False

    return True


if __name__ == '__main__':
    expression1: str = "{ [ a * ( c + d ) ] - 5 }"
    expression2: str = "{ a * ( c + d ) ] - 5 "
    expression3: str = "{ a * ) c + d ] ( - 5 }"
    expression4: str = "{ a * ) c + d ( ] - 5 }"

    print("Expresión balanceada: {0} - {1}".format(expression1, is_equilibrated(expression1)))
    print("Expresión no balanceada: {0} - {1}".format(expression2, is_equilibrated(expression2)))
    print("Expresión no balanceada: {0} - {1}".format(expression3, is_equilibrated(expression3)))
    print("Expresión no balanceada: {0} - {1}".format(expression3, is_equilibrated(expression4)))

# Expresión balanceada: { [ a * ( c + d ) ] - 5 } - True
# Expresión no balanceada: { a * ( c + d ) ] - 5  - False
# Expresión no balanceada: { a * ) c + d ] ( - 5 } - False
# Expresión no balanceada: { a * ) c + d ] ( - 5 } - False
