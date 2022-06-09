
def main():
    while True:
        try:
            num1 = int(input('Introduce el primer número: '))
            break
        except:
            print("No has introducido un primer numero entero")
    while True:
        try:
            num2 = int(input('Introduce el segundo número: '))
            break
        except:
            print("No has introducido un segundo número entero")
    print(f'El MCD es {getMCD(num1,num2)}')
    print(f'El MCM es {getMCM(num1,num2)}')    
    
def getMCD(number1,number2):
    if number2>number1:
        number1,number2 = number2,number1
    div =  number1%number2   
    if number2%div == 0:
            return int(div)

def getMCM(number1,number2):
    return int((number1*number2)/getMCD(number1,number2))

if __name__ == '__main__':
    main()

