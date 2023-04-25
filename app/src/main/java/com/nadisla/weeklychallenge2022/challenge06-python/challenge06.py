"""
* Challenge #6
* REVERSING STRINGS
* Difficulty: EASY
*
* Statement: Create a program that reverses the order of a text string without using language-specific functions that do so automatically.
* - If we pass "Hello world" we would return "dlrow olleH"
*
* Reto #6
* INVIRTIENDO CADENAS
* Dificultad: FÁCIL
*
* Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
* - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
"""
def reverse_string(string):
    reversed_string = ""
    str_len = len(string) - 1
    for idx in range(str_len):
        str_len = str_len - 1
        reversed_string += string[str_len]
    return reversed_string
print(reverse_string("Hello world"))