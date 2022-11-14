"""
 * Reto  # 8
 * DECIMAL A BINARIO
 * Fecha publicación enunciado: 18/02/22
 * Fecha publicación resolución: 02/03/22
 * Dificultad: FÁCIL

 * Enunciado: Crea un programa se encargue de transformar un número decimal a binario 
                sin utilizar funciones propias del lenguaje que lo hagan directamente.
"""


def decimal_to_binary(decimal: int) -> str:
    """Convirtiendo de decimal a binario usando el método de division sucesiva por 2."""

    binary = ""

    while decimal != 0:

        remainder = decimal % 2
        decimal //= 2
        binary = f"{remainder}{binary}"

    return "0" if binary == '' else binary


if __name__ == '__main__':
    print(decimal_to_binary(20))
    print(decimal_to_binary(0))
    print(decimal_to_binary(270))
    print(decimal_to_binary(3))
