from cmath import nan
import sys

def main():
    myFile ='Reto21/Challenge21.txt'
    #myFile = input("Introduce ruta del fichero: ")

    # Leo fichero, almaceno las líneas en una lista de strings y cierro el fichero
    fichero = open(myFile, 'r')
    Lines = fichero.readlines()
    fichero.close()
    
    # Variable para almacenar el resultado
    result = 0
    # Variable para almacenar una operación matemática
    data = ''
    # Variable contador
    lineNum = 1
    # Recorro las líneas del fichero
    for line in Lines: 
        # Concateno línea en variable data
        data += line.strip()
        # Por cada 3 líneas tengo una operación matemática
        if (lineNum % 3 == 0):
            #print(data)
            # Almaceno el resultado de la operación matemática
            result = getResult(data)
            # Incluyo el resultado como un elemento más de la lista
            Lines.insert(lineNum,str(result))
            # Vacío data para que sólo tenga una operación matemática
            data=''
        lineNum += 1
    # Redondeo el resultado a 2 decimales
    print(round(result,2))    
        

def getResult(operation):
    
    if(operation.count('+') > 0):
        num1,num2 = operation.split('+')
        return (castNumber(num1)+castNumber(num2))
    elif(operation.count('-')):
        elems = operation.split('-')
        # Para control de números negativos
        if len(elems) != 2:
            ind = operation.find('-',1)
            num1 = operation[0:ind]
            num2 = operation[ind+1:]
        else:
           num1,num2 = operation.split('-')
        return (castNumber(num1)-castNumber(num2))
    elif(operation.count('*')):
        num1,num2 = operation.split('*')
        return (castNumber(num1)*castNumber(num2))
    elif(operation.count('/')):
        num1,num2 = operation.split('/')
        return (castNumber(num1)/castNumber(num2))
    else:
        sys.exit(f'No se han podido resolver las operaciones. Error en: {operation}')

def castNumber(numString):
    try:
        return float(numString)
    except:
        sys.exit(f'No se han podido resolver las operaciones. Error obteniendo número de: {numString}')
        

if __name__ == '__main__':
    main()

