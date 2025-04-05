"""
#16-EN MAYÚSCULA
/*
 * Crea una función que reciba un String de cualquier tipo y se encargue de
 * poner en mayúscula la primera letra de cada palabra.
 * - No se pueden utilizar operaciones del lenguaje que
 *   lo resuelvan directamente.
 */
"""

def convertir (texto):
    print (texto)

    lista = texto.split()#convertimos el texto en una lista para poder interactuar con ella

    #print (lista)   
    lista_mod = []
    palabra_nueva = ""
    for i in lista: #recorremos cada palabra una a una
        var = 0
        for x in i: #recorremos cada letra de la palabra
            if var == 0:
                palabra_nueva += x.upper() #convertimos la letra a mayuscula
                var = 1
            else:
                palabra_nueva += x.lower()#convertimos la letra a minuscula
        var = 0
        lista_mod.append(palabra_nueva) #añadimos la palabra nueva a la lista
        palabra_nueva = ""

    texto_mod = ""
    for i in lista_mod: #recorremos la lista modificada añadiendo un espacio y convirtiendola en texto
        texto_mod += i
        texto_mod += " "

    return texto_mod
    
print(convertir ("hola y adIOs pero esto es una prueba de ensayo y error"))