"""
#11-ELIMINANDO CARACTERES
/*
 * Crea una función que reciba dos cadenas como parámetro (str1, str2)
 * e imprima otras dos cadenas como salida (out1, out2).
 * - out1 contendrá todos los caracteres presentes en la str1 pero NO
 *   estén presentes en str2.
 * - out2 contendrá todos los caracteres presentes en la str2 pero NO
 *   estén presentes en str1.
 */
"""

def eliminar(str1, str2):
    
    #inciamos variables
    out1 = ""
    out2 = ""
    lista_1 =[]
    lista_2 =[]

    # convertimos las cadenas de texto en listas
    for x in str1.lower():
        lista_1 += x
    for z in str2.lower():
        lista_2 += z
    
    #recorremos las lista en busca de coincidencias
    for var1 in lista_1:
        if var1 not in lista_2:
            out1 += var1
    for var2 in lista_2:
        if var2 not in lista_1:
            out2 += var2


    return out1,out2

print (eliminar("Hola", "adios"))
