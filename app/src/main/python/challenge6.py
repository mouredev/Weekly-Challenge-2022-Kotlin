"""
 * Reto #6
 * INVIRTIENDO CADENAS
 * Fecha publicación enunciado: 07/02/22
 * Fecha publicación resolución: 14/02/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
"""


def reverse(text: str) -> str:
    text_count = len(text) - 1
    reversed_text = []

    for i in range(0, text_count + 1):
        reversed_text.append(text[text_count - i])

    return "".join(reversed_text)


if __name__ == '__main__':
    print(reverse('hola mundo'))
    print(reverse('weekly challenge'))
