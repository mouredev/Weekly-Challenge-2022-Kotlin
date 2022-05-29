import os
import sys

def main():
    myFile ='Challenge21.txt'
    #myFile = input("Introduce ruta del fichero: ")

    fichero = open(myFile, 'r')
    Lines = fichero.readlines()
    fichero.close()
    #print(len(fichero.readlines()))
    result = 0
    data = ''
    lineNum = 1
    for line in Lines: 
        data += line.strip()
        if (lineNum % 3 == 0):
            print(data)
            result = getResult(data)
            Lines.insert(lineNum,str(result))
            data=''
        lineNum += 1
    print(result)    
        

def getResult(operation):
    
    if(operation.count('+') > 0):
        num1,num2 = operation.split('+')
        return round(castNumber(num1)+castNumber(num2),2)
    elif(operation.count('-')):
        num1,num2 = operation.split('-')
        return round(castNumber(num1)-castNumber(num2),2)
    elif(operation.count('*')):
        num1,num2 = operation.split('*')
        return round(castNumber(num1)*castNumber(num2),2)
    elif(operation.count('/')):
        num1,num2 = operation.split('/')
        return round(castNumber(num1)/castNumber(num2),2)
    else:
        sys.exit(f'No se han podido resolver las operaciones. Error en: {operation}')

def castNumber(numString):
    try:
        return float(numString)
    except:
        sys.exit(f'No se han podido resolver las operaciones. Error obteniendo número de: {numString}')
        

if __name__ == '__main__':
    main()

