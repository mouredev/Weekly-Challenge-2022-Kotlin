"""""
numeros primos = numeros divisibles entre ellos mismos y 1
el 1 y 0 no cuentan
"""""

def numeroprimo(numero):
    for n in range(2, numero): #hace un rango de 2 hasta el numero enviado
        if numero % n == 0:#comprueba si el numero del for es capaz de dividir al numero enviado
            print("No es primo", n, "es divisor")
            return False
    print(f"{numero} es primo")
    return True
    #Si el numero es divisible por alguno, no es primo, si no lo es es primo

def inicio(): 
    for i in range(100):#un for que va desde el 0 al 100
        if i <= 1: #Si el numero es menor igual a 1, hace pass
            pass
        else:
            numeroprimo(i) #envia el numero al comprobador de si es o no primo

inicio()
