# /*
#  * Enunciado: Crea un programa se encargue de transformar un número binario
#  * a decimal sin utilizar funciones propias del lenguaje que 
#  * lo hagan directamente.
#  */
def main(bin):
    bin=str(bin)
    size=len(bin)
    b=0
    ans=0
    total=0
    for i in range (0,size):
        position=((size-1) -i)
        digit=bin[i]
        digit=int(digit)
        multi=digit*2**position
        total+=multi
            
    return total

if __name__ == "__main__":
    bin=int(input("Type your binary number\n"))
    print(f'The decimal number is: {main(bin)}')