"""
#14¿ES UN NÚMERO DE ARMSTRONG?
/*
 * Escribe una función que calcule si un número dado es un número de Armstrong
 * (o también llamado narcisista).
 * Si no conoces qué es un número de Armstrong, debes buscar información
 * al respecto.
 */

Es un número que equivale a la suma de sus dígitos, cada uno elevado a una potencia. 
Por ejemplo, si tienes un número como 153, es un Armstrong número porque 1^3 + 5^3 + 3^3 es igual a 153

"""

def calculadora (num):

    num2 = str(num) #convertimos el numero en texto para poder interactuar con el
    suma = 0

    for i in range (len (num2)): #recorremos el numero y lo elevamos al numero de digitos que tiene 
        suma += pow (int (num2[i]), len (num2))

    if suma == num: # comprobamos 
        print (f"el numero {num} SI es un número de Armstrong")
    else:
        print (f"el numero {num} NO es un número de Armstrong")

calculadora (153)
calculadora (8208)
calculadora (1533)