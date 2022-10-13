"""
* Reto #2
* LA SUCESIÓN DE FIBONACCI
* Fecha publicación enunciado: 10/01/22
* Fecha publicación resolución: 17/01/22
* Dificultad: DIFÍCIL
*
* Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
* La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
* 0, 1, 1, 2, 3, 5, 8, 13...
*
"""

#Athor: Jose Silva
#Date: 12/10/2022
#Challenge 2

def fibonacci():
    a, b = 0, 1
    for i in range(1,51):
        print(a, end = " ")
        a, b = b, a+b

fibonacci()