"""
Dado un listado de números, encuentra el SEGUNDO más grande.
"""
#Declaramos una lista
list = [154, 900, 9, 1, 2 ,3]

#Ordenamos la lista de menor mayor
list.sort()

#Elegimos el segundo máximo
second_max = list[-2]
print (second_max)