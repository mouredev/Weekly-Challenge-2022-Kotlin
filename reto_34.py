"""

Reto de programación #34
Daniel Mattps
Lenguaje Python

"""
lista_ordenada = [5, 6, 7, 8, 9, 11, 14, 17, 20, 25, 40]
lista_ordenada.sort()  # solo para asegurar que esta ordenada
lista_faltante = []

numero_actual = None

while lista_ordenada:
    if numero_actual is None:
        numero_actual = lista_ordenada.pop(0)
        continue

    numero_actual += 1
    elemento = lista_ordenada[0]
    if numero_actual == elemento:
        numero_actual = elemento
        elemento = lista_ordenada.pop(0)
    elif numero_actual < elemento:
        lista_faltante.append(numero_actual)
        print('Falta el número', numero_actual)
    else:
        # Si es que hay números repetidos
        lista_ordenada.pop(0)
        print('Error con el numero de la lista', elemento)
        numero_actual -= 1

print('Numeros faltantes: ', lista_faltante)


"""
Resultado:

Falta el número 10
Falta el número 12
Falta el número 13
Falta el número 15
Falta el número 16
Falta el número 18
Falta el número 19
Falta el número 21
Falta el número 22
Falta el número 23
Falta el número 24
Falta el número 26
Falta el número 27
Falta el número 28
Falta el número 29
Falta el número 30
Falta el número 31
Falta el número 32
Falta el número 33
Falta el número 34
Falta el número 35
Falta el número 36
Falta el número 37
Falta el número 38
Falta el número 39
Numeros faltantes:  [10, 12, 13, 15, 16, 18, 19, 21, 22, 23, 24, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39]


"""
