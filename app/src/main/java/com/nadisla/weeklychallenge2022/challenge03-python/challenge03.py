"""
* Challenge #3
* IS IT A PRIME NUMBER?
* Difficulty: MEDIUM
*
* Statement: Write a program that is responsible for checking whether or not a number is prime.
* Once this is done, print the prime numbers between 1 and 100.

* Reto #3
* ¿ES UN NÚMERO PRIMO?
* Dificultad: MEDIA
*
* Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
* Hecho esto, imprime los números primos entre 1 y 100.
"""
def is_prime(number):
    divisors = 0;
    if (number < 2):
        return False
    for num in range(1, number + 1):
        if (number % num == 0):
            divisors += 1
    return True if divisors == 2 else False
for num in range(1, 101):
    if (is_prime(num)):
        print(num)