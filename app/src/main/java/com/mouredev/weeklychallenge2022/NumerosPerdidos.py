# Enunciado Reto #34: Dado un array de enteros ordenado y sin repetidos, 
# crea una función que calcule y retorne todos los que faltan entre
# el mayor y el menor.
# - Lanza un error si el array de entrada no es correcto.

def numerosPerdidos(lista):
    numeroLista = 0
    listaPerdidos=[]
    pos = 0
    error=0
    for i in range(len(lista)):
        numeroAnterior=numeroLista
        numeroLista=lista[i]
        if numeroLista > numeroAnterior:
            perdidos = numeroLista - numeroAnterior -1 
            for dif in range(perdidos):
                listaPerdidos.insert(pos,numeroLista - perdidos + dif)
                pos += 1 
        elif numeroLista == numeroAnterior:
            error = 1
        else:
            error = 2
    if error == 0:
        print("Lista de Enteros Perdidos:", listaPerdidos)
    elif error == 1:
        print("Error en la array de entrada, no puede haber números repetidos")
    else:
        print("Error en la array de entrada, la array ha de estar ordenada de más pequeño a mayor")

numerosPerdidos([1,2,5])
numerosPerdidos([1,1,5]) # Error entrada de array, numeros repetidos
numerosPerdidos([2,1,5]) # Error entrada de array, no ordenados
numerosPerdidos([1,5,10])
numerosPerdidos([1,15])