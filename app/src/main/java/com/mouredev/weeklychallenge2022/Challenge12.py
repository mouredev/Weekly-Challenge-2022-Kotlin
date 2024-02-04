"""/*
 * Escribe una función que reciba un texto y retorne verdadero o
 * falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee
 * de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 */"""

def palindromo(frase):
    frase = frase.lower()
    simbolos = {" ":"", ",":"","?":"","¿":"","!":"","¡":"","(":"",")":"",".":"","á": "a", "é": "e", "í": "i", "ó": "o", "ú": "u"}    
    for caracter in simbolos:
        if caracter in frase:
            frase = frase.replace(caracter, simbolos[caracter])
            
    if frase == frase[::-1]:
            return True
    else:
        return False
                
frase = input("Dime la frase: ")
print(f"¿Es palíndroma? {palindromo(frase)}")