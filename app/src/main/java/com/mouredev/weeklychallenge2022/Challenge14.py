"""/*
 * Escribe una función que calcule si un número dado es un número de Armstrong
 * (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información 
 * al respecto.
 */"""

def narcisista(num):
    num = str (num)
    longitud = len(num)
    num = int(num)
    numero = num
    suma = dig = 0
    while num != 0:
        dig = int(num % 10)
        suma = suma + (dig ** longitud)
        num = int(num/10)
    if numero == suma:
        return True
    else:
        return False
    
print(narcisista(371))
print(narcisista(8208))
print(narcisista(2015))
print(narcisista(4210818))
print(narcisista(120))