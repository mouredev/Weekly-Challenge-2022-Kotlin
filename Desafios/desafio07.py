
def inicio():
    oracion = "Hola, yo soy alguien que dice mucho hola, yo soy hola"
    print(oracion)
    oracion = comas(oracion)
    oracion = oracion.lower()
    separacion_palabras = carga_lista_int(oracion)
    oracion = vaciar_espacios(oracion)
    oracion = cargar_lista_palabras(oracion, separacion_palabras)
    dic_palabras(oracion)


def dic_palabras(lista):
    repeticiones = {}
    for n in lista:
        if n in repeticiones :
            repeticiones[n] += 1 #le agrega valor al dic
        else:
            repeticiones[n] = 1 #crea el dic

    print(repeticiones)
    print("total de palabras" , sum(repeticiones.values()))




def vaciar_espacios(oracion): #se elimina los espacios de la oracion
    nueva_oracion = ""
    comodin = ""
    for i in range(len(oracion)):
        if oracion[i] != " ":
            comodin = oracion[i]
            nueva_oracion = nueva_oracion + comodin
    return nueva_oracion

def cargar_lista_palabras(oracion, saltos): #hace una lista con las palabras separadas
    saltos.append(len(oracion))
    contador = 0
    comodin = ""
    lista_palabras = list()
    for a in saltos:
        palabra = ""
        for b in range(contador, a):
         comodin = oracion [b]
         palabra = palabra + comodin
         contador = contador + 1
        lista_palabras.append(palabra)
    return lista_palabras


def carga_lista_int(oracion): #guarda en que posiciones hay espacio
    salto = list() 
    for i in range(len(oracion)):
        if oracion[i] == " ":
            valor_list = i - len(salto)
            salto.append(valor_list)
    return salto

            
def comas(oracion): #se elimina los puntos y comas de la oracion
    str_palabra = ""
    str_comodin = ""
    for i in range(len(oracion)):
        if oracion[i] == "," or oracion[i] == ".":
            pass
        else:
            comodin = oracion[i]
            str_palabra = str_palabra + comodin
    return str_palabra     

            
inicio()