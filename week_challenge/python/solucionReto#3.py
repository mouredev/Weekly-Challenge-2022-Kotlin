# solucion Reto#2
# Dificultad: DIFÍCIL

# LA SUCESIÓN DE FIBONACCI

# Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
# La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
# 0, 1, 1, 2, 3, 5, 8, 13...


def isPrime(number):
    
    index = 1
    result = []

    while index <= number:
        isRemainderZero = number%index == 0
        if isRemainderZero :
             result.append(index)
        index+=1
    if len(result) == 2 :
        print(number)


def onetoHundred():

    index = 1
    while index <= 100:
        isPrime(index)
        index+=1
onetoHundred()

# big(0) time complexity = 0(n^^2)
# big(0) space complexity = 0(n^^2)