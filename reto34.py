
#
# Enunciado: Dado un array de enteros ordenado y sin repetidos,
# crea una función que calcule y retorne todos los que faltan entre
# el mayor y el menor.
# - Lanza un error si el array de entrada no es correcto.
#

array = (1, 4, 8, 16)


def arrayValido(array):
    x = 0
    y = 1
    try:
        while x < len(array) - 1:
            if type(array[x]) != int:
                return False
            else:
                if array[y] < array[x]:
                    return False
                else:
                    y += 1
            x += 1
        return True
    except:
        return False

def buscaFaltante(array):
    inicio = array[0]
    final = array[-1]
    return set(range(inicio, final + 1)).difference(array)


if arrayValido(array):
    buscaFaltante(array)
    print(array)
    print(buscaFaltante(array))
else:
    print("Array no válido")