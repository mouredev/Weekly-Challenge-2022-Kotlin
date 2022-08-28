#Array de prueba
order_array = [2,4,7,9,10,11]
disordered_array = [2,7,4,8,9,10]
repeated_array = [2,2,4,8,9,11]

def faltantes(data):
    primer_item = data[0]
    ultimo_item = data[-1]
    num_faltantes = ultimo_item - primer_item
    #Error si el array no esta ordenado
    
    for i in range(1,len(data)):
            #Pruebas al arreglo
            if(data[i-1]>data[i]):
                print('Error: El arreglo no esta ordenado')
                exit() 
            if(data[i-1]==data[i]):
             print('Error: El arreglo tiene caracteres repetidos')
             exit()
    
    
    print('Numeros faltantes : ')
    for i in range(1,num_faltantes):
        print(data[0]+i)

#Prueba #1 Arreglo ordenado
faltantes(order_array)
#Prueba #2 Arreglo desordenado
faltantes(disordered_array)
#Prueba #3 Arreglo con caracteres repetidos
faltantes(repeated_array)