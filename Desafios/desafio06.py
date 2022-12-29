palabra = "hola mundo"

def inicio():
    largo = int(len(palabra)) #tomo el largo de la palabra
    print(resultado = reorganizador(largo, palabra))#envio el largo y la palabra
    

def reorganizador(largo, palabra):
    nueva_palabra = ""#inicio la variable str
    for i in range(1,largo+1): #hace un recorrido desde el 1 hasta el largo + 1
        comodin = palabra[-i] #el comodin toma el valor del caracter contrario al recorrido
        nueva_palabra = nueva_palabra + comodin  #el comodin va apilando los caracteres en el resultado
    return nueva_palabra
inicio()