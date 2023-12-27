"""/*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 */"""

def esprimo(num):
    contador = 0
    for i in range (1,num+1):
        if num % i == 0:
            contador = contador + 1
    if contador == 2:
        print(num)
    
print ("Los primeros 100 números primos son:")
for j in range (2,100):   
    esprimo (j)
