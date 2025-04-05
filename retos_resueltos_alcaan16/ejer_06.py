"""
#6-INVIRTIENDO CADENAS
/*
 * Crea un programa que invierta el orden de una cadena de texto
 * sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 */
"""

def reves (texto):
    texto_reves = ""
    largo =  len(texto)
    print (texto)
    #print (largo)
    for i in range (0, largo):
        #print (texto[i])
        texto_reves += texto[largo-i-1] 
    return texto_reves

print(reves("Hola mundo"))