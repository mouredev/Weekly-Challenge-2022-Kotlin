"""
#13-FACTORIAL RECURSIVO
/*
 * Escribe una función que calcule y retorne el factorial de un número dado
 * de forma recursiva. hay que multiplicar todos los números enteros positivos que hay entre ese número y el 1
 */

"""

def calc (num: int):

    total = 1
    for x in range (1, num+1):
        total = total * x 

    print (f"el factorial de {num} es {total}")
    
calc (6)