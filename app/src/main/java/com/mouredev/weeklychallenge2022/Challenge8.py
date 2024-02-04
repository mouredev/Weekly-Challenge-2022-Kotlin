"""/*
 * Crea un programa se encargue de transformar un número
 * decimal a binario sin utilizar funciones propias del lenguaje que lo hagan directamente.
 */"""

def dec_a_bin(num):
    cadena = ""       
    while num > 0:
        cadena = str(num % 2) + cadena
        num = num // 2
    if len(cadena) < 4:
        long = 4 - len (cadena)
        for i in range (0,long):
            cadena = "0" + cadena    
            i = i + 1
        print(cadena)
    else:             
        print(cadena)
        
num = int(input("Introduce el decimal que quieres convertir a binario: "))
dec_a_bin(num) 