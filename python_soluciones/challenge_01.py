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


def anagrama(texto_01:str, texto_02:str) -> bool:
    """Recibe dos textos y determina si es un anagrama"""

    # Comprobación de textos vacíos
    if texto_01 == "" or texto_02 == "":
        return False

    # Como lo aclara el reto, dos textos iguales no son un anagrama
    if texto_01 == texto_02:
        return False


if __name__ == "__main__":
    main()
