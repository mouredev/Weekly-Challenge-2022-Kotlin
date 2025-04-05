"""
#7-CONTANDO PALABRAS
/*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */
"""

#funcion para eliminar los simbolos

def corrector (frase):

    simbolos = [".", ",", ":", ";", "!", "¡", "?", "¿", "(", ")", "{", "}", "[", "]", "-"]
    frase_nueva = ""

    #recorre la frase letra por letra y elimina los simbolos    
    for letra in frase:
       
        if letra in simbolos:
            letra = ("")
                
        frase_nueva += letra
        
    #devuelve la frase convertida en una lista y en minusculas
    return frase_nueva.lower().split(" ")


# funcion principal para contar
def contar (frase):

    frase_listada = corrector(frase)
    contador = {}
    #recorre en la frase listada nueva las palabras y las asigna a un diccionario
    for palabra in frase_listada:
        if palabra not in contador:
            contador[palabra] = 1
        else:
            contador[palabra] += 1

    #recorre el diccionario y lo muestra
    print("el conteo es el siguiente: ")
    for listado in contador:
        print (f"{listado} : {contador[listado]}") 


contar("esta es la Prueba, prueba? prueba:")