"""
* Reto #3
* ¿ES UN NÚMERO PRIMO?
* Fecha publicación enunciado: 17/01/22
* Fecha publicación resolución: 24/01/22
* Dificultad: MEDIA
*
* Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
* Hecho esto, imprime los números primos entre 1 y 100.
"""

#Author: Jose Silva
#Date: 12/10/2022
#Challenge 3

def is_primo(n):
    if n < 2:
        return False
    for i in range(2,int(n/2)):
        if n % i == 0:
            return False
        return f'{n} es primo'
for k in range(2,101):
    print(is_primo(k))