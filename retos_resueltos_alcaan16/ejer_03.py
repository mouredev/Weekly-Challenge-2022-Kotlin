"""
#3-¿ES UN NÚMERO PRIMO?
/*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 */

En matemáticas, un número primo es un número natural mayor que 1 
que tiene únicamente dos divisores positivos distintos: él mismo y el 1.
Los números primos son:
2, 3, 5, 7, 11, 13, 17, 19, 23, 29

"""
def primo (numero):
    if numero < 2:
        return False
    
    for i in range(2,numero):
        if numero %  i == 0:
            return False

    return True
x = 13
resultado = primo(x)
print (f"el numero {x} es primo? {resultado}")


#listado primos
def list_primo ():
    print ("\nlos primeros numeros primos son:")
    for numero_2 in range(0,101):
        if numero_2 >= 2:
            divisible = False
            for i in range(2,numero_2):
                if numero_2 % i == 0:  
                    divisible = True
                    break
            #if not divisible: #tambien es correcto
            if divisible == False:    
                print (numero_2)

list_primo()
