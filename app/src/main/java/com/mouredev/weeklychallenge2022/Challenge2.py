"""/*
 * Escribe un programa que imprima los 50 primeros números de la sucesión
 * de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */"""

def fibonacci():
    print("Estos son los 50 primeros números de la sucesión de Fibonacci empezando en 0")
    pri = sum =  0
    seg = 1
    for i in range (0,50):
        print(pri)
        sum = pri + seg
        pri = seg
        seg = sum
