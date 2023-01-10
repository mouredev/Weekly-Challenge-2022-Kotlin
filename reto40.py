#
# Reto #40
# TRIÁNGULO DE PASCAL
# Fecha publicación enunciado: 03/10/22
# Fecha publicación resolución: 10/10/22
# Dificultad: MEDIA
#
# Enunciado: Crea una función que sea capaz de dibujar el "Triángulo de Pascal"
# indicándole únicamente el tamaño del lado.
#
# - Aquí puedes ver rápidamente cómo se calcula el triángulo:
#   https://commons.wikimedia.org/wiki/File:PascalTriangleAnimated2.gif
#

def matriz(lados):
    salida = {}
    if lados == 1:
        salida[0] = 1
    if lados == 2:
        salida[0] = 1
        salida[1] = 1
    if lados > 2:
        salidaAux = matriz(lados - 1)
        for i in range(lados):
            if (i == 0) or (i == lados - 1):
                salida[i] = 1
            else:
                salida[i] = salidaAux[i - 1] + salidaAux[i]
    return salida


def trianguloPascal(lados):
    for i in range(lados + 1):
        triangulo = matriz(i)
        for j in range(len(triangulo)):
            print(triangulo[j], end='  ')
        print()


if __name__ == "__main__":
    lados = input("Lados: ")
    trianguloPascal(int(lados))
