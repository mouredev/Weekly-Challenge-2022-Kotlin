""" 
Enunciado: Crea un programa se encargue de transformar un número binario a decimal sin utilizar funciones propias del lenguaje que lo hagan directamente.
"""

binario = str(input("Introduce un número binario: "))
decimal = 0
n = len(binario)
for i in binario:
    n -= 1
    decimal = decimal + (2**n) * int(i)
print("Número decimal equivalente:", decimal)
