
def calFactorial(numero):
    
    if numero == 1:
        return 1
    else:
        return numero * calFactorial(numero-1)

#Llamada función principal
if __name__ == '__main__':
    numero = int(input('Introduce un número: '))
    print(f'El factorial de {numero} es:',calFactorial(numero))