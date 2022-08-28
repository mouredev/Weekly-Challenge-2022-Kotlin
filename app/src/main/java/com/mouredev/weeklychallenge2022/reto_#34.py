# # RETO #34
# 
# Enunciado: Dado un array de enteros ordenado y sin repetidos,  
# crea una función que calcule y retorne todos los que faltan entre  
# el mayor y el menor.  
# _Lanza un error si el array de entrada no es correcto._


# 6. funcion para devolver numeros faltantes
def lost_numbers(lista):
    '''
    ## 1. Descripción:
    ------------------
    Esta funcion recibe una lista ordenada ascendentemente y sin repetidos para devolver la cantidad y los números
    consecutivos faltantes.
    
    ## 2. Parámetros entrada:
    -------------------------
    Lista ordenada y sin repetidos: list
    
    ## 3. Parámetros salida:
    ------------------------
    Números faltantes: Int
    Lista con números faltantes: List
    
    ## 4. Proceso:
    --------------
    Para verificar cuantos numeros faltan lo que se realiza diferenciaentre el ultimo elemento (mayor) con el primero (menor), sumarle 1 y 
    compararlo con el tamaño de la lista (que es dinamico) ya que la lista ira incrementando su tamaño con forme va agregando los números
    faltantes. Dentro del bucle se calcula la diferencia entre dos elementos consecutivos y se le suma 1 para calcular cuantos números consecutivos
    faltantes hay entre ellos y asi ir insertandolos.
    '''
    i=0
    lista_temp = []
    while lista[-1]-lista[0]+1 != len(lista):
        dif=lista[i+1] - lista[i] - 1
        if dif > 0:
            for z in range(dif):
                lista.insert(i+1+z,lista[i+z]+1)
                lista_temp.append(lista[i+z]+1)
        i+=1

    return lista_temp, len(lista_temp)

# 5. Verifica si esta ordenado
def validate_order(lista):
    '''
    ## 1. Descripción
    -----------------
    Función que permite verificar si la lista esta ordenada ascendentemente
    
    ## 2. Parámetros entrada:
    -------------------------
    Lista de enteros: List
    
    ## 3. Parámetros salida:
    ------------------------
    0: No está ordenada
    1: Si está ordenada
    
    ## 4. Proceso
    -------------
    Esta funcion varifica si el elemento actual de la lista es mayor al siguiente en caso sea cierto el bucle se detiene
    
    '''
    i = 0
    while i < len(lista)-1:
        if lista[i] > lista[i+1]:
            return 0
        i+=1
    return 1

# 4.Verifica si hay repetidos
def validate_repeated(lista):
    '''
    ## 1. Descripción:
    ------------------
    Función que permite verificar si hay número repetidos en una lista
    
    ## 2. Parámetros entrada:
    -------------------------
    Lista de enteros: List
    
    ## 3. Parámetros salida:
    ------------------
    0: Si tiene repetidos
    1: No tiene repetidos
    
    ## 4. Proceso
    -------------
    Verifica si dos elementos de la lista contiguos son iguales
    '''
    i = 0
    while i < len(lista)-1:
        if lista[i] == lista[i+1]:
            return 0
        i+=1
    return 1

# 3. Convierte arreglo de string - arreglo de enteros
def convert_to_integer(lista_string):
    '''
    ## 1. Descripción
    -----------------
    Permite convertir una lista de elementos string's a una lista de enteros.
    
    ## 2. Parámetros entrada:
    -------------------
    Lista de string: List
    
    ## 3. Parámetros salida:
    ------------------
    Lista de enteros: List
    
    ## 4. Proceso
    -------------
    Verifica si dos elementos de la lista contiguos son iguales, con la ayuda de la funcion map(), pasamos la parte interior de la lista sin contar
    los corchetes del arreglo. y sobre eso lo separamos a través de las comas y luego convertimos a enteros.
    '''
    return list(map(int, lista_string[1:len(lista_string)-1].split(',')))

# 2. funcion para verificar que cada elemento posea digitos entre 0-9 y negativos
def validate_digits(lista_string):
    '''
    ## 1. Descripción
    -----------------
    Verifica que cada elemento (string) de la lista entregada tenga el formato de un número ya sea positivo o negativo
    
    ## 2. Parámetros entrada:
    -------------------
    Lista de string: List
    
    ## 3. Parámetros salida:
    ------------------
    0: No se cumple con el formato de un número positivo o negativo
    1: Se cumple con el formato de un número
    
    ## 4. Proceso
    -------------
    Pimero se separa la para interior del arreglo con formato de string y se separa a través de las comas.
    Posteriormente, se verificada cada elemento del arreglo.
    PAra ello, se valida primero si posee algún signo '-' para verificar si son negativos. En caso lo sea, se empieza evaluar los dígitos
    después de ese signo, verificando si estan en el rango de número de su respectivo código ASCII.
    En caso no se tenga el signo '-' se evalua igualmente pero desde el comienzo.
    '''
    lista_string = lista_string[1:len(lista_string)-1].split(',')
    element = 0
    while element < len(lista_string):
        
        signal = lista_string[element].count('-')
        
        if signal != 1:
            initial = 0
        else:
            initial = 1
    
        for i in range(initial,len(lista_string[element])):
            if (ord(lista_string[element][i]) < 48) or (ord(lista_string[element][i]) > 57):
                return 0 
        element+=1
    
    return 1

# 1. funcion para validar el formato
def validate_format(cadena):
    '''
    ## 1. Descripción
    -----------------
    Valida que el arreglo cumpla con el formato de un arreglo [1,2,3,4,5]
    
    ## 2. Parámetros entrada:
    -------------------------
    Cadena: String
    
    ## 3. Parámetros salida:
    ------------------------
    0: El arreglo no cumple con el formato de lista
    1: Si cumple con el formato
    
    ## 4. Proceso
    -------------
    Se verifica el formato del arreglo de una lista de números, es decir, si hay doble coma seguida o si solo hay ',' seguido de un ']', etc.
    '''
    i=1
    while i < len(cadena)-1:
        if cadena[i] == ',' and (cadena[i+1] == ',' or cadena[i+1] ==']' or cadena[i-1] == '['):
            return 0
        i+=1
    return 1

def main():
    '''
    Función principal, que verifica las diferentes condiciones que debe cumplir el arreglo para realizar el cálculo de números 
    faltantes
    
    Parámetros entrada:
    -------------------
    Ninguno
    
    ## 3.Parámetros salida:
    ------------------
    Ninguno
    
    ## 4. Proceso
    -------------
    Utiliza todas las funciones creadas para primero filtrar todos los requisitos que debe cumplir el ejercicio y una vez pasado dichos filtros
    realizar el calculo de números faltantes
    '''
    flag = -1
    while flag == -1:
        lista = input('Ingrese arreglo (ejm. [1,2,5,30]): ')
        if validate_format(lista) == 1:
            if validate_digits(lista) == 1:
                lista = convert_to_integer(lista)
                if validate_repeated(lista) == 1:
                    if validate_order(lista) == 1:
                        lista, cant = lost_numbers(lista)
                        if cant != 0:   
                            print(f'\nHay {cant} números perdidos')
                            print(f'\nLista = {lista}')
                            flag = 0
                        else:
                            print('Arreglo completo :)')
                            flag = 0
                    else:
                        print('Arreglo no está ordenado: :(')
                else:
                    print('Arreglo con números repetidos :(')
            else:
                print('Arreglo debe contener SOLO enteros :(')
        else:
            print('Formato de arreglo incorrecto :(')


if __name__ == '__main__':
    main()