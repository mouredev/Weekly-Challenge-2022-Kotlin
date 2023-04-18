"""
    Reto #1
    ¿ES UN ANAGRAMA?
    Fecha publicación enunciado: 2022/01/
    Fecha publicación resolución: 2023/04/18
    Dificultad: MEDIA

    Enunciado: Escribe una función que reciba dos palabras (String)
        y retorne verdadero o falso (Boolean) según sean o no anagramas.
    Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
    NO hace falta comprobar que ambas palabras existan.
    Dos palabras exactamente iguales no son anagrama.
"""


def main():
    """Función principal"""

    texto_01 = input("Escriba una palabra: ")
    texto_02 = input("Escriba una segunda palabra: ")

    son_anagramas = anagrama(texto_01, texto_02)
    if son_anagramas:
        print("Las palabras SON ANAGRAMAS")
    else:
        print("Las palabras NO son ANAGRAMAS")


def anagrama(texto_01: str, texto_02: str) -> bool:
    """Recibe dos textos y determina si es un anagrama"""

    # Como lo aclara el reto, dos textos iguales no son un anagrama
    if texto_01 == texto_02:
        return False

    # Si tiene diferente longitud lo más seguro es que sean diferentes
    if len(texto_01) != len(texto_02):
        return False

    # Revisar el texto_01 contiene cada una de sus letras
    for letra in texto_01:
        if not letra in texto_02:
            return False
    # Comprobamos en el otro sentido, si el texto_02 contiene todas las letras del texto_01
    for letra in texto_02:
        if not letra in texto_01:
            return False

    # Entrega True si pasó todas las pruebas
    return True


if __name__ == "__main__":
    main()
