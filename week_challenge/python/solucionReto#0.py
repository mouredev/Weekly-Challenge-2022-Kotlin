# solucion reto #0
# mode: easy xD

# * Enunciado: Escribe un programa que muestre por consola (con un print) los números de 1 a 100 (ambos incluidos y con un salto de línea entre cada impresión), sustituyendo los siguientes:
#  * - Múltiplos de 3 por la palabra "fizz".
#  * - Múltiplos de 5 por la palabra "buzz".
#  * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".



def main():

    count = 0

    while count <= 100:

        isDivideByFive = count % 5 == 0
        isDivideByThree = count % 3 == 0

        if isDivideByFive and isDivideByThree :
            print('fizzbuzz')
        if isDivideByFive:
            print('buzz')
        if isDivideByThree:
            print('fizz')
        
        count +=1

main()

# big(0) = time Complexity 0(1) 
# big(0) = space Complexity 0(1)