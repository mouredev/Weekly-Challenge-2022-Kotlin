"""/*
 * Crea un programa que invierta el orden de una cadena de texto
 * sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 */"""
 
def invierte(cadena):
    cadenainvertida = ""
    for caracter in cadena:
        cadenainvertida = caracter + cadenainvertida
    print (cadenainvertida)

cadena = input("Dime una cadena: ")
invierte(cadena)
