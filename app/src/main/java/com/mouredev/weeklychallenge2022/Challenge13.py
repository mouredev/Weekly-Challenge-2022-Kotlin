"""/*
 * Escribe una función que calcule y retorne el factorial de un número dado
 * de forma recursiva.
 */"""
 
def factorial (num):
    if num > 0:
        mul = num * factorial (num-1)
        return mul
    else:
        return 1

print(factorial(2))
print(factorial(3))
print(factorial(4))
print(factorial(25))
print(factorial(5))
print(factorial(10))