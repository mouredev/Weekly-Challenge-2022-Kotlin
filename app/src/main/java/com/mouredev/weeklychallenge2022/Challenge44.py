# 
# Reto #44: BUMERANES
# FÁCIL | Publicación: 02/10/22 | Resolución: 07/11/22
# /*
#  * Enunciado: Crea una función que retorne el número total de bumeranes de 
#  * un array de números enteros e imprima cada uno de ellos.
#  * - Un bumerán (búmeran, boomerang) es una secuencia formada por 3 números
#  *   seguidos, en el que el primero y el último son iguales, y el segundo
#  *   es diferente. Por ejemplo [2, 1, 2].
#  * - En el array [2, 1, 2, 3, 3, 4, 2, 4] hay 2 bumeranes ([2, 1, 2] 
#  *   y [4, 2, 4]).
#  */

import random


def boomerang_search(array):

    print(f""" 
    >> Array generado aleatoriamente: 
    {array}""")

    boom_numbers = []
    counter = 0
    q = len(array) - 1

    for item in range(0, q):

        if (item + 2) > q:
            break
        else:
            n1 = array[item]
            n2 = array[item +1]
            n3 = array[item + 2]

            if n1 == n3 and n1 != n2:
                boom_numbers.append([n1,n2,n3])
                counter += 1


    return print(f""" 
    >> 🪃 Bumeranes encontrados: {counter}

    >> Los Bumeranes son: {boom_numbers}""")


# array = [2, 1, 2, 3, 3, 4, 2, 4]
# boomerang_search(array)

# Bonus track >> Generador de arrays aleatorios


def array_generator (n):     
    random_array = []
    for item in range(0, n):
        random_array.append(random.randint(0, 9))

    return random_array

# Agrega el la cantidad de elementos "n" que deseas tenga el Array
# n debe ser un integer positivo

n = 20

boomerang_search(array_generator(n))